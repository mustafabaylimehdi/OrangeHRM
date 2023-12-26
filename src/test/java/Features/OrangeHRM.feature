@OrangeHRM
  Feature: OrangeHRM Check Test Cases

    @AllEmpty
    Scenario: Empty Username & Empty Password
      Given User at login page
      When Click login button
      Then Check required message about username and password

    @FalseLogin
    Scenario: False Username & False Password
      Given User at login page
      When False Username & Password
      When Click login button
      Then Check Invalid Credentials Message about login page

    @CorrectLogin
    Scenario: Correct Username & Password
      Given User at login page
      When Correct Username & Password
      When Click login button
      Then Check Successful Login

    @ChangeName
    Scenario: Change First Name and Last Name
      Given User at login page
      When Correct Username & Password
      When Click login button
      Then Check Successful Login
      When Click to My Info Button
      When Change Name and Surname
      When Click to Save Button
      Then Check New Name and Surname