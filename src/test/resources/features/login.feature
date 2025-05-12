@tag
Feature: Login
  Scenario Outline: Login attempts with different credentials
  Given I am on the login page
  And I enter my username "<username>"
  And I enter my password "<password>"
  When I click the login button
  Then a message appears "<message>"

  Examples:
    | username        | password      | message             |
    | validUsername   | validPassword | Successful Login!   |
    | invalidUsername | validPassword | Unsuccessful Login! |

