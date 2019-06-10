/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.view;

import basicbanktransactionproject.controller.LoginController;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Binh
 */
public class LoginView implements IView{
    
    LoginController loginController;
    
    public void setLoginController(LoginController controller){
        this.loginController= controller;
        
    }

    @Override
    public void showInitialPage() {
        
        System.out.println("------------");
        System.out.println("Login Page");
        System.out.println("------------");

        try {
            System.out.println("Please input your name");
            Scanner sc = new Scanner(System.in);
            String userName = sc.nextLine();
            System.out.println("Please input your password");
            String password = sc.nextLine();
            loginController.authenticateUser(userName, password);
        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showInitialPage();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("------------");
        System.out.println(message);
        System.out.println("------------");
    }
    
    


    
}
