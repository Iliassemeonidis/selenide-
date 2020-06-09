package ru.idtm.documino;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RequiredFields {
    private final static String BUTTON = "Выбрать";
    private final static String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";


    public static void description(String text) {
        $(byXpath("//*[@id=\"dss_description\"]")).setValue(text);
    }

    public static void addressee(String text) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(text);
        $(byText("Главный специалист"))
                .click();
        $$(PATH).findBy(text(BUTTON)).click();

    }
    public static void addressee1(String text) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(text);
        $(byText("Начальник 1"))
                .click();
        $$(PATH).findBy(text(BUTTON)).click();

    }
    public static void signatory(String text) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div[1]/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(text);
        $(byText("Главный специалист"))
                .click();
        $$(PATH).findBy(text(BUTTON)).click();

    }


}
