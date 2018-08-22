/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qainfotech.hris;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Arjita
 */
public class hris_segregated {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Arjita
 */

    public static void main(String[]args) throws InterruptedException{
        
    WebDriver;
    System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://hris.qainfotech.com/login.php");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Verification of the Page title
    String ActualTitle= driver.getTitle();
    System.out.println("ActualTitle:" +ActualTitle);
    String ExpectedTitle="HRIS Login";
    if(ActualTitle.equals(ExpectedTitle)){
        System.out.println("Title is correct and ExpectedTitle is:" +ExpectedTitle);
    }
    else{
        System.out.println("Title is incorrect");
    }
    
    // Login HRIS
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("arjitaagarwal");
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qait@12345");
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();
   // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
   // verified page is loaded completely
   JavascriptExecutor js1=(JavascriptExecutor)driver;
   boolean status1= js1.executeScript("return document.readyState").toString().equals("complete");
   if(status1){
       System.out.println("Page is loaded completely timesheet");
   }
   else{
       System.out.println("Page is not loaded completely timesheet");
   }
    Thread.sleep(1000);
   // element(By.cssSelector("#hamburger")).click();
    click(element("//a[@id='hamburger']" , "xpath"));
    driver.findElement(By.xpath("//a[@title='Time']")).click();
   
    // scrolling down
    JavascriptExecutor js2=(JavascriptExecutor)driver;
    WebElement element=driver.findElement(By.xpath("//div[@id='dv_2018-08-15']"));
    js2.executeScript("arguments[0].scrollIntoView(true);",element);
    System.out.println(element.getText());
     
    Thread.sleep(5000);
    // punch details
    
    
    
    Date date=new Date();
    System.out.println (date);
    SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
          String currentDate=sdf.format(date);
          System.out.println(currentDate);
          
          String date1=currentDate.substring(0, 2);
          System.out.println(date1);
    
    
    Actions hover=new Actions(driver);
   // hover.moveToElement(driver.findElement(By.xpath("//div[@id='dv_2018-08-17']"))).build().perform();
    hover.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'currentDate')]"))).build().perform();
    
   //driver.findElement(By.xpath("//div[@id='dv_2018-08-17']//div[1]//div[2]//ul//li[2]//div[2]//div[1]//span[2]//b"));
   // WebElement punch_details= driver.findElement(By.xpath("//b[contains(text(),'09:51:00, 13:45:00, 14:04:00, 18:36:00, 18:38:00, 18:41:00')]"));
    WebElement punch_details1=driver.findElement(By.xpath("//b[contains(text(), 'Punches:')]"));
    String details= punch_details1.getText();
   // String arr[] = details.split(",");
    int string_length=details.length();
    String excl_punch= details.substring(9,string_length-1);
    System.out.println(string_length);
    System.out.println(excl_punch);
    String num_punches[]=excl_punch.split(",");
    for(String w:num_punches){
     System.out.println(w);    
    }
    System.out.println("No. of punches:" +num_punches.length);
    
    
  
    
    
    
    //String Punch[]= details.split(": ",2);
    //String PunchTimes= Arrays.toString(Punch);
    //String total_inout[]=PunchTimes.split(",",8);
    
//    for(String w:arr){
//        System.out.println(w);
//    }
//    System.out.println("No. of punches :"+ arr.length);
//    //String times= Arrays.toString(Punch);
//    
    
    
    //Leave Status
   
    
    driver.findElement(By.cssSelector("#hamburger")).click();
    
    JavascriptExecutor js3=(JavascriptExecutor)driver;
    WebElement element1=driver.findElement(By.xpath("//div[@id='dv_2018-08-03']"));
    js2.executeScript("arguments[0].scrollIntoView(true);",element1);
    System.out.println(element1.getText());
    
    
    driver.findElement(By.xpath("//a[@title='Leave']")).click();
    WebDriverWait wait= new WebDriverWait(driver,10);
    WebElement Leave_Summary=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='treeview  active']//ul//li[1]//a//span[1]")));
    Leave_Summary.click();
//    Thread.sleep(1000);
//    driver.findElement(By.xpath("//li[@class='treeview  active']//ul//li[1]//a//span[1]")).click();
    driver.findElement(By.xpath("//li[@class='treeview  active']//ul[1]//li[1]//ul//li/a")).click();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
   JavascriptExecutor js=(JavascriptExecutor)driver;
   boolean status= js.executeScript("return document.readyState").toString().equals("complete");
   if(status){
       System.out.println("Page is loaded completely");
   }
   else{
       System.out.println("Page is not loaded completely");
   }
   
    // finding the leaves left
    driver.switchTo().frame("rightMenu");
    
    
    WebDriverWait wait1= new WebDriverWait(driver,10);
    WebElement PTO=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@border='0']//tbody[1]//tr[1]//td[5]")));
   //WebElement PTO = driver.findElement(By.xpath("//table[@border='0']//tbody[1]//tr[1]//td[5]"));
   String leaves= PTO.getText();
   System.out.println("PTO left is:"+ leaves);
    
    
    }
    public WebElement element(String locator,String locatortype){
    return driver.findElement(By.xpath(locator));
    
}
    public void click(WebElement ele){
        ele.click();
        System.out.println("clicked on element" +ele);
    }
    
    public static WebDriver getDriver(String browser){
    System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
    return new ChromeDriver();
 
 }

  
}
