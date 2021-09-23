Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Newly opened chrome browser
    And Navigate to "http://demowebshop.tricentis.com/" Site
    And Click on Login link in home page to land on Secure sign in Page
    When User enters <username> and <password> and logs in
    Then Verify that user is succesfully logged in
    And close browsers

    Examples:
      |username			|password	|
      |JN.8i4201@gmail.test	|Tosca1234!		|
      |JN.2Nb315@gmail.test	|Tosca1234!      |