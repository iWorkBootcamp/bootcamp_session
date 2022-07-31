package com.test.web;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class practice1 {

    @BeforeTest
    public static void setup() {
        System.out.println("setup");
    }

    @Test(priority = 2)
    public static void createEmp() {
        System.out.println("createEmp");
    }

    @Test(priority = 3)
    public static void getAllEmpRegistered() {
        System.out.println("getAllEmpRegistered");

    }

    @Test(priority = 4)
    public static void editEmpInfo() {
        System.out.println("editEmpInfo");
    }

    @AfterTest
    public static void shutdown() {
        System.out.println("shutdown");
    }

}





