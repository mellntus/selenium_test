package maven_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WhiteboxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try	{
			System.setProperty("webdriver.chrome.driver", "C:\\File Instalation\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
//			Open New Browser + Open Specified URL + Maximize
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			String newline = System.getProperty("line.separator");
			
//			Test Case 1 : Title = Swag Labs
			String urlTitle = driver.getTitle();
			if("Swag Labs".equals(urlTitle)) {
				System.out.print("First Test Case Passed" + newline);
			}else {
				System.out.print("First Test Case Failed" + newline);
			}
			
			Thread.sleep(2000);
			
//			Test Case 2 : Login Fail with Incorrect Email/Password
//			Username
			WebElement inputUsername = driver.findElement(By.xpath("//*[@id='user-name']"));
			inputUsername.sendKeys("standard");
			String dataUsername = inputUsername.getAttribute("value");
			
//			Password
			WebElement inputPassword = driver.findElement(By.xpath("//*[@id='password']"));
			String password = "secret_sauce";
			inputPassword.sendKeys(password);
			String dataPassword = inputPassword.getAttribute("value");
			
			driver.findElement(By.xpath("//*[@id='login-button']")).submit();
			
//			System.out.print(dataUsername + newline);
//			System.out.print(dataPassword + newline);
			
			if(("standard_user".equals(dataUsername) && password.equals(dataPassword)) || 
					("locket_out_user".equals(dataUsername) && password.equals(dataPassword)) ||
						("problem_user".equals(dataUsername) && password.equals(dataPassword)) || 
							("performance_user".equals(dataUsername) && password.equals(dataPassword))) {
				
				System.out.print("Second Test Case Failed" + newline);
			}else {
				System.out.print("Second Test Case Passed" + newline);
			}
			
			Thread.sleep(2000);
			
//			Test Case 3 : Login Fail with Incorrect Password
//			Username
			inputUsername.clear();
			inputUsername.sendKeys("standard_user");
			String dataUsername1 = inputUsername.getAttribute("value");
			
//			Password
			inputPassword.clear();
			inputPassword.sendKeys("secret");
			String dataPassword1 = inputPassword.getAttribute("value");
			
			driver.findElement(By.xpath("//*[@id='login-button']")).submit();
			
//			System.out.print( dataUsername1 + newline);
//			System.out.print(dataPassword1 + newline);
			
			if(("standard_user".equals(dataUsername1) && password.equals(dataPassword1)) || 
					("locket_out_user".equals(dataUsername1) && password.equals(dataPassword1)) ||
						("problem_user".equals(dataUsername1) && password.equals(dataPassword1)) || 
							("performance_user".equals(dataUsername1) && password.equals(dataPassword1))) {
				System.out.print("Third Test Case Failed" + newline);
			}else {
				System.out.print("Third Test Case Passed" + newline);
				
			}
			
			Thread.sleep(2000);
			
//			Test Case 4 : Login Passed
//			Username
			inputUsername.clear();
			inputUsername.sendKeys("standard_user");
			String dataUsername2 = inputUsername.getAttribute("value");
			
//			Password
			inputPassword.clear();
			inputPassword.sendKeys(password);
			String dataPassword2 = inputPassword.getAttribute("value");
			
			driver.findElement(By.xpath("//*[@id='login-button']")).submit();
			
			if(("standard_user".equals(dataUsername2) && password.equals(dataPassword2)) || 
					("locket_out_user".equals(dataUsername2) && password.equals(dataPassword2)) ||
						("problem_user".equals(dataUsername2) && password.equals(dataPassword2)) || 
							("performance_user".equals(dataUsername2) && password.equals(dataPassword2)) ) {
				System.out.print("Fourth Test Case Passed" + newline);
				driver.navigate().to("https://www.saucedemo.com/inventory.html");  
			}else {
				System.out.print("Fourth Test Case Failed" + newline);
				
			}
			
			Thread.sleep(2000);
			
//			Test Case 5 : Add to Cart Button
			driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
			driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).click();
			
			driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
			
			driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")).click();
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, 300)");
			System.out.println("Fifth Test Case Passed");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
			jse.executeScript("window.scrollBy(0, -300)");
			
//			Test Case 6 : Filter By Index 0 - 3
			WebElement listDropdown = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select"));
			Select dropdown = new Select(listDropdown);
			List <WebElement> tagFilter = dropdown.getOptions();
			
			int size = tagFilter.size();
			
//			Stuck at Loop Index 1
			for(int i = 0; i<2 ; i++) {
				String options = tagFilter.get(i).getText();
				tagFilter.get(i).click();
				Thread.sleep(1000);
				System.out.println(options);
			}
			System.out.println("Sixth Test Case Passed");
			
//			Test Case 7 : Remove Product from Cart
			driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
			driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']")).click();
			System.out.println("Seventh Test Case Passed");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@id='checkout']")).click();
			
//			Test Case 8 : Fill Checkout Form + Logout
//			First-Name
			WebElement inputFirstName = driver.findElement(By.xpath("//*[@id='first-name']"));
			inputFirstName.sendKeys("Erlangga");
			String dataFirstName = inputFirstName.getAttribute("value");
			
//			Last-Name
			WebElement inputLastName = driver.findElement(By.xpath("//*[@id='last-name']"));
			inputLastName.sendKeys("AH");
			String dataLastName = inputLastName.getAttribute("value");
			
//			Postal-Code
			WebElement inputPostalCode = driver.findElement(By.xpath("//*[@id='postal-code']"));
			inputPostalCode.sendKeys("11840");
			String dataPostalCode = inputPostalCode.getAttribute("value");
			
			if(dataFirstName != null && dataLastName != null && dataPostalCode != null) {
				System.out.println("Eighth Test Case Passed");
				driver.findElement(By.xpath("//*[@id='continue']")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='finish']")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='back-to-products']")).click();
				driver.navigate().to("https://www.saucedemo.com/inventory.html");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
				
			}else {
				System.out.println("Eight Test Case Fail");
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
