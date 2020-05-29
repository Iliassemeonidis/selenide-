package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateDocument {
    public static void create(String documentName){
        $(byText("Создать документ")).click();
        $(byText(documentName)).click();
        $(byText("Создать")).click();
    }
    public static void createInDoc(String documentName, String documentName1){
        $(byText("Создать документ")).click();
        $(byText(documentName)).click();
        $(byText(documentName1)).click();
        $(byText("Создать")).click();
    }

}
