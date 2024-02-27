package stepdefinitions.grid_test;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class GridStepDefs {
    /*
   Ders:https://lms.techproeducation.com/mod/book/view.php?id=6601&chapterid=32470
   Selenium GRİD  testlerimizi paralel olarak farklı ortamlarda, (ders33 videosaaat1.18 de paralel anlatımı)
   farklı tarayıcılarda veya farklı sayılarda koşmamıza yarayan bir SUNUCUdur.
   Test komutları bir sunucu merkezi (HUB) tarafından alınır ve json biçimine çevrilir.
   Bu json biçimindeki test komutları birden çok kayıtlı Grid Node una yönlendirilir ve burada çalıştırılır.

   DİKKAT: Masaüstüne seleniumServer klasörü açtık ve
   içine selenium-server-4.14.0.jar dosyasını, chrome, edge ve firefox(gecko) driver indirdik.
   Bu klasörde cmd açtık.
   cmd ekranında şu komutu gir: java -jar selenium-server-4.14.0.jar standalone

   localhost:4444 tıkladığında çıkan Max. Concurrency: 16 sayısı aynı anda 16 test yapabileceğini gösterir.
   testng de paralel test xml file ile cucumber da maven ile yapılır.

   paralel test için 3 farklı runner ımızı aynı anda çalıştıracağız. Bunlardan biri Grid ve CrossBrowser testi yapıyor.
   Terminali açıyoruz ve bukomutugiriyoruz: mvn clean verify  sonra : mvn clean install
    */
    WebDriver driver;

    @Given("user goes to app with chrome")
    public void user_goes_to_app_with_chrome() throws MalformedURLException {

        //RemoteDriver objesi oluştur --> new URL(),  new ChromeOptions()
        //http://192.168.1.59:4444 bu adres değişebilir. cmd de grid açtıktan sonra localhost:4444 in verdiği adrestir.
        /*
        Selenium Grid
Mülakatlarda sorulur ama çok kullanılmaz.

Testlerimizi paralel olarak farklı ortamlarda,
farklı tarayıcılarla, farklı sayılarda koşmamızı sağlayan bir sunucudur.

selenium merkezine bağlanıp orada bir makineden çalışmamız için
kurulum:
masaüstüne bir klasör aç.
içine
1.selenium-server-4.14.0.jar
2.chromedriver.exe crome son versiyon
3.https://github.com/mozilla/geckodriver/releases 'dan geckodriver.exe //firefox driver
4.msedgedriver.exe  edge son versiyon

3 farklı driver oldu.

masaüstü klasörde cmd aç.
java -jar selenium-server-4.14.0.jar standalone (enter)

cmd de çıkan http://192.168.1.38:4444 adresi url e girilir.başka çıkabilir.


         */
        driver = new RemoteWebDriver(new URL("http://192.168.1.37:4444"), new ChromeOptions());

        //Gerisi selenium...
        driver.get("https://www.bluerentalcars.com/");


    }
    @When("verify the title is {string}")
    public void verify_the_title_is(String title) {

        assertEquals(title, driver.getTitle());

    }
    @Then("close the driver")
    public void close_the_driver() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();

    }

    @Given("user goes to app with firefox")
    public void userGoesToAppWithFirefox() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.37:4444"), new FirefoxOptions());
       // driver = new RemoteWebDriver(new URL("localhost:4444"), new FirefoxOptions()); buda olabilirdi
        driver.get("https://www.bluerentalcars.com/");

    }

    @Given("user goes to app with edge")
    public void userGoesToAppWithEdge() throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.37:4444"), new EdgeOptions());
        driver.get("https://www.bluerentalcars.com/");

    }
}
