package Game;

import java.util.Random;

public class Calculation extends Player {
    // this will be the where all the calculation will be made

    public static double generateRandomDouble() {
        Random random = new Random();
        return random.nextDouble();
    }
    public static int generateRandomInt(int attack) {
        Random random = new Random();
        return random.nextInt(attack);
    }

   // by using these i can make sure that the odds are more easy to manage in the beginning later on i could add
    // a luck method into it that changes the values a bit
    public static double calculateOneInTenth() {
        if( generateRandomDouble() < 0.1) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneNine() {
        if( generateRandomDouble() < 0.11) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneEight() {
        if( generateRandomDouble() < 0.12) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneSeventh() {
        if( generateRandomDouble() <0.14) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneSix() {
        if( generateRandomDouble() <0.166) {
            return 1;
        } else {return 0;}    }

    public static double calculateOneInFifth() {
        if( generateRandomDouble() < 0.2) {
            return  1;
        } else {return 0;}     }

    public static double calculateOneFourth() {
        if( generateRandomDouble() <0.25) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneInTwo() {
        if( generateRandomDouble() < 0.5) {
            return 1;
        } else {return 0;}     }

    public static int calculateOne() {
         return 1; }

    public static double calculateOneInTwenty() {
        if( generateRandomDouble() < 0.05) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneInFifty() {
        if( generateRandomDouble() < 0.02) {
            return 1;
        } else {return 0;}     }

    public static double calculateOneInHundred() {
        if( generateRandomDouble() < 0.01) {
            return 1;
        } else {return 0;}    }

    public static double calculateOneInThousand() {
        if( generateRandomDouble() < 0.001) {
            return 1;
        } else {return 0;}    }



 }

