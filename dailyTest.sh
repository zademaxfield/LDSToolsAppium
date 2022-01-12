#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDailyTests.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/iOSDaily.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSDailyTestsCucumber.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports1/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber1.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports2/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber2.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports3/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber3.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports4/CucumberTestReport.json /Users/zmaxfield/Documents/iOSDailyCucumber4.json
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDailyTestsMultiple.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/target/surefire-reports/testng-results.xml /Users/zmaxfield/Documents/AndroidDaily.xml
/opt/homebrew/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/AndroidDailyTestsMultipleCucumber.xml
sleep 30
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports1/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyCucumber1.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports2/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyCucumber2.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports3/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyCucumber3.json
cp /Users/zmaxfield/Documents/workspace/qa-membertools-all/src/test/java/Reports/cucumber-reports4/CucumberTestReport.json /Users/zmaxfield/Documents/AndroidDailyCucumber4.json