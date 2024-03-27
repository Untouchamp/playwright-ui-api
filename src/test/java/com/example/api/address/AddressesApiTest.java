package com.example.api.address;

import com.microsoft.playwright.APIResponse;
import config.APITestSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static config.SetupConfig.APIEndpoints.apiGetAddress;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressesApiTest extends APITestSetup {
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
    void getAddressesTest() {
        APIResponse addressResponse = request.get(apiGetAddress);
        assertTrue(addressResponse.ok(), addressResponse.text());
    }
}
