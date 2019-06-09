/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicbanktransactionproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Binh
 */
public class UserRepository {
    private static List<User> listOfUsers = new ArrayList<>();

    public List<User> getListOfUsers() {
        return listOfUsers;
    }
    

}
