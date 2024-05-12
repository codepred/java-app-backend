package com.example.cleanrepo.keycloak.service;

import com.example.cleanrepo.keycloak.dto.UserRegistrationRecord;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.oauth2.jwt.Jwt;


import java.io.IOException;

public interface KeycloakUserService {

    UserRegistrationRecord createUser(UserRegistrationRecord userRegistrationRecord);
    UserRepresentation getUserByJwt(Jwt jwt);
    void deleteUserByJwt(Jwt jwt);
    void emailVerification(String userId);
    UserResource getUserResource(String userId);
    void updatePassword(Jwt jwt);
}
