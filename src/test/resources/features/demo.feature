@tagAll
Feature: TODO MVC Playwrigth

#  Background: Clear the todo list
#    Given I enter to the TodoMVC webpage
#    When I clear all items

  @THA-1
  Scenario: User can add a new todo item.
    Given I enter to the TodoMVC webpage
    When I add a new item "item2"
    Then the item "item2" should appear in the list

  @THA-1
  Scenario: User can successfully clear completed todo items.
    Given I enter to the TodoMVC webpage
    When I add a new item "item1"
    And I mark the item "item1" as completed
    And I clear the completed item
    Then the item "item1" should not appear in the list

  @THA-2
  Scenario: User can successfully make duplicate todo items.
    Given I enter to the TodoMVC webpage
    When I add a new item "item1"
    And I add a new item "item1"
    Then the item "item1" should appear the item duplicated

  @THA-3
  Scenario: Number of active items are equal to the counter in list.
    Given I enter to the TodoMVC webpage
    When I add a new item "item1"
    And I add a new item "item2"
    And I add a new item "item3"
    And I mark the item "item2" as completed
    And I select the Active filter
    Then the number of items left should be equal to the items counter

  @THA-3
  Scenario: Number of completed items are equal to the counter in list.
    Given I enter to the TodoMVC webpage
    When I add a new item "item1"
    And I add a new item "item2"
    And I add a new item "item3"
    And I mark the item "item2" as completed
    And I select the Completed filter
    Then the number of items left should be equal to the items counter

  @THA-4
  Scenario: User can delete a todo item.
    Given I enter to the TodoMVC webpage
    When I add a new item "item1"
    And I delete the item "item1"
    Then the item "item1" should not appear in the list
