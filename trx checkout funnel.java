import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class trx checkout funnel {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void trx checkout funnel() {
        wd.get("http://www.clarisonic.com/on/demandware.store/Sites-Clarisonic-US-Site/default/Default-Start?hiconversion_alternate=pMrGqnJhiV&hiconversion_baseline=true&hiconversion_flicker=visibility&hiconversion_flow=UQtQuNbjHu&hiconversion_include=true&hiconversion_page=Jrjfn40ROx&hiconversion_test=true");
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.header"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("body.pt_storefront"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("DEVICES"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("li.hic_nav"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("Sonic Radiance 3 Speeds for a full solution to diminish dark spots"))).build().perform();
        wd.findElement(By.linkText("Sonic Radiance 3 Speeds for a full solution to diminish dark spots")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("clarisonic-brightening-radiance-cl28-page"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.product_primary_image"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.ui-widget-overlay.ui-front"))).build().perform();
        wd.findElement(By.cssSelector("div.ui-widget-overlay.ui-front")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.product_primary_image"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='product_primary_image']/img"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[5]/div"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#add_to_cart_form > fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("add_to_cart"))).build().perform();
        wd.findElement(By.id("add_to_cart")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#add_to_cart_form > fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.mini_cart_totals"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("CHECKOUT"))).build().perform();
        wd.findElement(By.linkText("CHECKOUT")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("h2.recommendation_title.bg_title_box > span"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.loader_bg"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.loader_indicator"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.loader_bg"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.content.cart"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("dwfrm_cart_checkoutCart"))).build().perform();
        wd.findElement(By.name("dwfrm_cart_checkoutCart")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("logincheckout_container"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.block_login"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_login"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='radio_buttons_checkout']/div[1]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.have_account.f_label > span.f_label_value"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.have_account.f_label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.f_label.new_customer > span.f_label_value"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.f_label.new_customer"))).build().perform();
        wd.findElement(By.cssSelector("label.f_label.new_customer")).click();
        if (!wd.findElement(By.id("new_customer")).isSelected()) {
            wd.findElement(By.id("new_customer")).click();
        }
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.have_account.f_label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.have_account.f_label > span.f_label_value"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("label.have_account.f_label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("dwfrm_login_unregistered"))).build().perform();
        wd.findElement(By.name("dwfrm_login_unregistered")).click();
        wd.findElement(By.id("dwfrm_login_username_d0jspvulaxid")).click();
        wd.findElement(By.id("dwfrm_login_username_d0jspvulaxid")).clear();
        wd.findElement(By.id("dwfrm_login_username_d0jspvulaxid")).sendKeys("tester@hiconversion.com");
        wd.findElement(By.name("dwfrm_login_unregistered")).click();
        wd.findElement(By.cssSelector("#cart-items-form > fieldset > button[name=\"dwfrm_cart_checkoutCart\"]")).click();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("tr.order_subtotal.js_order_subtotal > td"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("c2091769017-page"))).build().perform();
        wd.findElement(By.id("c2091769017-page")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("billingaddressinfo"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='editprofile']/div[11]/div"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_billing_billingAddress_addressFields_zip"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_billing_billingAddress_addressFields_city"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='editprofile']/div[6]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='shippingaddressinfo']/fieldset/div[12]/label"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_useAsBillingAddress"))).build().perform();
        if (!wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_useAsBillingAddress")).isSelected()) {
            wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_useAsBillingAddress")).click();
        }
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//label[@for='dwfrm_singleshipping_shippingAddress_useAsBillingAddress']/span"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).sendKeys("please");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).sendKeys("delete");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_companyName")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_companyName")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_companyName")).sendKeys("hiconversion");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys("hiconversion");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address2")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address2")).sendKeys("\\9");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).sendKeys("boca raton");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_zip")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_zip")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_zip")).sendKeys("33431");
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).sendKeys("561-555-1212");
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_newsletter_checkoutSubscription_sendnewsletters"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_phone")).sendKeys("\\undefined");
        if (wd.findElement(By.id("dwfrm_newsletter_checkoutSubscription_sendnewsletters")).isSelected()) {
            wd.findElement(By.id("dwfrm_newsletter_checkoutSubscription_sendnewsletters")).click();
        }
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='checkout_subscriptions_area']/div[1]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.some_help"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button"))).build().perform();
        wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("c2091806408-page"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_companyName"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//label[@for='dwfrm_singleshipping_shippingAddress_addressFields_companyName']//span[.='Company Name']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.main"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).click();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@id='shippingaddressinfo']//label[normalize-space(.)='Address 1']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).clear();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys("4800 t-rex ave");
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button"))).build().perform();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).click();
        wd.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys("\\undefined");
        wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("c2091903806-page"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.ui-widget-overlay.ui-front"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.ui-dialog-content.ui-widget-content"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='address_validation']//li[.='boca raton, FL, 33431, US']"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.name("dwfrm_billing_billingAddress_saveAddress"))).build().perform();
        wd.findElement(By.name("dwfrm_billing_billingAddress_saveAddress")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("c2091967292-page"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.shipping_methods"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.account_create_login"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_createaccount_confirmpassword"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.account_create_login"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.id("dwfrm_createaccount_confirmpassword"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.secondary.summary"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button"))).build().perform();
        wd.findElement(By.xpath("//form[@class='checkout']/div[2]/div[5]/button")).click();
        new Actions(wd).moveToElement(wd.findElement(By.id("c2091976152-page"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.product_name"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.linkText("Sonic Radiance Brightening Solution"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='shipping_methods']/fieldset/div[2]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.shipping_methods"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset.select_payment_method"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("action > fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='primary']/div[3]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset.select_payment_method > legend > span.legend_message"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("fieldset.select_payment_method"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("action > fieldset"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.xpath("//div[@class='account_create_login_benefits']/div/h3[2]"))).build().perform();
        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.main"))).build().perform();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
