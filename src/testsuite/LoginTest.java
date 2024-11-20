package testsuite;

/**
 * 1. userShouldNavigateToLoginPageSuccessfully()
 *
 * * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign In!’
 *
 * 2. userShouldLoginSuccessfullyWithValidCredentials()
 *
 * * click on the ‘Login’ link
 * * Enter a valid username
 * * Enter a valid password
 * * Click on the ‘Login’ button
 * * Verify the ‘Welcome to our store’
 * text is displayed
 * 3. verifyTheErrorMessage()
 *
 * * click on the ‘Login’ link
 * * Enter the invalid username
 * * Enter the invalid password
 * * Click on the ‘Login’ button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find the login link element andclick on the login link element

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        String expectedText = "Welcome, Please Sign In!";
        WebElement welcomeTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText, actualText);


    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Find the email field and type email address to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime@gmail.com");

        // Find the password field and type email address to email field
        driver.findElement(By.name("Password")).sendKeys("Prime1234");

        // find login button element and click on it
        driver.findElement(By.xpath("//input[@value = 'Log in']")).click();
        String expectedErrorMessage = "‘Login was unsuccessful.\n" +
                "Please correct the errors and try again. No customer account found’";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class = 'validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not displayed" , expectedErrorMessage,actualErrorMessage);


    }

    public void  verifyTheErrorMessage(){
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // Find the email field and type email address to email field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime@gmail.com");

        // Find the password field and type email address to email field
        driver.findElement(By.name("Password")).sendKeys("Prime1234");


    }

    @After
    public void tearDownBrowser() {
         closeBrowser();
    }
}