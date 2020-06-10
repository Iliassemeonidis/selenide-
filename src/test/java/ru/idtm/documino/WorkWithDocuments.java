package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class WorkWithDocuments {

    public static void tryToFindDocWithDescription(String description){
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(description);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText("Распорядительные документы"))
                .first()
                .click();

    }
    public static void tryToFindDocWithRegNumber(String regNumber){
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(regNumber);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText("Распорядительные документы"))
                .first()
                .click();

    }


    public static void tryToFindDocWithSinger(String singer) {
        // ием по подписанту
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(singer);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText("Распорядительные документы"))
                .first()
                .click();
    }


    public static void tryToFindDoc(String doc) {
        // ием по подписанту
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(doc);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
    }



}
