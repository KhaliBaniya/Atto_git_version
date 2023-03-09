package org.example;

import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        DataBase.initTable();

        // TODO  at home
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        InitDataBase initDataBase = (InitDataBase) context.getBean("initDatabase");

        initDataBase.adminInit();
        initDataBase.addCompanyCard();

        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}
