package es.asw.inciManager

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class IncidenceManager extends Simulation {

	val httpProtocol = http
		.baseURL("http://52.47.153.181:8085")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Origin" -> "http://52.47.153.181:8085",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("IncidenceManagerHeavy")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_1")
			.post("/index")
			.headers(headers_1)
			.formParam("login", "Juan")
			.formParam("password", "123456")
			.formParam("kind", "Entity"))
		.pause(2)
		.exec(http("request_2")
			.get("/list")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_3")
			.get("/details/2")
			.headers(headers_0))

	setUp(scn.inject(rampUsers(150) over (5 seconds))).protocols(httpProtocol)
}