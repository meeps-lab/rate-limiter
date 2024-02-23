package com.leahf.ratelimiter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class GreetingController {

	@Value("${testapi.restclient.host}")
	private String testApiHost;

	@Value("${testapi.restclient.port}")
	private String testApiPort;

	@Value("${testapi.restclient.protocol}")
	private String testApiProtocol;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		RestClient restClient = RestClient.builder()
			.baseUrl(testApiProtocol + "://" + testApiHost + ":" + testApiPort)
			.build();

        return restClient.get()
			.uri("/greeting?name={name}", name)
			.retrieve()
			.body(Greeting.class);
	}
}
