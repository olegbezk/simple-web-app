package com.gl.trainee.webapptest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebAppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebApp() throws Exception {
    driver.get(baseUrl + "/simple-web-app/");
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("test");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("test");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("test");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("resst");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("rest");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("231");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("rest");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("rest");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Login Page")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("rest");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
    try {
      assertEquals("", driver.findElement(By.name("user")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("rest");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Login Page")).click();
    try {
      assertEquals("", driver.findElement(By.name("pass")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("test");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Login Page")).click();
    try {
      assertEquals("", driver.findElement(By.name("conf")).getAttribute("value"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("serv");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("123");
    driver.findElement(By.name("conf")).clear();
    driver.findElement(By.name("conf")).sendKeys("123");
    driver.findElement(By.name("register")).click();
    driver.findElement(By.linkText("Login Page")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
