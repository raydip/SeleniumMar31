package kwdFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {

	WebDriver driver;

	public void openBrowser() {
		driver = new ChromeDriver();
	}

	public void maxBrowser() {
		driver.manage().window().maximize();
	}

	public void impWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void navToApp(String url) {
		driver.get(url);
	}

	public void entInTextBox(String locValue, String Value) {
		driver.findElement(By.id(locValue)).sendKeys(Value);
	}

	public void clickBtn(String loc, String locValue) {
		if (loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		} else if (loc.equals("xpath")) {
			driver.findElement(By.xpath(locValue)).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locValue)));
		}
	}

	public String getErrorMsg(String loc, String locValue) {
		String errorMsg = null;
		if (loc.equals("cssSelector")) {
			errorMsg = driver.findElement(By.cssSelector(locValue)).getText();
		} else if (loc.equals("id")) {
			errorMsg = driver.findElement(By.id(locValue)).getText();
		}
		return errorMsg;

	}

	public void appClose() {
		driver.close();
	}
}
