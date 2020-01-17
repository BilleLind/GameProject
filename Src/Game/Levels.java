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
                System.out.println("in the times before one of the small wars considering the ancient wars all know\n" +
                        "there were one who grew up among those who many saw lesser than them self's\n" +
                        "he grew up among the Edema Ruh - son of one who mastered the stage and who one came from\n" +
                        "higher standing than most" + " he was called kvothe");


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
                System.out.println("choice 1: Attack the on in front - attack");
                System.out.println("choice 2: Take to the trees and flee - flee");
                System.out.println("choice 3: Subdue Them - subdue");
                boolean firstChoiceRunning = true;
                firstChoiceLoop:
                while (firstChoiceRunning) {
                        game.choice = input.next();
                        switch (game.choice) {
                                case "attack":
                                        System.out.println("attacking");
                                        setFirstchoiceinlevel(1);
                                        break firstChoiceLoop;
                                case "flee":
                                        System.out.println("fleeing");
                                        setFirstchoiceinlevel(5);
                                        break firstChoiceLoop;
                                case "subdue":
                                        System.out.println("subduing");
                                        setFirstchoiceinlevel(3);
                                        break firstChoiceLoop;
                                case "cheat":
                                        System.out.println("Cheating");
                                        setFirstchoiceinlevel(10);
                                        break firstChoiceLoop;
                                default:
                                        System.out.println("failure");
                                        continue firstChoiceLoop;
                        }

                }
        }
        public void firstBackStoryKilling() {
                // the text after killing them
               //unable to set the values of player in here, it won't change it while using it later
                System.out.println("After killing the bandits you find a decent weapon and " + Game.player.getCoins() + " coins!");
                System.out.println("You find some meat and decide to rest up");    }
        public void firstBackStorySubdued() {
                System.out.println("After subduing the enemy, you steal a fine sword from them");
                System.out.println("They give you their hidden coins for letting them live");
                System.out.println("Obtained " + Game.player.getCoins() + " Coins!"); }
        public void firstBackStoryFleeing() {
                System.out.println("while fleeing to the woods you get scratched and wounded");
                System.out.println("you wound you right hand and lost a bit of health"); }


        public void secondChoiceStory() {
                System.out.println("After Resting a while i decide to head on toward the town\n " +
                        "while walking you are confronted by 2 stranger\ns" +
                        "they seem angry and ask you how you have come through this way\n"+
                        "you tell them what happened and they charge you\n"); }
        public void secondBackStory() {
                System.out.println("Weary after fighting 2 sets of enemies in one day\n" +
                        "you decide to find shelter in a nearby cave");
        }
        public void thirdChoiceStory() {
                System.out.println("After a well deserved rest, you head out of the cave and towards the road\n" +
                        " you decide to head on toward the nearby town, thinking there are no more bandit's\n" +
                        "You come across chest of coins!\n");
        }

        public void fourthChoiceStory() {
                System.out.println("you come across a town, you are stopped by 2 guards\n" +
                        "they demand payment for entry, 4 coins out of your" + Game.player.getCoins() +" coins\n" );
        }
        private  int fourthchoiceinlevel;

        public void setFourthchoiceinlevel(int fourthchoiceinlevel) {
                this.fourthchoiceinlevel = fourthchoiceinlevel;
        }

        public int getFourthchoiceinlevel() {
                return fourthchoiceinlevel;
        }

        public void fourthChoices() {
                System.out.println("You are left with 3 choices\n" +
                        "1. pay them and enjoy the comforts of sleeping in a bed\n" +
                        "2. slap on of them and see where it leads\n" +
                        "3. leave");
                boolean fourthchoice=true;
                while (fourthchoice) {
                        game.choice=input.next();
                        switch (game.choice) {
                                case "pay them":
                                        System.out.println("Paying");
                                        setFourthchoiceinlevel(1);
                                        fourthchoice=false;
                                case  " slap":
                                        System.out.println("Slapping");
                                        setFourthchoiceinlevel(2);
                                        fourthchoice=false;
                                case "leave":
                                        System.out.println("Leaving");
                                        setFourthchoiceinlevel(3);
                                        fourthchoice=false;
                        }
                }
        }


}

