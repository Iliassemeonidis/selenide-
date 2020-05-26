package ru.testing;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class User {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);
    @Test
    public void userConect() throws Exception {

        String url = "http://185.187.112.55/";
        browser = "firefox";
        open(url);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();

    }
}
