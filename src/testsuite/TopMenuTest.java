package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        //computer element
        clickOnElement(By.linkText("Computers"));


        //Actuall result
         WebElement actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualmsg = actualresult.getText();

        //expected result
        String expectedresult = "Computers";

        //Match actual result and expectedresult
        Assert.assertEquals(actualmsg, expectedresult);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        clickOnElement(By.linkText("Electronics"));

        // expected result
        String expectedresult = "Electronics";
        // Actual result
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals(actualMessage,expectedresult);


    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));

        //expected result
       String expectedresult = "Apparel";

        //acutal result
        WebElement actualMessageElement = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals(actualMessage,expectedresult);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        clickOnElement(By.linkText("Digital downloads"));

        //expected result
        String expectedresult = "Digital downloads";
        // actual result
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals(actualMessage,expectedresult);

    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        clickOnElement(By.linkText("Books"));

        //expexted result
        String expectedResult = "Books";
        //Actual result
        String actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Books')]")).getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals("User is not Books page",actualMessageElement,expectedResult);

    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        clickOnElement(By.linkText("Jewelry"));

        //expected result
        String expectedResult = "Jewelry";
        // actual result
        String actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]")).getText();
        System.out.println(actualMessageElement);
        Assert.assertEquals("User is not on Jewelry tab",actualMessageElement,expectedResult);

    }
@Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        clickOnElement(By.linkText("Gift Cards"));

        // expected result
    String expectedResult = "Gift Cards";
    // actual result
    String actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Gift Cards')]")).getText();
    System.out.println(actualMessageElement);
    Assert.assertEquals("User unable to open Gift cards",actualMessageElement,expectedResult);


}
public void tearDown(){
        driver.quit();
}
}
