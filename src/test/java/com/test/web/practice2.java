package com.test.web;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;


public class practice2 {
    static WebDriver driver;
    static String randomAlphanumeric;
    static ExtentTest test;
    static ExtentReports report;

    @Test(priority = 1)
    public void setup() {
        System.out.println("SETUP started . . . ");

        //setups
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        randomAlphanumeric = UUID.randomUUID().toString().substring(30);
        String reportPath = ("report/" + randomAlphanumeric + "-ExtentReportResults.html");
        report = new ExtentReports(reportPath, true);
        System.out.println("    - Report: " + reportPath);
        test = report.startTest("SELENIUM TEST - EMPLOYEE");
        test.log(LogStatus.INFO, "SETUP started . . . ");
        //open browser URL
        driver.get("https://iwork-employee-ui.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "React App");
        System.out.println("    - Check: React App title.");
        System.out.println("    - Result: PASS");
        test.log(LogStatus.INFO, "      - Check: React App title.");
        test.log(LogStatus.PASS, "      - Result: PASS");

    }

    @Test(priority = 2)
    public void createEmp() {
        System.out.println("CREATE EMPLOYEES started  . . . ");
        test.log(LogStatus.INFO, "CREATE EMPLOYEES started . . . ");

        //Find firstname input field and type "FirstName"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/input")).sendKeys("FirstName" + "-" + randomAlphanumeric);
        wait(1000);
        test.log(LogStatus.INFO, "      - Name Used: FirstName-" + randomAlphanumeric);

        //Find lastname input field and type "LastName"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[2]/input")).sendKeys("LastName");
        wait(1000);

        //Find email input field and type "Email"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[3]/input")).sendKeys(randomAlphanumeric + "@email.com");
        wait(1000);

        //From the dropdown list, select "Male"
        Select gender = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[4]/label/select")));
        gender.selectByVisibleText("Male");
        //gender.selectByIndex(1);
        wait(2000);

        //Click on the Create button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button")).click();
        wait(1000);

        //accept popup alert
        driver.switchTo().alert().accept();
        wait(1000);

        System.out.println("    - Check: Input fields, dropdown and button exist.");
        System.out.println("    - Result: PASS");
        test.log(LogStatus.INFO, "      - Check: Input fields, dropdown and button exist.");
        test.log(LogStatus.PASS, "      - Result: PASS");

    }

    @Test(priority = 4)
    public void getAllEmpRegistered() {
        System.out.println("GET ALL EMPLOYEES started...");
        test.log(LogStatus.INFO, "GET ALL EMPLOYEES started . . . ");

        //Click on getAll
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/a[2]")).click();
        wait(2000);

        //Validate the p-tag equals "All Employees"
        String pTag = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/p")).getText();
        String table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]")).getText();
        Assert.assertEquals(pTag, "All Employees");
        wait(2000);

        System.out.println("    - Check: All Employees");
        System.out.println("    - Check: All employees text exists.");
        test.log(LogStatus.INFO, "      - Check: All employees text exists.");

        //print in console
        System.out.println("    - Result: PASS");
        test.log(LogStatus.PASS, "      - Result: PASS");
    }

    //@Test(priority = 3)
    public void editEmpInfo() {
        System.out.println("editEmpInfo");
    }

    @AfterTest
    public void shutdown() {
        System.out.println("shutdown");
        //closing out the test
        driver.close();
        report.endTest(test);
        report.flush();

    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}





