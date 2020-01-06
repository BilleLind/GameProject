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

            int tally=0;
        for (int i =0; i<1000; i++) {
            double injuriedResult = Calculation.calculateInjuring(kvothe.getChanceOfInjuring(), kvothe.getNumberForChances(),Calculation.generateRandomInt());

            if (injuriedResult==1.0) {
                tally++;
                System.out.println(tally);
            }

        }



    }




}
