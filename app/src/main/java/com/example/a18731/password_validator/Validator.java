package com.example.a18731.password_validator;

/**
 * Created by 18731 on 2018/2/9.
 */

public class Validator {
    public int Password(String pass) {
        String lowC = pass.toLowerCase();
        if (pass.equals("password")){
            return 1;
        }
        else if (pass.length() < 8){
            return 2;
        }
        else if (!pass.matches("[a-zA-Z0-9]+")){
            return 3;
        }
        else if (pass.equals(lowC)) {
            return 4;
        }
        else if (pass.length() < 10) {
            return 5;
        }
        else{
            return 6;
        }
    }
}
