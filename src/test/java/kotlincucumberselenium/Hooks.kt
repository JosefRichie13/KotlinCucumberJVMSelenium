package kotlincucumberselenium

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import io.github.bonigarcia.wdm.WebDriverManager
import kotlincucumberselenium.Hooks.webDriver.driver
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File


class Hooks {

    object webDriver {
        var driver: WebDriver? = null
    }

    @Before
    fun executedBefore() {
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
    }

    @After
    fun executedAfter(scenario: Scenario) {
        val screenshot: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
        val fileContent: ByteArray = FileUtils.readFileToByteArray(screenshot)
        scenario.attach(fileContent, "image/png", "image1")
        driver?.quit()
    }
}