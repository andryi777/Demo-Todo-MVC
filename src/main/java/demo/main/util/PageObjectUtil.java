package demo.main.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectUtil {

	// singleton
	private static PageObjectUtil obj = null;

	private PageObjectUtil() {
	}

	public static PageObjectUtil getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public void seleniumClick(WebDriver webDriver, final String xpath, int pos) {
		By by = By.xpath(xpath);
		List<WebElement> lista = webDriver.findElements(by);
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			we.click();
			sleep(1.5);
		}
	}
	
	public void seleniumDoubleClick(WebDriver webDriver, WebElement we) {
		Actions actions = new Actions(webDriver);
		actions.doubleClick(we).build().perform();
		sleep(1.5);
	}
	
	public void seleniumHover(WebDriver webDriver, final String xpath, int pos) {
		Actions action = new Actions(webDriver);
		By by = By.xpath(xpath);		
		List<WebElement> lista = webDriver.findElements(by);
		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			action.moveToElement(we).perform();
			sleep(1.5);
		}
	}
	
	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void selectItemfromCombobox(WebDriver webDriver, final String path, String valor) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		for (WebElement we : lista) {
			System.out.println(we.getText().trim());
			if (we.getText().trim().equals(valor)) {
				we.click();
				break;
			}
		}
	}

	public void scrollJSToElement(WebDriver webDriver, String xpath) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		WebElement elemento = seleniumGetWebElement(webDriver, xpath, 0);
		jse.executeScript("arguments[0].scrollIntoView();", elemento);
	}

	public WebElement seleniumGetWebElement(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			return lista.get(pos);
		}

		return null;
	}
	
	public String seleniumGetText(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);
		String texto;
		texto = lista.get(pos).getText();
		return texto;
	}

	public void seleniumWriteText(WebDriver webDriver, final String path, int pos, String text, Keys key) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(text);

				if (key != null) {
					sleep(1.50);
					we.sendKeys(key);
				}

				sleep(1);
			}
		}
	}

}
