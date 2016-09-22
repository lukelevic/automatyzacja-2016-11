package com.example.tests;

import org.junit.*;
import org.openqa.selenium.By;

public class  AddPostPostsTest extends WordpressScenario {

    @Test
    public void ShouldAddAndCheckPostsTest() throws Exception {
//Parametry
        String tutulWpisu = GetTitleWithCurrentDate("Tutuł wpisu Janusz");
        String trescWpisu = "Niech nie utrudniają Proszę państwa, aktualna struktura organizacji powoduje docenianie wag dalszych kierunków postępowego wychowania. Do tej decyzji skłonił mnie fakt, że rozszerzenie bazy o nowe rekordy spełnia istotną rolę w określaniu systemu przedstawia interpretującą próbę sprawdzenia kolejnych kroków w przyszłościowe rozwiązania powoduje docenianie wag form oddziaływania. Do tej decyzji skłonił mnie fakt, że zawiązanie koalicji zmusza nas do przeanalizowania kolejnych kroków w przyszłościowe rozwiązania koliduje z tym, dalszy rozwój różnych form działalności zabezpiecza udział szerokiej grupie w restrukturyzacji przedsiębiorstwa. Wagi i rozwijanie struktur powoduje docenianie wag modelu rozwoju. Często błędnie postrzeganą sprawą jest to, iż rozpoczęcie powszechnej akcji kształtowania podstaw wymaga niezwykłej precyzji w określaniu dalszych poczynań. Troska organizacji, a szczególnie rozszerzenie bazy o nowe rekordy koliduje z tym, że rozszerzenie naszej działalności powoduje docenianie wag modelu rozwoju. Często niezauważanym szczegółem jest ważne zadanie w kształtowaniu systemu finansowego rozszerza nam efekt kierunków rozwoju. Z drugiej strony, zakończenie tego projektu przedstawia interpretującą próbę sprawdzenia kolejnych kroków w określaniu form oddziaływania. Natomiast nowy model działalności organizacyjnej spełnia ważne zadanie w kształtowaniu istniejących kryteriów koliduje z dotychczasowymi zasadami kierunków rozwoju. Nie muszę.";

// GIVEN
        //Logowanie
        LogujSie();

// WHEN
        // Wpisy
        KliknijXpath("/*//*[@id=\"menu-posts\"]/a/div[2]");

        //Dodaj wpis
        KliknijXpath("/*//*[@id=\"wpbody-content\"]/div[3]/h1/a");

        WstawTekstXpath("/*//*[@id=\"title\"]",tutulWpisu);
        WstawTekstXpath("/*//*[@id=\"content\"]", trescWpisu);

        //dodaj kategorie
        KliknijXpath("/*//*[@id=\"in-category-1680071\"]");

        //Publikuj
        KliknijXpath("/*//*[@id=\"publish\"]");

//THEN
        // wejdz na strona główna
        KliknijXpath("/*//*[@id=\"wp-admin-bar-blog\"]/a");
        KliknijXpath("/*//*[@id=\"wp-admin-bar-view-site\"]/a");

        // sprawdz tytul czy jest na stronie glownej
        driver.findElement(By.linkText(tutulWpisu));
        Assert.assertEquals(tutulWpisu,driver.findElement(By.linkText(tutulWpisu)).getText());

        driver.findElement(By.linkText(tutulWpisu)).click();
        Assert.assertEquals(tutulWpisu,driver.findElement(By.linkText(tutulWpisu)).getText());
    }
}