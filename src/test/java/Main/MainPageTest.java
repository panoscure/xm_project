package Main;

import com.google.common.truth.Truth;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.objects.HomePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import properties.Properties;

public class MainPageTest {




    @ParameterizedTest
    @ValueSource(strings = {"--start-maximized", "--window-size=1024,768", "--window-size=800,600"})
    // Provide the two values here
    @DisplayName("Parametarized")
    public void MainPageTestCase1(String resolution) {

        Properties.loadProperties("site.properties");
        String url = Properties.getPropertyValue("url");

        WebDriverManager.chromedriver().driverVersion("115.0").setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments(new String[]{"--start-maximized"});
        chromeOptions.addArguments(new String[]{resolution});

        chromeOptions.addArguments(new String[]{"--ignore-certificate-errors"});
        chromeOptions.addArguments(new String[]{"--remote-debugging-port=9222"});

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(url);

        System.out.println("resolution: " + resolution);
        //here i will click accept all in the popup
        HomePageObjects HomePageObject = new HomePageObjects(webDriver);
        HomePageObject.clickPopUp();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = String.valueOf(HomePageObject.getMainPageMessage());
        System.out.println("Message is:" + message);
        Truth.assertThat(message).isEqualTo("1000+");

        webDriver.close();


    }
}
