/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.controller;

import basicbanktransactionproject.view.WelcomeView;

/**
 *
 * @author Binh
 */
public class WelcomePageController{

    WelcomeView welcomePageView;

    private static WelcomePageController controllerInstance = null;

    private WelcomePageController() {
    }

    public static WelcomePageController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new WelcomePageController();
        }
        return controllerInstance;
    }

    public void doSelected(int selectedOption) {
        switch (selectedOption) {
            case 1:
                RegistrationController registrationController = RegistrationController.getInstance();
                registrationController.showRegistrationView();
                break;

            case 2:
                LoginController loginController = LoginController.getInstance();
                loginController.showLoginView();
                break;
            case 3:
                System.out.println("Program closed");
                break;
            default:
                System.out.println("You have choosen an invalid command. Please try again");
                welcomePageView.showInitialPage();
                break;

        }
    }

    public void initView() {
        welcomePageView = new WelcomeView();
        welcomePageView.setWelcomePageController(this);
        welcomePageView.showInitialPage();
    }

}
