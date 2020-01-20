package Game;

import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    static Player player = new Player();
    boolean firstCombatWon =false, firstCombatFleet=false, firstCombatSubdued=false; // will be used for a victory sheet of sort


    int attackChoice;

    public void gameRunning() {


        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (1 or 2)");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            characterOne();
        } else if (yourChoice==2) {
            characterTwo();
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

        if (firstCombatSubdued) {level.firstBackStorySubdued();}
        else if (firstCombatWon) {level.firstBackStoryKilling();}
        else if (firstCombatFleet) {level.firstBackStoryFleeing();}

            level.secondChoiceStory();
            Humans humans2a = new Humans(6,4,1, " bandit's friend ", true);
            Humans humans2b = new Humans(8,5,2," Bandit's wife", true);
            combat(humans2a, humans2b);

            level.secondBackStory();
            level.thirdChoiceStory();
            player.setCoins(player.getCoins()+6);
            Humans humans3a = new Humans(10,4,2,"Town's Guard", true);
            Humans humans3b = new Humans(12,5,1,"Town's tall guard", true);
            level.fourthChoiceStory();
            level.fourthChoices();
            if (level.getFourthchoiceinlevel()==1) {
                System.out.println(player.getCoins() + " coins before");
                player.setCoins(player.getCoins()-4);
                System.out.println("you have " + player.getCoins() + " Coins left");
            } else if (level.getFourthchoiceinlevel()==2) {
                System.out.println("They attack you");
                combat(humans3a, humans3b);
                player.setHealth(24);
                player.setAttack(player.getAttack()+1);
                System.out.println("Weary after fighting you are left stronger");
            } else if (level.getFourthchoiceinlevel()==3) {
                System.out.println("You wonder out into the woods to sleep");
            }

    }


    public void combat(Creature creature, Creature creature2) {

        boolean combatInProgress=true;
        while (combatInProgress) {
            if (creature.opponentAlive()) {
                System.out.println(creature.getName() + "\t is alive | " + creature.getHealth() + " Health left");
            } else if (!creature.opponentAlive()) {
                System.out.println(creature.getName() + " Have been defeated");
            }
            if (creature2.opponentAlive() && !creature2.getInUse()) {
                System.out.println(creature2.getName() + " is alive | " + creature2.getHealth() + " Health left");

            } else if (!creature2.opponentAlive() && creature2.getInUse()) {
                System.out.println(creature2.getName() + " Have been defeated");
            }
            if (player.isAlive()){System.out.println(player.getName() + " Your are alive | " + player.getHealth() + " Health  left");}

            if (!creature2.getInUse()) {
                System.out.println("Choose which opponent you would attack!\n" +
                        "Front/right = 1, Behind/left = 2"); attackChoice = input.nextInt(); }
            else {System.out.println("Attack the opponent!"); attackChoice = 1;}


            if (!creature.opponentAlive()) { // to make sure that are not a attack wasted, would you attack a dead body? :D
                System.out.println(creature.getName() + " is dead DimWit!!");
                attackChoice = 2;
            }else if (!creature2.opponentAlive()) {System.out.println(creature2.getName() + " is dead DimWit!!");
                attackChoice = 1;}

            if (attackChoice == 1) {
                int playerDamage = Calculation.generateRandomInt(player.getAttack());
                System.out.println("You are attacking: " + creature.getName() + " | with " + playerDamage + " Damage!");

                    if (creature.getDefence() - playerDamage==-2) {
                        System.out.println("Your damage broke through their defence of: " + creature.getDefence());
                        creature.setHealth(creature.getHealth()-playerDamage);
                    } else if (creature.getDefence() - playerDamage==-1) {
                        System.out.println("Your damage slipped through their defence of: " + creature.getDefence());
                        creature.setHealth(creature.getHealth()- playerDamage);
                    } else if (creature.getDefence() == playerDamage) {
                        System.out.println("Their defence are this attack's match!");
                        creature.setHealth(creature.getHealth()-1);
                    }else if (creature.getDefence() -playerDamage==1) {
                        System.out.println("Their defence are superior!");
                    } else if (creature.getDefence() - playerDamage==2) {
                        System.out.println("Maybe run? perhaps"); }
                 else {creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());}

                if (creature.opponentAlive()) {
                    int addDamage = Calculation.generateRandomInt(creature.getAttack());

                    if ( player.getDefence() > addDamage) {
                        if (player.getDefence() - addDamage==-2) {
                            System.out.println(creature.getName() + " Attack broke through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth()-addDamage+player.getDefence()); }
                        else if (player.getDefence() - addDamage==-1) {
                            System.out.println(creature.getName() + " Attack slipped through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth()- addDamage + player.getDefence()); }
                        else if (player.getDefence() == addDamage) {
                            System.out.println("Their attack equals our defence!");
                            player.setHealth(player.getHealth()-1); }
                        else if (player.getDefence() - addDamage ==1) {
                            System.out.println("Your defence is superior!"); }
                        else if (player.getDefence() - addDamage==2) {
                            System.out.println("Their attack stood no chance against your defence!"); }
                    } else {System.out.println(creature.getName() + " Dealt you " + addDamage + " Damage" + " mitigated by your defence of: " + player.getDefence());
                        player.setHealth(player.getHealth() - addDamage + player.getDefence()); }

                } if (creature2.opponentAlive()) {
                    int addDamage2 = Calculation.generateRandomInt(creature2.getAttack());

                    if ( player.getDefence() > addDamage2) {
                        if (player.getDefence() - addDamage2==-2) {
                            System.out.println(creature2.getName() + " Attack broke through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth()-addDamage2+player.getDefence()); }
                        else if (player.getDefence() - addDamage2==-1) {
                            System.out.println(creature2.getName() + " Attack slipped through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth()- addDamage2 + player.getDefence()); }
                        else if (player.getDefence() == addDamage2) {
                            System.out.println("Their attack equals our defence!");
                            player.setHealth(player.getHealth()-1); }
                        else if (player.getDefence() - addDamage2 ==1) {
                            System.out.println("Your defence is superior!"); }
                        else if (player.getDefence() - addDamage2==2) {
                            System.out.println("Their attack stood no chance against your defence!"); }
                    } else {System.out.println(creature2.getName() + " Dealt you " + addDamage2 + " Damage" + " mitigated by your defence of: " + player.getDefence());
                        player.setHealth(player.getHealth() - addDamage2 + player.getDefence()); }
                }
            } else if (attackChoice == 2) {
                int playerDamage = Calculation.generateRandomInt(player.getAttack());
                System.out.println("You are attacking: " + creature2.getName() + " | with " + playerDamage + " Damage!");

                    if (creature2.getDefence() - playerDamage==-2) {
                        System.out.println("Your damage broke through their defence of: " + creature2.getDefence());creature2.setHealth(creature2.getHealth()-playerDamage);}
                    else if (creature2.getDefence() - playerDamage==-1) {
                        System.out.println("Your damage slipped through their defence of: " + creature2.getDefence());creature2.setHealth(creature2.getHealth()- playerDamage);}
                    else if (creature2.getDefence() == playerDamage) {
                        System.out.println("Their defence are this attack's match!");creature2.setHealth(creature2.getHealth()-1);}
                    else if (creature2.getDefence() -playerDamage==1) {System.out.println("Their defence are superior!");}
                    else if (creature2.getDefence() - playerDamage==2) {System.out.println("Maybe run? perhaps"); }
                 else { creature2.setHealth(creature2.getHealth()-playerDamage+creature2.getDefence()); }

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





    public void characterOne() {
        player.setHealth(20);
        player.setAttack(5);
        player.setName("Kvothe");
        player.setCoins(2);
        player.setWeapon(0);
        player.setBornWithTalent(3);
        player.setEquipment(0);
        player.setDefence(1);
        System.out.println("Your characters name is: " + player.getName());  // to be displayed at the top of the program
        System.out.println("Your character have: " + player.getHealth() + " Health");
        System.out.println("Your character is generally skilled");
    }
    public void characterTwo() {
        player.setName("Reshi");
        player.setHealth(18);
        player.setDefence(2);
        player.setAttack(4);
        player.setEquipment(0);
        player.setWeapon(0);
        player.setBornWithTalent(4);
        System.out.println("Your characters name is: " + player.getName());
        System.out.println("Your character have: " + player.getHealth() + " Health");
    }




}



