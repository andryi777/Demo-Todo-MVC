package demo.test.definition;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import demo.main.step.DemomvcStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class DemoDefinition {
	
	@Steps
	private DemomvcStep demomvcStep;

	@Given("I enter to the TodoMVC webpage")
	public void i_enter_to_the_todo_mvc_webpage() {
		demomvcStep.openWeb();
	}

	@When("I clear all items")
	public void i_clear_all_items() {
		demomvcStep.clearAllItems();
	}

	@When("I add a new item {string}")
	public void i_add_a_new_item(String itemName) {
		demomvcStep.addNewItem(itemName);
	}

	@Then("the item {string} should appear in the list")
	public void the_item_should_appear_in_the_list(String itemName) {
		assertTrue(demomvcStep.isItemExist(itemName));
	}

	@When("I mark the item {string} as completed")
	public void i_mark_the_item_as_completed(String itemName) {
		demomvcStep.markItemAsCompleted(itemName);
	}

	@When("I clear the completed item")
	public void i_clear_the_completed_item() {
		demomvcStep.selectClearCompleted();
	}
	
	@Then("the item {string} should not appear in the list")
	public void the_item_should_not_appear_in_the_list(String itemName) {
		assertFalse(demomvcStep.isItemExist(itemName));
	}

	@Then("the item {string} should appear the item duplicated")
	public void the_item_should_should_appear_the_item_duplicated(String itemName) {
		assertTrue(demomvcStep.isItemDuplicatedExist(itemName));
	}

	@When("I select the Active filter")
	public void i_select_the_active_filter() {
		demomvcStep.selectActivefilter();
	}

	@Then("the number of items left should be equal to the items counter")
	public void the_number_of_items_left_should_be_equal_to_the_items_counter() {
		assertTrue(demomvcStep.isCountMatchingListSize());
	}

	@When("I select the Completed filter")
	public void i_select_the_completed_filter() {
		demomvcStep.selectCompletedfilter();
	}

	@When("I delete the item {string}")
	public void i_delete_the_item(String itemName) {
		demomvcStep.deleteItem(itemName);
	}
}
