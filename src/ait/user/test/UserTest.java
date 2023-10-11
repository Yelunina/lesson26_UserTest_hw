package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    final String email = "peter@gmx.de";
    final String password = "12345Az!";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    /*
1) @ exists and only one (done)
2) dot after @ (done)
3) after last dot 2 and more symbols (done)
4) alphabetic, digits, '_', '-', '.', '@' (done)
 */
    @Test
    void testValidEmail() {
        String validEmail = "iryna@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testWithoutDoggy() {
        String invalidEmail = "iryna.gmail.com";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testSomeDoggy() {
        String invalidEmail = "iryn@a@gmail.com";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testDotAfterDoggy() {
        String invalidEmail = "iryna@gmailcom";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testAfterLastDotNoSymbols() {
        String invalidEmail = "iryna@gmail.com.";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testAfterLastDotOneSymbols() {
        String invalidEmail = "iryna@gmail.com.m";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testIncorrectSymbol() {
        String invalidEmail = "?ryna@gmail.com";
        user.setEmail(invalidEmail);
        assertEquals(email, user.getEmail());
    }

//    @Test
//    void testValidPassword(){
//        String validPassword = "qwertB7$";
//        user.setPassword(validPassword);
//        assertEquals(validPassword,user.getPassword());
//    }
//    @Test
//    void testPasswordLength(){
//        String invalidPassword = "wertB7$";
//        user.setPassword(invalidPassword);
//        assertEquals(password,user.getPassword());
//    }
//    @Test
//    void testPasswordUpperCase(){
//        String invalidPassword = "qwertb7$";
//        user.setPassword(invalidPassword);
//        assertEquals(password,user.getPassword());
//    }
//    @Test
//    void testPasswordLowerCase(){
//        String invalidPassword = "QWERTY7$";
//        user.setPassword(invalidPassword);
//        assertEquals(password,user.getPassword());
//    }
//    @Test
//    void testPasswordDigit(){
//        String invalidPassword = "qwertBD$";
//        user.setPassword(invalidPassword);
//        assertEquals(password,user.getPassword());
//    }
//    @Test
//    void testPasswordSpecialSymbol(){
//        String invalidPassword = "qwertdfA3";
//        user.setPassword(invalidPassword);
//        assertEquals(password,user.getPassword());
//    }
}