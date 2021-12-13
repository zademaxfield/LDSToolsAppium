#!/bin/bash
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
/usr/local/bin/mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSSmokeTwoSimCucumber.xml
