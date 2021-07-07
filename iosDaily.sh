#!/bin/bash

echo Start of Test!
# shellcheck disable=SC2164
cd /Users/zmaxfield/Documents/workspace/qa-membertools-all
mvn clean test -DsuiteXmlFile=src/test/java/TestNG/iOSJustForTesting.xml
