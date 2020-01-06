package Game;

import java.util.Random;

public class Calculation extends Player {
    // this will be the where all the calculation will be made


    public static double generateRandomInt() {
        Random random = new Random();
        double genResult = random.nextDouble();
        return genResult;
    }

    public static double calculateKilling(double chanceNumber, double standardValue, double generatedNumber) {
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


    }

    public static double calculateInjuring(double chanceNumber, double standardValue, double generatedNumber) {
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
    }

    public static double calculateSubduing(double chanceNumber, double standardValue, double generatedNumber) {
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
    }

    public static double calculateWinningOver(double chanceNumber, double standardValue, double generatedNumber) {
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
    }

}

