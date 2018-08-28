Feature: Test cases for verification of the 'Add  a new computer' functionality

  Background:
    Given I open the Home Page
    And I click on the 'Add a new computer' button on the Home Page
    And The 'Add a computer' page should be open

  @Test-1 @create @regression
  Scenario Outline: Adding a new computer to the database with only 'Computer name' field
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The Home Page should be open
    And The warning message should have the following text
    """
    Done! Computer <computer_name> has been created
    """
    And The quantity of computers increased by 1

    Examples:
      | computer_name |
      | Test Computer |

  @Test-2 @create @regression
  Scenario Outline: Adding a new computer to the database with the all specified fields
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '<introduced_date>' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '<discontinued_date>' value in the 'Discontinued date' field on the 'Add a computer' page
    And I specify '<company>' value in the 'Company' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The Home Page should be open
    And The warning message should have the following text
    """
    Done! Computer <computer_name> has been created
    """
    And The quantity of computers increased by 1

    Examples:
      | computer_name                  | introduced_date | discontinued_date | company                                     |
      | Sony Test Comp                 | 2000-01-01      | 2000-12-31        | Sony                                        |
      | a                              | 0001-01-01      | 0001-01-02        | Apple Inc.                                  |
      | ~`!@#$%^&*()_-+={[}}\;:',<.>?/ | 9999-12-31      | 0001-01-01        | Samsung Electronics                         |
      | 123123612356                   | 1999-12-31      | 2000-01-01        | Thinking Machines                           |
      | A B C D                        | 1997-09-01      | 2001-10-10        | Research In Motion                          |
      | Русский компьютер              | 2005-10-09      | 2009-11-11        | Canon                                       |
      | 汉字/汉语                          | 1000-12-31      | 999-11-01         | OQO                                         |
      | العَرَبِيَّة                   | 1-1-1           | 9-9-9             | E.S.R. Inc.                                 |
      | T__E__S__T                     | 10-9-11         | 99-11-20          | Micro Instrumentation and Telemetry Systems |
      | @TestComputer                  | 100-05-30       | 999-7-31          | IBM                                         |

  @Test-3 @create @regression
  Scenario Outline: Checking the validation of the 'Computer name' field
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '<introduced_date>' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '<discontinued_date>' value in the 'Discontinued date' field on the 'Add a computer' page
    And I specify '<company>' value in the 'Company' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The warning flag should be displayed

    Examples:
      | computer_name | introduced_date | discontinued_date | company    |
      |               |                 |                   |            |
      |               | 1999-12-31      |                   |            |
      |               |                 | 2000-01-01        |            |
      |               |                 |                   | Apple Inc. |
      |               | 2001-11-30      | 2001-02-02        | ASUS       |
      |               | 2009-06-15      | 2010-07-03        |            |
      |               | 2011-04-28      |                   | OMRON      |
      |               |                 | 2019-02-28        | Cray       |

  @Test-4 @create @regression
  Scenario Outline: Creating a computer with an invalid Introduced date
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '<introduced_date>' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '<discontinued_date>' value in the 'Discontinued date' field on the 'Add a computer' page
    And I specify '<company>' value in the 'Company' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The warning flag should be displayed

    Examples:
      | computer_name  | introduced_date | discontinued_date | company            |
      | Alfa Computer  | aaaa            | 1980-03-21        | Lincoln Laboratory |
      | Zeta Comparius | 2000            | 1992-03-31        |                    |
      | IBM 47         | 06-19           | 2010-02-27        | Netronics          |
      | Android 4.5    | 1989-05-32      |                   |                    |
      | CMXT 442       | 2015-02-29      | 2002-06-06        | Xerox              |
      | VCCX 776       | 2008-Sep-30     | 1999-01-25        |                    |

  @Test-5 @create @regression
  Scenario Outline: Creating a computer with an invalid Discontinued date
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '<introduced_date>' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '<discontinued_date>' value in the 'Discontinued date' field on the 'Add a computer' page
    And I specify '<company>' value in the 'Company' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The warning flag should be displayed

    Examples:
      | computer_name  | introduced_date | discontinued_date | company              |
      | Alfa Computer  |                 | a2018-08-14       | Lincoln Laboratory   |
      | Zeta Comparius | 1997-11-11      | 2012-2-           |                      |
      | IBM 47         | 2006-6-19       | 2004-Aug-15       | Atari                |
      | Android 4.5    | 1994-01-12      | 10000000000-08-2  |                      |
      | CMXT 442       | 2015-02-29      | 1990-10-00        | IMS Associates, Inc. |
      | VCCX 776       | 2008-Sep-30     | 1999-02-28        |                      |

  @Test-6 @create @regression
  Scenario Outline: Click on 'Cancel' button should not trigger creating of a new computer
    When I specify '<computer_name>' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '<introduced_date>' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '<discontinued_date>' value in the 'Discontinued date' field on the 'Add a computer' page
    And I specify '<company>' value in the 'Company' field on the 'Add a computer' page
    And I click on the 'Cancel' button
    Then The Home Page should be open
    And The quantity of computers should not be changed

    Examples:
      | computer_name | introduced_date | discontinued_date | company      |
      | TCCX 66A      | 2007-09-05      | 2015-12-06        | Lenovo Group |
      | CDDDF 554     |                 |                   |              |
      |               |                 |                   |              |

  @Test-7 @create @BUG @regression
  Scenario: Getting a validation error on the Add Computer page should not change url
    When I specify 'FRRC 554' value in the 'Computer name' field on the 'Add a computer' page
    And I specify '2013-13-32' value in the 'Introduced date' field on the 'Add a computer' page
    And I specify '2015-06-07' value in the 'Discontinued date' field on the 'Add a computer' page
    And I click on the 'Create this computer' button
    Then The warning flag should be displayed
    And The 'Add a computer' page should be open
