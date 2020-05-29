package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserChange {

    public static void comInBoss1(){
        $("button.el-tooltip:nth-child(5)").click();
        $(byText("Выход")).click();
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }
    public static void comInClerk2(){
        $("button.el-tooltip:nth-child(5)").click();
        $(byText("Выход")).click();
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Clerk2").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }


}
