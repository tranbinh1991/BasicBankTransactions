/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model.controller;

import basicbanktransactionproject.model.User;
import basicbanktransactionproject.model.UserRepository;
import basicbanktransactionproject.view.LoginView;

/**
 *
 * @author Binh
 */
public class LoginController {

    private static LoginController controllerInstance = null;
    private UserRepository users = new UserRepository();
    private LoginView view;

    private LoginController() {
    }

    public void showLoginView() {
        view = new LoginView();
        view.setLoginController(this);
        view.showPage();

    }

    public static LoginController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new LoginController();
        }
        return controllerInstance;
    }

    public BankAccountController authenticateUser(String name, String password) {
        boolean successfulAuthentication = false;

        for (User user : users.getListOfUsers()) {

            if (user.getName().equals(name)) {

                if (user.getPassword().equals(password)) {
                    System.out.println("------------");
                    System.out.println("Successful login");
                    System.out.println("------------");
                    successfulAuthentication = true;
                    return new BankAccountController(user);
                }
            }
        }

        if (successfulAuthentication == false) {
            System.out.println("------------");
            System.out.println("Incorrect username or password");
            System.out.println("------------");
            WelcomePageController welcomePageController = WelcomePageController.getInstance();
            welcomePageController.initView();
        }

        return null;

    }
}
