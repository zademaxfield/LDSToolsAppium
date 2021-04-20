#!/usr/bin/perl
@a = ("R9TN80AQ57J", "364c5930534f3098", "99051FFBA000S7", "R38M803MWGM");

foreach $i (@a) {
    system("adb -s " . $i . " uninstall org.lds.ldstools.dev");
    system("adb -s " . $i . " uninstall org.lds.ldstools");
    system("adb -s " . $i . " uninstall org.lds.ldstools.alpha");
    system("adb -s " . $i . " uninstall io.appium.uiautomator2.server");
    system("adb -s " . $i . " uninstall io.appium.uiautomator2.server.test");
    system("adb -s " . $i . " uninstall io.appium.unlock");
    system("adb -s " . $i . " uninstall io.appium.settings");
}
exit(0);
