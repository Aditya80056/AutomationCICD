
@tag
Feature: Purcashe the order
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And checkout <productname> and submit the order

    Examples: 
      | name                  | password     | productName | 
      | aditya84051@gmail.com | Okay@google1 | ZARA COAT 3 |
