package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserChange {
    public static void exit() {
        sleep(1000);
        $("button.el-tooltip:nth-child(4)").click();
        sleep(1000);
        $(byText("Выход")).click();
    }

    public static void comInBoss11(){
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }
    public static void comInBoss51(){
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss51").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }
    public static void comInBoss31(){
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss31").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }
    public static void comInBoss21(){
        sleep(1000);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss21").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }


}
