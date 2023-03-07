package org.example;

import org.example.controller.AuthController;
import org.example.db.DB;
import org.example.db.InitDB;

public class Main {
    public static void main(String[] args) {
        DB.initTable();

        InitDB.adminInit();
        InitDB.addCompanyCard();

        AuthController authController = new AuthController();
        authController.start();

    }
}