package kotlincucumberselenium

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.util.stream.Collectors


class Driver {

    fun loadAUrl(url: String?) {
        Hooks.webDriver.driver?.get(url)
    }

    fun typeText(textToType: String?, element: By?) {
        Hooks.webDriver.driver?.findElement(element)?.sendKeys(textToType)
    }

    fun clickButton(element: By?) {
        Hooks.webDriver.driver?.findElement(element)?.click()
    }

    fun getTextFromElement(element: By?): String? {
        return Hooks.webDriver.driver?.findElement(element)?.text
    }

    fun getSpecificTextFromAListOfElements(element: By?, index: Int): String? {
        return Hooks.webDriver.driver?.findElements(element)?.get(index)?.text
    }

    fun getAllTextFromAListOfElements(element: By?): List<String>? {
        val elements: List<WebElement> = Hooks.webDriver.driver?.findElements(element) as List<WebElement>
        return elements.stream().map { obj: WebElement -> obj.text }.collect(Collectors.toList())
    }

    fun selectFromDropdownUsingText(element: By?, selectOptionInText: String?) {
        val elementToSelect: WebElement? = Hooks.webDriver.driver?.findElement(element)
        val select = Select(elementToSelect)
        select.selectByVisibleText(selectOptionInText)
    }

    fun getTheCurrentURL(): String? {
        return Hooks.webDriver.driver?.currentUrl
    }

    fun switchBetweenTabs(tabNumber: Int?) {
        val setOfHandleIDS: Set<String> = Hooks.webDriver.driver?.windowHandles as Set<String>
        val listOfHandleIDS: List<String> = ArrayList(setOfHandleIDS)
        Hooks.webDriver.driver?.switchTo()?.window(listOfHandleIDS[tabNumber!!])
    }

    // Checks if an element is present in the DOM or not
    // Returns FALSE if element is NOT visible, which means the size will be 0
    // Returns TRUE if element is visible, which means the size will be greater than 0
    fun elementVisibleOrNot(element: By?): Boolean {
        val status: Int? = Hooks.webDriver.driver?.findElements(element)?.size
        return if (status == 0) {
            false
        } else {
            true
        }
    }
}