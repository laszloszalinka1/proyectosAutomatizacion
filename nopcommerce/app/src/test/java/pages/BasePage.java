package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    private static JavascriptExecutor js;
    
    static{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\automation\\practice\\app\\src\\test\\resources\\webDriver\\chromedriver.exe");
        ChromeOptions chrome = new ChromeOptions();
        driver = new ChromeDriver(chrome);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }
    public static void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();

    }
    public static void closeBrowser(){
        driver.quit();
    }
    public WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void clickElement(String locator){
    find(locator).click();
    }

    public void write(String locator,String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }
    public void selectedFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);

    }
    public void selectedFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(valueToSelect);

    }
    public void selectedFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }
    public void hoverOverelement(String locator){
        action.moveToElement(find(locator));
    }
    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }
    public void rightClick(String locator){
        action.contextClick(find(locator));
    }
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return find(cellINeed).getText();


    }
    public void clicElementFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
         find(cellINeed).click();


    }
    public String textFromElement(String locator){
        return find(locator).getText();
    }
    public void goToPage(String[] ruta){
        
        for(int i = 0; i < ruta.length; i++){
            clickElement(ruta[i]);
        }
    }
    public void scrollDown(String scroll){
        js.executeScript(scroll);

    }


}
