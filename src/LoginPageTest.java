import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest {
    static WebDriver chromeDriver;


    @BeforeClass
    public static void initDriver() {
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
    public void LG1() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.cssSelector("a[href='signup.html']")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/signup.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void LG2() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).click();
        chromeDriver.findElement(By.className("google")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Please enter your email or username";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG3() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userpasswordInp")).click();
        chromeDriver.findElement(By.className("google")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementpassword")).getText();
        String expectedText ="Please enter your password";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG4() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Please enter your email or username";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG5() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("abc");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="This is not a valid email address";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG6() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("a@a.com");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElementpassword")).getText();
        String expectedText ="Please enter your password";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG7() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("a@a.com");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("abc");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualText = chromeDriver.findElement(By.id("smallElement")).getText();
        String expectedText ="Your email and password don't match our records. Please try again.";
        assertEquals(expectedText,actualText);
    }

    @Test
    public void LG8() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("userEmailInp")).sendKeys("default@gmail.com");
        chromeDriver.findElement(By.id("userpasswordInp")).sendKeys("Default1");
        chromeDriver.findElement(By.id("loginBtn")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/todolist.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void LG9() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("show")).click();

        //Check output
        assertTrue(chromeDriver.findElement(By.id("more-social-medai")).isDisplayed());
    }

    @Test
    public void LG10() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/index.html");
        chromeDriver.findElement(By.id("show")).click();

        //Check output 1
        Boolean expectDisplayed = chromeDriver.findElement(By.id("more-social-medai")).isDisplayed();
        assertTrue(expectDisplayed);

        //Execute test case
        chromeDriver.findElement(By.id("show")).click();

        //Check output 2
        Boolean expectHidden = !chromeDriver.findElement(By.id("more-social-medai")).isDisplayed();

        assertTrue(expectHidden);
    }

    @AfterClass
    public static void tearDown(){
        chromeDriver.quit();
    }

}
