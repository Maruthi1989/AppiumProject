package com.appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAppAutomation
{

	static AndroidDriver driver=null;

	public static void main(String[] args) 
	{
		appInstall();
		apiDemos();

	}


	static void appInstall()
	{

		try
		{
			
			//String filepath=System.getProperty("user.dir")+"\\src\\API Demos.apk";

			DesiredCapabilities cap=new DesiredCapabilities();

			//cap.setCapability(MobileCapabilityType.APP, filepath);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Maruthi_AVD");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			cap.setCapability("appPackage", "com.touchboarder.android.api.demos");
			cap.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");



			URL url=new URL("http://127.0.0.1:4723/wd/hub");

			driver=new AndroidDriver(url,cap);
			
			driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());  
		}

	}
	
	
	static void apiDemos()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']")).click();
		
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='View Flip']"));
		
		TouchActions touch=new TouchActions(driver);
		touch.scroll(ele, 10, 100);
		touch.perform();
		ele.click();
		
	}

}//main class close
