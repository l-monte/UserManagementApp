# UserManagementApp

**The project is implemented using:**
* Angular: 8.2.13
* Java 8

**The application is build in the following way:**
* frontend is build using Angular CLI and *ng serve*
* backend is build using Intellij IDE v. 2018.3.6 with *Run 'Application'*

**Assumptions:**
* There are 100 users generated internally by application
* Each of these users has email like: *user[0-99].surname(at)gmail.com*, i.e. user58.surname@gmail.com
* Email is necessary to login to the application. 
* There could by any password passed in login form, but it could not be empty
* After sign in, users are displayed in pages form, each contains 10 users
* After login, user statistics are downloaded from server
