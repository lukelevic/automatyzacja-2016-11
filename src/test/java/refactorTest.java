//package com.example.tests;

import org.junit.Test;


public class refactorTest extends mainClass{

    @Test
    public void testIde() throws Exception {
        // driver.manage().window().maximize();

        openPage();
        logInWordpress();
        open();
        addText();
        findText();

    }


    }

