Feature: CreateDirectory

  Scenario Outline: Validate that directory is created
    Given I created a directory <DIRNAME> in my home directory
    And I create <NUMBER_OF_FILES> files with <NUMBER_OF_LINES> lines each in <DIRNAME>
    Then I list all the files in <DIRNAME>
    And I should append the contents of the files to <TEMP> file in <DIRNAME> directory
    Then I download the <TEMP> file
    Then I print the contents in the <TEMP> file

    Examples: 
      | DIRNAME | NUMBER_OF_FILES | NUMBER_OF_LINES | TEMP |
      | test    |               5 |              10 | temp |
