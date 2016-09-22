//package com.example.tests;

import org.junit.Test;


public class refactorTest extends mainClass {
    String password = "QW12qw12";
    String login = "szkolenieautomatyzacja";

    @Test
    public void testIde() throws Exception {
        // driver.manage().window().maximize();

        openPage();
        logInWordpress(login, password);
        open();
        addText();
        findText();

    }


}

