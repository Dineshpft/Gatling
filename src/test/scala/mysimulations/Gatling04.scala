package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Gatling04 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    .proxy(Proxy("localhost", 8888))
    .baseUrl("https://www.bing.com")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
    //The following line mimics desktop chrome browser
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36.")
  //The following line mimics mobile chrome browser
  //.userAgentHeader("Mozilla/5.0 (Linux; Android 10; SM-G981B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.162 Mobile Safari/537.36")


  // Mozilla/5.0 (Linux; Android 130; SM-G981B) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.162 Mobile Safari/537.36

  //---- Scenario Section
  val scn = scenario("BlazeHomePage")
    .exec(http("Homepage_request").get("/"))

  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}