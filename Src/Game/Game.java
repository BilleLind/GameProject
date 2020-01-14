package Game;

import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    Player player = new Player();
    boolean firstCombatWon =false, firstCombatFleet=false, firstCombatSubdued=false; // will be used for a victory sheet of sort


    int attackChoice;

    public void gameRunning() {


        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (1 or 2)");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
            //can customize to your desire

            //Player player = new Player(20, "Kvothe", 4, 2, 0, 0,3,2);
            //player.setAttack(4);
            //player.setHealth(20);
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
        Humans human = new Humans(4,3,0,"bandit", true);
        Humans human2 = new Humans(3,4,1,"Bandit 2", true);
        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();
        if (level.getFirstchoiceinlevel()==1) { // attack option
            combat(human, human2);
            firstCombatWon=true;
        } else if (level.getFirstchoiceinlevel()==5) { // flee option
            if (Calculation.calculateOneEight()==1) {
                firstCombatFleet=true;
            }else {combat(human, human2); firstCombatWon=true; }
        } else if (level.getFirstchoiceinlevel()==3) { //subdue option (aka op lucky option)
            if (Calculation.calculateOneInThousand()==1) {
                firstCombatSubdued=true;   } else {combat(human, human2); firstCombatWon=true;} }

        if (firstCombatSubdued) {player.setCoins(10); player.setWeapon(3); player.setHealth(25);
            level.firstBackStorySubdued();}

        else if (firstCombatWon) {player.setWeapon(2); player.setHealth(24); player.setCoins(4);
            level.firstBackStoryKilling();     }

        else if (firstCombatFleet) {player.setAttack(player.getAttack()-1); player.setHealth(17);
            level.firstBackStoryFleeing();}
            // end of the first story piece + combat/flee or subdue option

        System.out.println("Test");

        System.out.println(player.getHealth());
        System.out.println(player.getWeapon());
        System.out.println(player.getCoins());
            // TODO Second story - second battle
            level.secondChoiceStory();
            Humans humans2a = new Humans(6,4,1, " bandit's friend ", true);
            Humans humans2b = new Humans(8,5,2," Bandit's wife", true);
            combat(humans2a, humans2b);
            player.setHealth(24);
            player.setCoins(player.getCoins()+2);
        System.out.println(player.getCoins() + " coins!");
        System.out.println(player.getHealth() + " test after health reset");
            player.setEquipment(2);
        System.out.println(player.getEquipment() + " EQ" + player.getHealth() + " hP with EQ");
            level.secondBackStory();



    }


    public void combat(Creature creature, Creature creature2) {
        System.out.println("You have Encountered: " );
        System.out.println(creature.getName() + " With: " + creature.getHealth() + " Health");
        if (!creature2.getInUse()) {
            System.out.println(creature2.getName() + " With: " + creature2.getHealth() + " Health"); }
        boolean combatInProgress=true;
        while (combatInProgress) {
            //System.out.println(player.getHealth() + "HP in COMBAT");
           // if (!player.isAlive()) {
            //    System.out.println(player.getName() + " is alive");
             //   System.out.println(player.getHealth() + " Health left");
           // } else if (player.isAlive()) {
           //     System.out.println("You have been defeated!");
            //    combatInProgress=false; }
            // something wrong about the isAlive() :/

            if (creature.opponentAlive()) {
                System.out.println(creature.getName() + " is alive | " + creature.getHealth() + " Health left");
            } else if (!creature.opponentAlive()) {
                System.out.println(creature.getName() + " Have been defeated");
            }
            if (creature2.opponentAlive() && !creature2.getInUse()) {
                System.out.println(creature2.getName() + " is alive | " + creature2.getHealth() + " Health left");

            } else if (!creature2.opponentAlive() && creature2.getInUse()) {
                System.out.println(creature2.getName() + " Have been defeated");
            }

            if (!creature2.getInUse()) {
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
                System.out.println("You are attacking: " + creature.getName());
                int playerDamage = Calculation.generateRandomInt(player.getAttack());

                if (creature.getDefence() > playerDamage) {
                     // it would heal the mob, there by making it regenerate
                    System.out.println("Your attack was WEAK!");
                    creature.setHealth(creature.getHealth() -1);
                } else {System.out.println("Damage dealt: " + playerDamage + " to " +creature.getName());
                    creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());}
                //TODO System.out.println(creature.getHealth() + " Add1 - health"); removable??
                if (creature.opponentAlive()) {
                    int addDamage = Calculation.generateRandomInt(creature.getAttack());

                    if ( player.getDefence() > addDamage) {
                         // it would heal the mob, there by making it regenerate
                        System.out.println(creature.name + " Attack was WEAK!");
                        player.setHealth(player.getHealth()-1);
                    } else {System.out.println(creature.getName() + " Dealt you " + addDamage + " Damage");
                        player.setHealth(player.getHealth() - addDamage + player.getDefence());
                    System.out.println(player.getHealth() + " Player health left"); }
                } if (creature2.opponentAlive()) {
                    int addDamage2 = Calculation.generateRandomInt(creature2.getAttack());

                    if (player.getDefence() > addDamage2) {
                        System.out.println(creature2.getName() + " Attack was WEAK!");
                        player.setHealth(player.getHealth()-1); // it would heal the mob, there by making it regenerate
                    }else {System.out.println(creature2.getName() + " Dealt you " + addDamage2 + " Damage");
                        player.setHealth(player.getHealth() - addDamage2 + player.getDefence());
                    System.out.println(player.getHealth() + " Player health left");}
                }
            } else if (attackChoice == 2) {
                if (!creature2.opponentAlive()) {
                    attackChoice = 1;
                }
                System.out.println("You are attacking: " + creature2.getName());
                int playerDamage = Calculation.generateRandomInt(player.getAttack());

                if (creature2.getDefence() > playerDamage) {
                    System.out.println("Your attack was WEAK!");
                    // it would heal the mob, there by making it regenerate
                    creature2.setHealth(creature2.getHealth()-1);
                } else {System.out.println("Damage dealt: " + playerDamage + " to " +creature2.getName());
                    creature2.setHealth(creature2.getHealth()-playerDamage+creature2.getDefence()); }

                if (creature2.opponentAlive()) {
                    int addDamage2 = Calculation.generateRandomInt(creature2.getAttack());

                    if (player.getDefence() > addDamage2) {
                        System.out.println(creature2.getName() + "  Attack was WEAK!");
                        player.setHealth(player.getHealth()-1); // it would heal the mob, there by making it regenerate
                    }else {System.out.println(creature2.getName() + " Dealt you " + addDamage2 + " Damage");
                        player.setHealth(player.getHealth() - addDamage2 + player.getDefence());
                    System.out.println(player.getHealth() + " Player health left");}
                } if (creature.opponentAlive()) {
                    int addDamage = Calculation.generateRandomInt(creature.getAttack());

                    if ( player.getDefence() > addDamage) {
                        // it would heal the mob, there by making it regenerate
                        System.out.println(creature.getName() + " Attack was WEAK!");
                        player.setHealth(player.getHealth() -1);
                    } else {System.out.println(creature.getName() + " Dealt you " + addDamage + " Damage");
                        player.setHealth(player.getHealth() - addDamage + player.getDefence());
                    System.out.println(player.getHealth() + " Player health left");}
                }
            }
            if (!creature.opponentAlive() && !creature2.opponentAlive() || creature2.getInUse()) {
                combatInProgress=false;
            }
        }

    }


}



