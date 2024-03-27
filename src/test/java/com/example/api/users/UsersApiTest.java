package com.example.api.users;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import config.APITestSetup;
import helpers.DataHub;
import infrastructure.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static config.SetupConfig.APIEndpoints.*;
import static helpers.DataHub.convertObjectToMap;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersApiTest extends APITestSetup {
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
        //TODO add functionality of deleting every entity that tests created
    }

    @Test
    void checkUsersList() {
        APIResponse users = request.get(apiGetUsers);
        assertTrue(users.ok());
        JsonArray json = new Gson().fromJson(users.text(), JsonArray.class);
        JsonObject user = null;
        for (JsonElement item : json) {
            JsonObject itemObj = item.getAsJsonObject();
            if (!itemObj.has("username")) {
                continue;
            }
            if ("wertyu".equals(itemObj.get("username").getAsString())) {
                user = itemObj;
                break;
            }
        }
        assertNotNull(user);
        assertEquals("wrer@gmail.com", user.get("email").getAsString(), user.toString());
    }

    @Test
    void checkUserDeletion() {
        APIResponse userByUsername = request.get(apiGetUserFilter,
                RequestOptions.create().setQueryParam("username", "5ad47038e3"));
        User user = new Gson().fromJson(userByUsername.text(), User.class);
        assertEquals("", user.getEmail());
    }

    @Test
    void checkDefaultUserCreation() {
        User user = User.createDefaultUser(request);
        assertEquals("defaultuser", user.getUsername(), user.toString());
    }

    @Test
    void userCreationTest() {
        String username = DataHub.getRandomUniqueValue(8);
        String email = DataHub.generateRandomEmail();
        User user = User.builder()
                .username(username)
                .email(email).build();
        request.post(apiPostAuthCreateUser,
                RequestOptions.create().setData(convertObjectToMap(user)));
        assertEquals(username, user.getUsername(), user.toString());
        assertEquals(email, user.getEmail(), user.toString());
    }
}
