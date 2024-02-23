package com.leahf.ratelimiter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class GreetingController {

	@Value("${testapi.restclient.uri}")
	private String restClientBaseUrl;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		RestClient restClient = RestClient.builder()
			.baseUrl(restClientBaseUrl)
			.build();

        return restClient.get()
			.uri("/greeting?name={name}", name)
			.retrieve()
			.body(Greeting.class);
	}
}
