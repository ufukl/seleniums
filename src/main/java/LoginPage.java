import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super();
        this.webDriver = driver;
        this.wait = wait;


    }

    public HomePage loginAs(String username, String password) {

        executeLogin(username, password);
        return new HomePage(webDriver,wait);
    }

    private void executeLogin(String username, String password) {

        webDriver.findElement(By.id("email")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("loginButton")).submit();
    }
}
