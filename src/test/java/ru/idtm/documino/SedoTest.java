package ru.idtm.documino;


import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SedoTest {
    private final Logger log = Logger.getLogger(SedoTest.class.getName());
    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private final String SAVE = "Сохранить";
    private final String REQUISITES = "Реквизиты";
    private final String DELETE = "Удалить";
    private final String CONTENT = "Контент";



    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void test1() {
        OpenBrowser.openUtl();
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }

    @Test
    public void test2() {
        $(byText("Создать документ")).click();
        $(byText("ИСХОДЯЩИЕ ДОКУМЕНТЫ")).click();
        $(byText("Создать")).click();
    }


    @Test  // заполняем обязательные поля
    public void test3() {
        $(byText(REQUISITES)).click();
        //Подписант
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс11");
        $(byText("Начальник 4")).click();
        //путь к кнопке выбрать подписанта
        $$(PATH).findBy(text(BUTTON)).click();
        // заполняем поле Внешний адресат

        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[16]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"fio\"]")).setValue("Иванов");
        $(byText("Иванов И. И.")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        // Краткое содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Test");
        //сохраняем
        $(byText(CONTENT)).click();
    }

    @Test
    public void test4() {
        // добавляем контент
        $("input").uploadFile(new File("test"));
    }

    @Test
    public void test5() {
        // сохраняем
        $(byText(SAVE)).click();
       sleep(500);

    }

    @Test
    public void test6() {
        // проверяем что заполнились Регистрационный номер, Временный номер
        $(byText(REQUISITES)).click();
        sleep(500);


    }

    @Test
    public void test7() {
        // скачиваем контент
        $(byText(CONTENT)).click();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
         sleep(10000);

    }

    @Test
    public void test8() {
        // удаляем документ
        $(byText(DELETE)).click();
        sleep(900);
    }

}
