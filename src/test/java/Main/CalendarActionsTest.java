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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class CalendarActionsTest {




    @ParameterizedTest
    @ValueSource(strings = {"--start-maximized", "--window-size=1024,768", "--window-size=800,600"})
    // Provide the two values here
    @DisplayName("Parametarized")
    public void CalendarActionsTestCase4(String resolution) {

        String message;

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
        HomePageObjects HomePageObject= new HomePageObjects(webDriver);
        HomePageObject.clickPopUp();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(resolution.equals("--window-size=800,600"))
        {
            HomePageObject.MenuSmall();
            HomePageObject.clickResearchAndEducationsmall();
            HomePageObject.clickEconomicCalendarSmall();
        }
        else {

            HomePageObject.clickResearchAndEducation();

            message = String.valueOf(HomePageObject.getResearchAndEducationMessage());
            System.out.println("Message is:" + message);
            //I assert that in every resolution i must find this button
            Truth.assertThat(message).contains("RESEARCH & EDUCATION");

            //Here i will click the economic calendar inside research and education
            HomePageObject.clickEconomicCalendar();
        }
        //Verify if calendar is loaded, trick here is that there is an iframe, so i have to switch to it in order to find the element
        String messageCalendar = HomePageObject.getEconomicCalendar();
        Truth.assertThat(messageCalendar).contains("events");

        if(resolution.equals("--window-size=800,600")) {
            HomePageObject.clickCalendarIcon();
        }

        //Getting the current date value
        LocalDate currentdate = LocalDate.now();
        System.out.println("Current date: "+currentdate);
        //Getting the current day
        int currentDay = currentdate.getDayOfMonth();
        Month currentMonth = currentdate.getMonth();
        int currentYear = currentdate.getYear();

        int tomorrow = currentDay+1;    //To be clear it needs enchancement to work correct with dates 31+1 etc

        //I will select slicer and move it to today 30, to tomorrow 100

        HomePageObject.SlideCalendar(40);
        message = HomePageObject.GetCalendarSelectedDay();
        Truth.assertThat(message).contains(String.valueOf(currentDay));

        System.out.println("message Today?"+ message);

        HomePageObject.SlideCalendar(40);
        message = HomePageObject.GetCalendarSelectedDay();
        Truth.assertThat(message).contains(String.valueOf(tomorrow));

        //Locate next Monday
        LocalDate ld = LocalDate.of(currentYear, currentMonth, currentDay);
        System.out.println(ld);
        ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(ld.getDayOfMonth());

        HomePageObject.SlideCalendar(100);
        message = HomePageObject.GetCalendarSelectedDay();
        Truth.assertThat(message).contains(String.valueOf(ld.getDayOfMonth()));


        webDriver.close();


    }
}
