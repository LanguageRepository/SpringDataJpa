package com.example;

import java.util.Random;

public class App {

    public static void main(String[] args) {

        System.out.println(new App().getRandomPassword());
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char chars[] = symbols.toCharArray();
        System.out.println(chars[(int)(Math.random()*36)]);

    }

    private String getRandomPassword() {
        String password = "";
        String symbols = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char chars[] = symbols.toCharArray();
        int index;
        for(index = 8; index >=0; --index) {
            int s = (int)(Math.random()*(symbols.length()-1));
            password = password.concat(Character.toString(chars[s]));
        }
        return password;
    }

}
