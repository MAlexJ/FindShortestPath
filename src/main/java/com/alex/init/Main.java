package com.alex.init;


import com.alex.controller.MainController;
import com.alex.exception.AppException;

public class Main {

    public static void main(String[] args) {
        MainController controller = new MainController();
        try {
            controller.init();
        }catch (AppException e){
            System.out.println(e.getMessage());
        }

    }
}
