package com.stepdefinition;

import org.openqa.selenium.By;

import Greens.cucuproject.Basefunctions;

public class dotry extends Basefunctions {
	public static void main(String[] args) {
		
	//pomclass po = new pomclass(driver);
	browserlauncher("chrome");
	gourl("https://www.xe.com");
	
	driver.findElement(By.xpath("//div[contains(@class,'amount-input')]")).click();
	implicitwait(50);
	driver.findElement(By.xpath("//div[contains(@class,'amount-input')]")).sendKeys("10");

}
}