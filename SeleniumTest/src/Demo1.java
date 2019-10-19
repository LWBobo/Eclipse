import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	public static void main(String[] args) {

			WebDriver driver = new ChromeDriver();
		
			driver.get("http://114.116.106.156/show-how/common/login.jsp");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='租户'])[1]/following::div[2]")).click();
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("test006");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='账号'])[1]/following::label[1]")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("1");
		    driver.findElement(By.id("userForm")).submit();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='首页'])[2]/following::span[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='个人事务'])[1]/following::span[1]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='个人信息'])[1]/following::span[1]")).click();	    
		    driver.findElement(By.id("pimInfo_email")).clear();
		    driver.findElement(By.id("pimInfo_email")).sendKeys("123456@163.com");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='邮箱'])[1]/following::div[2]")).click();
		    
		    driver.findElement(By.id("pimInfo_cellphone")).clear();
		    driver.findElement(By.id("pimInfo_cellphone")).sendKeys("12345678901");
		    
		    
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='手机'])[1]/following::div[2]")).click();
		    driver.findElement(By.id("pimInfo_telephone")).clear();
		    driver.findElement(By.id("pimInfo_telephone")).sendKeys("13253376824");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='QQ'])[1]/following::div[2]")).click();
		    driver.findElement(By.id("userBase_wechatnumber")).clear();
		    driver.findElement(By.id("userBase_wechatnumber")).sendKeys("542819222");
		    
		    
		    driver.findElement(By.id("submitButton")).click();
	  		    	
		
	}

}
