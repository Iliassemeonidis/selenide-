package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateDocument {
    public static void create(String documentName){
        $(byText("Создать документ")).click();
        $(byText(documentName)).click();
        $(byText("Создать")).click();
    }
    public static void createInDoc(String documentName, String documentName1){
        $(byText("Создать документ")).click();
        $(byText(documentName)).click();
        sleep(1000);
        $(documentName1).click();
        sleep(1000);
        $(byText("Создать")).click();
    }


}
