package pages.docs;

import com.microsoft.playwright.Page;
import pages.INavbar;

public class DocsIntroPage implements INavbar {
    private final Page page;

    public DocsIntroPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }
}
