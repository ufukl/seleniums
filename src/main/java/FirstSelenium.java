import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class FirstSelenium {


    public static WebDriver webDriver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(webDriver,30);


    public void openingPageTest() {
        webDriver.navigate().to("http://www.n11.com/");
        wait.until(ExpectedConditions.titleIs("n11.com - Alışverişin Uğurlu Adresi"));
        webDriver.findElement(By.linkText("Giriş Yap")).click();
        wait.until(ExpectedConditions.titleIs("Giriş Yap - n11.com"));

    }


    public void loginTest() throws Exception {

        LoginPage loginPage = new LoginPage(webDriver,wait);
        HomePage homePage = loginPage.loginAs("****", "*****");
        homePage.checkRedirectToHomePage();
    }

    public void searchTest() {

        webDriver.findElement(By.id("searchData"))
                .sendKeys("samsung");
        webDriver.findElement(By.className("searchBtn")).click();

        Assert.assertEquals(webDriver.getTitle(),"Samsung - n11.com");

        List<WebElement> pagination =webDriver.findElements(By.xpath("//div[@class='pagination']//a"));

        if(pagination .size()>0){
            pagination.get(1).click();
        }

    }

    public void clickToFavorilereEkleTest() {

        WebElement divElement = webDriver.findElement(By.id("p-13631913"));
        List<WebElement> spans= divElement.findElements(By.tagName("span"));

        String spanArray[]=new String[spans.size()];

        for(int i = 0; i < spans.size(); i++) {
            spanArray[i] = spans.get(i).getAttribute("title");

            if(spanArray[i].equalsIgnoreCase("Favorilere Ekle")) {
                spans.get(i).click();
            }
        }
    }

    public void clickHesabimTest() {
        webDriver.findElement(By.linkText("Hesabım")).click();
        wait.until(ExpectedConditions.titleIs("Hesabım - n11.com"));
    }

    public void clickFavorilerimTest() {
        webDriver.findElement(By.linkText("Favorilerim")).click();
        wait.until(ExpectedConditions.titleIs("Favorilerim - n11.com"));

    }

    public boolean checkFavoriExistTest() {
        WebElement divElement = webDriver.findElement(By.className("rightColumn"));
        List<WebElement> ahrefElements= divElement.findElements(By.tagName("a"));

        String tdsArray[]=new String[ahrefElements.size()];

        for(int i = 0; i < ahrefElements.size(); i++) {
            tdsArray[i] = ahrefElements.get(i).getAttribute("href");

            if(tdsArray[i] != null &&tdsArray[i].equals("http://www.n11.com/samsung-i8200-galaxy-s3-mini-cep-telefonu-P13631913")) {
                return true;
            }
        }
        return false;

    }

    public void clickKaldirTest() {

        webDriver.findElement(By.linkText("Kaldır")).click();
    }


    @Test
    public void doAllTests() throws Exception {
        openingPageTest();
        loginTest();
        searchTest();
        clickToFavorilereEkleTest();
        clickHesabimTest();
        clickFavorilerimTest();
        Assert.assertEquals(true,checkFavoriExistTest());
        clickKaldirTest();
    }


}
