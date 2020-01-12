package Game;

import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    String attack = "attack", wound = "wound", subdue = "subdue", winOver = "winOver", flee = "flee", talk = "talk", cheat = "cheat";
    Humans h = new Humans();
    Player player = new Player();
    boolean firstCombatWon =false, firstCombatFleet=false, firstCombatSubdued=false; // will be used for a victory sheet of sort
    int playerDamageDealt, adversariesDamageDealt;
    int attackChoice;

    public void gameRunning() {


        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (only 1)");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
            //can customize to your desire


            player.setName("Kvothe");
            player.setHealth(20);
            player.setBornWithTalent(3);
            player.setWeapon(0);
            player.setEquipment(0);
            player.setAttack(3);
            player.setDefence(2);
            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + player.getName());  // to be displayed at the top of the program
            System.out.println("Your character have: " + player.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else if (yourChoice==2) {
            player.setName("Reshi");
            player.setHealth(18);
            player.setDefence(4);
            player.setAttack(4);
            player.setEquipment(0);
            player.setWeapon(0);
            player.setBornWithTalent(4);
            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + player.getName());
            System.out.println("Your character have: " + player.getHealth() + " Health");
        }else{
            System.out.println("Error - please choose 1");
            yourChoice = input.nextInt();
        }


        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story
        Levels level = new Levels();
        level.preStoryKvothe();
        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();

        if (level.getFirstchoiceinlevel()==1) {
            System.out.println("success");
            h.human1Method();
            h.human1.setInitialized(1);
            h.human2Method();
            h.human1.setInitialized(1);
            System.out.println("Attack either the one in front - 1");
            System.out.println("Or attack the one in the back - 2");
            combatMethod();
        } else if (level.getFirstchoiceinlevel()==5) {
            System.out.println("success 2");
            if (Calculation.calculateOneEight()==1) {
                firstCombatFleet=true;
            }else { System.out.println("Attack either the one in front - 1");
                    System.out.println("Or attack the one in the back - 2");
                    combatMethod();}
        } else if (level.getFirstchoiceinlevel()==3) {
            if (Calculation.calculateOneInThousand()==1) {
                firstCombatSubdued=true;   }          }

        if (firstCombatSubdued) {
            level.firstBackStorySubdued();
        } else if (firstCombatWon) {
            level.firstBackStoryKilling();
        }else if (firstCombatFleet) {
            level.firstBackStoryFleeing();        }


    }

    public void choices() {   // the choice method -
        System.out.println("Please choose a Action");
        System.out.println();
        choice = input.next();
        switch (choice) {
            case "attack":
                System.out.println("attack");
             //   setFirstchoiceinlevel(1);

                break;
            case "wound":
                System.out.println("wound");
                //setFirstchoiceinlevel(2);

                break;
            case "subdue":
                System.out.println("subdue");
               // level.setFirstchoiceinlevel(3);

                break;
            case "winOver":
                System.out.println("winOver");
              //  level.setFirstchoiceinlevel(4);

                break;
            case "flee":
               /// level.setFirstchoiceinlevel(5);

                System.out.println("flee");

                break;
            case "talk":
                System.out.println("talk");
              //  level.setFirstchoiceinlevel(6);
                break;
            case "cheat":
                System.out.println("cheat");
             //   level.setFirstchoiceinlevel(10);
                break;
            default:
                System.out.println("failure");
                break;
        }
    }

   public void combatMethod() {

       boolean combatInProgress = true;
       while (combatInProgress) // how to do this with different opponents?
       {
           System.out.println("yeaah");
           if (player.isAlive()) {
               System.out.println(player.getName() + " Is alive");  // displayed in the top
               System.out.println(player.getHealth() + " Health left");
           } else if (!player.isAlive()) {
               System.out.println("you have been defeated");
               break;
           }
           if (h.human1.opponentAlive()) {
               System.out.println(h.human1.getName() + " Is alive"); // displayed left middle or right side
               System.out.println(h.human1.getHp() + " Health left");
           } // perhaps a picture? over the text/values
           else if (!h.human1.opponentAlive()) {
               System.out.println(h.human1.getName() + " Have been defeated");
           }
           if (h.human2.opponentAlive()) {
               System.out.println(h.human2.getName() + " Is alive");
               System.out.println(h.human2.getHp() + " Health left");
           } else if (h.human2.opponentAlive()) {
               System.out.println(h.human2.getName() + " Have been defeated");
           }
           if (!h.human1.opponentAlive() && !h.human2.opponentAlive()) {
               System.out.println("You have Killed both Enemies");
               firstCombatWon = true;
               combatInProgress=false;   }

           firstCombatMethod();
       }
   }
      public void firstCombatMethod() {
         attackChoice=input.nextInt();
          if (attackChoice==1) {
              if (!h.human1.opponentAlive()) {
                  System.out.println(h.human1.getName()+" is dead your dimwit");
                  h.human1.setKilled(0);
                  attackChoice=2;  }
              System.out.println("you are attacking" + h.human1.getName());
              playerDamageDealt=Calculation.generateRandomInt(player.getAttack());
              System.out.println(" damage dealt:" +playerDamageDealt);
              int currentHP =h.human1.getHp();
              h.human1.setHp(currentHP-playerDamageDealt+h.human1.getHp());
              System.out.println("1 health :" +h.human1.getHp());
                mobAttackBack1();
          }else if (attackChoice==2) {
              if (!h.human2.opponentAlive()) {
                  System.out.println(h.human2.getName()+" is dead your dimwit");
                  h.human2.setKilled(0);
                  attackChoice=1;   }
              System.out.println("you are attacking" + h.human2.getName());
              playerDamageDealt=Calculation.generateRandomInt(player.getAttack());
              System.out.println(" damage dealt:" +playerDamageDealt);
              int currentHP =h.human2.getHp();
              h.human2.setHp(currentHP-playerDamageDealt+h.human2.getHp());
              System.out.println("2 health :" + h.human2.getHp());
                mobAttackBack1();          }
          if (h.human1.opponentKilled() && h.human2.opponentKilled()) {
              firstCombatWon=true;          }                                       }


       public void mobAttackBack1() {
        for (int i=0; i<1;i++) {
           if (h.human1.opponentAlive() && h.human1.opponentInitialized()) {
               adversariesDamageDealt = Calculation.generateRandomInt(h.human1.getAtk());
               int playerCurrentHP =player.getHealth();
               player.setHealth(playerCurrentHP-adversariesDamageDealt); }
           if (h.human2.opponentAlive() && h.human2.opponentInitialized()) {
               adversariesDamageDealt = Calculation.generateRandomInt(h.human2.getAtk());
               player.setHealth(player.getHealth()-adversariesDamageDealt+player.getDefence()); }
                } }
      public void mobAttackBack2() {
        for (int i=0; i<1;i++) {
            if (h.human3.opponentAlive() && h.human3.opponentInitialized()) {
                adversariesDamageDealt = Calculation.generateRandomInt(h.human3.getAtk());
                int playerCurrentHP =player.getHealth();
                player.setHealth(playerCurrentHP-adversariesDamageDealt); }
            if (h.human4.opponentAlive() && h.human4.opponentInitialized()) {
                adversariesDamageDealt = Calculation.generateRandomInt(h.human4.getAtk());
                player.setHealth(player.getHealth()-adversariesDamageDealt+player.getDefence()); }
                } }
    public void mobAttackBack3() {
        for (int i=0; i<1;i++) {
            if (h.human5.opponentAlive() && h.human5.opponentInitialized()) {
                adversariesDamageDealt = Calculation.generateRandomInt(h.human5.getAtk());
                int playerCurrentHP =player.getHealth();
                player.setHealth(playerCurrentHP-adversariesDamageDealt); }
            if (h.human6.opponentAlive() && h.human6.opponentInitialized()) {
                adversariesDamageDealt = Calculation.generateRandomInt(h.human6.getAtk());
                player.setHealth(player.getHealth()-adversariesDamageDealt); }
        } }


      //else if (!player.isAlive()) {
          //System.out.println("more yeaah");
      //}



}



