package Game;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello this is my first real game project!");



      Game g = new Game();
      //maybe make the set method in main, or make it like
        // Creature creature, Creature creature2, Creature player ?? could work. then it should only need
        // to be set up and initialized like Humans??
      g.player.setHealth(20);
      g.player.setAttack(5);
      g.player.setName("Kvothe");
      g.player.setCoins(2);
      g.player.setWeapon(0);
      g.player.setBornWithTalent(3);
      g.player.setEquipment(0);
      g.player.setDefence(1);

      if (g.player.isAlive()) {
          System.out.println("Whaat");
      } else if (!g.player.isAlive()) {
          System.out.println("EHH?");
      }else System.out.println("THE FUCK");
      g.gameRunning();






        /*int tally=0;
        for (int i =0; i<1000; i++) {

            double result = Calculation.calculateOneInTenth();
            System.out.println(result);
            if (result ==01) {
                tally++;
                System.out.println(tally);
            }

        } */
/*
int dmg0 = 0;
int dmg1 = 0;
int dmg2 = 0;
int dmg3 = 0;
        for (int i = 0; i <100; i++) {
            int damagedealt=Calculation.generateRandomInt(3);
            System.out.println(damagedealt);
            if (damagedealt==0) {
                dmg0++;
            }else if (damagedealt==1) {
                dmg1++;
            }else if (damagedealt==2) {
                dmg2++;
            }else if (damagedealt==3) {
                dmg3++;
            }
            System.out.println("dmg0:" + dmg0);
            System.out.println("dmg1:" + dmg1);
            System.out.println("dmg2:" + dmg2);
            System.out.println("dmg3:" + dmg3);
         } */





    }




}
