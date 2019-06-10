/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.view;

import basicbanktransactionproject.controller.WelcomePageController;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Binh
 */
public class WelcomeView implements IView{
    
    WelcomePageController welcomePageController;
    
    public void setWelcomePageController (WelcomePageController controller){
        this.welcomePageController =  controller;
    }
            


    @Override
    public void showPage() {
        
        System.out.println("------------");
        System.out.println("Welcome to our NetBank");
        System.out.println("Please register or log in to use our services");
        System.out.println("1. Register");
        System.out.println("2. Log in");
        System.out.println("3. Exit");
        System.out.println("------------");
        System.out.println("Please choose a option: ");

        try {
            Scanner sc = new Scanner(System.in);
            int selected = sc.nextInt();
            this.welcomePageController.doSelected(selected);
           

        } catch (InputMismatchException e) {
            showErrorMessage("Invalid Input. Please try again");
            showPage();
        }
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("------------");
        System.out.println(message);
        System.out.println("------------");
    }
    
    


    
}
