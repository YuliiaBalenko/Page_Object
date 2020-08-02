package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.Waiters.waitForAllElementsOnHomePage;
import static util.Waiters.waitForAllElementsOnWomanPage;

public class HomePage extends Page {

    public static final String AUTOMATION_PRACTICE_PAGE_URL = "http://automationpractice.com/index.php";
    public static final String ALL_ELEMENTS_HOME_PAGE_ID = "index";
    public static final String ALL_ELEMENTS_WOMAN_PAGE_ID = "category";
    public static final String ALL_ELEMENTS_DRESSES_PAGE_ID = "page";

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]")
    private WebElement womanButton;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesButton;

    public HomePage(WebDriver driver) {
        super(driver);
        open();

    }

    public void open() {
        driver.get(AUTOMATION_PRACTICE_PAGE_URL);
        waitForAllElementsOnHomePage(driver, ALL_ELEMENTS_HOME_PAGE_ID);
    }

    public WomanPage clickOnWomenTab() {
        womanButton.click();
        waitForAllElementsOnWomanPage(driver, ALL_ELEMENTS_WOMAN_PAGE_ID);
        return new WomanPage(driver);
    }

    public DressesPage clickOnDressesTab() {
        dressesButton.click();
        waitForAllElementsOnWomanPage(driver, ALL_ELEMENTS_DRESSES_PAGE_ID);
        return new DressesPage(driver);
    }
}
