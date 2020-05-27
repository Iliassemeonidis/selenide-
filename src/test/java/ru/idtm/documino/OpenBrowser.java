package ru.idtm.documino;
import org.junit.Before;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenBrowser {

    public static void openUtl() {
        browser = "firefox";
//        browserPosition = "990x100";
//        browserSize = "780x950";

        open("http://172.25.144.151/");

    }

}
