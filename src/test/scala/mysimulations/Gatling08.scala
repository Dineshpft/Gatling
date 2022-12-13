package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


class Gatling08 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
     .proxy(Proxy("localhost", 8888))
    .baseUrl("https://blazedemo.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
  flushCookieJar
  flushHttpCache
  flushSessionCookies


  //---- Scenario Section
  val scn = scenario("BlazeHomePage")
    .group("Homepage_tx") {
      exec(http("Homepage_request").get("/"))
    }
    .pause(5.seconds)

    .group("FindFlight_tx") {
      exec(http("FindFlightRequest")
        .post("/reserve.php")
        .formParam("fromPort","Boston")
        .formParam("toPort","Berlin")
      )
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
