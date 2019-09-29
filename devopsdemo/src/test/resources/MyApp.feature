#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Test the Fib, Prime and Sorting of numbers

  Scenario: Test for Fib numbers
    Given Open Chrome browser and my App
    When I enter input for Fib "9"
    Then Click on Generate Fib Series
    Then I get output for Fib "[0, 1, 1, 2, 3, 5, 8, 13, 21]"
    
  Scenario: Test for negative input for Fib
    When I enter input for Fib "-1"
    Then Click on Generate Fib Series
    Then I get output for Fib "Enter a valid number"
    
   Scenario: Test for Prime numbers
   	When I give input for Prime Num "9"
   	Then Click on Generate Prime numbers
   	Then I get output for prime "[1, 2, 3, 5, 7, 11, 13, 17, 19]"
   	
   	Scenario: Test for negative input for Primes
   		When I give input for Prime Num "-2"
   		Then Click on Generate Prime numbers
   		Then I get output for prime "Enter a valid number"
    	
    Scenario: Test for sorting of numbers
    	When I give list of numbers "15,3,4,5,6,7,1,2,10,22,1,23,2,34,2,3,56,78,90,0,1000,19887,2635,77764"
    	Then I click on sort numbers
    	Then I get sorted numbers "[0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 10, 15, 22, 23, 34, 56, 78, 90, 1000, 2635, 19887, 77764]"
    	
    Scenario: Test for nice day message
    	Then I get "Have a Nice Day"	
    	
    Scenario: Close browser
    	Then Close Browser
    
    
