package Game;

import java.util.Scanner;

public class Levels {
        Scanner input = new Scanner(System.in);
        private String levelName;
        private int levelNumber;
        Game game = new Game();
        private int numberOfAdversaries; //the mininum number of needed to encounter - maybe a "bonus boss"
        private int difficulty; // 1 easy, 2 little harder 3 medium and so on
        int coins, health, weapon, equipment, attack,defence;

        final double chanceOfBossEncounter = 0.05; // 5%, times levelNumber so chances will be higher further one


        public void preStoryKvothe() {
                System.out.println("in the times before one of the many small wars considering how great the ancient wars\n" +
                        "both in scale and of consequence that all know and fear\n" +
                        "there were one who grew up among those who many saw lesser than them self's\n" +
                        "he grew up among the Edema Ruh - son of one who mastered the stage and who one came from\n" +
                        "higher standing than most" + " he was called kvothe");
        }
        public void preStoryReshi() {
                System.out.println("in ancient times the races were many, now not many know of those who came before\n" +
                        "or walks among them, since they have the same skin, yet are greater than humans\n" +
                        "Reshi is one among those of the ancient lineage");
        }

        public void firstChoicesStory() {
                System.out.println("After wandering many miles and months, locked away all the parts that was wounded\n" +
                        "you finally became awoken by the strange rustling of the leaves\n" +
                        "Suddenly you have been blocked by 2 men on in front of you, the other behind you\n" +
                        "with the roads blocked and thick trees and uncertainty blocking both sides\n" +
                        "you are left with 3 choices");
        }

        private int firstchoiceinlevel;

        public int getFirstchoiceinlevel() {
                return firstchoiceinlevel;
        } //change to choiceInLevel to be resusable, would reset it everytime because set and get

        public void setFirstchoiceinlevel(int firstchoiceinlevel) {
                this.firstchoiceinlevel = firstchoiceinlevel;
        }

        public void firstChoices() {
                System.out.println("*** choice 1: 'Attack' the on in front      ***");
                System.out.println("*** choice 2: Take to the trees and 'flee'  ***");
                System.out.println("*** choice 3: 'Subdue' Them                 ***");
                boolean firstChoiceRunning = true;
                firstChoiceLoop:
                while (firstChoiceRunning) {
                        game.choice = input.next();
                        switch (game.choice) {
                                case "Attack":
                                case "attack":
                                case "1":
                                        setFirstchoiceinlevel(1);
                                        break firstChoiceLoop;
                                case "Flee":
                                case "flee":
                                case "2":
                                        setFirstchoiceinlevel(5);
                                        break firstChoiceLoop;
                                case "Subdue":
                                case "subdue":
                                case "3":
                                        setFirstchoiceinlevel(3);
                                        break firstChoiceLoop;
                                case "cheat":
                                        setFirstchoiceinlevel(10);
                                        break firstChoiceLoop;
                                default:
                                        System.out.println("failure");
                                        continue firstChoiceLoop;
                        }

                }
        }
        public void firstBackStoryKilling() {
                Game.player.setWeapon(2); Game.player.setHealth(24); Game.player.setCoins(4);
                System.out.println("After killing the bandits you find a decent weapon and " + Game.player.getCoins() + " coins!");
                System.out.println("You find some meat and decide to rest up");    }
        public void firstBackStorySubdued() {
                Game.player.setCoins(10); Game.player.setWeapon(3); Game.player.setHealth(25);
                System.out.println("After subduing the enemy, you steal a fine sword from them");
                System.out.println("They give you their hidden coins for letting them live");
                System.out.println("Obtained " +Game.player.getCoins() + " Coins!"); }
        public void firstBackStoryFleeing() {
                Game.player.setAttack(Game.player.getAttack()-1); Game.player.setHealth(17);
                System.out.println("while fleeing to the woods you get scratched and wounded");
                System.out.println("you wound you right hand and lost a bit of health"); }


        public void secondChoiceStory() {
                System.out.println("After Resting a while i decide to head on toward the town\n " +
                        "while walking you are confronted by 2 stranger's\n" +
                        "they seem angry and ask you how you have come through this way\n"+
                        "you tell them what happened and they charge you\n"); }
        public void secondBackStory() {
                System.out.println("Weary after fighting 2 sets of enemies in one day\n" +
                        "you decide to find shelter in a nearby cave\n" +
                        "There you find a small stash of things - some coins and equipment!");
                Game.player.setHealth(24);
                Game.player.setCoins(Game.player.getCoins()+2);
                System.out.println(Game.player.getCoins() + " coins!");
                Game.player.setEquipment(2);
        }
        public void thirdChoiceStory() {
                System.out.println("After a well deserved rest, you head out of the cave and towards the road\n" +
                        " you decide to head on toward the nearby town, thinking there are no more bandit's\n" +
                        "You come across chest of coins!\n");
        }
        public void fourthChoiceStory() {
                System.out.println("you come across a town, you are stopped by 2 guards\n" +
                        "they demand payment for entry, 4 coins out of your" + Game.player.getCoins() +" coins\n"); }

        private  int fourthchoiceinlevel;
        public void setFourthchoiceinlevel(int fourthchoiceinlevel) {this.fourthchoiceinlevel = fourthchoiceinlevel;}
        public int getFourthchoiceinlevel() {return fourthchoiceinlevel;}

        public void fourthChoices() {
                System.out.println("You are left with 3 choices\n" +
                        "1. 'pay' them and enjoy the comforts of sleeping in a bed\n" +
                        "2. 'slap' on of them and see where it leads\n" +
                        "3. 'leave' ");
                boolean fourthChoice=true;
                fourthChoiceWhile: while (fourthChoice) {
                        game.choice=input.next();
                        switch (game.choice) {
                                case "pay":
                                case "1":
                                        setFourthchoiceinlevel(1);
                                        fourthChoice=false;
                                case "slap":
                                case "2":
                                        setFourthchoiceinlevel(2);
                                        break fourthChoiceWhile;
                                case "leave":
                                case "3":
                                        setFourthchoiceinlevel(3);
                                        fourthChoice=false;
                                default:
                                        System.out.println("Failure - wrong entered");
                        }
                }
        }
        public void fourthChoicePay() {
                System.out.println("You pay them  4 coins out of your: " +Game.player.getCoins() + " Coins\n" );
                Game.player.setCoins(Game.player.getCoins()-4);}
        public void fourthChoiceSlap() {
                System.out.println("You Slap the one closets to you, the other attacks you right after it"); }
        public void fourthSlapBackRewars() {
                System.out.println("You come out in top and go into the town, feeling stronger ready for a nights rest");
                Game.player.setHealth(26);Game.player.setAttack(Game.player.getAttack()+1); }

                private int sleptInTheStableFOrQuest; // 1 for the stable quest 2 for inn quest

        public int getSleptInTheStableFOrQuest() {
                return sleptInTheStableFOrQuest;
        }

        public void setSleptInTheStableFOrQuest(int sleptInTheStableFOrQuest) {
                this.sleptInTheStableFOrQuest = sleptInTheStableFOrQuest;
        }

        public void enteredTownPaid() {
                System.out.println("The town is lively with several shops around, bustling with life\n" +
                        "While bargaining and discovering the town you figure out several offers you can take\n" +
                        "1. a bed to sleep in, food and ale for the night - for 4 coins\n" +
                        "2. sleep with the horses, a new stronger weapon - 8 coins\n" +
                        "3. all inclusive: weapon, a bed to sleep in and a cloak for the journey - 14 coins\n" +
                        "4. choose the items yourself");
                boolean enteredTownChoices=true;
                while (enteredTownChoices) {
                        game.choice=input.next();
                        switch (game.choice) {
                                case "1":
                                        System.out.println("Having decided on the inn you eat and drink your fill and turn in for the night");
                                        setSleptInTheStableFOrQuest(2);
                                        enteredTownChoices=false;
                                case "2":
                                        System.out.println("You cling tightly to your new weapon while sleeping in the rough");
                                        Game.player.setWeapon(Game.player.getWeapon()+3);
                                        setSleptInTheStableFOrQuest(1);
                                        enteredTownChoices=false;
                                case "3":
                                        System.out.println("Choosing to have it all, you celebrate");
                                        Game.player.setWeapon(Game.player.getWeapon()+3);
                                        Game.player.setEquipment(Game.player.getEquipment()+2);
                                        setSleptInTheStableFOrQuest(2);
                                        enteredTownChoices=false;
                                case "4":
                                        chooseTheOffers(); }
                }       }
        public void chooseTheOffers() {
                boolean check1=false, check2=false, check3=false, check4=false;
                boolean choosingTheOffers=true;
                System.out.println("You have these choices:\n" +
                        "1. The inn with a bed, food and ale - 4 coins\n" +
                        "2. The barn with the horses - 1 coin\n" +
                        "3. A stronger weapon - 7 coins\n" +
                        "4. A cloak to fend off the rain - 2 coins\n" +
                        "type 'exit' after having chosen");
                while (choosingTheOffers) {
                        System.out.println("You have: " + Game.player.getCoins() + " Coins left");}
                        String choiceBeeingMade =input.next();
                        switch (choiceBeeingMade) {
                                case "inn":
                                case "1":
                                        if (!check1) {
                                        System.out.println("You have paid 4 coins for a bed and a meal");
                                        Game.player.setCoins(Game.player.getCoins()-4);
                                                setSleptInTheStableFOrQuest(2);check1=true;}
                                        else {System.out.println("You already paid for the inn"); }

                                case "barn":
                                case "2":
                                        if (!check2) {
                                        System.out.println("You have paid 1 coin for the warm comfort of horse shit");
                                        Game.player.setCoins(Game.player.getCoins()-1);check2=true;
                                        setSleptInTheStableFOrQuest(1);}
                                        else {System.out.println("You already paid for the barn"); }
                                case "weapon":
                                case "3":
                                        if (!check3) {
                                                System.out.println("You choose to find a stronger weapon, Gaining 3 attack");
                                                Game.player.setWeapon(Game.player.getWeapon()+3);
                                                Game.player.setCoins(Game.player.getCoins()-7);check3=true;}
                                        else {System.out.println("You already paid for the inn"); }
                                case "cloak":
                                case "4":
                                        if (!check4) {
                                                System.out.println("You decide to be wise and get a cloak, boosting health with 2");
                                                Game.player.setEquipment(Game.player.getEquipment()+2);
                                                Game.player.setCoins(Game.player.getCoins()-2);check4=true;}
                                        else {System.out.println("You already paid for the inn"); }
                                case "exit":
                                        if (check1 || check2) {choosingTheOffers=false;
                                        } else System.out.println("You have to choose a place to sleep");} }

                                        private int fightAfterSlap;

        public int getFightAfterSlap() {
                return fightAfterSlap;
        }

        public void setFightAfterSlap(int fightAfterSlap) {
                this.fightAfterSlap = fightAfterSlap;
        }

        public void enterTownAfterSlap() {
                System.out.println("After having won over the guards, you stroll into the town feeling good with yourself\n" +
                                   "You spot a nice looking weapon and stroll over there, a while after looking at the weapon\n" +
                                   "You find yourself surrounded by 3 men in arms, they demand penance in the form of coins\n" +
                                   "For assaulting the guards - they demand 10 coins for the crime and banishment from the town\n" +
                                   "You have 2 choices\n" +
                                   "1. pay them 10 coins\n" +
                                   "2. say fuck it and attack them! ");
                boolean choicesForAfterSlapping=true;
                townAfterSlapping: while (choicesForAfterSlapping) {
                        String choiceBeingMade=input.next();
                        switch (choiceBeingMade) {
                                case "1":
                                        System.out.println("Went into 1 in choicesForAfterSlapping");
                                        if (Game.player.getCoins() >=10) {
                                        System.out.println("You pay them  10 coins of your" + Game.player.getCoins() + " Coins\n" );
                                        Game.player.setCoins(Game.player.getCoins()-10);
                                        setFightAfterSlap(2);break townAfterSlapping;}
                                        else if (Game.player.getCoins() <10) {
                                                System.out.println("Not enough Coins!");
                                                continue townAfterSlapping;}
                                case "2":
                                        System.out.println(choiceBeingMade + " choice being made");
                                        setFightAfterSlap(1);
                                        choicesForAfterSlapping=false;
                                        break townAfterSlapping;
                        }
                }

        }
        private int slapPaid;

        public void setSlapPaid(int slapPaid) {
                this.slapPaid = slapPaid;
        }

        public int getSlapPaid() {
                return slapPaid;
        }

        public void enterTownSlapPaid() {
                if (Game.player.getCoins() <0) {
                System.out.println("After having paid them you walk around and try to decide what to do with the remainder\n" +
                        "of your coins. only having: " + Game.player.getCoins() + " Coins left\n" +
                        "Leaves you with 2 choices\n" +
                        "1. go hunt bandits in the woods\n" +
                        "2. sleep in a staple");
                boolean choiceforslapPaid = true;
                townSlapPaid: while(choiceforslapPaid) {
                String choiceBeingMade=input.next();
                switch (choiceBeingMade) {
                        case "1":
                                if (Game.player.getCoins() ==0) {System.out.println("not any money you wonder into the woods for a payday");
                                        setSlapPaid(1); break townSlapPaid; }
                                else {System.out.println("You choose to keep the money for another day");
                                        setSlapPaid(1); break townSlapPaid;}

                        case "2":
                                 if (Game.player.getCoins()<=1) {
                                        System.out.println("You pay the stable boy to sleep there for the night");
                                        Game.player.setCoins(Game.player.getCoins()-1);
                                         setSleptInTheStableFOrQuest(1);
                                        setSlapPaid(2); break townSlapPaid; } } } }
        }
        public void sleptInTheWoodsAfterTown() {
                System.out.println("Time go by faster than expected, having found a nice dry cave with running clean water nearby\n" +
                        "you scavenge the nearby surroundings, in the start for bandits, later more and more for food\n" +
                        "time go by....");
                int health = Game.player.getHealth();
                for (int i =0; i <10; i++) {
                        game.waitFor(1000);
                        System.out.println("Day " + i);}
                System.out.println("You find a field filled with mushroom and decide to make a stew!");
                for (int d =0; d < 30; d++) {
                        System.out.println("Day " + d + "|" + health + " Health");
                        Game.player.setHealth(health-1);
                        if (Game.player.getHealth() ==10) {
                                System.out.println("You decide you have lived your live like your wanted and enjoy the last of it"); }
                        if (Game.player.getHealth() ==5) {
                                System.out.println("Birds have built a nest above your cave's opening, you are left with a smile"); }
                        if (Game.player.getHealth() ==0) {
                                System.out.println("Many months later villagers find your body, after fighting dragon sized birds!\n" +
                                        "they figure out your body + the mushrooms made things go big, since you too look like a giant!");}
                game.waitFor(2000);}

        }

        public void questAfterTownStable() {
                System.out.println("A merchant approaches you the day after leaving the barn with a quest of a sort\n" +
                        "she ask you if you want to be a guard while going to northern country Leagaria capital Falaria\n" +
                        "with nothing better to do and the promise of a worthwhile pay, you accept and go with");
                game.waitFor(10000);
                System.out.println("The Road to Falaria is long, yet well traveled, meeting many travelers, some kind\n" +
                        "sharing their fire place other hostile...\n" +
                        "Shouting begin waking you up for your midday nap, you grap you weapon and jump out of the wagon\n" +
                        "you are faced against 2 thugs, the merchant fighting against a third");
        game.waitFor(8000);}
        public void afterFirstCombatMerchant() {
                System.out.println("Having defeated the thugs you discover that the merchant is strong, having dealt with the third thug herself\n" +
                        "Time go by and you arrive safely in Falaria\n" +
                        "To be Continued ;-D"); }





        public void questAfterTownInn() {
                // if sleep in inn then a more refined quest and in stable a merchant. inn => higher reward/ harder quest
                System.out.println("A noble approaches you the day after while you are having your breakfast\n" +
                        "having asked for permission to sit, you allow him to do so\n" +
                        "He heard tales of your exploits, having dealt 2 enemies at once, 2 days in a row\n" +
                        "you are offered the job of guarding him while travelling to the southern province\n" +
                        "You will be paid 20 golden coins! ");
                game.waitFor(10000);
                System.out.println("The road is well build, and even being in the back of the carriage is comfortable\n" +
                        "you slowly fall asleep...");
                game.waitFor(4000);
                System.out.println("You awake finding yourself in noble clothes, with iron shackles on!!\n" +
                        "there are barely any light and a eerie quiet atmosphere");
                for (int i = 0; i < 30; i ++) {
                        if (i==0){System.out.println("Times go bye, hoping something to happen");}

                        if (i==7){System.out.println("A week have gone bye, having lived on the drops of water coming through\n" +
                                        "the window and relying or deep meditation"); }
                        if (i==14) { System.out.println("2 weeks.... you begin to loose hope"); }
                        if (i==21) {System.out.println("3 weeks.....");}
                        if (i==29)  {System.out.println("You drift into a deep slumber...");
                                        Game.player.setHealth(0);}
                        game.waitFor(3000);
                }
        }




}









