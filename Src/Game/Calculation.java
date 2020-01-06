package Game;

import java.util.Random;

public class Calculation {
    // this will be the where all the calculation will be made
    Random random = new Random();


    public static int generateRandomInt (int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

}
