package com.cybertek.tests.weeklyTasks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class AutomationTask {

    public static void main(String[] args) throws InterruptedException {

        //defining
        String amazonTitle = "Amazon.com. Spend less. Smile more.";
        String youtubeTitle = "YouTube";

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://amazon.com");

        System.out.print(driver.getTitle() + " == " + amazonTitle + " ");
        System.out.println(driver.getTitle().equalsIgnoreCase(amazonTitle));

        Thread.sleep(2000);

        driver.get("https://youtube.com");
        System.out.print(driver.getTitle() + " == " + youtubeTitle + "? ");
        System.out.println(driver.getTitle().equalsIgnoreCase(youtubeTitle));

        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.quit();
    }
}
