package ru.idtm.documino;

import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class Content {
    public static void contentUpload(String fileName) {

        $$("input")
                .first()
                .uploadFile(new File(fileName));

        //$("input").uploadFile(new File(fileName));
    }

}
