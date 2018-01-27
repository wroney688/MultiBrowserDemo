
package com.roneymis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiBrowserDemo {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new ChromeDriver();
        WebDriver driver2 = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");
        driver2.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        WebElement element2 = driver2.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");
        element2.sendKeys("Cream!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        element2.submit();

        // Check the title of the page
        System.out.println("Page title of browser 1 is: " + driver.getTitle());
        System.out.println("Page title of browser 2 is: " + driver2.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        (new WebDriverWait(driver2, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cream!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page 1 title is: " + driver.getTitle());
        System.out.println("Page 2 title is: " + driver2.getTitle());
        
        //Close the browser
        driver.quit();
		driver2.quit();
    }
}
