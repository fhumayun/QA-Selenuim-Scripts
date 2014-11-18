package com.seleniumsimplified.webdriver.basics;

import com.seleniumsimplified.webdriver.manager.Driver;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * This is not a test in the main course.
 *
 * It is a file that I add for experimenting with code.
 *
 * It should be ignored.
 *
 * The code in here may not actually work.
 */
@Ignore("Because this is a scratchpad and I only want to use it when I need it, it might have random stuff in it")
public class Scratchpad {

    private static WebDriver driver;

    @Test
    public void createAChromeDriver(){
        System.setProperty(Driver.BROWSER_PROPERTY_NAME,"CHROME");

        assertBrowserTestRuns();
    }
    public void assertBrowserTestRuns(){
        driver = Driver.get();

        Driver.BrowserName browser = Driver.currentDriver;
        String setting = System.getProperty(Driver.BROWSER_PROPERTY_NAME);
        driver.get("http://compendiumdev.co.uk/");
        assertThat(driver.getTitle(), is("Basic Web Page Title"));
    }



//    @Before
//    public void setup(){
//
//        // frame example to base work on
//        driver = Driver.get("http://compendiumdev.co.uk/selenium/basic_html_form.html");
//    }
//
//    @Test
//    public void myStuff(){
//
//        // experiment for http://seleniumsimplified.com/2014/06/selenium-webdriver-getattribute-nuance/
//
//        Set<String> tags = new HashSet<String>();
//
//        List<WebElement> elements = driver.findElements(By.cssSelector("*")); // get everything
//        System.out.println(" TAG   [  Text    |   Attribute  ]");
//        for(WebElement element : elements){
//            String getText = element.getText();
//            String getAttribute = element.getAttribute("text");
//
//            int getTextLen = 0;
//            int maxStringLen = 0;
//            int getAttributeLen=0;
//
//            if(getText != null){
//                getTextLen = getText.length();
//                if(getTextLen>0)
//                    maxStringLen = (getTextLen>16) ? 15 : getTextLen -1;
//                getText = getText.replaceAll("\n","").substring(0, maxStringLen);
//                getText = (getTextLen > 16) ? getText + "..." : getText;
//            }
//
//            maxStringLen = 0;
//            if(getAttribute != null){
//                getAttributeLen = getAttribute.length();
//                if(getAttributeLen>0)
//                    maxStringLen = (getAttributeLen>16) ? 15 : getAttributeLen -1;
//                getAttribute = getAttribute.replaceAll("\n","").substring(0, maxStringLen);
//                getAttribute = (getAttributeLen > 16) ? getAttribute + "..." : getAttribute;
//            }
//
//            if(!tags.contains(element.getTagName())){
//                System.out.println(element.getTagName());
//                System.out.println(" - getText : " + "(" + getTextLen + ")" + getText);
//                System.out.println(" - getAttribute : " + "(" + getAttributeLen + ")" + getAttribute);
//            }
//            tags.add(element.getTagName());
//
//            if(getAttributeLen > getTextLen){
//                System.out.println("***" + element.getTagName() + "[" + getTextLen + "]" + " vs " + getAttribute);
//            }
//        }
//
//    }
//
//    @After
//    public void cleanup(){
//        driver.quit();
//    }
//


}
