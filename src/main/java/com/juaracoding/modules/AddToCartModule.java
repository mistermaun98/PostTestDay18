package com.juaracoding.modules;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartModule {
    private WebDriver driver;

    public AddToCartModule() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'ToolsQA Demo Site')]")
    WebElement homeLink;

    @FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
    WebElement pickProduct;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement color;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement size;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddCart;

    @FindBy(xpath = "//a[normalize-space()='View cart']")
    WebElement viewCart;

    @FindBy(xpath = "//h1[normalize-space()='Cart']")
    WebElement txtCart;

    public void mainPage() {
        homeLink.click();
    }

    public String validatePage() {
        return txtCart.getText();
    }

    public void chooseVariant() {
        pickProduct.click();
        color.sendKeys("Pink");
        size.sendKeys("38");
        btnAddCart.click();
        viewCart.click();
    }
}
