package com.prometheus.cucumber.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import com.prometheus.cucumber_selenium.CucumberSeleniumApplication;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes=CucumberSeleniumApplication.class)
public class LoginStepsDefinitionTest {
	private static final String BASE_URL = "http://localhost:8083";
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeAll
	public static void setupAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@AfterAll
	public static void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	    driver.get(BASE_URL);
	}
	
	@Given("I enter my username {string}")
	public void i_enter_my_username(String username) {
		final String USERNAME_ID = "username";
	    WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(USERNAME_ID)));
	    usernameField.sendKeys(username);
	}
	
	@Given("I enter my password {string}")
	public void i_enter_my_password(String password) {
		final String PASSWORD_ID = "password";
	    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_ID)));
	    passwordField.sendKeys(password);
	}
	
	@When("I click the login button")
	public void i_click_the_login_button() {
		final String LOGIN_BTN_ID = "login-btn";
	    WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOGIN_BTN_ID)));
	    loginBtn.click();
	}
	
	@Then("a message appears {string}")
	public void a_message_appears(String message) {
	    final String MESSAGE_ID = "login-message";
	    WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MESSAGE_ID)));
	    assertEquals(message, messageElement.getText());
	}
	
}
