package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragDropCheck {
    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        //Configuration.headless = true;  //скрываем браузер - обработка в памяти
    }

    @Test
    void dragSquareToAnotherAndCheckBoth() {
        // Открыть сайт
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //sleep (2000);
        //Перетащить один квадрат на место другого
        $("#column-a").dragAndDropTo("#column-b");
        //sleep (2000);
        //Проверить, что квадраты поменялись местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        //sleep (2000);
    }

    @AfterAll
    static void fin() {
        System.out.println("That's all, Folks!");
    }
}
