package ru.idtm.documino;

import org.junit.Before;

import java.io.*;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class OpenBrowser {

    public static void openUtl() {
        browser = "firefox";
        String file = "адрес.txt";
        String adress;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            adress = reader.readLine();
            open(adress);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  open("http://172.25.144.151/");// стейдж


    }

    public static void openUtl2() {
        browser = "firefox";
        open("http://172.25.144.163");// прод

    }

    public static void openUtl3() {
        browser = "firefox";
        open("https://le-sedo.devel/");// дев

    }

}
