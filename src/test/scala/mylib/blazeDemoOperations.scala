package mylib

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class blazeDemoOperations {
  def blazeDemoHomePage() = {
    exec(http("Homepage_request")
      .get("/")
      .check(status.is(200)) //status Validation
      .check(substring("Welcome to the Simple Travel Agency!"))
    )
  }

  def findFlight(fromCity:String,toCity:String) = {
    exec(http("FindFlightRequest") //second transaction
      .post("/reserve.php")
      .formParam("fromPort", fromCity)
      .formParam("toPort", toCity)
      // .check(status.is(200))
      .check(status.in(200, 201, 202, 203, 204))
      .check(substring(s"Flights from ${fromCity} to ${toCity}:"))
      // .check(css("body > div.container > table > tbody > tr:nth-child(1) > td:nth-child(2) > input"))
      // .check(css("body > div.container > table > tbody > tr:nth-child(3) > td:nth-child(1)"))
      .check(css("body > div.container > table")) // css validation
      .check(regex("<input type=\"hidden\" value=\"(.*)\" name=\"flight\">").find(1).saveAs("prmFlight"))
      .check(regex("<input type=\"hidden\" value=\"(.*)\" name=\"price\">").find(1).saveAs("prmPrice"))
      .check(regex("<input type=\"hidden\" value=\"(.*)\" name=\"airline\">").find(1).saveAs("prmAirline"))
      .check(regex("<input type=\"hidden\" name=\"fromPort\" value=\"(.*)\"/>").find(1).saveAs("prmFromPort"))
      .check(regex("<input type=\"hidden\" name=\"toPort\" value=\"(.*)\"/>").find(1).saveAs("prmToPort"))

    )
  }
  def selectFlight()={
    exec(http("SelectFlight_request")
      .post("/purchase.php")
      .formParam("flight", "${prmFlight}")
      .formParam("price", "${prmPrice}")
      .formParam("airline", "${prmAirline}")
      .formParam("fromPort", "${prmFromPort}")
      .formParam("toPort", "${prmToPort}")
      .check(status.is(200))
      .check(substring("Please submit the form below to purchase the flight."))
    )

  }

  def purchaseTicket() = {
    exec(http("purchaseTicket_request")
      .post("/confirmation.php")
      .formParam("_token", "")
      .formParam("inputName", "Chikkanna")
      .formParam("address", "XYZ")
      .formParam("city", "Bang")
      .formParam("state", "Karnatak")
      .formParam("zipCode", "560040")
      .formParam("cardType", "amex")
      .formParam("creditCardNumber", "123456789")
      .formParam("creditCardMonth", "11")
      .formParam("creditCardYear", "2025")
      .formParam("nameOnCard", "NAmeOnCardName")
      .formParam("rememberMe", "YES")
      .check(status.is(200))
      .check(substring("Thank you for your purchase today!"))
      .check(regex("<td>(.*)</td>").find(1).saveAs("prmID"))
    )

  }
}
