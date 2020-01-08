package Game;

import java.util.Random;

public class Calculation extends Player {
    // this will be the where all the calculation will be made


    public static double generateRandomInt() {
        Random random = new Random();
        double genResult = random.nextDouble();
        return genResult;
    }

   /* public static double calculateKilling(double chanceNumber, double standardValue, double generatedNumber) {
        double preResult = generatedNumber / standardValue;
        // System.out.println("generated: " + generatedNumber + " " + standardValue + " " + chanceNumber); test part
        int result;
        if (preResult < chanceNumber) { // the positive result for the player
            //System.out.println(result); test part
            System.out.println("the opponent died"); //test part
            return result = 1;
        } else {
            result = 0; // the negativ result for the player
            //System.out.println(result); test part
            System.out.println("the opponent lived"); //test part
            return result;
        }
    } */

   /* public static double calculateInjuring(double chanceNumber, double standardValue, double generatedNumber) {
        double preResult = generatedNumber / standardValue;
        System.out.println("generated: " + generatedNumber + " " + standardValue + " " + chanceNumber);
        int result;
        if (preResult < chanceNumber) { // the positive result for the player
            result = 1;
            System.out.println(result);
            System.out.println("the opponent was injured");
            return result;
        } else {
            result = 0; //the negativ result for the player
            System.out.println(result);
            System.out.println("the action failed");
            return result;      }
    } */

  /*public static double calculateSubduing(double chanceNumber, double standardValue, double generatedNumber) {
        double preResult = generatedNumber / standardValue;
        System.out.println("generated: " + generatedNumber +" " +standardValue +" " + chanceNumber);
        int result;
        if (preResult < chanceNumber) {
            result =1;
            System.out.println(result);
            System.out.println("The opponent was subdued");
            return result;
        } else  {result=0;
            System.out.println(result);
            System.out.println("The action failed");
        return result;}
    } */

   /* public static double calculateWinningOver(double chanceNumber, double standardValue, double generatedNumber) {
        double preSult = generatedNumber / standardValue;
        System.out.println("generated: " + generatedNumber +" "+ standardValue+" "+ chanceNumber);
        int result;
        if (preSult < chanceNumber) {
            result = 1;
            System.out.println(result);
            System.out.println("The opponent was won over");
            return result;
        } else {result = 0;
            System.out.println(result);
            System.out.println("The action failed");
        return result;}
    } */

    public static double calculateOneInTenth() {
        int result=0;
        if( generateRandomInt() < 0.1) {
            return result =1;
        } else return 0;    }

    public static double calculateOneNine() {
        int result=0;
        if( generateRandomInt() < 0.11) {
            return result =1;
        } else return 0;    }

    public static double calculateOneEight() {
        int result=0;
        if( generateRandomInt() < 0.12) {
            return result =1;
        } else return 0;    }

    public static double calculateOneSeveth() {
        int result=0;
        if( generateRandomInt() <0.14) {
            return result =1;
        } else return 0;    }

    public static double calculateOneSix() {
        int result=0;
        if( generateRandomInt() <0.166) {
            return result =1;
        } else return 0;    }

    public static double calculateOneInFifth() {
        int result=0;
        if( generateRandomInt() < 0.2) {
            return result =1;
        } else return 0;    }

    public static double calculateOneFourth() {
        int result=0;
        if( generateRandomInt() <0.25) {
            return result =1;
        } else return 0;    }

    public static double calculateOneInTwo() {
        int result=0;
        if( generateRandomInt() < 0.5) {
            return result =1;
        } else return 0;    }

    public static double calculateOne() {
        return 1; }




    public static void whichCalc() {
        Game g = new Game();
    /* if (action.equals(kill)) {
                    double Result = Calculation.calculateKilling(kvothe.getChanceOfKilling(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    //killingResult returns 1 or 0 of result in Calculation.  so 1= opponent died, 0= opponents survived about 1/5 within 1000 tries dies
                }
                if (action.equals(wound)) {
                    double Result = Calculation.calculateInjuring(kvothe.getChanceOfInjuring(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // injured 2/5 in a 1000 tries 380-420 occurrence's
                }
                if (action.equals(subdue)) {
                    double Result = Calculation.calculateSubduing(kvothe.getChanceOfSubduing(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // subdued 225-267 out of 1000 => 1/4
                }
                if (action.equals(winOver)) {
                    double Result = Calculation.calculateWinningOver(kvothe.getChanceOfWinningOver(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // 15-22 in 1000   0.02 => very rare
                }
                if (action.equals(talk)) {
                    double Result= Calculation.calculateOneInTenth();
                } */
    }

}

