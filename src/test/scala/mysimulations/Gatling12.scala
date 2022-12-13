package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._


class Gatling12 extends Simulation {

  val fromcity:String="Boston"
  val tocity:String="Berlin"

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    // .proxy(Proxy("localhost", 8888))
    .baseUrl("https://blazedemo.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
  flushCookieJar//to clear cookies, cache, sessions
  flushHttpCache
  flushSessionCookies


  //---- Scenario Section
  val scn = scenario("BlazeHomePage") //first request
    .group("Homepage_tx") {
      exec(http("Homepage_request")
        .get("/")
        .check(status.is(200))//status Validation
        .check(substring("Welcome to the Simple Travel Agency!"))

      )
    }
    .pause(5.seconds)

    .group("FindFlight_tx") {
      exec(http("FindFlightRequest")//second transaction
        .post("/reserve.php")
        .formParam("fromPort",fromcity)
        .formParam("toPort",tocity)
       // .check(status.is(200))
        .check(status.in(200,201,202,203,204))
        .check(substring(s"Flights from ${fromcity} to ${tocity}:"))
       // .check(css("body > div.container > table > tbody > tr:nth-child(1) > td:nth-child(2) > input"))
       // .check(css("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(1)"))
        .check(css("body > div.container > table")) // css validation




      )
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
