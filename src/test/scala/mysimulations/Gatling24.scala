package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import mylib.blazeDemoOperations

import scala.concurrent.duration._

//exiting the virtual user when error occurs in check is failed

class Gatling24 extends Simulation {

  val blazeDemo = new blazeDemoOperations()

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
      //blazedemo.blazedemohomepage()
      exec(http("Homepage_request")
        .get("/")
        .check(status.is(200))
        .check(substring("Welcome to the Simple Travel Agency"))
      )
    }
    .exitHereIfFailed
    .pause(5.seconds)
    .group("FindFlight_tx")
    {
      blazeDemo.findFlight("Boston","London")
    }
    //Deserialization and serialization
    .exec(
      session => {
        println("*****************************************")
        println("Before Price Modification")
        println("Price = " + session("prmPrice").as[String])

        val new_session = session.set("prmPrice", 600)//creating new session and passing new value 600

        println("After Price Modification")
        println("Price = " + new_session("prmPrice").as[String])
        println("*****************************************")
        new_session
      }
    )
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
      println("ID = " + session("prmId").as[String])
      session
    }
//---- Simulation/Injection Section
setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
