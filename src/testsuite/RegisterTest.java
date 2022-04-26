package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);


    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.linkText("Register"));

        // expected result
        String expectedresult = "Register";
        // Actual result
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals(actualMessage,expectedresult);
    }
    @Test
    public void userShoudRegisterAccountSuccessfully() {
        // click on the Register link
        clickOnElement(By.linkText("Register"));

        // Select gender radio button
        clickOnElement(By.id("gender-male"));

        // Enter the First name
        sendTextToElement(By.id("FirstName"),"Saurabh");


        // Enter the Last name
        sendTextToElement(By.name("LastName"),"Patel");

        //Click the year of Birth
        clickOnElement(By.xpath("//select[@name='DateOfBirthYear']/option[89]"));

      // click the date of Birth
        clickOnElement(By.xpath("//select[@name='DateOfBirthDay']/option[29]"));

// click the Month of Birth
        clickOnElement(By.xpath("//select[@name='DateOfBirthMonth']/option[11]"));

        // Enter the email in email field
        sendTextToElement(By.name("Email"),"sathipatil@gmail.com");

        //Enter the password field
        sendTextToElement(By.name("Password"),"@12465");

        // reconfirm the password
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"@12465");

        // Click on Registration button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        // verify the text 'Your registration completed'

        // expected result
        String expectedresult = "Your registration completed";
        // Actual result
        WebElement actualResult = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = actualResult.getText();
        System.out.println(actualResult);
        Assert.assertEquals("Registration completed",actualMessage,expectedresult);


    }
    public void tearDown() { closeBrowser();}

}