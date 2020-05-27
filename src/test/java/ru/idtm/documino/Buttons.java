package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Buttons {
    private final static String REQUISITES = "Реквизиты";
    private final static String SAVE = "Сохранить";
    private final static String DELETE = "Удалить";
    private final static String CONTENT = "Контент";
    private final static String CONSIDERATION = "На рассмотрение";
    private final static String REGISTER = "Зарегистрировать";
    private final static String REVIEW = "На Рассмотрение";

    public static void requisites(){
        $(byText(REQUISITES)).click();
    }
    public static void save(){
        $(byText(SAVE)).click();
    }
    public static void delete(){
        $(byText(DELETE)).click();
    }
    public static void content(){
        $(byText(CONTENT)).click();
    }
    public static void consideration(){
        $(byText(CONSIDERATION)).click();
    } public static void register(){
        $(byText(REGISTER)).click();
    } public static void review(){
        $(byText(REVIEW)).click();
    }


}
