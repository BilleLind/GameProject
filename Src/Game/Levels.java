package Game;

import java.util.Scanner;

public class Levels {
        Scanner input = new Scanner(System.in);
        private String levelName;
        private int levelNumber;
        Game game = new Game();
        private int numberOfAdversaries; //the mininum number of needed to encounter - maybe a "bonus boss"
        private int difficulty; // 1 easy, 2 little harder 3 medium and so on
        Player player = new Player();


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
        }

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
                player.setCoins(4);
                player.setHealth(24);
                player.setWeapon(2);
                System.out.println("After killing the bandits you find a decent weapon and " + player.getCoins() + "coins!");
                System.out.println("You find some meat and decide to rest up");    }
        public void firstBackStorySubdued() {
                player.setCoins(10);
                player.setWeapon(3);
                player.setHealth(25);
                System.out.println("After subduing the enemy, you steal a fine sword from them");
                System.out.println("They give you their hidden coins for letting them live");
                System.out.println("Optained " +player.getCoins() + " Coins!"); }
        public void firstBackStoryFleeing() {
                player.setAttack(player.getAttack()-1);
                player.setHealth(17);
                System.out.println("while fleeing to the woods you get scratched and wounded");
                System.out.println("you wound you right hand and lost a bit of health");

        }

}

