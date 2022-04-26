package testsuite;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void navigateToLoginPageSuccessfully() {

        clickOnElement(By.linkText("Log in"));

        // This is from requirement

        String expectedMessage = "Welcome, Please Sign In!";

        // find welcome text and element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);
        //validate actual and expected message
        Assert.assertEquals("Not Navigate to login page", expectedMessage, actualMessage);



    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        //find login link and click on login link
        clickOnElement(By.linkText("Log in"));

        // Enter email in to email field
        sendTextToElement(By.id("Email"),"pappupatil@gmail.com");

        // Enter Password to password field
        sendTextToElement(By.name("Password"),"123456");

        // Login
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));


        String expectedResult = "Log out";
        WebElement logOutLink = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualResult = logOutLink.getText();


        Assert.assertEquals("Verify logged out", expectedResult, actualResult);
        // error message
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        // find login link and click on login link
        clickOnElement(By.linkText("Log in"));

        //Invalid email in the email field
        sendTextToElement(By.id("Email"),"pappu@gmail.com");

        //Invalid password in the password field
        sendTextToElement(By.name("Password"),"123456");

        //click on login
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));


        String expectedErrormessage =  "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";


        String actualErrormessage = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]")).getText();

        Assert.assertEquals("Error message not displayed", expectedErrormessage, actualErrormessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
