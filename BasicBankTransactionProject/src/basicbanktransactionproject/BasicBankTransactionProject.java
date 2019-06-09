/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject;

import basicbanktransactionproject.model.User;
import basicbanktransactionproject.model.UserRepository;
import basicbanktransactionproject.model.controller.WelcomePageController;
import basicbanktransactionproject.view.WelcomeView;

/**
 *
 * @author Binh
 */
public class BasicBankTransactionProject {


    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        
        User user = new User("Binh", "password");
        User user2 = new User("Borisz", "password");
        User user3 = new User("a", "a");
        repository.getListOfUsers().add(user);
        repository.getListOfUsers().add(user2);
        repository.getListOfUsers().add(user3);
        
        WelcomePageController welcomePageController = WelcomePageController.getInstance();
        welcomePageController.initView();
    }
    
}
