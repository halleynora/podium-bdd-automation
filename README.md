
## Executing the tests
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=chrome
```

To run specific test suites you will need to annotate test accordinly then provide the tags at build time.  This will help run paralell execution as well.
```json
$ mvn clean verify -Ddriver=chrome -Dcucumber.options="--tag @smoke"
```

There is also a runner class located src/test/java/podium/CucumberTestSuite.java

####The test results will be recorded in the `target/site/serenity` directory.  Open index.html in browser of your choice

#Bugs I am noticing
Severe latency with the widget loading on the demo page.  Not sure if it is processes running on the weekdends
in the `demo` environment or something else.  There is a TypeError with widget.js `Cannot read properties of 
undefined (reading organizationScript)`

No validation on Search Input Text field.  

Errors in console when widget seems to get hung up and have to refresh.  I am not able to reproduce what causes this yet.
`widget.js:2          POST https://mind-flayer.podium.com//graphql 500 (Internal Server Error)`
`widget.js:2 Uncaught (in promise) TypeError: Cannot read properties of undefined (reading 'locations')`

Per project instructions it says that there are only 4 locations but I am only seeing the same 3 locations regardless of geography.

### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments.
```json
environments {
all {
  api.base.uri = "https://demo.podium.tools/#{environment}-"
  home.page = "#{webdriver.base.url}"
}
default {
  webdriver.base.url = "https://demo.podium.tools/qa-webchat-lorw/"
}
stage{
  webdriver.base.url = "https://stage.podium.tools/stage-webchat-lorw/"
}
uat{
  webdriver.base.url = "https://uat.podium.tools/uat-webchat-lorw/"
}
}
```

You use the `environment` system property to determine which environment to run against.  If you don't supply the argument it will use what is defined in `default` For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```

