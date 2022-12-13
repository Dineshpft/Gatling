package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Gatling05 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    .proxy(Proxy("localhost", 8888))
    .baseUrl("https://www.google.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
    .acceptLanguageHeader("te")

  //---- Scenario Section
  val scn = scenario("BlazeHomePage")
    .exec(http("Homepage_request").get("/"))

  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
