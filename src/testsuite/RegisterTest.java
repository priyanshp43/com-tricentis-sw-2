package testsuite;

/**
 * 1. userShouldNavigateToRegisterPageSuccessfully()
 *
 * * click on the ‘Register’ link
 * * Verify the text ‘Register’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Register’ link
 * * Select the gender radio button
 * * Enter the First name
 *
 * * Enter the Last name
 * * Enter Email address
 * * Enter Password
 * * Enter Confirm password
 * * Click on the ‘Register’ button
 *
 * * Verify the text 'Your registration completed’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.linkText("Register")).click();
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText, "Register");
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Urvi");
        driver.findElement(By.id("LastName")).sendKeys("p");
        driver.findElement(By.id("Email")).sendKeys("urvishaparmar22@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password123");
        driver.findElement(By.id("register-button")).click();
        String actualText = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")).getText();
        Assert.assertEquals(actualText, "Your registration completed");
    }

    @After
    public void tearDownBrowser() {
         closeBrowser();
    }
}
