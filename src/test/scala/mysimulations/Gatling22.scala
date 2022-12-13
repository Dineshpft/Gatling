package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations

import scala.concurrent.duration._

//loading testing based on RPS throttle


class Gatling22 extends Simulation {

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
  setUp(scn.inject(constantUsersPerSec(1)during(1.minute))
    .throttle(
      reachRps(5) in (10.seconds),
      holdFor(10.seconds),
      jumpToRps(10),
      holdFor(10.seconds),
      jumpToRps(20),
      holdFor(10.seconds),
    )
    .disablePauses
    .protocols(httpProtocol))
    .assertions(global.responseTime.max.lt(5000))
    .assertions(forAll.responseTime.max.lt(5000))


}
