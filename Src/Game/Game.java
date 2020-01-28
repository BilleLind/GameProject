package Game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    static Player player = new Player();

    boolean firstCombatWon = false, firstCombatFleet = false, firstCombatSubdued = false; // will be used for a victory sheet of sort
    boolean enteredTown = false, sleptInTheWoods = false, slappedTheGuards = false;
    int attackChoice;
    // making the adversaries up here so it can be called everywhere, could reuse them but would need to set them correctly as you need them creature3 being inUse false until being needed
    static Humans human1 = new Humans(0, 0, 0, "", false);
    static Humans human2 = new Humans(0, 0, 0, "", false);
    static Humans human3 = new Humans(0, 0, 0, "", false);

    static boolean combatInProgress = true;

    public void space() {
        System.out.println("***********************************************");
    }

    public void gameRunning() {
        Levels level = new Levels();
        space();
        System.out.println("***** 1. Choice - Kvothe the traveler *********\n" +
                "***** 2. Choice - Reshi the unkown ************");
        space();
        System.out.println("******* Please select Your character: *********");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            characterOne();
            level.preStoryKvothe();
        } else if (yourChoice == 2) {
            level.preStoryReshi();
            characterTwo();
        } else {System.out.println("Error - please choose 1 or 2");
        yourChoice=input.nextInt();}

        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story

        level.preStoryKvothe();
        space();
        System.out.println("Loading....");
        waitFor(20000);  // wait method first implement
        level.firstChoicesStory();
        waitFor(4000);
        space();
        level.firstChoices();
        if (level.getFirstchoiceinlevel() == 1) { // attack option
            firstCombatCombo();
            combatAgainstThree(human1, human2, human3, 2);
            firstCombatWon = true;
        } else if (level.getFirstchoiceinlevel() == 5) { // flee option
            if (Calculation.calculateOneEight() == 1) {
                firstCombatFleet = true;
            } else {
                combatAgainstThree(human1, human2, human3, 2);
                firstCombatWon = true;
            }
        } else if (level.getFirstchoiceinlevel() == 3) { //subdue option (aka op lucky option)
            if (Calculation.calculateOneInThousand() == 1) {
                firstCombatSubdued = true;
            } else {
                combatAgainstThree(human1, human2, human3, 2);
                firstCombatWon = true;
            }
        }

        if (firstCombatSubdued) {
            level.firstBackStorySubdued();
        } else if (firstCombatWon) {
            level.firstBackStoryKilling();
        } else if (firstCombatFleet) {
            level.firstBackStoryFleeing();
        }
        waitFor(8000);
        level.secondChoiceStory(); // reset of creature and creature2. with inUse already set
        secondCombatCombo();
        combatAgainstThree(human1, human2, human3, 2);

        level.secondBackStory();
        waitFor(5000);
        level.thirdChoiceStory();
        waitFor(4000);
        player.setCoins(player.getCoins() + 6);

        level.fourthChoiceStory();
        level.fourthChoices();
        if (level.getFourthchoiceinlevel() == 1) {
            level.fourthChoicePay();
            enteredTown = true;
        } else if (level.getFourthchoiceinlevel() == 2) {
            level.fourthChoiceSlap();
            thirdCombatCombo();
            combatAgainstThree(human1, human2, human3, 2);
            level.fourthSlapBackRewars();
            slappedTheGuards = true;
        } else if (level.getFourthchoiceinlevel() == 3) {
            System.out.println("You wonder out into the woods to sleep");
            sleptInTheWoods = true;}

        // break off of events one where you are in the town, perhaps one of each method of getting in
        //and one for sleeping in the woods
        if (enteredTown) {
            level.enteredTownPaid();
        }
        else if (slappedTheGuards) {
            level.enterTownAfterSlap();
            if (level.getFightAfterSlap() == 1) {
                fourthCombatCombo();
                combatAgainstThree(human1, human2, human3, 3);

            } else if (level.getFightAfterSlap() == 2) {
                level.enterTownSlapPaid();
                if (level.getSlapPaid() == 1) {
                    sleptInTheWoods = true;
                }
            } // same with this one (read below)

        } else if (sleptInTheWoods) { // this story line ends here, dies xD
            level.sleptInTheWoodsAfterTown();
        }


        if (level.getSlapPaid() == 2 || level.getSleptInTheStableFOrQuest() == 1) { // if slept in barn - going north split off   - method split off not possible with Level level = new Level
            level.questAfterTownStable();
            firstCombatMerchant();
            combatAgainstThree(human1, human2, human3, 2);
            level.afterFirstCombatMerchant();
            //TODO stops here but can continue, first do the second one


        }



        if (level.getSleptInTheStableFOrQuest() == 2) { //todo if slept in the inn - going south split off
            level.questAfterTownInn();
            System.out.println("LOL");
        }


    }


    public void combatAgainstThree(Creature creature, Creature creature2, Creature creature3, int x) {

        combatInProgress = true;


        while (combatInProgress) {

            System.out.println("***********************************************");
            creatureCheck(creature);
            creatureCheck(creature2);
            creatureCheck(creature3);
            System.out.println("***********************************************"); //47
            if (player.getName().equals("Kvothe")) {
                if (player.getHealth() >= 10) {
                    if (player.isAlive()) {
                        System.out.println("*** " + player.getName() + " Your are alive | " + player.getHealth() + " Health left  ***");
                        System.out.println("***********************************************");
                    }
                } else if (!player.isAlive()) {
                    combatInProgress = false;
                }
                if (player.getHealth() < 10) {
                    {
                        System.out.println("*** " + player.getName() + " Your are alive | " + player.getHealth() + " Health  left  ***");
                        System.out.println("***********************************************");
                    }
                }
            } else if (player.getName().equals("Reshi")) {
                if (player.getHealth() >= 10) {
                    if (player.isAlive()) {
                        System.out.println("*** " + player.getName() + " Your are alive | " + player.getHealth() + " Health left   ***");
                        System.out.println("***********************************************");
                    }
                }
                if (player.getHealth() < 10) {
                    {
                        System.out.println("*** " + player.getName() + " Your are alive | " + player.getHealth() + " Health left    ***");
                        System.out.println("***********************************************");
                    }
                }
            }


            System.out.println("*** Choose which opponent you would attack! ***\n" +
                    "******* Right = 1, Left = 2, Middle = 3 *******");

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

            attackChoice = input.nextInt();
            combatFillAttackPart(creature, creature2, creature3, x);
        }

    }


    public void creatureCheck(Creature creature) {
        String compare = "længdepå9";
        String star = "";
        if (creature.getHealth() < 10) {
            star = "*";
        }
        int i;
        if (!creature.inUse) {
            i = 2;
        }
        for (i = 0; i < 1; i++) {
            if (creature.getName().length() < 8) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health lef        ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated             ***");
                }
            }
            if (creature.getName().length() == 8) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left      ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated             ***");
                }
            }
            if (creature.getName().length() == compare.length()) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left     ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated            ***");
                }
            }
            if (creature.getName().length() == 10) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left    ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated           ***");
                }
            }
            if (creature.getName().length() == 11) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left   ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated          ***");
                }
            }
            if (creature.getName().length() == 12) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left  ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated         ***");
                }
            }
            if (creature.getName().length() == 13) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left ***" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated        ***");
                }
            }
            if (creature.getName().length() == 14) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left **" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated       ***");
                }
            }
            if (creature.getName().length() == 15) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left *" + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated       **");
                }
            }
            if (creature.getName().length() == 16) {
                if (creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " is alive | " + creature.getHealth() + " Health left " + star);
                } else if (!creature.opponentAlive() && creature.inUse) {
                    System.out.println("*** " + creature.getName() + " Have been defeated      **");
                }
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

    public void firstCombatCombo() {
        human1.setHealth(6);
        human1.setAttack(4);
        human1.setDefence(1);
        human1.setName("Bandit #1");
        human1.setInUse(true);
        human2.setHealth(7);
        human2.setAttack(5);
        human2.setDefence(2);
        human2.setName("Bandit #2");
        human2.setInUse(true);
        human3.setInUse(false); // just in case
    }

    public void secondCombatCombo() {
        human1.setName("Bandit friend");
        human2.setName("Bandit's Brother");
        human1.setHealth(6);
        human1.setAttack(4);
        human1.setDefence(1);
        human2.setHealth(8);
        human2.setAttack(5);
        human2.setDefence(2);
    }

    public void thirdCombatCombo() {
        human1.setName("Town Guard");
        human2.setName("Town lookout");
        human1.setHealth(10);
        human1.setAttack(4);
        human1.setDefence(2);
        human2.setHealth(12);
        human2.setAttack(5);
        human2.setDefence(1);
    }

    public void fourthCombatCombo() {
        human1.setName("Town's Guard #1");
        human2.setName("Town's Guard #2");
        human1.setHealth(14);
        human1.setAttack(6);
        human1.setDefence(2);
        human2.setHealth(14);
        human2.setAttack(5);
        human2.setDefence(2);
        human3.setName("Town's Guard #3");
        human3.setHealth(8);
        human3.setAttack(4);
        human3.setDefence(1);
        human3.setInUse(true); // initialising the already set creature3 - wouldn't initialise, so i am setting it like the others
    }

    public void firstCombatMerchant() {
        human1.setName("Thug #2");
        human2.setName("Thug #3");
        human1.setHealth(15);
        human1.setAttack(6);
        human1.setDefence(2);
        human2.setHealth(16);
        human2.setAttack(6);
        human2.setDefence(1);
        human3.setInUse(false);
    }

    public void waitFor(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public void combatFillAttackPart(Creature creature, Creature creature2, Creature creature3, int x) { // the x to be able to set which would the first, second or third.

        System.out.println(attackChoice);
        if (attackChoice == 1) {
            int playerDamage = useGenerate(player); // made use of this instead to shorten the code written
            System.out.print("You are attacking: " + creature.getName() + " | with " + playerDamage + " Damage! | ");
            if (creature.getHealth() <= 0) {
                System.out.println("You target is dead, wtf?");
                attackChoice = 2;
            }

            if (creature.getDefence() - playerDamage == -2) {
                System.out.println("Your damage broke through their defence of: " + creature.getDefence());
                creature.setHealth(creature.getHealth() - playerDamage);
            } else if (creature.getDefence() - playerDamage == -1) {
                System.out.println("Your damage slipped through their defence of: " + creature.getDefence());
                creature.setHealth(creature.getHealth() - playerDamage);
            } else if (creature.getDefence() == playerDamage) {
                System.out.println("Their defence are this attack's match!");
                creature.setHealth(creature.getHealth() - 1);
            } else if (creature.getDefence() - playerDamage == 1) {
                System.out.println("Their defence are superior!");
            } else if (creature.getDefence() - playerDamage == 2) {
                System.out.println("Maybe run? perhaps");
            } else {
                creature.setHealth(creature.getHealth() - playerDamage + creature.getDefence());
            }
            retaliateCreature(creature, creature2, creature3);
        } else if (attackChoice == 2) {
            int playerDamage = useGenerate(player);
            System.out.print("You are attacking: " + creature2.getName() + " | with " + playerDamage + " Damage! | ");
            if (creature2.getHealth() <= 0) {
                System.out.println("You target is dead, wtf?");
                attackChoice = 3;
            }
            if (creature2.getDefence() - playerDamage == -2) {
                System.out.println("Your damage broke through their defence of: " + creature2.getDefence());
                creature2.setHealth(creature2.getHealth() - playerDamage);
            } else if (creature2.getDefence() - playerDamage == -1) {
                System.out.println("Your damage slipped through their defence of: " + creature2.getDefence());
                creature2.setHealth(creature2.getHealth() - playerDamage);
            } else if (creature2.getDefence() == playerDamage) {
                System.out.println("Their defence are this attack's match!");
                creature2.setHealth(creature2.getHealth() - 1);
            } else if (creature2.getDefence() - playerDamage == 1) {
                System.out.println("Their defence are superior!");
            } else if (creature2.getDefence() - playerDamage == 2) {
                System.out.println("Maybe run? perhaps");
            } else {
                creature2.setHealth(creature2.getHealth() - playerDamage + creature2.getDefence());
            }
            retaliateCreature(creature, creature2, creature3);
        } else if (attackChoice == 3) {
            int playerDamage = useGenerate(player);
            System.out.println("You are attacking: " + creature3.getName() + " | With " + playerDamage + " Damage!");
            if (creature3.getHealth() <= 0) {
                System.out.println("You target is dead, wtf?");
                attackChoice = 1;
            }
            if (creature3.getDefence() - playerDamage == -2) {
                System.out.println("Your damage broke through their defence of: " + creature3.getDefence());
                creature3.setHealth(creature3.getHealth() - playerDamage);
            } else if (creature3.getDefence() - playerDamage == -1) {
                System.out.println("Your damage slipped through their defence of: " + creature3.getDefence());
                creature3.setHealth(creature3.getHealth() - playerDamage);
            } else if (creature3.getDefence() == playerDamage) {
                System.out.println("Their defence are this attack's match!");
                creature3.setHealth(creature3.getHealth() - 1);
            } else if (creature3.getDefence() - playerDamage == 1) {
                System.out.println("Their defence are superior!");
            } else if (creature3.getDefence() - playerDamage == 2) {
                System.out.println("Maybe run? perhaps");
            } else {
                creature3.setHealth(creature3.getHealth() - playerDamage + creature3.getDefence());
            }
            retaliateCreature(creature, creature2, creature3);
        }


        if (creature.getHealth() <= 0 && creature.inUse) {

            if (!creature2.inUse && !creature3.inUse) {combatInProgress = false; }
            if (creature2.getHealth() <= 0 && creature2.inUse) {
                if (!creature3.inUse) {combatInProgress = false;}
                if (creature3.inUse && creature3.getHealth() <= 0) {combatInProgress = false;}
            }
        }
    }

    public int useGenerate(Creature creature) {
        return Calculation.generateRandomInt(creature.getAttack());
    }

    public boolean checkRetaliate(Creature creature) {
        return creature.opponentAlive() && creature.inUse;
    }

    public void retaliateCreature(Creature creature, Creature creature2, Creature creature3) {
        if (checkRetaliate(creature)) { // it keep saying that is is duplicated yet i cannot make it more short
            int addDamage = useGenerate(creature);
            int pDef = player.getDefence();
            int defMinusDamage = addDamage - pDef;
            if (defMinusDamage > 0) {System.out.println(creature.getName() + " dealt you " + defMinusDamage + " Damage!");
                player.setHealth(player.getHealth() - defMinusDamage); }
            else if (defMinusDamage == 0) { player.setHealth((player.getHealth() - 1));
                System.out.println(creature.getName() + " Attacked equals your defence (-1 Hp"); }
            else if (defMinusDamage < 0) { System.out.println("Player def to great for " + creature.getName() + " Attack"); }
            else {System.out.println("Faliure in the attack 2"); }}
        if (checkRetaliate(creature2)) {
            int addDamage = useGenerate(creature2);
            int pDef = player.getDefence();
            int defMinusDamage = addDamage - pDef;
            if (defMinusDamage > 0) {System.out.println(creature2.getName() + " dealt you " + defMinusDamage + " Damage!");
                player.setHealth(player.getHealth() - defMinusDamage); }
            else if (defMinusDamage == 0) { player.setHealth((player.getHealth() - 1));
                System.out.println(creature2.getName() + " Attacked equals your defence (-1 Hp"); }
            else if (defMinusDamage < 0) { System.out.println("Player def to great for " + creature2.getName() + " Attack"); }
            else {System.out.println("Faliure in the attack 2"); } }
        if (checkRetaliate(creature3)) {
            int addDamage = useGenerate(creature3);
            int pDef = player.getDefence();
            int defMinusDamage = addDamage - pDef;
            if (defMinusDamage > 0) {System.out.println(creature3.getName() + " dealt you " + defMinusDamage + " Damage!");
                player.setHealth(player.getHealth() - defMinusDamage); }
            else if (defMinusDamage == 0) { player.setHealth((player.getHealth() - 1));
                System.out.println(creature3.getName() + " Attacked equals your defence (-1 Hp"); }
            else if (defMinusDamage < 0) { System.out.println("Player def to great for " + creature3.getName() + " Attack"); }
            else {System.out.println("Faliure in the attack 3"); }    }
    }
}



