package Game;

import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    static Player player = new Player();
    boolean firstCombatWon =false, firstCombatFleet=false, firstCombatSubdued=false; // will be used for a victory sheet of sort
    boolean enteredTown = false, sleptInTheWoods=false, slappedTheGuards=false;
    int attackChoice;
// making the adversaries up here so it can be called everywhere, could reuse them but would need to set them correctly as you need them creature3 being inUse false until being needed
    static Humans creature = new Humans(4,3,0,"bandit", true);
    static Humans creature2 = new Humans(3,4,1,"Bandit 2", true);
    static Humans creature3 = new Humans(16, 4, 2, " Town's Guard #3", false);



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

        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();
        if (level.getFirstchoiceinlevel()==1) { // attack option
            combat(creature, creature2);
            firstCombatWon=true;
        } else if (level.getFirstchoiceinlevel()==5) { // flee option
            if (Calculation.calculateOneEight()==1) {
                firstCombatFleet=true;
            }else {combat(creature, creature2); firstCombatWon=true; }
        } else if (level.getFirstchoiceinlevel()==3) { //subdue option (aka op lucky option)
            if (Calculation.calculateOneInThousand()==1) {
                firstCombatSubdued=true;   } else {combat(creature, creature2); firstCombatWon=true;} }

        if (firstCombatSubdued) {level.firstBackStorySubdued();}
        else if (firstCombatWon) {level.firstBackStoryKilling();}
        else if (firstCombatFleet) {level.firstBackStoryFleeing();}

            level.secondChoiceStory(); // reset of creature and creature2. with inUse already set
            creature.setName("Bandit's friend"); creature2.setName("Bandit's Brother");
            creature.setHealth(6); creature.setAttack(4); creature.setDefence(1);
            creature2.setHealth(8); creature2.setAttack(5); creature2.setDefence(2);
            combat(creature, creature2);

            level.secondBackStory();
            level.thirdChoiceStory();
            player.setCoins(player.getCoins()+6);
            creature.setName("Town's Guard"); creature2.setName("Town's tall Guard");
            creature.setHealth(10); creature.setAttack(4); creature.setDefence(2);
            creature2.setHealth(12); creature2.setAttack(5); creature2.setDefence(1);
            level.fourthChoiceStory();
            level.fourthChoices();
            if (level.getFourthchoiceinlevel()==1) {
                level.fourthChoicePay();enteredTown=true;
            } else if (level.getFourthchoiceinlevel()==2) {
                level.fourthChoiceSlap();
                combat(creature, creature2);
                level.fourthSlapBackRewars();slappedTheGuards=true;
            } else if (level.getFourthchoiceinlevel()==3) { System.out.println("You wonder out into the woods to sleep"); sleptInTheWoods=true;}

            // break off of events one where you are in the town, perhaps one of each method of getting in
            //and one for sleeping in the woods
            if (enteredTown) {
                level.enteredTownPaid();
            } else if (slappedTheGuards) {
                level.enterTownAfterSlap();
                if (level.getFightAfterSlap()==1) {
                    Humans humanSlap1 = new Humans(14,6,2,"Town's Guard #1",true);
                    Humans humanSlap2 = new Humans(14,5,2,"Town's Guard #2", true);
                    Humans humanSlap3 = new Humans(16,4,2,"Town's Guard #3", true);
                    creature.setName("Town's Guard #1"); creature2.setName("Town's Guard #2");
                    creature.setHealth(14); creature.setAttack(6); creature.setDefence(2);
                    creature2.setHealth(14); creature2.setAttack(5); creature2.setDefence(2);
                    creature3.setInUse(true); // initialising the already set creature3

                }
            } else if (sleptInTheWoods) {
                System.out.println("Not complete yet -2");
            }

    }


    public void combatAgainstThree(Creature creature, Creature creature2, Creature creature3) {

        boolean combatInProgress=true;

        while (combatInProgress) {
            creatureCheck(creature);
            creatureCheck(creature2);
            creatureCheck(creature3);

            if (player.isAlive()){System.out.println(player.getName() + " Your are alive | " + player.getHealth() + " Health  left");}

            System.out.println("Choose which opponent you would attack!\n" +
                        "Front/right = 1, Behind/left = 2, Middle = 2"); attackChoice = input.nextInt(); }



            if (!creature.opponentAlive()) { System.out.println(creature.getName() + " is dead DimWit!!");
                    if (!creature2.opponentAlive() && creature3.opponentAlive()) {attackChoice=3;}
                    if (creature2.opponentAlive() && creature3.opponentAlive()) {attackChoice=2;}                       }
            else if (!creature2.opponentAlive()) {System.out.println(creature2.getName() + " is dead DimWit!!");
                    if (!creature.opponentAlive() && creature3.opponentAlive()) { attackChoice=3;}
                    if (creature.opponentAlive() && ! creature3.opponentAlive()) {attackChoice = 1;}                    }
            else if (!creature3.opponentAlive()) {System.out.println(creature3.getName() + " is dead dimWit!!");
                    if (!creature.opponentAlive() && creature2.opponentAlive()) {attackChoice=2;}
                    if (creature.opponentAlive() && !creature2.opponentAlive()) {attackChoice=1;}                       }

            //TODO make methods out of the the attackChoices
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
                        //TODO first attackChoice end
                } if (creature2.opponentAlive()) { //TODO make a seperate one for the second or third mob retaliate that are in each player attackChoice
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
            } else if (attackChoice == 2) { //TODO this will be deleted since the method formed from the above will be like this yet, only need to be made another for each of the creatures that are created
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



public void creatureCheck(Creature creature) {
    if (creature.opponentAlive()) {System.out.println(creature.getName() + "\t is alive | " + creature.getHealth() + " Health left"); }
    else if (!creature.opponentAlive()) {System.out.println(creature.getName() + " Have been defeated"); }              }



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


    public void combat(Creature creature, Creature creature2) { //TODO will need to do the same with this one, don't know why it is in the bottom though

        boolean combatInProgress=true;
            while (combatInProgress) {
                creatureCheck(creature);
                creatureCheck(creature2);

                if (!creature.opponentAlive()) { System.out.println(creature.getName() + " is dead DimWit!!");
                        attackChoice = 2;}
                else if (!creature2.opponentAlive()) {System.out.println(creature2.getName() + " is dead DimWit!!");
                        attackChoice = 1;}



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
                        System.out.println(player.getHealth() + " Player health left");}    }
            }
            if (!creature.opponentAlive() && !creature2.opponentAlive() || creature2.getInUse()) {
                combatInProgress=false;
            }
        }

    }

        public void combatFillAttackPart(Creature creature, Creature creature2, Creature creature3, int x) { // the x to be able to set which would the first, second or third.
            if (attackChoice == x) {
                int playerDamage = useGenerate(player); // made use of this instead to shorten the code written
                System.out.println("You are attacking: " + creature.getName() + " | with " + playerDamage + " Damage!");

                if (creature.getDefence() - playerDamage==-2) { System.out.println("Your damage broke through their defence of: " + creature.getDefence());creature.setHealth(creature.getHealth()-playerDamage); }
                else if (creature.getDefence() - playerDamage==-1) {System.out.println("Your damage slipped through their defence of: " + creature.getDefence());creature.setHealth(creature.getHealth()- playerDamage); }
                else if (creature.getDefence() == playerDamage) {System.out.println("Their defence are this attack's match!");creature.setHealth(creature.getHealth()-1); }
                else if (creature.getDefence() -playerDamage==1) {System.out.println("Their defence are superior!"); }
                else if (creature.getDefence() - playerDamage==2) {System.out.println("Maybe run? perhaps"); }
                else {creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());}

                if (checkRetaliate(creature)) { // it keep saying that is is duplicated yet i cannot make it more short
                    int addDamage = useGenerate(creature); // wonder if there will be conflict when there is more than one enemy
                    if (player.getDefence() > addDamage) {
                        if (player.getDefence() - addDamage == -2) {
                            System.out.println(creature.getName() + " Attack broke through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth() - addDamage + player.getDefence()); }
                        else if (player.getDefence() - addDamage == -1) {
                            System.out.println(creature.getName() + " Attack slipped through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth() - addDamage + player.getDefence()); }
                        else if (player.getDefence() == addDamage) {
                            System.out.println("Their attack equals our defence!");
                            player.setHealth(player.getHealth() - 1); }
                        else if (player.getDefence() - addDamage == 1) {
                            System.out.println("Your defence is superior!"); }
                        else if (player.getDefence() - addDamage == 2) {
                            System.out.println("Their attack stood no chance against your defence!"); } }
                     else {
                        System.out.println(creature.getName() + " Dealt you " + addDamage + " Damage" + " mitigated by your defence of: " + player.getDefence());
                        player.setHealth(player.getHealth() - addDamage + player.getDefence()); } }


                    if (checkRetaliate(creature2)) {
                        int addDamage2 = useGenerate(creature2);
                        if (player.getDefence() > addDamage2) {
                            if (player.getDefence() - addDamage2 == -2) {
                                System.out.println(creature.getName() + " Attack broke through your defence of: " + player.getDefence());
                                player.setHealth(player.getHealth() - addDamage2 + player.getDefence()); }
                            else if (player.getDefence() - addDamage2 == -1) {
                                System.out.println(creature.getName() + " Attack slipped through your defence of: " + player.getDefence());
                                player.setHealth(player.getHealth() - addDamage2 + player.getDefence()); }
                            else if (player.getDefence() == addDamage2) {
                                System.out.println("Their attack equals our defence!");
                                player.setHealth(player.getHealth() - 1); }
                            else if (player.getDefence() - addDamage2 == 1) {
                                System.out.println("Your defence is superior!"); }
                            else if (player.getDefence() - addDamage2 == 2) {
                                System.out.println("Their attack stood no chance against your defence!"); } }
                        else {
                            System.out.println(creature.getName() + " Dealt you " + addDamage2 + " Damage" + " mitigated by your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth() - addDamage2 + player.getDefence()); }
                    } if (checkRetaliate(creature3)) {
                        int addDamage3 = useGenerate(creature3);
                    if (player.getDefence() > addDamage3) {
                        if (player.getDefence() - addDamage3 == -2) {
                            System.out.println(creature.getName() + " Attack broke through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth() - addDamage3 + player.getDefence()); }
                        else if (player.getDefence() - addDamage3 == -1) {
                            System.out.println(creature.getName() + " Attack slipped through your defence of: " + player.getDefence());
                            player.setHealth(player.getHealth() - addDamage3 + player.getDefence()); }
                        else if (player.getDefence() == addDamage3) {
                            System.out.println("Their attack equals our defence!");
                            player.setHealth(player.getHealth() - 1); }
                        else if (player.getDefence() - addDamage3 == 1) {
                            System.out.println("Your defence is superior!"); }
                        else if (player.getDefence() - addDamage3 == 2) {
                            System.out.println("Their attack stood no chance against your defence!"); } }
                    else {
                        System.out.println(creature.getName() + " Dealt you " + addDamage3 + " Damage" + " mitigated by your defence of: " + player.getDefence());
                        player.setHealth(player.getHealth() - addDamage3 + player.getDefence()); }
                }

                // make creature static so it can be called, yet would need to make sure to set the not used (ex. after having 3 enemies then 2 enemies) so the third is null

            } }

            public int useGenerate(Creature creature) {
               return Calculation.generateRandomInt(creature.getAttack());
            }
            public boolean checkRetaliate(Creature creature) {
                return creature.opponentAlive() && creature.inUse;
            }




}



