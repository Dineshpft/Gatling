package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Gatling01 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    .baseUrl("https://blazedemo.com")


  //---- Scenario Section
  val scn = scenario("BlazeHomePage")
    .exec(http("Homepage_request").get("/"))

  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}