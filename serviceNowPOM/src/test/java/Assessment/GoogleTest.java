package Assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.servicenow.base.Browser;
import org.servicenow.base.SeleniumBase;
import org.testng.annotations.Test;

public class GoogleTest extends SeleniumBase {

	@Test
	void searchLetCode() throws InterruptedException {
		setUp(Browser.CHROME,"https://www.google.com/");
		WebElement searchElement = element("name", "q");
		type(searchElement, "Letcode", Keys.ENTER);
		Thread.sleep(3000);
		quit();
	}
	
}
