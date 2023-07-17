package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomclass {

	public static WebDriver driver;
	@FindBy(xpath="//div[contains(@class,'amount-input')]")private WebElement amount;
	@FindBy(id="midmarketFromCurrency")private WebElement fromcurrency;
	@FindBy(id="midmarketToCurrency")private WebElement tocurrency;
	@FindBy(xpath="(//button[contains(@class,'1qpsalo')])[3]")private WebElement convert;
	@FindBy(xpath="(//p[contains(@class,'result__BigRate')])")private WebElement convamount;
	
	   public pomclass(WebDriver driver) {
		   this.driver=driver;
			PageFactory.initElements(driver, this);
		}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getFromcurrency() {
		return fromcurrency;
	}

	public WebElement getTocurrency() {
		return tocurrency;
	}

	public WebElement getConvert() {
		return convert;
	}

	public WebElement getConvamount() {
		return convamount;
	}
	   
	   
	
}
