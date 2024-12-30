Feature: Login

  Scenario Outline: Validate that user is able to login
    Given I opened the app using following <URL>

    Examples: 
      | URL                                                     |
      | https://practicetestautomation.com/practice-test-login/ |

  Scenario Outline: Validate that user is able to login
    Given I opened the app using following <URL>
    When I type <USERNAME> into Username field
    And I type <PASSWORD> into Password field
    And I Push Submit button
    Then I should see success page
    Then I see the success message <SUCCESS_MESSAGE_1> or <SUCCESS_MESSAGE_2>
    Then I see the logout button

    Examples: 
      | USERNAME | URL                                                     | PASSWORD    | SUCCESS_MESSAGE_1      | SUCCESS_MESSAGE_2 |
      | student  | https://practicetestautomation.com/practice-test-login/ | Password123 | successfully logged in | Congratulations   |

  Scenario Outline: Validate that user is able to login
    Given I opened the app using following <URL>
    When I type <USERNAME> into Username field
    And I type <PASSWORD> into Password field
    And I Push Submit button
    Then I see the error message displayed
    Then I see the failure message <FAILURE_MESSAGE>

    Examples: 
      | USERNAME      | URL                                                     | PASSWORD    | FAILURE_MESSAGE           |
      | incorrectUser | https://practicetestautomation.com/practice-test-login/ | Password123 | Your username is invalid! |

  Scenario Outline: Validate that user is able to login
    Given I opened the app using following <URL>
    When I type <USERNAME> into Username field
    And I type <PASSWORD> into Password field
    And I Push Submit button
    Then I see the error message displayed
    Then I see the failure message <FAILURE_MESSAGE>

    Examples: 
      | USERNAME | URL                                                     | PASSWORD          | FAILURE_MESSAGE           |
      | student  | https://practicetestautomation.com/practice-test-login/ | incorrectPassword | Your password is invalid! |
