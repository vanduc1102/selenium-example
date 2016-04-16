package com.examples.seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
/**
 * This is the example get from http://www.tutorialspoint.com/selenium/selenium_rc.htm
 * with some modification to make it work
 * @author ducnguyen
 *
 */

public class TutorialPointApp {
   public static void main(String[] args) throws InterruptedException {
   
      // Instatiate the RC Server
      Selenium selenium = new DefaultSelenium("localhost", 4445 , "firefox", "http://www.calculator.net");
      selenium.start();   // Start
      selenium.open("/");  // Open the URL
      selenium.windowMaximize();
      
      // Click on Link Math Calculator
      selenium.click("xpath=.//*[@id='menu']/div[3]/a");
      Thread.sleep(2500); // Wait for page load
      
      // Click on Link Percent Calculator
      selenium.click("xpath=.//*[@id='menu']/div[4]/div[3]/a");
      Thread.sleep(4000); // Wait for page load
      
      // Focus on text Box
      selenium.focus("name=cpar1");
      // enter a value in Text box 1
      selenium.type("css=input[name=\"cpar1\"]", "10");
      
      // enter a value in Text box 2
      selenium.focus("name=cpar2");
      selenium.type("css=input[name=\"cpar2\"]", "50");
      
      // Click Calculate button
      selenium.click("xpath=.//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]");
      Thread.sleep(4000); // Wait for page load
      // verify if the result is 5
      String result = selenium.getText("xpath=.//*[@id='content']/p[2]/font/b");
      
      
      
      if (result.equals("5")){
         System.out.println("Pass");
      }
      else{
         System.out.println("Fail");
      }
      selenium.close();
   }
}
