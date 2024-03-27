package config;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;

import static config.SetupConfig.APIEndpoints.apiBaseUrl;

public class APITestSetup {
    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(APITestSetup.class);
    protected Playwright playwright;
    protected APIRequestContext request;

    protected void createPlaywright() {
        playwright = Playwright.create();
    }

    protected void createAPIRequestContext() {
        Map<String, String> headers = new HashMap<>();

        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL(apiBaseUrl)
                .setExtraHTTPHeaders(headers));
    }
}
