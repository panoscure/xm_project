package org.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageObjects {

    Duration timeout = Duration.ofSeconds(30);

    WebDriver webDriver;

    public HomePageObjects(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getMainPageMessage() {
        String path = "//*[@class='stripe-main__title']";

        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement text =  webDriver.findElement(By.xpath(path));

        String textAsString = text.getText();
        System.out.println("Text:"+textAsString);
        return textAsString;
    }

    public String getResearchAndEducationMessage() {
        String path = "//*[@id=\"main-nav\"]/li[4]/div/div/div[1]/span";

        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement text =  webDriver.findElement(By.xpath(path));

        String textAsString = text.getText();
        System.out.println("Text:"+textAsString);
        return textAsString;
    }

    public String getEconomicCalendar() {
        String path = "//*[@class='tc-economic-calendar-view-container-title tc-normal-text']";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //move browser a bit down
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,200);");
        webDriver.switchTo().frame(0);
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement text =  webDriver.findElement(By.xpath(path));

        String textAsString = text.getText();
        System.out.println("Text:"+textAsString);
        return textAsString;
    }


    public HomePageObjects clickPopUp() {
        String path = "//*[@id='cookieModal']/div/div/div[1]/div[3]/div[2]/div[3]/button";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickAcceptAll =  webDriver.findElement(By.xpath(path));
        clickAcceptAll.click();
        return this;
    }

    public HomePageObjects clickResearchAndEducation() {

        String path = "//*[@id=\"main-nav\"]/li[4]/a";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickSearchAndEducation =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickSearchAndEducation);
        return this;
    }

    public HomePageObjects IntroToTheMarkets() {

        String path = "//*[@id=\"js-videoPlaylist\"]/li[2]/button";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickSearchAndEducation =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickSearchAndEducation);
        return this;
    }

    public HomePageObjects Lesson1_1() {

        String path = "//*[@id=\"js-collapse-trd-s1\"]/ul/li[1]/a";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickSearchAndEducation =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickSearchAndEducation);
        return this;
    }

    public HomePageObjects ClickVideo() {
        webDriver.switchTo().frame(0);

        String path = "//video[@class='hls-player']";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickSearchAndEducation =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickSearchAndEducation);
        return this;
    }



    public HomePageObjects clickEducationalVideo() {

        String path = "//a[contains(text(),'Educational Videos')]";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickEducationalVideo =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickEducationalVideo);
        return this;
    }

    public HomePageObjects clickEducationalVideoSmall() {

        String path = "(//*[@href='https://www.xm.com/educational-videos'])[2]";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickEducationalVideo =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickEducationalVideo);
        return this;
    }


    public HomePageObjects clickResearchAndEducationsmall() {

        String path = "//span[text()='Research & Education']";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickButton =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickButton);
        return this;
    }


    public HomePageObjects MenuSmall() {

        String path = "//*[@id=\"main-nav\"]/div[1]/div/div/button[1]/i[1]";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickAcceptAll =  webDriver.findElement(By.xpath(path));
        clickAcceptAll.click();
        return this;
    }


    public HomePageObjects clickEconomicCalendar() {

        String path = "//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[1]/ul/li[6]/a";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickAcceptAll =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickAcceptAll);
        //clickAcceptAll.click();
        return this;
    }

    public HomePageObjects clickEconomicCalendarSmall() {
        String path = "//span[text()='Economic Calendar']";
        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickAcceptAll =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickAcceptAll);
        //clickAcceptAll.click();
        return this;
    }

    public HomePageObjects clickCalendarIcon() {
        String path = "//*[@class='mat-icon notranslate mat-badge ng-tns-c145-0 material-icons-outlined mat-icon-no-color mat-badge-overlap mat-badge-above mat-badge-after mat-badge-small mat-badge-hidden']";

        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement clickAcceptAll =  webDriver.findElement(By.xpath(path));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickAcceptAll);
        //clickAcceptAll.click();
        return this;
    }


    public HomePageObjects SlideCalendar(int distance) {
        String path = "//*[@class='mat-slider-thumb']";
        //webDriver.switchTo().frame(0);



        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));

        WebElement clickSlider =  webDriver.findElement(By.xpath(path));
        //clickSlider.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", clickSlider);
        //clickSlider.sendKeys(Keys.ARROW_RIGHT);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions move = new Actions(webDriver);
        Action action = (Action) move.dragAndDropBy(clickSlider, distance, 0).build();
        action.perform();
        return this;
    }

    public String GetCalendarSelectedDay() {
        //String path = "//*[@id=\"RecogniaContent\"]/table/tbody/tr/td/economic-calendar/div/tc-economic-calendar-landing/div/tc-economic-calendar-view-container/div/div/div[2]/div[1]/tc-time-filter-container/div/div/span/span/div";
        String path = "//*[contains(@class, 'mat-calendar-body-selected')]";


        new WebDriverWait(webDriver, timeout).until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(path)));
        WebElement text =  webDriver.findElement(By.xpath(path));
        String textAsString = text.getText();
        System.out.println("Text:"+textAsString);

        return textAsString;
    }


}