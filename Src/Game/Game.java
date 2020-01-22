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
    static Humans human1 = new Humans(0,0,0,"", false);
    static Humans human2 = new Humans(0,0,0,"", false);
    static Humans human3 = new Humans(0, 0, 0, "", false);



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
            //yourChoice = input.nextInt();
        } // a catch method if entered wrong


        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story
        Levels level = new Levels();
        level.preStoryKvothe();

        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();
        if (level.getFirstchoiceinlevel()==1) { // attack option
            firstCombatCombo();
            combatAgainstThree(human1, human2, human3,2);
            firstCombatWon=true;
        } else if (level.getFirstchoiceinlevel()==5) { // flee option
            if (Calculation.calculateOneEight()==1) {
                firstCombatFleet=true;
            }else {combatAgainstThree(human1, human2, human3,2); firstCombatWon=true; }
        } else if (level.getFirstchoiceinlevel()==3) { //subdue option (aka op lucky option)
            if (Calculation.calculateOneInThousand()==1) {
                firstCombatSubdued=true;   } else {combatAgainstThree(human1, human2, human3,2); firstCombatWon=true;} }

        if (firstCombatSubdued) {level.firstBackStorySubdued();}
        else if (firstCombatWon) {level.firstBackStoryKilling();}
        else if (firstCombatFleet) {level.firstBackStoryFleeing();}

            level.secondChoiceStory(); // reset of creature and creature2. with inUse already set
            human1.setName("Bandit's friend"); human2.setName("Bandit's Brother");
            human1.setHealth(6); human1.setAttack(4); human1.setDefence(1);
            human2.setHealth(8); human2.setAttack(5); human2.setDefence(2);
        combatAgainstThree(human1, human2, human3,2);

            level.secondBackStory();
            level.thirdChoiceStory();
            player.setCoins(player.getCoins()+6);
            human1.setName("Town's Guard"); human2.setName("Town's tall Guard");
            human1.setHealth(10); human1.setAttack(4); human1.setDefence(2);
            human2.setHealth(12); human2.setAttack(5); human2.setDefence(1);
            level.fourthChoiceStory();
            level.fourthChoices();
            if (level.getFourthchoiceinlevel()==1) {
                level.fourthChoicePay();enteredTown=true;
            } else if (level.getFourthchoiceinlevel()==2) {
                level.fourthChoiceSlap();
                combatAgainstThree(human1, human2, human3,2);
                level.fourthSlapBackRewars();slappedTheGuards=true;
            } else if (level.getFourthchoiceinlevel()==3) { System.out.println("You wonder out into the woods to sleep"); sleptInTheWoods=true;}

            // break off of events one where you are in the town, perhaps one of each method of getting in
            //and one for sleeping in the woods
            if (enteredTown) {
                level.enteredTownPaid();
            } else if (slappedTheGuards) {
                level.enterTownAfterSlap();
                if (level.getFightAfterSlap()==1) {
                    human1.setName("Town's Guard #1"); human2.setName("Town's Guard #2");
                    human1.setHealth(14); human1.setAttack(6); human1.setDefence(2);
                    human2.setHealth(14); human2.setAttack(5); human2.setDefence(2);
                    human3.setInUse(true); // initialising the already set creature3

                }
            } else if (sleptInTheWoods) {
                System.out.println("Not complete yet -2");
            }

    }


    public void combatAgainstThree(Creature creature, Creature creature2, Creature creature3, int x) {

        boolean combatInProgress=true;


        while (combatInProgress) {

            System.out.println("******************************************");
            creatureCheck(creature);
            creatureCheck(creature2);
            creatureCheck(creature3);
            System.out.println("******************************************");

            if (player.isAlive()){System.out.println(player.getName() + " Your are alive | " + player.getHealth() + " Health  left");
                System.out.println("----------------------------------------");}

            System.out.println("Choose which opponent you would attack!\n" +
                        "Front/right = 1, Behind/left = 2, Middle = 3"); //attackChoice = input.nextInt();

        //TODO to be deleted or implemented, is more of a nice thing to have
           /* if (!creature.opponentAlive()) { System.out.println(creature.getName() + " is dead DimWit!!");
                    if (!creature2.opponentAlive() && creature3.opponentAlive()) {attackChoice=3;}
                    if (creature2.opponentAlive() && creature3.opponentAlive()) {attackChoice=2;}                       }
            else if (!creature2.opponentAlive()) {System.out.println(creature2.getName() + " is dead DimWit!!");
                    if (!creature.opponentAlive() && creature3.opponentAlive()) { attackChoice=3;}
                    if (creature.opponentAlive() && ! creature3.opponentAlive()) {attackChoice = 1;}                    }
            else if (!creature3.opponentAlive()) {System.out.println(creature3.getName() + " is dead dimWit!!");
                    if (!creature.opponentAlive() && creature2.opponentAlive()) {attackChoice=2;}
                    if (creature.opponentAlive() && !creature2.opponentAlive()) {attackChoice=1;} */

        attackChoice=input.nextInt();
            combatFillAttackPart(creature, creature2, creature3, x);}

        }



public void creatureCheck(Creature creature) {
        for (int i = 0; i <1; i ++) {
    if (creature.opponentAlive() && creature.inUse) {System.out.println("*** "+ creature.getName() + " is alive | " + creature.getHealth() + " Health left ***"); }
    else if (!creature.opponentAlive() && creature.inUse) {System.out.println(creature.getName() + " Have been defeated"); }              } }



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
    public void firstCombatCombo() {
        human1.setHealth(6); human1.setAttack(4); human1.setDefence(1); human1.setName("Bandit #1"); human1.setInUse(true);
        human2.setHealth(7); human2.setAttack(5); human2.setDefence(2); human2.setName("Bandit #2"); human2.setInUse(true);
        human3.setInUse(false); // just in case
    }



        public void combatFillAttackPart(Creature creature, Creature creature2, Creature creature3, int x) { // the x to be able to set which would the first, second or third.

            System.out.println(attackChoice);
            if (attackChoice == 1) {
                int playerDamage = useGenerate(player); // made use of this instead to shorten the code written
                System.out.println("You are attacking: " + creature.getName() + " | with " + playerDamage + " Damage!");

                if (creature.getDefence() - playerDamage==-2) { System.out.println("Your damage broke through their defence of: " + creature.getDefence());creature.setHealth(creature.getHealth()-playerDamage); }
                else if (creature.getDefence() - playerDamage==-1) {System.out.println("Your damage slipped through their defence of: " + creature.getDefence());creature.setHealth(creature.getHealth()- playerDamage); }
                else if (creature.getDefence() == playerDamage) {System.out.println("Their defence are this attack's match!");creature.setHealth(creature.getHealth()-1); }
                else if (creature.getDefence() -playerDamage==1) {System.out.println("Their defence are superior!"); }
                else if (creature.getDefence() - playerDamage==2) {System.out.println("Maybe run? perhaps"); }
                else {creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());}
                retaliateCreature(creature,creature2,creature3); }
            else if (attackChoice == 2) {
                int playerDamage = useGenerate(player);
                System.out.println("You are attacking: " + creature2.getName() + " | with " + playerDamage + " Damage!");

                if (creature2.getDefence() - playerDamage==-2) { System.out.println("Your damage broke through their defence of: " + creature2.getDefence());creature2.setHealth(creature2.getHealth()-playerDamage); }
                else if (creature2.getDefence() - playerDamage==-1) {System.out.println("Your damage slipped through their defence of: " + creature2.getDefence());creature2.setHealth(creature2.getHealth()- playerDamage); }
                else if (creature2.getDefence() == playerDamage) {System.out.println("Their defence are this attack's match!");creature2.setHealth(creature2.getHealth()-1); }
                else if (creature2.getDefence() -playerDamage==1) {System.out.println("Their defence are superior!"); }
                else if (creature2.getDefence() - playerDamage==2) {System.out.println("Maybe run? perhaps"); }
                else {creature2.setHealth(creature2.getHealth() - playerDamage + creature2.getDefence());}
                retaliateCreature(creature,creature2,creature3); }
            else if ( attackChoice == 3) {
                int playerDamage = useGenerate(player);
                System.out.println("You are attacking: " + creature3.getName() + " | With " + playerDamage + " Damage!");
                if (creature3.getDefence() - playerDamage==-2) { System.out.println("Your damage broke through their defence of: " + creature3.getDefence());creature3.setHealth(creature3.getHealth()-playerDamage); }
                else if (creature3.getDefence() - playerDamage==-1) {System.out.println("Your damage slipped through their defence of: " + creature3.getDefence());creature3.setHealth(creature3.getHealth()- playerDamage); }
                else if (creature3.getDefence() == playerDamage) {System.out.println("Their defence are this attack's match!");creature3.setHealth(creature3.getHealth()-1); }
                else if (creature3.getDefence() -playerDamage==1) {System.out.println("Their defence are superior!"); }
                else if (creature3.getDefence() - playerDamage==2) {System.out.println("Maybe run? perhaps"); }
                else {creature3.setHealth(creature3.getHealth() - playerDamage + creature3.getDefence());}
                retaliateCreature(creature,creature2,creature3); }

            }

            public int useGenerate(Creature creature) {
               return Calculation.generateRandomInt(creature.getAttack());
            }
            public boolean checkRetaliate(Creature creature) {
                return creature.opponentAlive() && creature.inUse;
            }

            public void retaliateCreature(Creature creature, Creature creature2, Creature creature3) {
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
                            System.out.println(creature.getName()+" Attack equals our defence! (-1 hp)");
                            player.setHealth(player.getHealth() - 1); }
                        else if (player.getDefence() - addDamage == 1) {
                            System.out.println(creature.getName()+" Discover your defence superior!"); }
                        else if (player.getDefence() - addDamage == 2) {
                            System.out.println(creature.getName() +" Attack stood no chance against your defence!"); } }
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
                            System.out.println(creature2.getName() + " Attack equals our defence! (-1 hp)");
                            player.setHealth(player.getHealth() - 1); }
                        else if (player.getDefence() - addDamage2 == 1) {
                            System.out.println(creature2.getName() + " Discover your defence superior!"); }
                        else if (player.getDefence() - addDamage2 == 2) {
                            System.out.println(creature2.getName() +" Attack stood no chance against your defence!"); } }
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
                            System.out.println(creature3.getName() + " Attack equals our defence! (-1 hp)");
                            player.setHealth(player.getHealth() - 1); }
                        else if (player.getDefence() - addDamage3 == 1) {
                            System.out.println(creature3.getName() +" Discover your defence superior!"); }
                        else if (player.getDefence() - addDamage3 == 2) {
                            System.out.println(creature3.getName() + " Attack stood no chance against your defence!"); } }
                    else {
                        System.out.println(creature.getName() + " Dealt you " + addDamage3 + " Damage" + " mitigated by your defence of: " + player.getDefence());
                        player.setHealth(player.getHealth() - addDamage3 + player.getDefence()); }
            }


} }



