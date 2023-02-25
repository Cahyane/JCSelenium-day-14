package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumTestDay14 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracooding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        // isi form nama dan pekerjaan
        driver.findElement(By.id("first-name")).sendKeys("Widya");
        System.out.println("Nama Depan");
        driver.findElement(By.id("last-name")).sendKeys("Cahyani");
        System.out.println("Nama Panjang");
        driver.findElement(By.id("job-title")).sendKeys("Pegawai");
        System.out.println("Pekerjaan");

        // radio button
        driver.findElement(By.xpath("//*[@id=\"radio-button-2\"]")).click();
        driver.findElement(By.id("checkbox-2")).click();
        System.out.println("Radio Button OK");

        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        //select menu
        driver.findElement(By.id("select-menu")).click();
        WebElement selectmenu = driver.findElement(By.id("select-menu"));
        Select menu = new Select(selectmenu);
        menu.selectByIndex(3);
        System.out.println("Select Menu OK");

        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        //isi tanggal
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.id("datepicker")).sendKeys("02/25/2023");
        System.out.println("Tanggal OK");

        System.out.println("=== Delay 3 second===");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }

        // submit
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Selesai");


    }
}
