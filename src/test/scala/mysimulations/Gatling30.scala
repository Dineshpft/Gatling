package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations
import java.lang.Long
import scala.concurrent.duration._
//rendezvous point in web calls

class Gatling30 extends Simulation {

  val blazeDemo= new blazeDemoOperations()      //creating an instance of base class

  val prmUsers = Integer.getInteger("users", 5)
  val prmRamptime_in_mins = Long.getLong("ramptime_in_mins", 1)
  val prmMaxdurationtime_in_mins = Long.getLong("maxdurationtime_in_mins", 2)
  val prmHoldtime_in_mins = Long.getLong("holdtime_in_mins", 1)


  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    // .proxy(Proxy("localhost", 8888))
    .baseUrl("https://blazedemo.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
  flushCookieJar
  flushHttpCache
  flushSessionCookies


  //---- Scenario Section
  // .group creates transaction = homepage + embedded resources
  //.check is response assertion
  val scn = scenario("BlazeHomePage")
    .forever {

      group("Homepage_tx") {
        blazeDemo.blazeDemoHomePage()
      }

        //think-time
        .pause(5.seconds)

        .group("FindFlight_tx") {
          blazeDemo.findFlight("Paris", "london")
        }
        .pause(5.seconds)

        .group("SelectFlight_tx") {
          blazeDemo.selectFlight()
        }

        .pause(5.seconds)

        .rendezVous(10)
        .group("PurchaseTickets_tx") {
          blazeDemo.purchaseTicket()
        }

        //below block is to print prmId - To be finalized later
        .exec { session =>
          println("ID = " + session("prmId").as[String])
          session
        }
    }

  //---- Simulation/Injection Section
 // setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol).maxDuration(30.seconds).disablePauses
  setUp(scn.inject(
    rampConcurrentUsers(1) to (prmUsers) during (prmRamptime_in_mins.minute),
    constantConcurrentUsers(prmUsers) during (prmHoldtime_in_mins.minute),
    rampConcurrentUsers(prmUsers) to (1) during (prmRamptime_in_mins.minute)
  ).protocols(httpProtocol)).maxDuration(prmMaxdurationtime_in_mins.minute)
    .assertions(global.responseTime.max.lt(5000))
}



