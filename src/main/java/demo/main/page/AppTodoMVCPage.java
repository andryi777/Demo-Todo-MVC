package demo.main.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import demo.main.util.PageObjectUtil;
import demo.main.xpath.XpathTodoMVC;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class AppTodoMVCPage extends PageObject {

	private long wdwTimeOut = 300L;

	// xpath
	protected XpathTodoMVC xpathTodoMVC = XpathTodoMVC.getInstancia();


	// util
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

	public long getWdwTimeOut() {
		return wdwTimeOut;
	}

	public void init(String url) {
		getDriver().navigate().to(url);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
	}

	public void clearAllItems() {
		List<WebElement> countItems = getDriver().findElements(By.xpath(xpathTodoMVC.listItems()));
		for(WebElement item : countItems) {
            WebElement inputElement = item.findElement(By.xpath(".//div/input"));
            if (inputElement != null) {
                inputElement.click();
            }
		}
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.btnClearCompleted(), 0);
	}

	public void selectClearCompleted() {
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.btnClearCompleted(), 0);
	}
	
	public void addNewItem(String itemName) {
		pageObjectUtil.seleniumWriteText(getDriver(), xpathTodoMVC.txtItem, 0, itemName, Keys.ENTER);
	}

	public boolean isItemExist(String itemName) {
		List<WebElement> countItems = getDriver().findElements(By.xpath(xpathTodoMVC.listItems()));
		for(WebElement item : countItems) {
            WebElement inputElement = item.findElement(By.xpath(".//div/label"));
            if (inputElement.getText().trim().compareTo(itemName)==0) {
                return true;
            }
		}
		return false;
	}

	public void markItemAsCompleted(String itemName) {
		System.err.println("asdasdasda: "+xpathTodoMVC.rbnItem(itemName));
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.rbnItem(itemName), 0);
	}

	public void selectActiveFilter() {
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.btnActive(), 0);
	}

	public boolean isCountMatchingListSize() {
		List<WebElement> countItems = getDriver().findElements(By.xpath(xpathTodoMVC.listItems()));
		int lblCounter = Integer.parseInt(pageObjectUtil.seleniumGetText(getDriver(), xpathTodoMVC.lblCounter(), 0));
		if (lblCounter==countItems.size())
			return true;
		return false;
	}

	public void selectCompletedFilter() {
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.btnCompleted(), 0);
	}

	public boolean isItemDuplicatedExist(String itemName) {
		int countDuplicated=0;
		List<WebElement> countItems = getDriver().findElements(By.xpath(xpathTodoMVC.listItems()));
		for(WebElement item : countItems) {
            WebElement inputElement = item.findElement(By.xpath(".//div/label"));
            if (inputElement.getText().trim().compareTo(itemName)==0) {
            	countDuplicated++;
            }
		}
		if (countDuplicated>1)
			return true;
		return false;
	}

	public void deleteItem(String itemName) {
		System.out.println(xpathTodoMVC.btnDelete(itemName));
		pageObjectUtil.seleniumHover(getDriver(), xpathTodoMVC.item(itemName), 0);
		pageObjectUtil.seleniumClick(getDriver(), xpathTodoMVC.btnDelete(itemName), 0);
	}

}
