/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.view;

import basicbanktransactionproject.model.controller.RegistrationController;
import basicbanktransactionproject.model.controller.WelcomePageController;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Binh
 */
public class RegistrationView implements IView{
    
    RegistrationController registrationController;
    
    public void setRegistrationController(RegistrationController controller){
        this.registrationController= controller;
        
    }
            


    @Override
    public void showPage() {
        
        System.out.println("------------");
        System.out.println("Registration");
        System.out.println("Please input your name first press enter then your password");
        System.out.println("------------");

        try {
            Scanner sc = new Scanner(System.in);
            String userName = sc.nextLine();
            String password = sc.nextLine();
            this.registrationController.registerNewUser(userName, password);

            
           

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