package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

//PT of File upload activity
class gatling17 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    .proxy(Proxy("localhost", 8888))
    .baseUrl("https://cgi-lib.berkeley.edu")
    .inferHtmlResources() //to download embedded resources
    .maxConnectionsPerHostLikeChrome // number of parallel downloads for non html resources
  flushCookieJar
  flushHttpCache
  flushSessionCookies


  //---- Scenario Section
  val scn = scenario("BerkeleyHomePage")
    .group("Homepage_tx") {
      exec(http("Homepage_request")
        .get("/ex/fup.html")
        .check(status.is(200))
        .check(substring("Please fill in the file-upload form below"))
      )
    }
    .pause(5.seconds)

    .group("FileUpload_tx") {
      exec(http("FileUpload_request")
        .post("/ex/fup.cgi")
        .asMultipartForm
        .formParam("note","sample")
        .formUpload("upfile","src/test/resources/CityData.csv")
        .check(status.is(200))
        .check(substring("fromCity,toCity"))
        )
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}



