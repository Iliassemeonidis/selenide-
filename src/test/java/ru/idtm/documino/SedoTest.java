package ru.idtm.documino;


import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.Random;
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
    private final String INTERNAL_DOCUMENTS = "ВНУТРЕННИЕ ДОКУМЕНТЫ";
    private final String ERRAND = "ИНИЦИАТИВНОЕ ПОРУЧЕНИЕ";
    private final String MEMORANDUM_TEST = "C3(тест)";
    private final String BOSS = "Босс11";
    private final String DOC = "test.txt";
    private final String DOC1 = "ответ.txt";
    private final String REGULATORY_DOCUMENTS = "РАСПОРЯДИТЕЛЬНЫЕ ДОКУМЕНТЫ";
    private final String ORDER_DOCUMENTS = "Приказ (пустой шаблон)";
    private String val = "";


    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void tess_90() {
        OpenBrowser.openUtl();
        sleep(10000);
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
        //Подписант
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс11");
        $(byText("Главный специалист")).click();
        //путь к кнопке выбрать подписанта
        $$(PATH).findBy(text(BUTTON)).click();

        // заполняем поле Внешний адресат
//        $(".has-error > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
//       $(byXpath("/html/body/div[7]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/button")).click();
//       $(byXpath("//*[@id=\"fio\"]")).setValue("Босс21");
//       $(byXpath("/html/body/div[7]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/button")).click();
//       $$(byText("Начальник 1"))
//               .first()
//               .click();
//        $$(PATH).findBy(text(BUTTON)).click();

        $(byXpath("//*[@id=\"dsid_agent_person\"]")).setValue("Иванов");
        $(byText("Иванова123 И. И.,-")).click();
        // Краткое содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Test");
        //сохраняем
        $(byText(CONTENT)).click();
    }

    @Test
    public void test_93() {
        // добавляем контент
        Content.content(DOC);
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
        Random rd = new Random();
        //$(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        //$(byXpath("//*[@id=\"fio\"]")).setValue("Иванов");
        $(byXpath("//*[@id=\"dsid_agent_person\"]")).setValue("Иванов");
        sleep(1000);
        $(byText("Иванов И. И.,-")).click();
        //$$(PATH).findBy(text(BUTTON)).click();
        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue(String.valueOf(rd.nextInt(201) + 10));
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
        Content.content(DOC);
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
//        Buttons.register();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        //$(byText("Зарегистрировать")).click();
        sleep(10000);
    }

    @Test
    public void test_105() {
        // На Рассмотрение
        //Buttons.review(); переписать кнопку
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[2]/button")).click();
        sleep(10000);
    }


    @Test
    public void test_106() {
        Buttons.requisites();
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В канцелярии"));
    }

    @Test
    public void test_107() {
        // задание
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Предварительное рассмотрение"));
    }

    @Test
    public void test_108() {
        // На резолюцию
        test_98();
        test_99();
        test_100();
        test_101();
        test_102();
        test_103();
        test_104();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(1000);
    }


    @Test
    public void test_109() {
        // проверка статус доркумента
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В подразделении"));
    }

    @Test
    public void test_110() {
        // задание
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Рассмотрение"));
    }

     //служебная записка
    @Test
    public void test_111() {
        $(byText("Создать документ")).click();
        $(byText(INTERNAL_DOCUMENTS)).click();
        $(byText(MEMORANDUM_TEST)).click();
        $(byText("Создать")).click();
        Buttons.requisites();
    }

    @Test
    public void test_112() {
        //
        $$(byXpath("//*[@id=\"dsid_stamp\"]"))
                .first()
                .click();
        $(byText("Общего пользования")).click();

    }

    @Test
    public void test_113() {
        // описание
        RequiredFields.description("Служебка");
    }

    @Test
    public void test_114() {
        // адресат
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[10]/div/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        //$(byXpath("//*[@id=\"query\"]")).setValue(BOSS);
        $(byText("Главный специалист")).click();
        sleep(1000);
        $$(PATH).findBy(text(BUTTON)).click();
    }

    @Test
    public void test_115() {
        // подписант
        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue("Босс11");
        sleep(1000);
        $(byText("Босс11 , Главный специалист, АО \"ПЭС\"")).click();
    }


    @Test
    public void test_116() {
        // контен
        $(byText(CONTENT)).click();
        Content.content(DOC);
        sleep(1000);
    }

    @Test
    public void test_117() {
        Buttons.save();
        sleep(1000);
        Buttons.content();
        sleep(1000);
    }

    @Test
    public void test_118() {
        // сохраняем док
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(1000);
    }

    @Test
    public void test_119() {
        // нахолдим нашу служебку
        $(byText("Задания от меня")).click();
        $$(byText("Служебка"))
                .first()
                .click();
    }


//    @Test
//    public void test_120() {
////     история проверка нужного значения
//        Buttons.history();
//        $(".table-scroll-bar").shouldHave(text("Рассмотрение"));
//    }


    // Создание Исполнительного поручения

    @Test
    public void test_121() {
        CreateDocument.create(ERRAND);
        Buttons.requisites();
    }

    @Test
    public void test_122() {
        // заполняем поля
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[5]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(BOSS);
        $(byText("Главный специалист")).click();
        $$(PATH).findBy(text(BUTTON)).click();

        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test");
        $(byXpath("//*[@id=\"dsdt_control_date\"]")).click();
        $(byText("5")).click();
    }


    @Test
    public void test_123() {
        Buttons.content();
        Content.content(DOC);
    }

    @Test
    public void test_124() {
        Buttons.save();
        sleep(1000);
        Buttons.requisites();
        sleep(1000);
    }
/////////////////////////////// приказ
    @Test
    public void test_125() {
        CreateDocument.createInDoc(REGULATORY_DOCUMENTS, "div.menu-list:nth-child(2) > div:nth-child(1)");
        sleep(10000);
    }
    @Test
    public void test_126() {
        // создаем приказ
        Buttons.requisites();
    }


    // заполняем обязательные поле описание
    @Test
    public void test_127() {
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test777");
    }

    // поле подписант
    @Test
    public void test_128() {
// заполняем поле подписант
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).click();
        $("div.input-select-container:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
        sleep(1000);
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс21");
        sleep(1000);
        $(byText("Начальник 1")).click();
        $$(PATH).findBy(text(BUTTON)).click();
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
        Content.content(DOC);
    }

    //
//    // сохранякм и ждем
    @Test
    public void test_131() {
        Buttons.save();
        sleep(1000);
    }

    //
//    // нажимаем на вкладку соласование и подписание
    @Test
    public void test_132() {
        $(byText("Согласование и подписание")).click();
    }
//


    // заполняем этапы  проверка оформления
    @Test
    public void test_133() {
        // добавляем
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).click();

        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс51").pressEnter();
        sleep(10000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();
    }

    //
    @Test
    public void test_134() {
        // добавдяем согласующего
        //$("button.m-l-12").click();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[4]/div[2]/div/div[1]/div[3]/button[1]")).click();
    }

    //    // заполняем согласующего
    @Test
    public void test_135() {
        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).click();
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс31").pressEnter();
        sleep(10000);
        $(byText("Департамент 3")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();

    }

    //    // нажимаем кнопку на согласование
    @Test
    public void test_136() {
        Buttons.agreement();
        sleep(10000);
    }

    //// выходим из босса11
    @Test
    public void test_137() {
        // выходим из босса11
        UserChange.exit();
    }

    @Test
    public void test_138() {
        // заходим под boss51 провверяющий оформление
        UserChange.comInBoss51();
    }

    @Test
    public void test_139() {
        //находим под boss51 наш док
        $(byText("Все задания")).click();
        sleep(1000);
    }

    @Test
    public void test_140() {
        //находим под boss51
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue("Auto-test777");
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText("Распорядительные документы"))
                .first()
                .click();
    }

    @Test
    public void test_141() {
        // скачиваем контент
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
        sleep(1000);

    }

    @Test
    public void test_142() {
// отказ
        Buttons.revert();
    }

    @Test
    public void test_143() {
        // заполняем описание
        $(byXpath("//*[@id=\"reportText\"]")).setValue("Авто-отклон");

    }

    @Test // загружаем контент
    public void test_144() {
        Content.content(DOC1);
        sleep(1000);
    }

    @Test
    public void test_145() {
        // нажимаем кнопку вернуть
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(10000);
    }

    @Test
    public void test_146() {
        // выходим из boss51
        UserChange.exit();
    }
    @Test
    public void test_147() {
        // заходим под boss11
        UserChange.comInBoss11();
    }


    @Test
    public void test_148() {
        //находим под boss11 наш док
         Buttons.allTasks();
        sleep(10000);
    }

    @Test
    public void test_149() {
        // находим нужный док
        WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_150() {
        // возвращаем все назад опять на утрвеждение проверки оформления
        Buttons.bringBack();
        sleep(10000);
    }

        @Test
    public void test_151() {
        UserChange.exit();
    }

    @Test
    public void test_152() {
        UserChange.comInBoss51();
    }

    @Test
    public void test_153() {
        Buttons.allTasks();
    }

    @Test
    public void test_154() {
        // находим наш док
      WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_155() {
        // подверждаем что все все ок
        Buttons.complete();
    }
 ////выходим из boss51
    @Test
    public void test_156() {
        UserChange.exit();
    }

    // заходим к босс31 на этап согласования
    @Test
    public void test_157() {
        UserChange.comInBoss31();
    }
//
    @Test
    public void test_158() {
        Buttons.allTasks();
    }

    @Test
    public void test_159() {
        WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_160() {
// отклоняем наш док
        Buttons.reject();
    }

    @Test
    public void test_161() {
        // описание
        $(byXpath("//*[@id=\"reportText\"]")).setValue("Отклоняем для автотеста");
    }

    @Test
    public void test_162() {
        // загружаем док
        Content.content(DOC1);
        sleep(10000);
    }

    @Test
    public void test_163() {
        // нажимаем отклонить
        $(byXpath("/html/body/div[2]/div/div[3]/span/button[1]")).click();
    }

    @Test
    public void test_164() {
        // выходим из согласующего босс31
        UserChange.exit();
    }

    @Test
    public void test_165() {
        // заходим под босс11
        UserChange.comInBoss11();
    }

    @Test
    public void test_166() {
        // все задачи
        Buttons.allTasks();
    }

    @Test
    public void test_167() {
        // находим наш док
       WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_168() {
        // Всем, кто не согласовал на текущем этапе
        Buttons.forAllWhoAreNot();
    }
    @Test
    public void test_169() {
        //выходим из босс11
        UserChange.exit();
    }
    @Test
    public void test_170() {
        //заходим к согласующему 31
        UserChange.comInBoss31();
    }

    @Test
    public void test_171() {
        Buttons.allTasks();
    }

    @Test
    public void test_172() {
    WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_173() {
        // согласовываем
        Buttons.approve();
    }

    @Test
    public void test_174() {
        // выходим из согласующего
        UserChange.exit();
    }
    @Test // идем к подписанту
    public void test_175() {
        // подписант босс21
        UserChange.comInBoss21();
    }

    @Test
    public void test_176() {
        Buttons.allTasks();
    }
    @Test
    public void test_177() {
        WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_178() {
        //отклоняем с подписания
        Buttons.reject();
    }

    @Test
    public void test_179() {
        $(byXpath("//*[@id=\"reportText\"]")).setValue("авто-отклонение тест");
    }

    @Test
    public void test_180() {
        Content.content(DOC);
        sleep(10000);
    }

    @Test
    public void test_181() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(1000);
    }

    @Test
    public void test_182() {
        // выходим из подписанта босс21
        UserChange.exit();
    }
    @Test
    public void test_183() {
        // заходим к боссу11 автору
        UserChange.comInBoss11();
    }

    @Test
    public void test_184() {
        // все задачи
        Buttons.allTasks();
    }

    @Test
    public void test_185() {
        // находим наш док
       WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_186() {
        // отправляесм еще раз на подписание
        Buttons.toSing();
    }
    @Test
    public void test_187() {
        //выходим из автора босса 11
        UserChange.exit();
    }
    @Test
    public void test_188() {
        //заходим к подписанту
        UserChange.comInBoss21();
    }


    @Test
    public void test_189() {
        // все задачи
        Buttons.allTasks();
    }

    @Test
    public void test_190() {
        // находим наш док
       WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_191() {
        // подписываем
        Buttons.sing();
    }
/*
  ///  / временный блок 191 потому что будем создавать резолючию сразу после подписания
//     @Test
//    public void test_191() {
//   // поиск нашего дока
//    $("button.layout-action-button:nth-child(1)").click();
//    $(byXpath("//*[@id=\"changing\"]")).setValue("166").pressEnter();
//    $(byText("Искать")).click();
//    sleep(1000);
//    $$(byText("Auto-test777"))
//            .first()
//            .click();
//}*/

    @Test
    public void test_192() {
        // заходим в реквизиты чтоб скопировать значение рег номера
        Buttons.requisites();
        sleep(1000);
        val = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
    }

    @Test
    public void test_193() {
        // создаем резолюцию
        Buttons.createResolution();
    }
    @Test
    public void test_194() {
        // исполнитель
        $(byXpath("//*[@id=\"performers\"]")).setValue("Босс51");
        sleep(1000);
        $(byText("Босс51 , Начальник 1, Департамент 5")).click();

    }
    @Test
    public void test_195() {
        // заполняем поле дата исполнения
        $(byXpath("//*[@id=\"Дата исполнения\"]")).click();
        $(byText("Без срока")).click();
    }

    @Test
    public void test_196() {
        // описание заполняем
        $(byXpath("//*[@id=\"dssDescription\"]")).setValue("Трям");
    }


    @Test
    public void test_197() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").click();
        sleep(10000);
    }
     @Test
    public void test_198() {
       // выходим от автора резолюции
         UserChange.exit();
    }

    @Test
    public void test_199() {
       // заходим к тому кому адресованна резолюция
         UserChange.comInBoss51();
    }

    @Test
    public void test_200() {
        // все задания
        Buttons.allTasks();
    }

    @Test
    public void test_201() {
        // находим наш док
       WorkWithDocuments.tryToFind();
    }

    @Test
    public void test_202() {
        // переходим во вкладку история
        Buttons.history();
    }

    @Test
    public void test_203() {
        // проверяем что что ест текст исполения
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div[2]")).shouldHave(text("Исполнение"));
    }

    @Test
    public void test_204() {
        // нажимаем исполнить резорлючию
        Buttons.execute();
    }
    @Test
    public void test_206() {
        // описание
        $("#reportText").setValue("The end");
    }
    @Test
    public void test_207() {
        // pfuhe;ftv rjyntyn
        $(".file-input-label").uploadFile(new File(DOC));
    }
    @Test
    public void test_208() {
        // отправляем
       $("button.empty-purple:nth-child(4)").click();
    }

    @Test
    public void test_209() {
        // выходим из того кто сделал резолюцию
        UserChange.exit();
    }


    @Test
    public void test_210() {
      // заходим туда кто ее создавал
        UserChange.comInBoss21();
    }
@Test
    public void test_211() {
      //находим наш док
    $("button.layout-action-button:nth-child(1)").click();
    $(byText("По резолюциям")).click();
    $(byText("По документам")).click();
    $(byXpath("//*[@id=\"changing\"]")).setValue(val).pressEnter();
    $("button.rounded-button:nth-child(1)").click();
    sleep(1000);
    $$(byText("Auto-test777"))
            .first()
            .click();
    }
    @Test
    public void test_212() {
        // делаем крточку
        Buttons.printCart();
    }

    @Test
    public void test_213() {
        // заввершаем
        $(byText("Печать")).click();
        sleep(1000);
    }


//
//    @Test
//    public void test_205() {
//        // описание
//        $(byXpath("//*[@id=\"reportText\"]")).setValue("The end");
//    }
//
//    @Test
//    public void test_206() {
//        // документ загружаем
//        Content.content(DOC);
//    }
//
//    @Test
//    public void test_207() {
//        // выполняем
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/button[3]")).click();
//    }
//
//    @Test
//    public void test_196() {
//        $(byXpath("/html/body/div[1]/div[3]/nav/div[4]/button[1]")).click();
//
//    }
//
//    @Test
//    public void test_197() {
//
//    }
//
//    @Test
//    public void test_198() {
//        $(byText("По документам")).click();
//    }
//
//    @Test
//    public void test_199() {
//        $(byXpath("//*[@id=\"changing\"]")).setValue(val);
//    }
//
//    @Test
//    public void test_200() {
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/button[1]")).click();
//    }
//
//    @Test
//    public void test_201() {
//        $$(byText("Auto-test777"))
//                .first()
//                .click();
//    }
//
//    @Test
//    public void test_202() {
//        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div/button[1]")).click();
//    }
//
//    @Test
//    public void test_203() {
//        Buttons.printCart();
//    }
//
//

}
