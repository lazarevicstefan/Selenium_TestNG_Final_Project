| Test<br>Scenario ID | Test Case ID | Description                 | Steps To Reproduce                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Expected Results                                                                                                                                                                                                                                                         | Actual Results |
| ---------------- | ------------ | --------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | -------------- |
| TS_SIGN_UP_PAGE  | TC_ST_00     | Verify the url              | <ol><li>Check the url</li></ol>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | 'https[]()://vue-demo.daniel-avellaneda.com'                                                                                                                                                                                                          |                |
|                  | TC_ST_01     | Visit the signup page       | <ol><li>Open url</li><li>Click on 'Sign up button'</li><li>Check if the current url<br> contains '/signup' route</li></ol>                                                                                                                                                                                                                                                                                                                                                                                                                  | User will be redirected to the signup page<br>Url will be <br>'https[]()://vue-demo.daniel-avellaneda.com/signup'                                                                                                                                                                |                |
|                  | TC_ST_02     | Check input types           | <ol><li>Open url</li><li>Click on 'Sign up button'</li><li>Check the value of attribute 'type' for 'E-mail field'</li><li>Check the value of attribute 'type' for 'Password field'</li><li>Check the value of attribute 'type' for 'Confirm Password field'</li></ol>                                                                                                                                                                                                                                                                         | User will be redirected to the signup page<br>Value of the 'E-mail field' for attribute 'type' will be 'email' Value of the 'Password field' for attribute 'type' will be 'password'<br>Value of the 'Confirm Password field' for attribute 'type' will be 'password' |                |
|                  | TC_ST_03     | Sign up with existing email | <ol><li>Open url</li><li>Click on 'Sign up button'</li><li>Check if the current url contains '/signup' route</li><li>Input ``'Another User'`` as name in 'Name field'</li><li>Input ``'admin@admin.com'`` as e-mail in 'E-mail field'</li><li>Input ``'12345'`` as password in 'Password field'</li><li>Input ``'12345'`` as password in 'Confirm Password field'</li><li>Click on 'Sign me up button'</li><li>Check the text of the pop-up message</li><li>Check if the current url contains '/signup' route</li></ol>                                           | User will be redirected to the signup page<br>Url will be<br> 'https[]()://vue-demo.daniel-avellaneda.com/signup'<br>User will fail to sign up<br>Text of the pop-up message will be 'E-mail already exists'<br>Url will be <br>'https[]()://vue-demo.daniel-avellaneda.com/signup' <br> |                |
|                  | TC_ST_04     | Sign up with new email      | <ol><li>Open url</li><li>Click on 'Sign up button'</li><li>Input ``'Svetlana Radisic'`` as name in 'Name field'</li><li>Input ``'lana.radisic@bootcamp.rs'`` as e-mail in 'E-mail field'</li><li>Input ``'12345'`` as password in 'Password field'</li><li>Input ``'12345'`` as password in 'Confirm Password field'</li><li>Click on 'Sign me up button'</li><li>Check if the current url contains '/home' route</li><li>Check the text of the pop-up message</li><li>Click on 'Close button' from the dialog box</li><li>Click on 'Logout button'</li></ol> | User will be redirected to the signup page<br>User will be successfully signed up<br>Url will be <br>'https[]()://vue-demo.daniel-avellaneda.com/home'<br>Text of the pop-up message will be 'IMPORTANT: Verify your account'<br>User will be logged out<br>                     |                |