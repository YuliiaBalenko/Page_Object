package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebElementsSteps extends Page{

    WebElement colorOnLeftPanel;
    public static int quantityOfColorLeftPanel;
    public static int quantityOfColorMainContainer;
    List<WebElement> colorMainContainer;


    public WebElementsSteps(WebDriver driver) {
        super(driver);
    }


    public void findColorOnLeftPanelByXpath(String locatorToColorOnLeftPanel) {
        colorOnLeftPanel = driver.findElement(By.xpath(locatorToColorOnLeftPanel));

    }

    public int countColorOnLeftPanel() {
        String text = colorOnLeftPanel.getText();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int start = 0;
        while (matcher.find(start)) {
            String value = text.substring(matcher.start(), matcher.end());
            quantityOfColorLeftPanel = Integer.parseInt(value);
            start = matcher.end();
        }
        return quantityOfColorLeftPanel;
    }

    public void findColorOnMainContainerByXpath(String locatorToColorOnMainContainer) {

        colorMainContainer = driver.findElements(By.xpath(locatorToColorOnMainContainer));

    }

    public int countColorOnMainContainer() {
        quantityOfColorMainContainer = colorMainContainer.size();
        return quantityOfColorMainContainer;
    }
}


