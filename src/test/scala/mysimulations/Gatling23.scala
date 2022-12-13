package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations

import scala.concurrent.duration._

//load testing to achiceive 1000 requests/minute
//Before and After hooks


class Gatling23 extends Simulation {

  var blazeDemo = new blazeDemoOperations()

    before{
      println("from before block")

  }
    after{
      println("from after block")
      blazeDemo = null
  }


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
  setUp(scn.inject(constantUsersPerSec(10)during(5.minute))
    .throttle(
      reachRps(17) in (2.seconds),
      holdFor(60.seconds),
    )
    .disablePauses
    .protocols(httpProtocol))
    .assertions(global.responseTime.max.lt(5000))
    .assertions(forAll.responseTime.max.lt(5000))


}
