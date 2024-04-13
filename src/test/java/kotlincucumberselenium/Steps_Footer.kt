package kotlincucumberselenium

import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import org.junit.Assert.*

class Steps_Footer {

    var driverMethods = Driver()
    var configs = Configs()
    var selectors = Selectors()

    @And("I confirm that the footer is {string}")
    fun verifyFooterStatus(visibleStatus: String) {
        if (visibleStatus == "not visible") {
            assertFalse(driverMethods.elementVisibleOrNot(selectors.footer))
        } else {
            assertTrue(driverMethods.elementVisibleOrNot(selectors.footer))
        }
    }

    @And("I click on the {string} icon in the footer")
    fun clickOnTheFooterIcons(footerIcon: String) {
        when (footerIcon) {
            "Twitter" -> driverMethods.clickButton(selectors.footerTwitter)
            "Facebook" -> driverMethods.clickButton(selectors.footerFacebook)
            "LinkedIn" -> driverMethods.clickButton(selectors.footerLinkedin)
            else -> throw IllegalArgumentException("Incorrect Footer Icon : $footerIcon")
        }
    }

    @Then("I should see the {string} page opened with the URL as {string}")
    fun checkFooterRedirectURL(redirectPage: String, redirectURL: String) {
        when (redirectPage) {
            "Twitter" -> {
                driverMethods.switchBetweenTabs(1)
                assertEquals(driverMethods.getTheCurrentURL(), redirectURL)
                driverMethods.switchBetweenTabs(0)
            }
            "Facebook" -> {
                driverMethods.switchBetweenTabs(2)
                assertEquals(driverMethods.getTheCurrentURL(), redirectURL)
                driverMethods.switchBetweenTabs(0)
            }
            "LinkedIn" -> {
                driverMethods.switchBetweenTabs(3)
                assertEquals(driverMethods.getTheCurrentURL(), redirectURL)
                driverMethods.switchBetweenTabs(0)
            }
            else -> throw IllegalArgumentException("Incorrect Footer Icon : $redirectPage")
        }
    }


}