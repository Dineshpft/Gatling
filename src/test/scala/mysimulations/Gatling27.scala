package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

// REST API Testing  with GET, POST, PUT, DELETE methods

class Gatling27 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
    //   .proxy(Proxy("localhost", 8888))
    .baseUrl("https://reqres.in")
  flushCookieJar
  flushHttpCache
  flushSessionCookies

  //---- Scenario Section
  val scn = scenario("RESTAPI")
    .group("REST_GET_API_tx") {
      exec(http("GET_request")
        .get("/api/users/2")
        .check(status.is(200))
        .check(jsonPath("$.data.id").is("2"))
      )
    }

    // POST
    .group("REST_POST_API_tx") {
      exec(http("POST_request")
        .post("/api/users")
        .body(RawFileBody("REST_API_UserInfo.json"))
        .check(status.is(201))
        .check(regex(".*createdAt.*"))
      )
    }

    // PUT

    .group("REST_PUT_API_tx") {
      exec(http("PUT_request")
        .put("/api/users/2")
        .body(RawFileBody("REST_API_UserInfo.json"))
        .check(status.is(200))
        .check(regex(".*updatedAt.*"))
      )
    }

    // DELETE

    .group("REST_DELETE_API_tx") {
      exec(http("DELETE_request")
        .delete("/api/users/2")
        .check(status.is(204))
      )
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
