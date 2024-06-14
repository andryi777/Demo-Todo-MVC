package demo.main.step;

import demo.main.page.AppTodoMVCPage;
import net.serenitybdd.core.Serenity;

public class DemomvcStep {

	private AppTodoMVCPage appTodoMVCPage;
	
	public void openWeb() {
		appTodoMVCPage.init("https://demo.playwright.dev/todomvc/#/");
		Serenity.takeScreenshot();
	}

	public void clearAllItems() {
		appTodoMVCPage.clearAllItems();
		Serenity.takeScreenshot();
	}

	public void addNewItem(String itemName) {
		appTodoMVCPage.addNewItem(itemName);
		Serenity.takeScreenshot();
	}
	
	public void selectClearCompleted() {
		appTodoMVCPage.selectClearCompleted();
	}

	public boolean isItemExist(String itemName) {
		Serenity.takeScreenshot();
		return appTodoMVCPage.isItemExist(itemName);
	}

	public void markItemAsCompleted(String itemName) {
		appTodoMVCPage.markItemAsCompleted(itemName);
		Serenity.takeScreenshot();
	}

	public void selectActivefilter() {
		appTodoMVCPage.selectActiveFilter();
		Serenity.takeScreenshot();
	}

	public boolean isCountMatchingListSize() {
		Serenity.takeScreenshot();
		return appTodoMVCPage.isCountMatchingListSize();
	}

	public void selectCompletedfilter() {
		appTodoMVCPage.selectCompletedFilter();
		Serenity.takeScreenshot();
	}

	public boolean isItemDuplicatedExist(String itemName) {
		Serenity.takeScreenshot();
		return appTodoMVCPage.isItemDuplicatedExist(itemName);
	}

	public void deleteItem(String itemName) {
		appTodoMVCPage.deleteItem(itemName);
		Serenity.takeScreenshot();
	}
	
}
