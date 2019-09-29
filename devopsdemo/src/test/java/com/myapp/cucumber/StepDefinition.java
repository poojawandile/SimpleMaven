package com.myapp.cucumber;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.myapp.bl.PropertyLoader;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	static WebDriver driver;
	String browserHead;
	String appUrl;
	String chromeDriver;
	String chromeExe;
	
	
	@Given("^Open Chrome browser and my App$")
	public void openChromeAndmyapp() {
		
		PropertyLoader propLoader = new PropertyLoader();
		propLoader.readProperty();
		browserHead = propLoader.browserHead;
		appUrl = propLoader.appUrl;
		chromeDriver = propLoader.chromeDriver;
		chromeExe = propLoader.chromeExe;
		
		
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		System.setProperty("webdriver.chrome.bin", chromeExe);
		createDriver();
		driver.navigate().to(appUrl);
	}

	@When("^I enter input for Fib \"([^\"]*)\"$")
	public void i_enter_input_for_Fib(String arg1) {
		driver.findElement(By.name("numOfFibElements")).sendKeys(arg1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Click on Generate Fib Series$")
	public void click_on_Generate_Fib_Series() throws Throwable {
		driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[3]/span/input")).click();
		Thread.sleep(10000);

	}

	@Then("^I get output for Fib \"([^\"]*)\"$")
	public void i_get_output_for_Fib(String expectedResult) {
		try {
			String actualStr = driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[4]/strong")).getText();
			System.out.println("actualStr **** eeee" + actualStr);
			assertEquals(expectedResult, actualStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^I give input for Prime Num \"([^\"]*)\"$")
	public void i_give_input_for_Prime_Num(String arg1) {
			driver.findElement(By.name("numOfPrimeNumbers")).sendKeys(arg1);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Then("^Click on Generate Prime numbers$")
	public void click_on_Generate_Prime_numbers() {
		driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[3]/span/input")).click();
	}

	@Then("^I get output for prime \"([^\"]*)\"$")
	public void i_get_output_for_prime(String expectedPrimes) {
		String actualPrimes = driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[4]/strong")).getText();
		assertEquals(expectedPrimes, actualPrimes);

	}

	@When("^I give list of numbers \"([^\"]*)\"$")
	public void i_give_list_of_numbers(String listOfNums) {
		driver.findElement(By.xpath("/html/body/form/table/tbody[3]/tr/td[2]/input")).sendKeys(listOfNums);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^I click on sort numbers$")
	public void i_click_on_sort_numbers() {
		driver.findElement(By.xpath("/html/body/form/table/tbody[3]/tr/td[3]/span/input")).click();
	}

	@Then("^I get sorted numbers \"([^\"]*)\"$")
	public void i_get_sorted_numbers(String expectedNums) {
		String actualNums = driver.findElement(By.xpath("/html/body/form/table/tbody[3]/tr/td[4]/strong")).getText();
		assertEquals(expectedNums, actualNums);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^I get \"([^\"]*)\"$")
	public void i_get(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("/html/body/form/table/thead[2]/tr/td[3]/strong")).getText();
		assertEquals(expectedMsg, actualMsg);
	}
	
	@Then("^Close Browser$")
	public void close_Browser() throws Throwable {
		System.out.println("INside close ******** &&&&&&& ");
		driver.close();
		driver.quit();
		driver = null;

	}

	@SuppressWarnings("deprecation")
	private void createDriver() {
		

		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments(browserHead);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
