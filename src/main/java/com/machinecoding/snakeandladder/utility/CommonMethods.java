package com.machinecoding.snakeandladder.utility;

import java.util.Random;

public class CommonMethods {
    private static Integer userId = 1;
    private static final Random random = new Random();

    private CommonMethods(){}

    public static synchronized Integer getUserId(){
        return userId++;
    }

    public static int rollDice(){
        return random.nextInt(1,7);
    }
}
