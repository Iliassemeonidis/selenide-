package ru.idtm.documino;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SedoTest {

    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private final String CONTENT = "Контент";
    private final String INPUTDOCUMENT = "ВХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String OUTPUTDOCUMENT = "ИСХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String INTERNAL_DOCUMENTS = "ВНУТРЕННИЕ ДОКУМЕНТЫ";
    private final String ERRAND = "ИНИЦИАТИВНОЕ ПОРУЧЕНИЕ";
    private final String MEMORANDUM_TEST = "C3(тест)";
    private final String MEMORANDUM_TEXT = "Служебная записка";
    private final String BOSS = "Босс11";
    private final String INPUT_DOC = "Входящий документ.docx";
    private final String OUTPUT_DOC = "Исходящий выставка.png";
    private final String ORDER_DOC = "Приказ об изменении орг-штатной структуры.docx";
    private final String MEMORANDUM_DOC = "СЗ.txt";
    private final String ERRAND_DOC = "Распоряжение_.gif";
    private final String PROXY_DOC = "Доверенность на курьера.png";
    private final String ANSWER = "ответ.txt";
    private final String REGULATORY_DOCUMENTS = "РАСПОРЯДИТЕЛЬНЫЕ ДОКУМЕНТЫ";
    private final String ORDER_DOCUMENTS = "Приказ (пустая форма)";
    private final String ORDER_DOCUMENTS1 = "Приказ (общий)";
    private static String registrationNumber;
    private static String identifier;
    private static String temporaryNumber;
    private static String description;
    private static String singer;
    private static String organization;
    private static String department;
    private static final String AUTOTEST1 = "Автотест1 , Сотрудник, Департамент 1";
    private static final String AUTOTEST_NAME1 = "Автотест1";
    private static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
    private static final String AUTOTEST_NAME2 = "Автотест2";
    private static final String AUTOTEST3 = "Автотест3 , Сотрудник, Департамент 3";
    private static final String AUTOTEST_NAME3 = "Автотест3";
    private static final String AUTOTEST4 = "Автотест4 , Сотрудник, Департамент 4";
    private static final String AUTOTEST_NAME4 = "Автотест4";
    private static final String AUTOTEST5 = "Автотест5 , Сотрудник, Департамент 5";
    private static final String AUTOTEST_NAME5 = "Автотест5";



    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void tess_90() {
        OpenBrowser.openUtl3();
        /// sleep(10000);
        UserChange.comInAutotest1();
    }


    //////////////////////// приказ
    @Test
    public void test_125() {
      //  CreateDocument.createInDoc(REGULATORY_DOCUMENTS, ORDER_DOCUMENTS);
        $(byText("Создать документ")).click();
        $(byText(REGULATORY_DOCUMENTS)).click();
        boolean order = $(byText(ORDER_DOCUMENTS)).isDisplayed();
        if (!order) {
            $(byText(ORDER_DOCUMENTS1)).click();
        }else $(byText(ORDER_DOCUMENTS)).click();
        $(byText("Создать")).click();
    }

    @Test
    public void test_126() {
        // создаем приказ
        Buttons.requisites();
    }


     ////////заполняем обязательные поле описание
    @Test
    public void test_127() {
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test777");
    }

    // поле подписант
    @Test
    public void test_128() {
// заполняем поле подписант
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).isDisplayed();
        if (visible) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).click();
            $("div.input-select-container:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
            sleep(1000);
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME2);
            sleep(1000);

            $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
            $(byText("Тестовый Филиал")).click();
            $(byText("Департамент 2")).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else {
            $("#dsid_signer_empl").setValue(AUTOTEST_NAME2);
            $(byText(AUTOTEST2)).click();
        }
    }

    // переходим в контент
    @Test
    public void test_129() {
        Buttons.content();
    }

    //
//    // загружаем док
    @Test
    public void test_130() {
        Content.contentUpload(ORDER_DOC);
        sleep(1000);
    }

    //
//    // сохранякм и ждем
    @Test
    public void test_131() {
        Buttons.save();
        sleep(10000);
    }

    @Test
    public void test_132() {
        Buttons.requisites();
        sleep(1000);
    }

    @Test
    public void test_133() {
        // получаем рег набр
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
        System.out.println(registrationNumber);
    }

    @Test
    public void test_134() {
        // получаем временный номер
        temporaryNumber = $(byXpath("//*[@id=\"dss_work_number\"]")).getValue();
        System.out.println(temporaryNumber);
    }

    @Test
    public void test_135() {
        // получаем краткое описание
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();
        System.out.println(description);
    }

    @Test
    public void test_136() {
        // получаем подписанта
        singer = $(byXpath("//*[@id=\"dsid_signer_empl\"]")).getValue();
        System.out.println(singer);
    }


    @Test
    public void test_137() {
        // нажимаем на вкладку соласование и подписание
        $(byText("Согласование и подписание")).click();
        sleep(1000);
    }


    // заполняем этапы  проверка оформления
    @Test
    public void test_138() {
        // добавляем
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).click();
        }else {
            ElementsCollection el = $$(byText("Добавить этап"));
            el.get(0).click();
        }


        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME3).pressEnter();
        sleep(1000);
        $(byText("Департамент 3")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        boolean b = $(byText("Добавить")).isDisplayed();
        if (!b) {
             $$(byText("Сохранить")).shouldHaveSize(7)
                    .get(6)
                    .click();
        }else $(byText("Добавить")).click();
        sleep(1000);
    }


    @Test
    public void test_139() {
        // добавдяем этап
        boolean visible = $(byText("Добавить этап")).isDisplayed();
        if (!visible) {
            ElementsCollection el = $$(byText("Добавить этап"));
            el.get(0).click();
        }else $(byText("Добавить этап")).click();

        $(byXpath("//*[@id=\"term\"]")).setValue("3").pressEnter();

        boolean save = $(byXpath("/html/body/div[6]/div/div[3]/span/button[1]")).isDisplayed();
        if (!save) {
            $$(byText("Сохранить")).shouldHaveSize(7)
                    .get(6)
                    .click();
        }else $(byXpath("/html/body/div[6]/div/div[3]/span/button[1]")).click();
        sleep(1000);

    }

    //
//    //    // заполняем согласующего
    @Test
    public void test_140() {
        // согласующий
        $(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']")).click();
        $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']")).click();
        boolean dis = $(byXpath("//*[@id=\"branchId\"]")).isDisplayed();
        if (dis) {
            $(byXpath("//*[@id=\"branchId\"]")).click();
            $(byText("Тестовый Филиал")).click();
            sleep(1000);
        }
        dis = $(byXpath("//*[@id=\"query\"]")).isDisplayed();

        if (dis) {
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME4).pressEnter();
            sleep(1000);
            $(byText("Департамент 4")).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else{
            $$(PATH).findBy(text(BUTTON)).click();
            $("#selectedUsers").setValue(AUTOTEST_NAME4);
            $(byText(AUTOTEST4)).click();
        }

        $(byText("Добавить")).click();
//
    }

    @Test
    public void test_141() {
        // еще один согласуюющий
        $(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']")).click();
        $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']")).click();
//        $(byXpath("//*[@id=\"branchId\"]")).click();
//        $(byText("Тестовый Филиал")).click();
//        sleep(1000);
//        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
//        sleep(1000);
//        $(byText("Департамент 5")).click();
//        $$(PATH).findBy(text(BUTTON)).click();
//        $(byText("Добавить")).click();
        boolean dis = $(byXpath("//*[@id=\"branchId\"]")).isDisplayed();
        if (dis) {
            $(byXpath("//*[@id=\"branchId\"]")).click();
            $(byText("Тестовый Филиал")).click();
            sleep(1000);
        }
        dis = $(byXpath("//*[@id=\"query\"]")).isDisplayed();

        if (dis) {
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
            sleep(1000);
            $(byText("Департамент 5")).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else{
            $$(PATH).findBy(text(BUTTON)).click();
            $("#selectedUsers").setValue(AUTOTEST_NAME5);
            $(byText(AUTOTEST5)).click();
        }

        $(byText("Добавить")).click();

    }


    // нажимаем кнопку на согласование
    @Test
    public void test_143() {
        // согласовать
        sleep(10000);
        $(byXpath("//button[@class='action-button full-flex-sizes #ffd700']")).click();
        sleep(1000);
    }
//
    //// выходим из босса11
    @Test
    public void test_144() {
        // выходим из автотест1
            UserChange.exit();

    }

    @Test
    public void test_145() {
        // заходим под автотестом3 провверяющий оформление
        UserChange.comInAutotest3();
    }

    @Test
    public void test_146() {
        //находим под автотестом3 наш док
        $(byText("Мои задания")).click();
        $(byText("Все задания")).click();
        sleep(1000);
    }

    @Test
    public void test_147() {
        //находим под автотестом3 по описанию
        WorkWithDocuments.tryToFindDocWithDescription(description);
        System.out.println(description);

    }


    @Test
    public void test_148() {
        // скачиваем контент
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
        sleep(1000);

    }

    @Test
    public void test_149() {
        // отказваем в оформлениеи
        Buttons.revert();
    }

    @Test
    public void test_150() {
        // заполняем описание
        $(byXpath("//*[@id=\"reportText\"]")).setValue("Авто-отклон");
    }

    @Test // загружаем контент
    public void test_151() {
        $("input").uploadFile(new File(ANSWER));
        sleep(1000);
    }

    @Test
    public void test_152() {
        // нажимаем кнопку вернуть
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(10000);
    }

    @Test
    public void test_153() {
        // выходим из автотеста3
        UserChange.exit();
    }

    @Test
    public void test_154() {
        // заходим под автотестом1
        UserChange.comInAutotest1();
    }


    @Test
    public void test_155() {
     /*   //находим под автотест1 наш док
//        $(byText("Босс11")).click();
//        sleep(1000);
//
//        ElementsCollection a = $$(byText("Все задания"));
//        if (a.size() > 1) {
//            a.get(1).click();
//        } else $(byText("Все задания")).click();
//
//        sleep(1000);
*/
        boolean visible = $(byText("Все задания")).isDisplayed();

        if (!visible) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_156() {
        // находим нужный док по рег номеру
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        System.out.println(registrationNumber);
    }

    @Test
    public void test_157() {
        // возвращаем все назад опять на утрвеждение проверки оформления
        Buttons.bringBack();
        sleep(10000);
    }

    @Test
    public void test_158() {
        //выходитм из автотест1
        UserChange.exit();
    }

    @Test
    public void test_159() {
        // заходим под автотест3
        UserChange.comInAutotest3();
    }

    @Test
    public void test_160() {
        boolean b = $(byText("Все задания")).isDisplayed();

        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();

    }

    @Test
    public void test_161() {
        // находим наш док по рег номеру
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
    }

    @Test
    public void test_162() {
        // подверждаем что все все ок
        Buttons.complete();
    }


    @Test
    public void test_163() {
        ////выходим из автотест3
        UserChange.exit();
    }


    @Test
    public void test_164() {
        // заходим к автотесту4 на этап согласования
        UserChange.comInAutotest4();
    }

    @Test
    public void test_165() {
        boolean b = $(byText("Все задания")).isDisplayed();
        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_166() {
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_167() {
        // отклоняем наш док
        Buttons.reject();
    }

    @Test
    public void test_168() {
        // описание
        $(byXpath("//*[@id=\"reportText\"]")).setValue("Отклоняем для автотеста");
    }

    @Test
    public void test_169() {
        // загружаем док
        Content.contentUpload(ANSWER);
        sleep(10000);
    }

    @Test
    public void test_170() {
        // нажимаем отклонить
        $(byXpath("/html/body/div[2]/div/div[3]/span/button[1]")).click();
    }

    @Test
    public void test_171() {
        // выходим из согласующего автотест4
        UserChange.exit();
    }

    @Test
    public void test_172() {
        // заходим под автотест1

        UserChange.comInAutotest1();
    }

    @Test
    public void test_173() {
        // все задачи
//        $(byText("Босс11")).click();
//        sleep(1000);
//
//        ElementsCollection a = $$(byText("Все задания"));
//        if (a.size() > 1) {
//            a.get(1).click();
//        } else $(byText("Все задания")).click();
//
//        sleep(1000);

        boolean visible = $(byText("Все задания")).isDisplayed();

        if (!visible) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();

    }

    @Test
    public void test_174() {
        // находим наш док по описанию
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_175() {
        // Всем, кто не согласовал на текущем этапе
        Buttons.forAllWhoAreNot();
    }

    @Test
    public void test_176() {
        //выходим из автотест1
        UserChange.exit();
    }

    @Test
    public void test_177() {
        //заходим к согласующему атотест4
        UserChange.comInAutotest4();
    }

    @Test
    public void test_178() {
        boolean b = $(byText("Все задания")).isDisplayed();

        if (!b) {
            $(byText("Мои задания")).click();

        }

        Buttons.allTasks();
    }

    @Test
    public void test_179() {
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_180() {
        // согласовываем
        Buttons.approve();
    }

    @Test
    public void test_181() {
        // выходим из согласующего
        UserChange.exit();
    }

    // идем к след согласующему
    @Test
    public void test_182() {
        // заходим к след согласующему(он исполняющий обязанности босса32)
        UserChange.comInAutotest5();
    }


    @Test
    public void test_185() {
        // все задания
//        $("li.list-item-container:nth-child(4)").click();
//        sleep(1000);
//        $(byXpath("/html/body/div[1]/div[3]/div/div[1]/nav/ul/div/li[4]/ul/li[1]/button")).click();
//        sleep(1000);
        boolean visible = $(byText("Все задания")).isDisplayed();

        if (!visible) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_186() {
        // находим док по описанию
        WorkWithDocuments.tryToFindDocWithDescription(description);

    }

    @Test
    public void test_187() {
        // согласовываем
        $(".bg-color-green1").click();
    }

    @Test
    public void test_188() {
        //выходим из вторго согласующего
        UserChange.exit();
    }

    // идем к подписанту автотест2
    @Test
    public void test_189() {
        // подписант босс21
        UserChange.comInAutotest2();
    }

    @Test
    public void test_190() {
        boolean b = $(byText("Все задания")).isDisplayed();

        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_191() {
        WorkWithDocuments.tryToFindDocWithSinger(description);
    }

    @Test
    public void test_192() {
        //отклоняем с подписания
        Buttons.reject();
    }

    @Test
    public void test_193() {
        $(byXpath("//*[@id=\"reportText\"]")).setValue("авто-отклонение тест");
    }

    @Test
    public void test_194() {
        Content.contentUpload(ANSWER);
        sleep(10000);
    }

    @Test
    public void test_195() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(1000);
    }

    @Test
    public void test_196() {
        // выходим из подписанта автотеста2
        UserChange.exit();
    }

    @Test
    public void test_197() {
        // заходим к автотест1
        UserChange.comInAutotest1();
    }


    @Test
    public void test_198() {
        // все задачи
//        $(byText("Босс11")).click();
//        sleep(1000);
//
//        ElementsCollection a = $$(byText("Все задания"));
//        if (a.size() > 1) {
//            a.get(1).click();
//        } else $(byText("Все задания")).click();

        boolean visible = $(byText("Все задания")).isDisplayed();

        if (!visible) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();

    }

    @Test
    public void test_199() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithSinger(description);
    }

    @Test
    public void test_200() {
        // отправляесм еще раз на подписание
        Buttons.toSing();
    }

    @Test
    public void test_201() {
        //выходим из автора автотеста1
        UserChange.exit();
    }

    @Test
    public void test_202() {
        //заходим к подписанту автотест2
        UserChange.comInAutotest2();
    }


    @Test
    public void test_203() {
        // все задачи
        boolean b = $(byText("Все задания")).isDisplayed();

        if (!b) {
            $(byText("Мои задания")).click();

        }
        Buttons.allTasks();
    }

    @Test
    public void test_204() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_205() {
        // подписываем
        Buttons.sing();
    }

    @Test
    public void test_206() {
        // заходим в реквизиты чтоб скопировать значение рег номера
        Buttons.requisites();
        sleep(1000);
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
    }

    @Test
    public void test_207() {
        // создаем резолюцию
        Buttons.createResolution();
    }

    @Test
    public void test_208() {
        // исполнитель
        $(byXpath("//*[@id=\"performers\"]")).setValue(AUTOTEST_NAME5);
        sleep(1000);
        $(byText(AUTOTEST5)).click();

    }

    @Test
    public void test_209() {
        // заполняем поле дата исполнения
        boolean visible = $(byXpath("//*[@id=\"Дата исполнения\"]")).is(Condition.visible);
        if (visible) {
            $(byXpath("//*[@id=\"Дата исполнения\"]")).click();
            $(byText("Без срока")).click();

        }else{ $("#period").click();
        $(byText("Без срока")).click();}

    }

    @Test
    public void test_210() {
        // описание заполняем
        $(byXpath("//*[@id=\"dssDescription\"]")).setValue("Трям");
    }


    @Test
    public void test_211() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").click();
        sleep(10000);
    }

    @Test
    public void test_212() {
        // выходим от автора резолюции
        UserChange.exit();
    }

    @Test
    public void test_213() {
        // заходим к тому кому адресованна резолюция автотест5
        UserChange.comInAutotest5();
    }

    @Test
    public void test_214() {
        // все задания
        boolean b = $(byText("Все задания")).isDisplayed();
        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_215() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_216() {
        // переходим во вкладку история
        Buttons.history();
    }


    @Test
    public void test_218() {
        // нажимаем исполнить резорлючию
        Buttons.execute();
    }

    @Test
    public void test_219() {
        // описание
        $("#reportText").setValue("The end").pressEnter();
    }

    @Test
    public void test_220() {
        // загружаем контент
        Content.contentUpload(ANSWER);
        sleep(10000);
    }

    @Test
    public void test_221() {
        // отправляем
        $("button.empty-purple:nth-child(4)").click();
    }

    @Test
    public void test_222() {
        // выходим из того кто сделал резолюцию
        UserChange.exit();
    }


    @Test
    public void test_223() {
        // заходим туда кто ее создавал autotest2
        UserChange.comInAutotest2();
    }

    @Test
    public void test_224() {
        //находим наш доок
        $("button.el-tooltip:nth-child(1)").click();
        $(byText("По резолюциям")).click();
        $(byText("По документам")).click();
        $(byText("По резолюциям")).click();

    }

    @Test
    public void test_225() {

        boolean typs = $(byXpath("//*[@id=\"types\"]")).isDisplayed();

        if (!typs) {
            $(byXpath("//*[@id=\"dss_document_type\"]")).click();
        }
        else {
            $(byXpath("//*[@id=\"types\"]")).click();
        }
        sleep(1000);
        $(byText("Распорядительные документы")).click();
        $(byXpath("//*[@id=\"changing\"]")).setValue(registrationNumber);
        sleep(1000);


    }
/////////// подумать как оптимизироват этот блок
    @Test
    public void test_226() {
//        $(byText("Искать")).click();
//        sleep(10000);
//        boolean regNumbr = $(byText(registrationNumber)).isDisplayed();
//        if (!regNumbr) {
//            $(byText("По резолюциям")).click();
//            $(byText("По документам")).click();
//            $(byXpath("//*[@id=\"types\"]")).click();
//            sleep(1000);
//            $(byText("Распорядительные документы")).click();
//            $(byXpath("//*[@id=\"changing\"]")).setValue(registrationNumber);
//            $(byText("Искать")).click();
//            sleep(10000);
//        }
        WorkWithDocuments.tryToFindDoc(registrationNumber);
//        $$(byText(registrationNumber))
//                .first()
//                .click();

    }

    @Test
    public void test_227() {
        // делаем крточку
        Buttons.printCart();
    }

    @Test
    public void test_228() {
        // заввершаем
        $(byText("Печать")).click();
        sleep(1000);
    }
//
//    ////////////////// чать 2 Исх, Вх, Внутр, ИП
    @Test
    public void test_229() {
        UserChange.exit();
    }

    @Test
    public void test_230() {
        // автотест1
        UserChange.comInAutotest1();
    }

    @Test
    public void test_231() {
        // исходящий документ
        CreateDocument.create(OUTPUTDOCUMENT);
    }

    @Test
    public void test_232() {
        // добавляем контент
        Content.contentUpload(OUTPUT_DOC);
    }

    @Test
    public void test_233() {
        // переходим в реквизиты
        Buttons.requisites();
    }


    @Test
    public void test_234() {
        // Краткое содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test777");
    }

    //заполняем обязательные поля
    @Test
    public void test_235() {
        //Подписант
        boolean visble = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).isDisplayed();
        if (visble) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME1);
            $(byText("Департамент 1")).click();
            //путь к кнопке выбрать подписанта
            $$(PATH).findBy(text(BUTTON)).click();
        }else {
            $("#dsid_signer_empl").setValue(AUTOTEST_NAME1);
            $(byText(AUTOTEST1)).click();
        }
    }

    @Test
    public void test_236() {
        // сохраняем спецом чтоб перекинуло к незаполненым полям если они есть
        Buttons.save();
        sleep(1000);

    }

    @Test
    public void test_237() {
        // Внешний аресат
        sleep(1000);
        $("#dsid_agent_person").setValue(AUTOTEST_NAME3);
        $$(byText("Автотест3 А. Т.,ПАО \"ЛЕНЭНЕРГО\",Сотрудник 3")).first().click();

    }

    @Test
    public void test_238() {
        // сохраняем
        Buttons.save();
        sleep(10000);

    }

    @Test
    public void test_239() {
        // проверяем что заполнились Регистрационный номер, Временный номер
        Buttons.content();
        Buttons.requisites();
        sleep(1000);
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
    }

    @Test
    public void test_240() {
        // скачиваем контент
        Buttons.content();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
        sleep(1000);
    }

    /// переходим к проверке оформления
    @Test
    public void test_241() {
        //нажимаем на вкладку соласование и подписание
        $(byText("Согласование и подписание")).click();
    }


    @Test
    public void test_242() {
        //нажимаем добавить согласующего
        boolean b = $(byClassName("fs-12 flex flex-wrap ai-center stage-header tt-uppercase m-t-8 pos-relative")).isDisplayed();
        if (!b) {
            $$(byText("Добавить этап"))
                    .first()
                    .click();
        }
    }


    @Test
    public void test_243() {
        //ажимаем добавить проверяющего
        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
        sleep(1000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();

    }

    @Test
    public void test_244() {
        //нажимаем сохранить
        $$(byText("Сохранить")).shouldHaveSize(7)
                .get(6)
                .click();

    }


    @Test
    public void test_245() {
        //ажимаем добавить проверяющего
        boolean b = $(byText("Проверка оформления")).find(byText("Добавить этап")).is(visible);
        if (b) {
            ElementsCollection a = $$(byText("Добавить этап"));
            if (a.size() > 1) {
                a.get(1).click();
            }
        } else {
            boolean click = $(".layout-icon").isDisplayed();
            if (click) {
                $(".layout-icon").click();
            } else {
                $(byXpath("//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]")).click();

            }

        }


    }


    @Test
    public void test_246() {
        //ажимаем добавить проверяющего
        boolean visible = $(".layout-icon").isDisplayed();

        if (visible) {

            $(".layout-icon").click();
            $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
            $(byText("Тестовый Филиал")).click();
            sleep(1000);
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME3).pressEnter();
            sleep(1000);
            $(byText("Департамент 3")).click();
            sleep(1000);
            $$(PATH).findBy(text(BUTTON)).click();
            $$(byText("Сохранить")).shouldHaveSize(7)
                    .get(6)
                    .click();

        } else {

            $("#selectedUsers").setValue(AUTOTEST_NAME3);
            sleep(1000);
            $(byText(AUTOTEST3)).click();
            $(byText("Добавить")).click();
        }



    }

    @Test
    public void test_249() {
        // на согласование
        sleep(10000);
        Buttons.agreement();
        sleep(10000);
    }

    @Test
    public void test_250() {
        // меняем пользака
        UserChange.exit();
    }

    @Test
    public void test_251() {
        // заходим под проверяющим autotest5
        UserChange.comInAutotest5();
    }

    @Test
    public void test_252() {
//        / поиск по организации
//        находим наш доок
//        $("button.el-tooltip:nth-child(1)").click();
//        $(byText("По резолюциям")).click();
//        $(byText("По документам")).click();
//        $("#types").click();
//        $(byText("Исходящие документы")).click();
//        $("div.input-field-container:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Автотест1");
//        sleep(10000);
//        $(byText("Искать")).click();
//        sleep(1000);
//        boolean visible = $(byText("Согласование")).isDisplayed();
//        if (!visible) {
//            $(byText("По резолюциям")).click();
//            $(byText("По документам")).click();
//            $("#types").click();
//            $(byText("Исходящие документы")).click();
//            sleep(1000);
//            $("div.input-field-container:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(registrationNumber);
//            sleep(10000);
//            $(byText("Искать")).click();
//            sleep(1000);
//        }
//        visible = $(byText("Согласование")).isDisplayed();
//        if (visible) {
//            $$(byText("Согласование"))
//                    .first()
//                    .click();
//
//        }else{
//            visible = $(byText(registrationNumber)).isDisplayed();
//            if (!visible) {
//                $(byText("По резолюциям")).click();
//                $(byText("По документам")).click();
//                $("#types").click();
//                $(byText("Исходящие документы")).click();
//                sleep(1000);
//                $(byXpath("//div[6]//div[1]//div[1]//div[1]//input[1]")).setValue(registrationNumber);
//                $(byText("Искать")).click();
//            }
//            visible = $(byText(registrationNumber)).isDisplayed();
//            if (visible) {
//
//                $$(byText(registrationNumber))
//                        .first()
//                        .click();
//            }else WorkWithDocuments.tryToFindDoc(registrationNumber);
//
//
//        }
        WorkWithDocuments.tryToFindDoc(registrationNumber);
//    $$(byText(registrationNumber))
//        .first()
//        .click();
           sleep(1000);


        UserChange.exit();
        UserChange.comInAutotest1();
    }


    ///////////// //////// Входящий документ

    @Test
    public void test_254() {
        CreateDocument.create(INPUTDOCUMENT);
    }

    @Test
    public void test_255() {
        //Проверка на дубли
        Random rd = new Random();

        $(".layout-icon").click();
        $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__body div.user-select-dialogue-container div.user-selected-user-list-container div.tabs-wrapper div.column-container.tab-content-wrapper div.user-select-dialogue-wrapper div.table-container div.list-table.bg-color-white div.flex.flex-column.full-flex-sizes.p-r-16.table-header-container div.flex.ai-center.m-b-8 div.m-r-8.w-100.flex div.filter-container div.flex.full-with.filter-field.p-b-0 input#fio.base-input.full-with.fs-12").setValue(AUTOTEST_NAME3);
        sleep(1000);
        $$(byText("Сотрудник 3")).first().click();
        $$(PATH).findBy(text(BUTTON)).click();

        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue(String.valueOf(rd.nextInt(201) + 10));
        $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]")).click();
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).click();
        } else {
            $(byText("5")).click();
        }


    }

    @Test
    public void test_256() {
        //Жмем кнопку далее
        $(byText("Далее")).click();
        sleep(10000);
    }


    @Test
    public void test_257() {
        // заполняем обязательные поля
        Buttons.requisites();
        RequiredFields.addressee(AUTOTEST_NAME1, "Департамент 1",AUTOTEST1);
        RequiredFields.description("Auto-test");
        $("#dsid_document_kind").setValue("Вход");
        sleep(1000);
        $(byText("Входящие документы")).click();
    }

    @Test
    public void test_258() {
        // контент загружаем
        $(byText(CONTENT)).click();
        Content.contentUpload(INPUT_DOC);
        sleep(1000);

    }

    @Test
    public void test_259() {
        //Жмем кнопку зарегистрировать
        sleep(1000);
        Buttons.save();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_260() {
        //Жмем кнопку зарегистрировать
//        Buttons.register();
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_261() {
        // На Рассмотрение
        sleep(1000);
        boolean visibl = $(".\\#ffd700").isDisplayed();
        if (visibl) {
            $(".\\#ffd700").click();
        } else {
            visibl = $(byText("На Рассмотрение")).isDisplayed();
            if (visibl) {
                Buttons.review();
            } else $(byXpath("//button[@class='action-button full-flex-sizes #ffd700']")).click();
        }

        sleep(10000);
    }


    @Test
    public void test_262() {
        Buttons.requisites();
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В канцелярии"));
    }

    @Test
    public void test_263() {
        // задание
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Предварительное рассмотрение"));
        sleep(10000);
    }


    @Test
    public void test_264() {
        CreateDocument.create(INPUTDOCUMENT);
    }

    @Test
    public void test_265() {
        Random rd = new Random();

        $(".layout-icon").click();
        $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__body div.user-select-dialogue-container div.user-selected-user-list-container div.tabs-wrapper div.column-container.tab-content-wrapper div.user-select-dialogue-wrapper div.table-container div.list-table.bg-color-white div.flex.flex-column.full-flex-sizes.p-r-16.table-header-container div.flex.ai-center.m-b-8 div.m-r-8.w-100.flex div.filter-container div.flex.full-with.filter-field.p-b-0 input#fio.base-input.full-with.fs-12").setValue(AUTOTEST_NAME3);
        $$(byText("Сотрудник 3")).first().click();
        $$(PATH).findBy(text(BUTTON)).click();

        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue(String.valueOf(rd.nextInt(401) + 100));
        $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]")).click();
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).click();
        } else {
            $(byText("5")).click();
        }

    }

    @Test
    public void test_266() {
        $(byText("Далее")).click();
        sleep(10000);
    }

    @Test
    public void test_267() {
        Buttons.requisites();
        RequiredFields.addressee(AUTOTEST_NAME1, "Департамент 1",AUTOTEST1);
        RequiredFields.description("Auto-test");
        $("#dsid_document_kind").setValue("Вход");
        sleep(1000);
        $(byText("Входящие документы")).click();
    }

    @Test
    public void test_268() {
        $(byText(CONTENT)).click();
        Content.contentUpload(INPUT_DOC);
        sleep(1000);
    }

    @Test
    public void test_269() {
        Buttons.save();
        sleep(1000);
    }

    @Test
    public void test_270() {
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(10000);
    }


    @Test
    public void test_271() {
        // На резолюцию
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(1000);
    }


    @Test
    public void test_272() {
        // проверка статус доркумента
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В подразделении"));
    }

    @Test
    public void test_273() {
        // задание
        sleep(10000);
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Рассмотрение"));
    }

  //////   служебная записка
    @Test
    public void test_274() {
//        CreateDocument.createInDoc(INTERNAL_DOCUMENTS,MEMORANDUM_TEXT);
        $(byText("Создать документ")).click();
        $(byText(INTERNAL_DOCUMENTS)).click();
        sleep(1000);
        $(byText(MEMORANDUM_TEXT)).click();
        $(byText("Создать")).click();

    }

    @Test
    public void test_275() {
        // реквизиты
        Buttons.requisites();

    }

    @Test
    public void test_276() {
        //
        $$(byXpath("//*[@id=\"dsid_stamp\"]"))
                .first()
                .click();
        $(byText("Общего пользования")).click();

    }

    @Test
    public void test_277() {
        // описание
        RequiredFields.description("Служебка");
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();
    }

    @Test
    public void test_278() {
        // адресат

        RequiredFields.addressee(AUTOTEST_NAME2,"Департамент 2",AUTOTEST2);
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[10]/div/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
//        $("#query").setValue(AUTOTEST_NAME2);
//        //$(byXpath("//*[@id=\"query\"]")).setValue(BOSS);
//        $(byText("Департамент 2")).click();
//        sleep(1000);
//        $$(PATH).findBy(text(BUTTON)).click();
        $(byText(CONTENT)).click();
        Content.contentUpload(MEMORANDUM_DOC);
        sleep(1000);
        Buttons.save();
    }


    @Test
    public void test_279() {
        // подписант
        $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME1);
        $(byText("Департамент 1")).click();
        $$(PATH).findBy(text(BUTTON)).click();
//        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue("Босс11");
//        sleep(1000);
//        $(byText("Босс11 , Главный специалист, АО \"ПЭС\"")).click();
    }


    @Test
    public void test_280() {
        Buttons.save();
        sleep(1000);
        Buttons.content();
        sleep(1000);
        Buttons.requisites();
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
    }

    @Test
    public void test_281() {
        // на согласование
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(10000);
    }

    @Test
    public void test_282() {
//     нахолдим нашу служебку
        $("button.el-tooltip:nth-child(1)").click();
        $(byText("По резолюциям")).click();
        $(byText("По документам")).click();
        $("#types").setValue("Внутренние");
        sleep(100);
        $(byText("Внутренние документы")).click();
        $(byXpath("//*[@id=\"changing\"]")).setValue(registrationNumber);// по рег номеру не находит
        $(byText("Искать")).click();
        sleep(1000);


    }


    ////////  Создание Исполнительного поручения

    @Test
    public void test_283() {
        CreateDocument.create(ERRAND);
    }

    @Test
    public void test_284() {
        Buttons.content();
        Content.contentUpload(ERRAND_DOC);
    }

    @Test
    public void test_285() {
        // заполняем поля
        Buttons.requisites();
        RequiredFields.addressee(AUTOTEST_NAME1,"Департамент 1",AUTOTEST1);
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[5]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
////        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME1);
////        $(byText("Департамент 1")).click();
////        $$(PATH).findBy(text(BUTTON)).click();
        RequiredFields.description("Auto-test777");
//        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test");
        $(byXpath("//*[@id=\"dsdt_control_date\"]")).click();
        $(byText("7")).click();
    }


    @Test
    public void test_286() {
        sleep(1000);
        Buttons.save();
        sleep(1000);
        Buttons.requisites();
        sleep(1000);
    }
//
//    //    //////////// Доверенность
    @Test
    public void test_287() {
        CreateDocument.create("ДОВЕРЕННОСТЬ");
    }

    @Test
    public void test_288() {
        Content.contentUpload(PROXY_DOC);
    }

    @Test
    public void test_289() {
        Buttons.requisites();
    }

    @Test
    public void test_290() {
        // содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test888");
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();
    }

    @Test
    public void test_291() {
        // содержание
        sleep(1000);
        Buttons.save();
        sleep(1000);
    }

    @Test
    public void test_292() {
        // создаем кому
        $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
    }

    @Test
    public void test_293() {
        // кому
        $("#organizationId").setValue("ПАО \"ЛЕНЭНЕРГО\"");
        $(byText("ПАО \"ЛЕНЭНЕРГО\"")).click();
        sleep(1000);


        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);


        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
        sleep(1000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        sleep(1000);
    }

    @Test
    public void test_294() {
        // инициатор
        //$("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        $(byXpath("//input[@id='dsid_executor_empl']")).setValue(AUTOTEST_NAME5);
        $$(byText("Автотест5 , Сотрудник, Департамент 5")).first().click();
    }

    @Test
    public void test_295() {
        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue(AUTOTEST_NAME2);
        $(byText("Автотест2 , Сотрудник, Департамент 2")).click();
    }

    //
    @Test
    public void test_296() {
        // содержание
        Buttons.save();
        sleep(1000);
    }

    @Test
    public void test_297() {
        // содержание
        Buttons.agreement();
    }

//    @Test
//    public void test_298() {
//        // содержание
//        Buttons.allTasks();
//        sleep(10000);
//    }

    @Test
    public void test_299() {
        // содержание
//        WorkWithDocuments.tryToFindDoc("Auto-test888");

        $("button.el-tooltip:nth-child(1)").click();
        $(byText("По резолюциям")).click();
        $(byText("По документам")).click();
        sleep(1000);
        $("#types").setValue("Дов");
        sleep(1000);
        $(byText("Доверенность")).click();
//        $(byText("Краткое содержание")).click();
//        $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Служебка");
        $(byXpath("//*[@id=\"changing\"]")).setValue(description);// по рег номеру не находит
        $(byText("Искать")).click();
        sleep(1000);
        $$(byText(description)).first().click();
//
    }


}

