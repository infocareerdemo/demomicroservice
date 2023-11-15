package com.register.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
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

import com.register.dto.LoginResponse;
import com.register.dto.Users;

import jakarta.ws.rs.core.Response;

@Service
public class RegisterService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Keycloak keycloak;

	@Value("${keycloak.realm}")
	private String realm;

	public Users createUser(Users users) {

		UserRepresentation user = new UserRepresentation();
		user.setEnabled(true);
		user.setUsername(users.getUsername());
		user.setEmail(users.getEmail());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setEmailVerified(true);

		CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
		credentialRepresentation.setValue(users.getPassword());
		credentialRepresentation.setTemporary(false);
		credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

		List<CredentialRepresentation> list = new ArrayList<>();
		list.add(credentialRepresentation);
		user.setCredentials(list);

		UsersResource usersResource = getUsersResource();
		Response response = usersResource.create(user);
		if (Objects.equals(201, response.getStatus())) {
			return users;
		}
		return null;
	}

	private UsersResource getUsersResource() {
		RealmResource realm1 = keycloak.realm(realm);
		return realm1.users();
	}

	public UserRepresentation getUserById(String id) {
		return getUsersResource().get(id).toRepresentation();
	}

	public void deleteUserById(String id) {
		getUsersResource().delete(id);
	}

}
