Feature: Login into Application


Scenario: Postitive test validating login 


Given initialize the browser with chrome			
And   Navigate to "http://qaclickacademy.com/" site

When User click on login link and  enters "ajit@fmail.com" and "test123" and logs in			


Then Verify that user is sucessfully logged in


