package ru.idtm.documino;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class Content {
    public static void content(String fileName) {
        $("input").uploadFile(new File(fileName));

    }
}
