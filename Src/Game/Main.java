package Game;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello this is my first real game project!");

        Player kvothe = new Player();
        kvothe.setHealth(20);

        kvothe.setNumberForChances(2);
        kvothe.setChanceOfKilling(0.1);
        kvothe.setChanceOfInjuring(0.2);
        kvothe.setChanceOfSubduing(0.12);
        kvothe.setChanceOfWinningOver(0.01);
       double killingResult=Calculation.calculateKilling(kvothe.getChanceOfKilling(), kvothe.getNumberForChances(),  Calculation.generateRandomInt());
        //killingResult returns 1 or 0 of result in Calculation.  so 1= opponent died, 0= opponents survived about 1/5 within 1000 tries dies

        double injuriedResult = Calculation.calculateInjuring(kvothe.getChanceOfInjuring(), kvothe.getNumberForChances(),Calculation.generateRandomInt());
        // injured 2/5 in a 1000 tries 380-420 occurrence's

        double subduedResult = Calculation.calculateSubduing(kvothe.getChanceOfSubduing(), kvothe.getNumberForChances(),Calculation.generateRandomInt());
        // subdued 225-267 out of 1000 => 1/4

        double winningOverResult = Calculation.calculateWinningOver(kvothe.getChanceOfWinningOver(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
        // 15-22 in 1000   0.02 => very rare




    }




}
