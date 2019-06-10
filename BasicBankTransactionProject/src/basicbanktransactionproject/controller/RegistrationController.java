/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.controller;

import basicbanktransactionproject.model.User;
import basicbanktransactionproject.model.repository.UserRepository;
import basicbanktransactionproject.view.IView;
import basicbanktransactionproject.view.RegistrationView;

/**
 *
 * @author Binh
 */
public class RegistrationController {

    RegistrationView view;
    private UserRepository users = new UserRepository();

    private static RegistrationController controllerInstance = null;

    private RegistrationController() {
    }

    public static RegistrationController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new RegistrationController();
        }
        return controllerInstance;
    }

    public void showRegistrationView() {
        view = new RegistrationView();
        view.setRegistrationController(this);
        view.showPage();

    }

    public void registerNewUser(String name, String password) {
        boolean usernameAlreadyExists = false;
        
        for (User user : users.getListOfUsers()) {
            if (user.getName().equals(name)){
                usernameAlreadyExists = true;
            }
        }
        if (usernameAlreadyExists==true) {
            System.out.println("This username is already taken");
            view.showPage();
        } else {
            User user = new User(name, password);
            users.getListOfUsers().add(user);
            System.out.println("------------");
            System.out.println("Successful registration");
            System.out.println("------------");
            WelcomePageController welcomePageController = WelcomePageController.getInstance();
            welcomePageController.initView();
        }
    }

}
