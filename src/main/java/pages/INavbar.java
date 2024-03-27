package pages;

import com.microsoft.playwright.Page;
import pages.docs.DocsIntroPage;

public interface INavbar {
    String navBarLocator = "//nav[@aria-label='Main']";
    String docsSectionLocator = navBarLocator + "/descendant::a[text()='Docs']";
    String apiSectionLocator = navBarLocator + "/descendant::a[text()='API']";
    String javaDropdownLocator = navBarLocator +
            "/descendant::a[text()='Java']/parent::div[contains(concat(' ', @class, ' '), ' dropdown ')]";
    String communitySectionLocator = navBarLocator + "/descendant::a[text()='Community']";

    default void goToSectionNamed(Page page, String sectionName) {
        page.click(navBarLocator + String.format("/descendant::a[text()='%s']", sectionName));
    }

    default DocsIntroPage goToDocsIntroPage(Page page){

        page.click(docsSectionLocator);
        return new DocsIntroPage(page);
    }
}
