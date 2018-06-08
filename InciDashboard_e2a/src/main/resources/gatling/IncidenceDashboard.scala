package es.asw.inciDashboard

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class IncidenceDashboard extends Simulation {

	val httpProtocol = http
		.baseURL("http://35.180.43.248:8090")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")

	val headers_2 = Map(
		"Origin" -> "http://35.180.43.248:8090",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("IncidenceDashboard")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/favicon.ico")
			.headers(headers_1)))
		.pause(4)
		.exec(http("request_2")
			.post("/login")
			.headers(headers_2)
			.formParam("username", "Juan")
			.formParam("password", "123456")
			.formParam("${_csrf.parameterName}", "${_csrf.token}"))
		.pause(5)
		.exec(http("request_3")
			.get("/estadisticas")
			.headers(headers_0))
		.pause(19)
		.exec(http("request_4")
			.get("/estadisticas")
			.headers(headers_0))

	setUp(scn.inject(rampUsers(150) over (5 seconds))).protocols(httpProtocol)
}