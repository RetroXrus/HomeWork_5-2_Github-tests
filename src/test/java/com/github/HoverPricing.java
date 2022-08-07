package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HoverPricing {

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        //Configuration.browserSize = "1920x1080";
        //Configuration.browserPosition = "0x0";
        Configuration.headless = true;  //скрываем браузер - обработка в памяти
    }

    @Test
    void shouldFindGithubPricingCompareplans() {
        //открыть github
        open("https://github.com");
        //навести мышь на Pricing
        $(byText("Pricing")).hover();
        //кликнуть на "Compare plans"
        $(byText("Compare plans")).click();
        //убедимся, что открылась нужная страница
        $("body").shouldHave(text("Choose the plan that’s right for you."));
        //sleep (2000);
    }

    @AfterAll
    static void finitaLaCommedia() {
        System.out.println("That's all, Folks!");
    }
}
