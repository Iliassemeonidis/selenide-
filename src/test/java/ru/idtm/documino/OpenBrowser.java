package ru.idtm.documino;
import org.junit.Before;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class OpenBrowser {

    public static void openUtl() {
        browser = "firefox";
        open("http://172.25.144.151/");

    }

}
