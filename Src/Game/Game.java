package Game;

import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    String attack = "attack", wound = "wound", subdue = "subdue", winOver = "winOver", flee = "flee", talk = "talk", cheat = "cheat";
    Player player = new Player();

    boolean firstCombatWon =false, firstCombatFleet=false, firstCombatSubdued=false; // will be used for a victory sheet of sort
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

            Player player = new Player(20, "Kvothe", 4, 2, 0, 0,3,2);

            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + player.getName());  // to be displayed at the top of the program
            System.out.println("Your character have: " + player.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else if (yourChoice==2) {
            player.setName("Reshi");
            player.setHealth(18);
            player.setDefence(5);
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
        } // a catch method if entered wrong


        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story
        Levels level = new Levels();
        level.preStoryKvothe();


        Humans human = new Humans(4,3,0,"bandit");
        Humans human2 = new Humans(3,4,1,"Bandit 2");
        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();


        if (level.getFirstchoiceinlevel()==1) {
            System.out.println("success");
            System.out.println(player.getHealth() + "health");
            combat(human, human2);
        } else if (level.getFirstchoiceinlevel()==5) {
            System.out.println("success 2");
            if (Calculation.calculateOneEight()==1) {
                firstCombatFleet=true;
            }else {


            }
        } else if (level.getFirstchoiceinlevel()==3) {
            if (Calculation.calculateOneInThousand()==1) {
                firstCombatSubdued=true;   }          }

        if (firstCombatSubdued) {
            level.firstBackStorySubdued();
        }
        else if (firstCombatWon) {level.firstBackStoryKilling();}
        else if (firstCombatFleet) {
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


    public void combat(Creature creature, Creature creature2) {
        System.out.println("You have Encountered: " );
        System.out.println(creature.getName() + " With: " + creature.getHealth() + " Health");
        if (creature2.getInUse()) {
            System.out.println(creature2.getName() + " With: " + creature2.getHealth() + " Health"); }
        boolean combatInProgress=true;
        while (combatInProgress) {
            System.out.println(player.getHealth() + "HP in COMBAT");
            if (player.isAlive()) {
                System.out.println(player.getName() + " is alive");
                System.out.println(player.getHealth() + " Health left");
            } else if (!player.isAlive()) {
                System.out.println("You have been defeated!");
                combatInProgress=false; }
            if (creature.opponentAlive()) {
                System.out.println(creature.getName() + " is alive");
                System.out.println(creature.getHealth() + " Health left");
            } else if (!creature.opponentAlive()) {
                System.out.println(creature.getName() + " Have been defeated");
            }
            if (creature2.opponentAlive() && creature2.getInUse()) {
                System.out.println(creature2.getName() + " is alive");
                System.out.println(creature2.getHealth() + " Health left");
            } else if (!creature2.opponentAlive() && creature2.getInUse()) {
                System.out.println(creature2.getName() + " Have been defeated");
            }

            if (creature2.getInUse()) {
                System.out.println("Choose which opponent you would attack!\n" +
                        "Front/right = 1, Behind/left = 2");
                attackChoice = input.nextInt();
            } else {
                System.out.println("Attack the opponent!");
                attackChoice = 1;
            }

            if (attackChoice == 1) {
                if (!creature.opponentAlive()) {
                    System.out.println(creature.getName() + " is dead DimWit!!");
                    attackChoice = 2;
                }
                System.out.println("You are attacking" + creature.getName());
                int playerDamage = Calculation.generateRandomInt(player.getAttack());
                System.out.println("Damage dealt: " + playerDamage);
                creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());
                System.out.println(creature.getHealth() + " Add1 - health");
                if (creature.opponentAlive()) {
                    int addDamage = Calculation.generateRandomInt(creature.getAttack());
                    System.out.println(creature.getName() + " Dealt you " + addDamage + " Damage");
                    player.setHealth(player.getHealth() - addDamage + player.getDefence());
                }
            } else if (attackChoice == 2) {
                if (!creature2.opponentAlive()) {
                    attackChoice = 1;
                }
                System.out.println("You are attacking" + creature2.getName());
                int playerDamage = Calculation.generateRandomInt(player.getAttack());
                System.out.println("Damage dealt: " + playerDamage);
                creature.setHealth(creature2.getHealth() - playerDamage + creature2.getDefence());
                System.out.println(creature2.getHealth() + " Add2 - health");
                if (creature2.opponentAlive()) {
                    int addDamage2 = Calculation.generateRandomInt(creature2.getAttack());
                    System.out.println(creature2.getName() + " Dealt you " + addDamage2 + " Damage");
                    player.setHealth(player.getHealth() - addDamage2 + player.getDefence());
                }
            }
        }

    }


}



