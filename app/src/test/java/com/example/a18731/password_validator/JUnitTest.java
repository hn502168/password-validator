package com.example.a18731.password_validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by 18731 on 2018/2/9.
 */

public class JUnitTest {
    @Test
    public void passwordTest() {
        Validator V = new Validator();
        String pass = "password";
        assertEquals(1, V.Password(pass));
    }
    @Test
    public void lengthTest(){
        Validator V = new Validator();
        String pass = "123456";
        assertEquals(2, V.Password(pass));
    }
    @Test
    public void StrongTest(){
        Validator V = new Validator();
        String pass = "12345abcdeF";
        assertEquals(6, V.Password(pass));
    }
}
