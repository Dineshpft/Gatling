package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Gatling02 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    .proxy(Proxy("localhost", 8888))
    .baseUrl("https://blazedemo.com")


  //---- Scenario Section
  val scn = scenario("BlazeHomePage")
    .exec(http("Homepage_request").get("/"))

  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}

