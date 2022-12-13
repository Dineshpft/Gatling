package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations

import scala.concurrent.duration._

//calling user define methods from simulation section


class Gatling15 extends Simulation {

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
    .group("Homepage_tx") {
      blazeDemo.blazeDemoHomePage()
    }

    .pause(5.seconds)

    .group("FindFlight_tx")
    {
      blazeDemo.findFlight("Boston","London")
    }

//---- Simulation/Injection Section
setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
