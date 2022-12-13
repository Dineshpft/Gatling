
package mysimulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

// Soap API Testing

class Gatling26 extends Simulation {

  //---- Protocol Section
  val httpProtocol = http
    //--- Fiddler Proxy to check request & response
     .proxy(Proxy("localhost", 8888))
    .baseUrl("http://www.dneonline.com")
  flushCookieJar
  flushHttpCache
  flushSessionCookies

  //---- Scenario Section
  val scn = scenario("SoapAPI")
    .group("Soap_ADD_API_tx_method1") {
      exec(http("ADD_request")
        .post("/calculator.asmx")
        .header("Content-Type","application/soap+xml; charset=utf-8")
        .body(StringBody("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><Add xmlns=\"http://tempuri.org/\"><intA>2</intA><intB>4</intB></Add></soap12:Body></soap12:Envelope>"))
        .check(status.is(200))
        .check(substring("<AddResult>6</AddResult>"))
        //  .check(xpath("//AddResponse/AddResult",Map("soap12" -> "http://tempuri.org/")).exists)
      )
    }

    //method2 - using extra file as body data

    .group("Soap_ADD_API_tx_method2") {
      exec(http("ADD_request")
        .post("/calculator.asmx")
        .header("Content-Type", "application/soap+xml; charset=utf-8")
        .body(RawFileBody("SOAPBodyData.xml"))
        .check(status.is(200))
        .check(substring("<AddResult>30</AddResult>"))
      )
    }
  //---- Simulation/Injection Section
  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}


