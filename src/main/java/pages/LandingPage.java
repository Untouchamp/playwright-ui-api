package pages;

import com.microsoft.playwright.Page;

import static config.SetupConfig.UIEndpoints.uiBaseUrl;

public class LandingPage implements IPage, INavbar {
    private final Page page;

    public LandingPage(Page page) {
        this.page = page;
    }

    @Override
    public LandingPage open() {
        page.navigate(uiBaseUrl);
        return this;
    }

}
