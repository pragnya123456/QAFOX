package org.QAfoxProject.Components;

import org.QAfoxProject.GenericUtility.BaseConfiguration;
import org.QAfoxProject.GenericUtility.WebDriverLibrary;
import org.QAfoxProject.PageRepository.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Components_WebCameras_Test extends BaseConfiguration{

	@Test
	
	public void webCamera()
	{
		HomePage homeobj = new HomePage(webdriverobj.driver);
		webdriverobj.mouseHoverToElement(homeobj.getComponents());
		javautilityobj.pause(5000);
		homeobj.getWebcamera().click();
	}
}
