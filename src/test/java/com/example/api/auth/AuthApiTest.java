package com.example.api.auth;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
import config.APITestSetup;
import helpers.DataHub;
import infrastructure.entity.AuthToken;
import infrastructure.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Map;

import static config.SetupConfig.APIEndpoints.*;
import static helpers.DataHub.convertObjectToMap;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthApiTest extends APITestSetup {

    @BeforeAll
    void beforeAll() {
        createPlaywright();
        createAPIRequestContext();
    }

    void disposeAPIRequestContext() {
        if (request != null) {
            request.dispose();
            request = null;
        }
    }

    void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }

    @AfterAll
    void afterAll() {
        disposeAPIRequestContext();
        closePlaywright();
    }

    @Test
    void createUser() {
        User user = User.builder()
                .username(DataHub.getRandomUniqueValue(10))
                .email(DataHub.generateRandomEmail())
                .build();

        Map<String, String> userMap = convertObjectToMap(user);
        APIResponse createUserResponse = request.post(apiPostAuthCreateUser,
                RequestOptions.create().setData(userMap));
        assertTrue(createUserResponse.ok(), createUserResponse.statusText());
    }

    @Test
    void checkTokenCreation() {
        APIResponse tokenResponse = request.post(apiPostAuthToken,
                RequestOptions.create()
                        .setForm(
                                FormData.create()
                                        .set("username","5ad47038e3")
                                        .set("password","123456")
                        ));
        assertTrue(tokenResponse.ok(), "Server response: \n" + tokenResponse.text());
        AuthToken authTokenResp = new Gson().fromJson(tokenResponse.text(), AuthToken.class);
        assertFalse(authTokenResp.getToken().isEmpty(), "Response body:\n" + authTokenResp.getToken());
    }

}
