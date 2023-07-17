package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.helper.Filereadermanager;
import com.helper.Pageobjectmanager;
import com.runner.runnerclass;

import Greens.cucuproject.Basefunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sttepdefinition extends Basefunctions {
	public static WebDriver driver= runnerclass.driver;
	Pageobjectmanager pom = new Pageobjectmanager(driver);
	Actions performAct = new Actions(driver);
	@Given("launch the application")
	public void launchTheApplication() throws IOException {
		String siteaddress = Filereadermanager.getInstance().getcrinstance().siteaddress();
		gourl(siteaddress);
	}
	@When("user enters {string}  in amount field")
	public void userEntersInAmountField(String amo) {
		WebElement amount = pom.getlp().getAmount(); 
		performAct.sendKeys(amount, amo).build().perform(); 
	}
	@When("user selects {string} currency option before conversion")
	public void userSelectsCurrencyOptionBeforeConversion(String from) throws AWTException {
	   WebElement fromcurrency = pom.getlp().getFromcurrency();
	   fromcurrency.click();
	   JavascriptExecutor runJS= ((JavascriptExecutor) driver); 
		runJS.executeScript("arguments[0].value= 'from';", fromcurrency);
		robotenter();  
	}
	@When("user selects {string} currency to be converted after conversion")
	public void userSelectsCurrencyToBeConvertedAfterConversion(String to) throws AWTException, InterruptedException {
		 WebElement tocurrency = pom.getlp().getTocurrency();
		 performAct.click(tocurrency).perform();
		 performAct.moveToElement(tocurrency).click().perform(); 
		 performAct.sendKeys(to).perform(); 
		 robotenter();
		 Thread.sleep(8000);		
	}
	@Then("user converts the currency")
	public void userConvertsTheCurrency() throws InterruptedException {
		Thread.sleep(5000);
	  pom.getlp().getConvert().click();
	}
	@Then("user displays the converted currency")
	public void userDisplaysTheConvertedCurrency() {
	   String text = pom.getlp().getConvamount().getText();
	   System.out.println(text);
	}
	
	
	
	
}
