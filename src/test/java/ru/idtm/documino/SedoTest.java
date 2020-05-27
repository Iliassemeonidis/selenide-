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
    private final String CONTENT = "Контент";
    private final String INPUTDOCUMENT = "ИСХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String OUTPUTDOCUMENT = "ВХОДЯЩИЕ ДОКУМЕНТЫ";


    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void tess_90() {
        OpenBrowser.openUtl();
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();
    }

    @Test
    public void test_91() {
        CreateDocument.create(INPUTDOCUMENT);
    }


    @Test  // заполняем обязательные поля
    public void test_92() {
        Buttons.requisites();
        //$(byText(REQUISITES)).click();
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
    public void test_93() {
        // добавляем контент
        Content.content("test");
    }

    @Test
    public void test_94() {
        // сохраняем
        Buttons.save();
        sleep(500);

    }

    @Test
    public void test_95() {
        // проверяем что заполнились Регистрационный номер, Временный номер
        Buttons.requisites();
        sleep(500);


    }

    @Test
    public void test_96() {
        // скачиваем контент
        Buttons.content();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
        sleep(1000);

    }

    @Test
    public void test_97() {
        // удаляем документ
        Buttons.delete();
        sleep(900);
    }

    // Входящий документ

    @Test
    public void test_98() {
        CreateDocument.create(OUTPUTDOCUMENT);
    }

    @Test
    public void test_99() {
        //Проверка на дубли
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"fio\"]")).setValue("Иванов");
        $(byText("Иванов И. И.")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue("78897");
        $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]")).click();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).click();

    }

    @Test
    public void test_100() {
        //Жмем кнопку далее
        $(byText("Далее")).click();
        sleep(1100);
    }


    @Test
    public void test_101() {
        // заполняем обязательные поля
        Buttons.requisites();
        RequiredFields.addressee("Босс11");
        RequiredFields.description("Auto-test");
    }

    @Test
    public void test_102() {
        // контент загружаем
        $(byText(CONTENT)).click();
        Content.content("test");
        sleep(1000);

    }

    @Test
    public void test_103() {
        //Жмем кнопку зарегистрировать
        Buttons.save();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }
    @Test
    public void test_104() {
        //Жмем кнопку зарегистрировать
        Buttons.register();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_105() {
       // На Рассмотрение
        Buttons.review();
    }


    @Test
    public void test_106() {
       Buttons.requisites();
       $(byXpath("//*[@id=\"dss_status\"]")).shouldBe(text("В канцелярии"));
    }






}
