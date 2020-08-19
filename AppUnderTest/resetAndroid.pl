#!/usr/bin/perl
@a = ("ce061716cae890d10d7e", "364c5930534f3098", "710KPFX0305667", "89UY0C037");

foreach $i (@a) {
    system("adb -s " . $i . " uninstall org.lds.ldstools.dev");
    system("adb -s " . $i . " uninstall org.lds.ldstools");
    system("adb -s " . $i . " uninstall org.lds.ldstools.alpha");

}
exit(0);
