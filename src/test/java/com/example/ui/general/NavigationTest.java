package com.example.ui.general;

import com.microsoft.playwright.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LandingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest {

    @ParameterizedTest
    @CsvSource({
            "Docs, Installation | Playwright Java",
            "API, Playwright | Playwright Java",
            "Community, Welcome | Playwright Java"
    })
    void navigationTest(String sectionName, String expectedPageTitle) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            LandingPage landingPage = new LandingPage(page);
            landingPage
                    .open()
                    .goToSectionNamed(page, sectionName);
            assertThat(page).hasTitle(expectedPageTitle);
            browser.close();
        }
    }
}
