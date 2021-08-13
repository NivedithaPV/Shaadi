package com.shaadi.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shaadi.qa.base.TestBase;

public class HomePage extends TestBase{

	//PAge factory - object repository 
	@FindBy(xpath = "//button[contains(@data-testid, 'lets_begin')]")
	WebElement letsBegin;
	
	@FindBy(xpath = "//form[starts-with(@class,'form-module--wrapper')]")
	WebElement modal;
	
	@FindBy(xpath = "//input[contains(@name,'email')]")
	WebElement emailid;
	
	@FindBy(name="password1")
	WebElement password;
	
	@FindBy(xpath = "//div[contains(@class, 'Dropdown-control postedby_selector')]")
	WebElement dropdown;
	
	@FindBy(xpath = "//button[contains(@type, 'submit')]")
	WebElement button;
	
	@FindBy(xpath = "//div[contains(@class, 'Dropdown-control mother_tongue_selector Dropdown-disabled')]")
	WebElement community;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void letsbegin(){
		letsBegin.click();
	}
	
	public void SetUpAccount() {
		letsBegin.click();
	
		WebElement modalContainer = modal;
		
		WebElement modalContent = modalContainer.findElement(By.xpath("//input[contains(@name,'email')]"));
		modalContent.sendKeys("username@test.com");
		
		WebElement modalContent2 = modalContainer.findElement(By.xpath("//input[contains(@name,'password1')]"));
		modalContent2.sendKeys("password");		
		
		dropdown.click();
		List <WebElement> list = driver.findElements(By.xpath("//div[contains(@class, 'Dropdown-menu postedby_options')]//div"));
		
		
		for(int i =0; i<list.size(); i++) {
			
			if(list.get(i).getText().contains("Son")){
				list.get(i).click();
				break;
			}
		}
		button.click();		
	    
		String  text = community.getText();
		String Actualtext = text.toLowerCase();
		String url = driver.getCurrentUrl();
	    if (url.contains(Actualtext)) {
	     System.out.println("community name and mothertongue is same");
	    }else {
	    	System.out.println("community name and monther tongue is not same");
	    }
	}
}
