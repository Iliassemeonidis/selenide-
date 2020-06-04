package ru.idtm.documino;


import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SedoTest {
    private final Logger log = Logger.getLogger(SedoTest.class.getName());
    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private final String CONTENT = "Контент";
    private final String INPUTDOCUMENT = "ВХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String OUTPUTDOCUMENT = "ИСХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String INTERNAL_DOCUMENTS = "ВНУТРЕННИЕ ДОКУМЕНТЫ";
    private final String ERRAND = "ИНИЦИАТИВНОЕ ПОРУЧЕНИЕ";
    private final String MEMORANDUM_TEST = "C3(тест)";
    private final String BOSS = "Босс11";
    private final String DOC = "test.txt";
    private final String DOC1 = "ответ.txt";
    private final String REGULATORY_DOCUMENTS = "РАСПОРЯДИТЕЛЬНЫЕ ДОКУМЕНТЫ";
    private final String ORDER_DOCUMENTS = "Приказ (пустой шаблон)";
    private static String registrationNumber;
    private static String identifier;
    private static String temporaryNumber;
    private static String description;
    private static String singer;
    private static String organization;
    private static String department;


    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void tess_90() {
        OpenBrowser.openUtl();
       // sleep(10000);
        UserChange.comInBoss11();
    }

//    @Test
//    public void test_92() {
//        // проверяем наличие  Мои задания;
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Мои задания"));
//    }
//
//    @Test
//    public void test_93() {
//        // проверяем наличие Задания Босс31
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Задания Босс31"));
//    }
//
//    @Test
//    public void test_94() {
//        // проверяем наличие Все документы;
//        $(".sidebar-nav-list > div:nth-child(1)").shouldHave(text("Все документы"));
//    }
//
//    @Test
//    public void test_95() {
//        // проверяем наличие Недавние документы
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Недавние документы"));
//    }
//
//    @Test
//    public void test_96() {
//        // проверяем наличие Резолюции мне
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Резолюции мне"));
//    }
//
//    @Test
//    public void test_97() {
//        // проверяем наличие Резолюции от меня
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Резолюции от меня"));
//    }
//
//    @Test
//    public void test_98() {
//        // проверяем наличие Я контролер
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Я контролер"));
//    }
//
//    @Test
//    public void test_99() {
//        // проверяем наличие Созданные мной
//        $("div.ps--active-y:nth-child(1)").shouldHave(text("Созданные мной"));
//    }
//

    //////////////////////////// приказ
    @Test
    public void test_125() {
        CreateDocument.createInDoc(REGULATORY_DOCUMENTS, "div.menu-list:nth-child(2) > div:nth-child(1)");
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
    }


    // заполняем этапы  проверка оформления
    @Test
    public void test_138() {
        // добавляем
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).click();

        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс51").pressEnter();
        sleep(1000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();
    }

    @Test
    public void test_139() {
        // добавдяем согласующего
        //$("button.m-l-12").click();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[4]/div[2]/div/div[1]/div[3]/button[1]")).click();
    }

    //
//    //    // заполняем согласующего
    @Test
    public void test_140() {
        // согласующий
        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).click();
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс31").pressEnter();
        sleep(1000);
        $(byText("Департамент 3")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();

    }

    @Test
    public void test_141() {
        // еще один согласуюющий
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[4]/div[2]/div/div[1]/div[3]/button[1]")).click();
        $(".layout-icon").click();
        $("#branchId").click();
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс32").pressEnter();
        sleep(1000);
        $(byText("Департамент 3")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();

    }


    // нажимаем кнопку на согласование
    @Test
    public void test_143() {
        Buttons.agreement();
        sleep(10000);
    }

    //// выходим из босса11
    @Test
    public void test_144() {
        // выходим из босса11
        UserChange.exit();
    }

    @Test
    public void test_145() {
        // заходим под boss51 провверяющий оформление
        UserChange.comInBoss51();
    }

    @Test
    public void test_146() {
        //находим под boss51 наш док
        $(byText("Все задания")).click();
        sleep(1000);
    }

    @Test
    public void test_147() {
        //находим под boss51 по описанию
        WorkWithDocuments.tryToFindDocWithDescription(description);
        System.out.println(description);

    }

    //
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
        $("input").uploadFile(new File(DOC1));
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
        // выходим из boss51
        UserChange.exit();
    }

    @Test
    public void test_154() {
        // заходим под boss11
        UserChange.comInBoss11();
    }


    @Test
    public void test_155() {
        //находим под boss11 наш док
        Buttons.allTasks();
        sleep(100);
    }

    //
    @Test
    public void test_156() {
        // находим нужный док
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
        //выходитм из босса11
        UserChange.exit();
    }

    @Test
    public void test_159() {
        // заходим под боссом 51
        UserChange.comInBoss51();
    }

    @Test
    public void test_160() {
        Buttons.allTasks();
    }

    @Test
    public void test_161() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
    }

    @Test
    public void test_162() {
        // подверждаем что все все ок
        Buttons.complete();
    }

    ////выходим из boss51
    @Test
    public void test_163() {
        UserChange.exit();
    }

    // заходим к босс31 на этап согласования
    @Test
    public void test_164() {
        UserChange.comInBoss31();
    }

    @Test
    public void test_165() {
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
        Content.content(DOC1);
        sleep(10000);
    }

    @Test
    public void test_170() {
        // нажимаем отклонить
        $(byXpath("/html/body/div[2]/div/div[3]/span/button[1]")).click();
    }

    @Test
    public void test_171() {
        // выходим из согласующего босс31
        UserChange.exit();
    }

    @Test
    public void test_172() {
        // заходим под босс11
        UserChange.comInBoss11();
    }

    @Test
    public void test_173() {
        // все задачи
        Buttons.allTasks();
    }

    @Test
    public void test_174() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_175() {
        // Всем, кто не согласовал на текущем этапе
        Buttons.forAllWhoAreNot();
    }

    @Test
    public void test_176() {
        //выходим из босс11
        UserChange.exit();
    }

    @Test
    public void test_177() {
        //заходим к согласующему 31
        UserChange.comInBoss31();
    }

    @Test
    public void test_178() {
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
        UserChange.comInClerk2();
    }


    @Test
    public void test_185() {

//        ///часть для клерка3
//        $(byText("Задания Босс32")).shouldBe(visible);
//        $(byText("Задания Босс32")).click();
//


        // все задания
        $("li.list-item-container:nth-child(4)").click();
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[1]/nav/ul/div/li[4]/ul/li[1]/button")).click();
        sleep(1000);
//        Buttons.allTasks();
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

    // идем к подписанту боссу21
    @Test
    public void test_189() {
        // подписант босс21
        UserChange.comInBoss21();
    }

    @Test
    public void test_190() {
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
        Content.content(DOC);
        sleep(10000);
    }

    @Test
    public void test_195() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(1000);
    }

    @Test
    public void test_196() {
        // выходим из подписанта босс21
        UserChange.exit();
    }

    @Test
    public void test_197() {
        // заходим к боссу11 автору
        UserChange.comInBoss11();
    }

    //
    @Test
    public void test_198() {
        // все задачи
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
        //выходим из автора босса 11
        UserChange.exit();
    }

    @Test
    public void test_202() {
        //заходим к подписанту
        UserChange.comInBoss21();
    }


    @Test
    public void test_203() {
        // все задачи
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
        $(byXpath("//*[@id=\"performers\"]")).setValue("Босс51");
        sleep(1000);
        $(byText("Босс51 , Начальник 1, Департамент 5")).click();

    }

    @Test
    public void test_209() {
        // заполняем поле дата исполнения
        $(byXpath("//*[@id=\"Дата исполнения\"]")).click();
        $(byText("Без срока")).click();
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
        // заходим к тому кому адресованна резолюция
        UserChange.comInBoss51();
    }

    @Test
    public void test_214() {
        // все задания
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
        Content.content(DOC1);
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
        // заходим туда кто ее создавал
        UserChange.comInBoss21();
    }

    @Test
    public void test_224() {
        //находим наш доок
        $("button.el-tooltip:nth-child(1)").click();
        $(byText("По резолюциям")).click();
        $(byText("По документам")).click();

    }
    @Test
 public void test_225() {

        $(byXpath("//*[@id=\"changing\"]")).setValue(registrationNumber);

        sleep(1000);


    }
    @Test
 public void test_226() {
        $(byText("Искать")).click();
        sleep(10000);
        $$(byText(description))
                .first()
                .click();

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
////////////////////////////// чать 2 Исх, Вх, Внутр, ИП
    @Test
    public void test_229() {
        UserChange.exit();
    }
    @Test
    public void test_230() {
        UserChange.comInBoss11();
    }

    @Test
    public void test_231() {
        // исходящий документ
        CreateDocument.create(OUTPUTDOCUMENT);
    }

    @Test
    public void test_232() {
        // добавляем контент
        Content.content(DOC);
        Buttons.requisites();
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
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс11");
        $(byText("Главный специалист")).click();
        //путь к кнопке выбрать подписанта
        $$(PATH).findBy(text(BUTTON)).click();
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
        // работает при увеличении экрана
//        $(byXpath("//*[@id=\"dsid_agent_person\"]")).setValue("Иванов");
//        $(byText("Иванова123 И. И.,-")).click();
        // пробую
        $("#dsid_agent_person").setValue("Босс51");
        $(byText("Босс51,Сотрудники ОАО \"ЛЕНЭНЕРГО\",Начальник 1")).click();

    }

    @Test
    public void test_238() {
        // сохраняем
        Buttons.save();
        sleep(1000);

    }

    @Test
    public void test_239() {
        // проверяем что заполнились Регистрационный номер, Временный номер
        Buttons.content();
        Buttons.requisites();
        sleep(1000);
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
        Objects.requireNonNull(registrationNumber, "Поле решитсрационный номер пустое");
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
        //ажимаем добавить проверяющего
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[4]/div[2]/div/div[1]/div[3]/button[1]")).click();
    }
    @Test
    public void test_243() {
        //ажимаем добавить проверяющего
        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс51").pressEnter();
        sleep(1000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText("Добавить")).click();
    }

    @Test
    public void test_244() {
        // на согласование
        Buttons.agreement();
        sleep(10000);
    }
   @Test
    public void test_245() {
        // меняем пользака
        UserChange.exit();
    }
    @Test
    public void test_246() {
        // заходим под проверяющим
        UserChange.comInBoss51();
    }
    @Test
    public void test_247() {
       /// поиск по организации
        //находим наш доок
        $("button.el-tooltip:nth-child(1)").click();
        $(byText("По резолюциям")).click();
        $(byText("По документам")).click();
        $("#types").click();
        $(byText("Исходящие документы")).click();
        $("#drid_addressee_empl_branch").setValue("ПЭС");
        sleep(1000);
        $(byText("АО \"ПЭС\"")).click();
        $(byText("Искать")).click();
        sleep(1000);
//        $$(byText("ОАО \"ЛЕНЭНЕРГО\""))
//                .first()
//                .click();
    UserChange.exit();
    UserChange.comInBoss11();
    }



   ///////////////// //////// Входящий документ

    @Test
    public void test_248() {
        CreateDocument.create(INPUTDOCUMENT);
    }

    @Test
    public void test_249() {
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
    public void test_250() {
        //Жмем кнопку далее
        $(byText("Далее")).click();
        sleep(10000);
    }


    @Test
    public void test_251() {
        // заполняем обязательные поля
        Buttons.requisites();
        RequiredFields.addressee("Босс11");
        RequiredFields.description("Auto-test");
    }

    @Test
    public void test_252() {
        // контент загружаем
        $(byText(CONTENT)).click();
        Content.content(DOC);
        sleep(1000);

    }

    @Test
    public void test_253() {
        //Жмем кнопку зарегистрировать
        Buttons.save();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_254() {
        //Жмем кнопку зарегистрировать
//        Buttons.register();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        //$(byText("Зарегистрировать")).click();
        sleep(10000);
    }

    @Test
    public void test_255() {
        // На Рассмотрение
        //Buttons.review(); переписать кнопку
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[2]/button")).click();
        sleep(10000);
    }


    @Test
    public void test_256() {
        Buttons.requisites();
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В канцелярии"));
    }

    @Test
    public void test_257() {
        // задание
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Предварительное рассмотрение"));
    }

    @Test
    public void test_258() {
        // На резолюцию
        test_248();
        test_249();
        test_250();
        test_251();
        test_252();
        test_253();
        test_254();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(1000);
    }


    @Test
    public void test_259() {
        // проверка статус доркумента
        $$("div.form-item-container:nth-child(2) > div:nth-child(1) > div:nth-child(2)").findBy(text("В подразделении"));
    }

    @Test
    public void test_260() {
        // задание
        Buttons.history();
        $(".table-scroll-bar").shouldHave(text("Рассмотрение"));
    }

     //служебная записка
    @Test
    public void test_261() {
        $(byText("Создать документ")).click();
        $(byText(INTERNAL_DOCUMENTS)).click();
        $(byText(MEMORANDUM_TEST)).click();
        $(byText("Создать")).click();
        Buttons.requisites();
    }

    @Test
    public void test_262() {
        //
        $$(byXpath("//*[@id=\"dsid_stamp\"]"))
                .first()
                .click();
        $(byText("Общего пользования")).click();

    }

    @Test
    public void test_263() {
        // описание
        RequiredFields.description("Служебка");
    }

    @Test
    public void test_264() {
        // адресат
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[10]/div/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
        //$(byXpath("//*[@id=\"query\"]")).setValue(BOSS);
        $(byText("Главный специалист")).click();
        sleep(1000);
        $$(PATH).findBy(text(BUTTON)).click();
        $(byText(CONTENT)).click();
        Content.content(DOC);
        sleep(1000);
        Buttons.save();
    }



    @Test
    public void test_265() {
        // подписант
        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue("Босс11");
        sleep(1000);
        $(byText("Босс11 , Главный специалист, АО \"ПЭС\"")).click();
    }




    @Test
    public void test_266() {
        Buttons.save();
        sleep(1000);
        Buttons.content();
        sleep(1000);
    }

    @Test
    public void test_267() {
        // на согласование
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(10000);
    }

    @Test
    public void test_268() {
        // нахолдим нашу служебку
        Buttons.allTasks();
       WorkWithDocuments.tryToFindDoc("Служебка");
        $$(byText("Внутренние документы"))
                .first()
                .click();
    }



    // Создание Исполнительного поручения

    @Test
    public void test_269() {
        CreateDocument.create(ERRAND);
        Buttons.requisites();
    }

    @Test
    public void test_270() {
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
    public void test_271() {
        Buttons.content();
        Content.content(DOC);
    }

    @Test
    public void test_272() {
        Buttons.save();
        sleep(1000);
        Buttons.requisites();
        sleep(1000);
    }
    @Test
    public void test_273() {
        CreateDocument.create("ДОВЕРЕННОСТЬ");
    }
 @Test
    public void test_274() {
       Content.content(DOC);
    }
    @Test
    public void test_275() {
       Buttons.requisites();
    }
    @Test
    public void test_276() {
        // содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test888");
    }
    @Test
    public void test_277() {
        // содержание
        Buttons.save();
    }
    @Test
    public void test_278() {
        // создаем кому
       $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
    }
   @Test
    public void test_279() {
        // кому
       $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        $(byText("Тестовый Филиал")).click();
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс51").pressEnter();
        sleep(1000);
        $(byText("Департамент 5")).click();
        $$(PATH).findBy(text(BUTTON)).click();
        sleep(1000);
    }
   @Test
    public void test_280() {
        // инициатор
       $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
//       $("#branchId").setValue("Тестовый Филиал");
       $(byText("Главный специалист")).click();
//       sleep(1000);
//       $(byXpath("//*[@id=\"query\"]")).setValue("Босс51").pressEnter();
//       sleep(1000);
//       $(byText("Департамент 5")).click();
       $$(PATH).findBy(text(BUTTON)).click();
       sleep(1000);

    }
  @Test
    public void test_281() {
        // подписант
//      $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[20]/div/div/div/div[1]/div/div/div/div/div[1]/button")).click();
$("#dsid_signer_empl").setValue("Рю");
$(byText("Рюмин Андрей Валерьевич, ГД ПАО \"Ленэнерго\" - управляющей организации АО \"ПЭС\", АО \"ПЭС\"")).click();

    }


    @Test
    public void test_282() {
        // содержание
        Buttons.save();
    }
  @Test
    public void test_283() {
        // содержание
        Buttons.agreement();
    }

    @Test
    public void test_284() {
        // содержание
       Buttons.allTasks();
       sleep(10000);
    }
    @Test
    public void test_285() {
        // содержание
      WorkWithDocuments.tryToFindDoc("Auto-test888");
    }



}
