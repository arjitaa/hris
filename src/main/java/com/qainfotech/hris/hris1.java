
package com.qainfotech.hris;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class hris1 {
    
  
    
    static String url ="https://hris.qainfotech.com/login.php";
    static String login="//input[@type='text']";
    static String username="arjitaagarwal";
    static String pw_field="//input[@type='password']";
    static String password="Qait@123456";
    static String sign_inbutton="//input[@value='Sign In']";
    static String punch_indetails="(//h1[contains(text(),'dynamic')]/..//b)[2]";   //20-09-2018 09/20/2018 sdf.format(date1)
    //(//h1[contains(text(),'"+dtf.format(now)+"')]/..//b)[2]"
    static String leave_expand="#hamburger";
    static String leave_click="//a[@title='Leave']";
    static String leave_summary="//li[@class='treeview  active']//ul//li[1]//a//span[1]";
    static String personal_leavesummary="//li[@class='treeview  active']//ul[1]//li[1]//ul//li/a";
    static String PTO_leaves="//table[@border='0']//tbody[1]//tr[1]//td[5]";
    
    
    public static void main(String[]args) throws InterruptedException{
    System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(url);
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
    driver.findElement(By.xpath(login)).sendKeys(username);
    driver.findElement(By.xpath(pw_field)).sendKeys(password);
    driver.findElement(By.xpath(sign_inbutton)).click();
    
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
   
    
    Date date=new Date();
    System.out.println (date);
    SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
    Date date1= new Date();
    System.out.println(sdf.format(date1));
    
        //  String currentDate=sdf.format(date);
          //System.out.println(currentDate);
          
//          String date1=currentDate.substring(0, 2);
//          System.out.println(date1);
         String punch_details= driver.findElement(By.xpath(elementReplace(punch_indetails,sdf.format(date1)))).getAttribute(punch_indetails);
         
         System.out.println(punch_details);
    


  //Leave Status
   
    
    driver.findElement(By.cssSelector(leave_expand)).click();
    
//    JavascriptExecutor js2=(JavascriptExecutor)driver;
//    WebElement element1=driver.findElement(By.xpath("//div[@id='dv_2018-08-03']"));
//    js2.executeScript("arguments[0].scrollIntoView(true);",element1);
//    System.out.println(element1.getText());
//    
    
    driver.findElement(By.xpath(leave_click)).click();
    WebDriverWait wait= new WebDriverWait(driver,10);
    WebElement Leave_Summary=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(leave_summary)));
    Leave_Summary.click();
//    Thread.sleep(1000);
//    driver.findElement(By.xpath("//li[@class='treeview  active']//ul//li[1]//a//span[1]")).click();
    driver.findElement(By.xpath(personal_leavesummary)).click();
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
    WebElement PTO=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PTO_leaves)));
   //WebElement PTO = driver.findElement(By.xpath("//table[@border='0']//tbody[1]//tr[1]//td[5]"));
   String leaves= PTO.getText();
   System.out.println("PTO left is:"+ leaves);
    
    
    }
    private String currentDate;
    
    public static String elementReplace(String element, String replacement){
    	return element.replace("dynamic", replacement);
    }
    
}


