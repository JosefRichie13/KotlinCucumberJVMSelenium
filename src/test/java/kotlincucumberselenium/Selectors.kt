package kotlincucumberselenium

import org.openqa.selenium.By

class Selectors {
    var userName = By.id("user-name")
    var password = By.id("password")
    var loginButton = By.id("login-button")
    var homepageTitle = By.className("app_logo")
    var errorMessage = By.cssSelector(".error-message-container.error h3")
    var loginpageTitle = By.className("login_logo")
    var menu = By.id("react-burger-menu-btn")
    var logoutButton = By.id("logout_sidebar_link")
    var productBackpack = By.cssSelector("button[name*=sauce-labs-backpack]")
    var productBikelight = By.cssSelector("button[name*=sauce-labs-bike-light]")
    var productTshirt = By.cssSelector("button[name*=sauce-labs-bolt-t-shirt]")
    var productJacket = By.cssSelector("button[name*=sauce-labs-fleece-jacket]")
    var productOnesie = By.cssSelector("button[name*=sauce-labs-onesie]")
    var productTshirtRed = By.cssSelector("button[name*=allthethings]")
    var cart = By.className("shopping_cart_link")
    var checkout = By.id("checkout")
    var firstName = By.id("first-name")
    var lastName = By.id("last-name")
    var zipCode = By.id("postal-code")
    var continueButton = By.id("continue")
    var finishButton = By.id("finish")
    var checkoutBanner = By.className("complete-header")
    var taxCalculated = By.className("summary_tax_label")
    var subtotal = By.className("summary_subtotal_label")
    var fullTotal = By.cssSelector("div[class*=summary_total_label]")
    var priceList = By.className("inventory_item_price")
    var itemNumberInCart = By.className("shopping_cart_badge")
    var productSort = By.className("product_sort_container")
    var productList = By.className("inventory_item_name")
    var footer = By.className("footer")
    var footerTwitter = By.cssSelector(".social_twitter a")
    var footerFacebook = By.cssSelector(".social_facebook a")
    var footerLinkedin = By.cssSelector(".social_linkedin a")
}