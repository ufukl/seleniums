import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;


public class HomePage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        super();
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void checkRedirectToHomePage() {
        wait.until(ExpectedConditions.titleIs("n11.com - Alışverişin Uğurlu Adresi"));
    }
}
