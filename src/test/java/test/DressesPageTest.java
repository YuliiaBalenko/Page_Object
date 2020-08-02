package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.DressesPage;


import static page.WomanPage.quantityOfColorLeftPanel;
import static page.WomanPage.quantityOfColorMainContainer;

public class DressesPageTest {
    WebDriver driver = new ChromeDriver();
    DressesPage dressesPage;

    @BeforeSuite
    public void openDressesPage() {
        dressesPage = PageFactory.initElements(driver, HomePage.class).clickOnDressesTab();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"//*[@style='background:#f5f5dc;']", "//*[@id='ul_layered_id_attribute_group_3']/li[1]/label/a/span"},
                {"//*[@style='background:#ffffff;']", "//*[@id='ul_layered_id_attribute_group_3']/li[2]/label/a/span"},
                {"//*[@style='background:#434A54;']", "//*[@id='ul_layered_id_attribute_group_3']/li[3]/label/a/span"},
                {"//*[@style='background:#F39C11;']", "//*[@id='ul_layered_id_attribute_group_3']/li[4]/label/a/span"},
                {"//*[@style='background:#5D9CEC;']", "//*[@id='ul_layered_id_attribute_group_3']/li[5]/label/a/span"},
                {"//*[@style='background:#A0D468;']", "//*[@id='ul_layered_id_attribute_group_3']/li[6]/label/a/span"},
                {"//*[@style='background:#F1C40F;']", "//*[@id='ul_layered_id_attribute_group_3']/li[7]/label/a/span"},
                {"//*[@style='background:#FCCACD;']", "//*[@id='ul_layered_id_attribute_group_3']/li[8]/label/a/span"}};
    }

    @Test(dataProvider = "data-provider")
    public void testColorsOnDressesPage(String locatorToColorOnMainContainer, String locatorToColorOnLeftPanel) {

        dressesPage.findColorOnMainContainerByXpath(locatorToColorOnMainContainer);
        dressesPage.countColorOnMainContainer();
        dressesPage.findColorOnLeftPanelByXpath(locatorToColorOnLeftPanel);
        dressesPage.countColorOnLeftPanel();

        Assert.assertEquals(quantityOfColorMainContainer, quantityOfColorLeftPanel);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

