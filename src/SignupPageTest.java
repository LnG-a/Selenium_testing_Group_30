import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SignupPageTest {
    static WebDriver chromeDriver;


    @BeforeClass
    public static void initDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://E-Learning//3-1//Tesing//selenium jar and drivers//chromeDriver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("http://127.0.0.1:5500/signup.html");
        chromeDriver.manage().window().maximize();

        //Signup a default user
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("Continuebtn")).click();
    }

    @Test
    public void SU1() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.cssSelector("a[href='index.html']")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/index.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void SU2() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).click();
        chromeDriver.findElement(By.className("google")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Please enter your email";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU3() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("abc");
        chromeDriver.findElement(By.className("google")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="This is not a valid email address";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU4() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("Continuebtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Please enter your email";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU5() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("abc");
        chromeDriver.findElement(By.id("Continuebtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="This is not a valid email address";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU6() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("abc@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();

        //Check output
        Boolean expectDisplayed = chromeDriver.findElement(By.id("datacontainer")).isDisplayed();
        assertTrue(expectDisplayed);

        String actualText = chromeDriver.findElement(By.id("Continuebtn")).getText();
        String expectedText ="Create Account";
        assertEquals(expectedText,actualText);

    }

    @Test
    public void SU7() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userEmailInp")).clear();
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Please enter your email";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU8() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userEmailInp")).clear();
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("abc");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="This is not a valid email address";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU9() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementFname")).getText();
        String expectedText ="Please enter your first name";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU10() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("1");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementFname")).getText();
        String expectedText ="Name should not contain special characters or Numbers";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU11() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("1");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementLname")).getText();
        String expectedText ="Name should not contain special characters or Numbers";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU12() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementpassword")).getText();
        String expectedText ="Please enter your password";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU13() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("abc");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementpassword")).getText();
        String expectedText ="Password must contain an uppercase letter, numbers and at least 8 characters";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU14() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("Continuebtn")).click();


        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="This email’s already used";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void SU15() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default1@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("Continuebtn")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/index.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void SU16() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default1@gmail.com");
        chromeDriver.findElement(By.id("Continuebtn")).click();
        chromeDriver.findElement(By.id("userFnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userLnameInp")).sendKeys("Default");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("Continuebtn")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/index.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void SU17() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default1@gmail.com");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/todolist.html";
        assertEquals(expectedURL,actualURL);
    }


    @Test
    public void SU18() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("show")).click();

        //Check output
        assertTrue(chromeDriver.findElement(By.id("more-social-medai")).isDisplayed());
    }

    @Test
    public void SU19() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/signup.html");
        chromeDriver.findElement(By.id("show")).click();

        //Check output 1
        boolean expectDisplayed = chromeDriver.findElement(By.id("more-social-medai")).isDisplayed();
        assertTrue(expectDisplayed);

        //Execute test case
        chromeDriver.findElement(By.id("show")).click();

        //Check output 2
        boolean expectHidden = !chromeDriver.findElement(By.id("more-social-medai")).isDisplayed();
        assertTrue(expectHidden);
    }

    @AfterClass
    public static void tearDown(){
        chromeDriver.quit();
    }

}
