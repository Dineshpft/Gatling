package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations

import scala.concurrent.duration._

//loading testing with 25 users for 3 minutes


class Gatling21 extends Simulation {

  val blazeDemo = new blazeDemoOperations()

  // val fromCity:String="Boston"
  //val toCity:String="Berlin"




  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    .proxy(Proxy("localhost", 8888))
    .baseUrl("https://blazedemo.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
  flushCookieJar//to clear cookies, cache, sessions
  flushHttpCache
  flushSessionCookies


  //---- Scenario Section
  val scn = scenario("BlazeHomePage") //first request
    .forever {
      pace(5.seconds)


      .group("Homepage_tx") {
        blazeDemo.blazeDemoHomePage()
      }
        .pause(5.seconds)
        .group("FindFlight_tx") {
          blazeDemo.findFlight("Boston", "London")
        }
        .pause(5.seconds)
        .group("selectFlight_tx") {
          blazeDemo.selectFlight()
          //This is for selecting flight
        }
        .pause(5.seconds)

        .group("purchaseTicket_tx") {
          blazeDemo.purchaseTicket()
        }
        .exec { session =>
          println("ID = " + session("prmId"))
          session
        }
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(
    rampConcurrentUsers(1) to (25) during (1.minute),
    constantConcurrentUsers(25) during (2.minutes),
  ).protocols(httpProtocol)).maxDuration(3.minutes)
    .assertions(global.responseTime.max.lt(5000))
    .assertions(forAll.responseTime.max.lt(5000))


}
