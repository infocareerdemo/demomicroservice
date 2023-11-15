package com.auth.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.auth.entity.LoginResponse;

@Service
public class LoginService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${spring.security.oauth2.client.provider.springboot.issuer-uri}")
	private String issuerUrl;
	@Value("${spring.security.oauth2.client.registration.springboot.client-id}")
	private String clientId;
	@Value("${spring.security.oauth2.client.registration.springboot.client-secret}")
	private String clientSecret;
	@Value("${spring.security.oauth2.client.registration.springboot.authorization-grant-type}")
	private String grantType;

	public LoginResponse login(Map<String, String> request) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
		data.add("client_id", clientId);
		data.add("client_secret", clientSecret);
		data.add("grant_type", grantType);
		data.add("username", request.get("username"));
		data.add("password", request.get("password"));

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(data,
				headers);

		ResponseEntity<LoginResponse> response = restTemplate.postForEntity("http://localhost:8080/realms/springboot/protocol/openid-connect/token", httpEntity, LoginResponse.class);

		return response.getBody();

	}
	
	
	public String logout(Map<String, String> token) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
		data.add("client_id", clientId);
		data.add("client_secret", clientSecret);
		data.add("refresh_token",token.get("token"));

		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(data,
				headers);

		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/realms/springboot/protocol/openid-connect/logout", httpEntity, String.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			return "Logged Out...!!!";
		}
		return response.getBody();

	}

}
