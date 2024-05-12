package com.example.cleanrepo.keycloak.api;

import com.example.cleanrepo.keycloak.dto.UserRegistrationRecord;
import com.example.cleanrepo.keycloak.service.KeycloakUserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class KeycloakUserApi {


    private final KeycloakUserService keycloakUserService;


    @PostMapping("create")
    public UserRegistrationRecord createUser(@RequestBody UserRegistrationRecord userRegistrationRecord) {

        return keycloakUserService.createUser(userRegistrationRecord);
    }

    @GetMapping("myinfo")
    public UserRepresentation getUser(@AuthenticationPrincipal Jwt jwt) {
        return keycloakUserService.getUserByJwt(jwt);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@AuthenticationPrincipal Jwt jwt) {
        keycloakUserService.deleteUserByJwt(jwt);
    }


    @PutMapping("/{userId}/send-verify-email")
    public void sendVerificationEmail(@PathVariable String userId) {
        keycloakUserService.emailVerification(userId);
    }

    @PutMapping("/update-password")
    public void updatePassword(@AuthenticationPrincipal Jwt jwt) {
        keycloakUserService.updatePassword(jwt);
    }
}
