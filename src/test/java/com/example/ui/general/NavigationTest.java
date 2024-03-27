package com.example.ui.general;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LandingPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
        page.close();
    }

    @ParameterizedTest
    @CsvSource({
            "Docs, Installation | Playwright Java",
            "API, Playwright | Playwright Java",
            "Community, Welcome | Playwright Java"
    })
    void navigationTest(String sectionName, String expectedPageTitle) {
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
