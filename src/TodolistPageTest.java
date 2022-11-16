import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TodolistPageTest {
    static WebDriver chromeDriver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver","D://E-Learning//3-1//Tesing//selenium jar and drivers//chromeDriver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }
    @Test
    public void TD1() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("logoutBtn")).click();

        //Check output
        String actualURL = chromeDriver.getCurrentUrl();
        String expectedURL ="http://127.0.0.1:5500/index.html";
        assertEquals(expectedURL,actualURL);
    }

    @Test
    public void TD2() {
        //Execute test case
        chromeDriver.navigate().to("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("addBtn")).click();
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));

        //Check output
        Integer numberOfTask = contents.size();
        assertEquals(1,numberOfTask);
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="";
        assertEquals(expectedTaskTitle,actualTaskTitle);
    }

    @Test
    public void TD3() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        Integer numberOfTask = contents.size();
        assertEquals(1,numberOfTask);
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);
    }

    @Test
    public void TD4() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle = "go shopping";
        assertEquals(expectedTaskTitle, actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Check output 2
        contents = chromeDriver.findElements(By.className("content"));
        Integer numberOfTask = contents.size();
        assertEquals(0, numberOfTask);

    }
    @Test
    public void TD5() {
        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.id("layer")).isDisplayed());
    }

    @Test
    public void TD6() {
        //Reset
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.id("layer")).isDisplayed());

        //Execute test case
        chromeDriver.findElement(By.id("ChangeBtn")).click();

        //Check output 3-4
        assertFalse(chromeDriver.findElement(By.id("layer")).isDisplayed());

        contents = chromeDriver.findElements(By.className("content"));
        actualTaskTitle = contents.get(0).getText();
        assertEquals(expectedTaskTitle,actualTaskTitle);
    }

    @Test
    public void TD7() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.id("layer")).isDisplayed());

        //Execute test case
        chromeDriver.findElement(By.id("edituserworksInp")).clear();
        chromeDriver.findElement(By.id("edituserworksInp")).sendKeys("hair cut");
        chromeDriver.findElement(By.id("ChangeBtn")).click();

        //Check output 3-4
        assertFalse(chromeDriver.findElement(By.id("layer")).isDisplayed());

        contents = chromeDriver.findElements(By.className("content"));
        actualTaskTitle = contents.get(0).getText();
        expectedTaskTitle ="hair cut";
        assertEquals(expectedTaskTitle,actualTaskTitle);
    }

    @Test
    public void TD8() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.id("layer")).isDisplayed());

        //Execute test case
        chromeDriver.findElement(By.id("edituserworksInp")).clear();
        chromeDriver.findElement(By.id("edituserworksInp")).sendKeys("hair cut");
        chromeDriver.findElement(By.id("CancelBtn")).click();

        //Check output 3-4
        assertFalse(chromeDriver.findElement(By.id("layer")).isDisplayed());

        contents = chromeDriver.findElements(By.className("content"));
        actualTaskTitle = contents.get(0).getText();
        expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);
    }

    @Test
    public void TD9() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.className("doneword")).isDisplayed());
    }

    @Test
    public void TD10() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output 1
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitle = contents.get(0).getText();
        String expectedTaskTitle ="go shopping";
        assertEquals(expectedTaskTitle,actualTaskTitle);

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();

        //Check output 2
        assertTrue(chromeDriver.findElement(By.className("doneword")).isDisplayed());

        //Execute test case
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();

        //Check output 3
        assertFalse(chromeDriver.findElement(By.className("doneword")).isDisplayed());
    }

    @Test
    public void TD11() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("hair cut");
        chromeDriver.findElement(By.id("addBtn")).click();

        //Check output
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        List<WebElement> status = chromeDriver.findElements(By.className("doneword"));

        String actualTaskTitleGoShopping = contents.get(0).getText();
        String actualTaskTitleHaircut = contents.get(1).getText();

        assertEquals("go shopping",actualTaskTitleGoShopping);
        assertEquals("hair cut",actualTaskTitleHaircut);

        assertTrue(status.get(0).isDisplayed());
        assertFalse(status.get(1).isDisplayed());


    }

    @Test
    public void TD12() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();
        chromeDriver.findElement(By.id("ChangeBtn")).click();

        //Check output
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitleGoShopping = contents.get(0).getText();
        assertEquals("go shopping",actualTaskTitleGoShopping);
        assertTrue(chromeDriver.findElement(By.className("doneword")).isDisplayed());
    }

    @Test
    public void TD13() {
        //Reset
        chromeDriver.findElement(By.cssSelector(".remove[onclick='remove(0)']")).click();

        //Execute test case
        chromeDriver.get("http://127.0.0.1:5500/todolist.html");
        chromeDriver.findElement(By.id("userworksInp")).sendKeys("go shopping");
        chromeDriver.findElement(By.id("addBtn")).click();
        chromeDriver.findElement(By.cssSelector(".Userword[onchange='check(this,0)']")).click();
        chromeDriver.findElement(By.cssSelector(".edit[onclick='edit(0)']")).click();
        chromeDriver.findElement(By.id("CancelBtn")).click();

        //Check output
        List<WebElement> contents = chromeDriver.findElements(By.className("content"));
        String actualTaskTitleGoShopping = contents.get(0).getText();
        assertEquals("go shopping",actualTaskTitleGoShopping);
        assertTrue(chromeDriver.findElement(By.className("doneword")).isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        chromeDriver.quit();
    }
}
