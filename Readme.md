This little project uses the [Selenium webdriver](http://www.seleniumhq.org) to demonstrate automating coordination between
two distinct web sites.

Uses the [Selenium ChromeDriver](http://chromedriver.storage.googleapis.com/index.html) that must be downloaded and put in the path.  2.35 was latest version at last check.

JAVA_HOME should point to a JDK and not a JRE `set JAVA_HOME=c:\program files\java\jdk1.8.0_162`

To compile: `mvn clean compile assemble:single`

To execute: `java -jar target/MultiBrowserDemo-1.0-jar-with-dependencies.jar`
