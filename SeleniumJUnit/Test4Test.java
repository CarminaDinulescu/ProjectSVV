// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Test4Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test4() {
    driver.get("http://127.0.0.1:10008/");
    driver.manage().window().setSize(new Dimension(1074, 692));
    driver.findElement(By.linkText("do general relative links work")).click();
    driver.findElement(By.linkText("https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html")).click();
    {
      WebElement element = driver.findElement(By.linkText("java.lang.Object"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.linkText("do simple absolute links work")).click();
    driver.findElement(By.cssSelector(".vspace:nth-child(4)")).click();
    driver.findElement(By.linkText("Attach:MockUnit3.zip")).click();
    driver.findElement(By.linkText("do general absolute links work")).click();
    driver.findElement(By.linkText("here")).click();
    driver.findElement(By.linkText("project to analyze (JUnit)")).click();
    driver.findElement(By.linkText("do URLs with spaces work")).click();
    driver.findElement(By.cssSelector(".vspace:nth-child(2) > .urllink:nth-child(1)")).click();
  }
}
