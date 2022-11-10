# EMI_Calculator_Automation  

## EMI calculator app tested using different dataset whether it is giving the correct results or not .

Here the following tasks are done:

* An EMI Calculator app extracted from EMI calculator is automated by extracting its apk.  

* Different data is tested where user gives Amount,Interest,Period and Processing fee and hits Calculate button. 

* The monthly EMI,total interest ,processing fee and total payment generated are matched with the expected data provided in the dataset. 

* Database testing is performed on a minor scale to check whether the system handles varieties of data to give correct result or not.  

* It is tested for five different data and a reset button will be pressed after a test case with a single data is executed.  

* JSON data will be stored for every user information. 
  
### Technology used:  

* Tool: Selenium Webdriver  
* IDE: Intellij, Android Studio 
* Build tool: Gradle  
* Language: Java  
* Test_Runner: Appium 
* Framework: TestNG 

### Prerequisites 
* Install Android Studio latest version 
* Install Appium 1.17.1 
* Install jdk 8 or any LTS version  
* Configure ANDROID_HOME, JAVA_HOME and GRADLE_HOME 
* Stable internet connection
* A PC/Laptop having minimum ram of 8GB 

### Project Run 
#### Appium 
* Create an emulator/virtual device in Android Studio and run it.
* Check the uuid of that emulator in cmd with "adb devices" command.
* Open Appium and start server. Then open inspector tool.
* Set the desired capabilities with following information:    

```
  "deviceName": "My Device",
  "platformName": "Android",
  "uuid": Enter your uuid here,
  "platformVersion": Enter your android version,
  "appPackage": "com.continuum.emi.calculator",
  "appActivity": "com.finance.emicalci.activity.Splash_screnn"
``` 

* Save this activity and click start session    
### Run the automation script in the terminal by following command: 
 ```
 gradle clean test 
``` 
 ### A report generated and will be looking like this:  
 
 
 ![normalreport](https://user-images.githubusercontent.com/62753355/201164314-d3271a64-9a2f-4c26-a220-dac6e03d71c2.PNG)

 * After automation to view allure report , give the following commands:
 
 ```
 allure generate allure-results --clean -o allure-report
allure serve allure-results 
```   

![allurereport](https://user-images.githubusercontent.com/62753355/201164363-10ebef50-7cbf-44c4-bff2-45a81cda370b.PNG)
