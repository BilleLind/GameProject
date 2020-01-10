package Game;

import java.util.Scanner;

public class Levels {
        Scanner input = new Scanner(System.in);
        private String levelName;
        private int levelNumber;

        private int numberOfAdversaries; //the mininum number of needed to encounter - maybe a "bonus boss"
        private int difficulty; // 1 easy, 2 little harder 3 medium and so on


        final double chanceOfBossEncounter=0.05; // 5%, times levelNumber so chances will be higher further one


        public void preStoryKvothe(){
                System.out.println("in the times before one of the small wars considering the ancient wars all know\n" +
                        "there were one who grew up among those who many saw lesser than them self's\n" +
                        "he grew up among the Edema Ruh - son of one who mastered the stage and who one came from\n" +
                        "higher standing than most" +" he was called kvothe");




        }

        public void firstChoicesStory(){
                //c.choiceNumber=1; dont need i think because of the theDifferentActions()
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
                boolean firstChoicesRunning=true;
                first: while (firstChoicesRunning) {
                        System.out.println("choice 1: Attack the on in front - attack");
                        System.out.println("choice 2: Take to the trees and flee - flee");
                        System.out.println("choice 3: Subdue Them - subdue");







}}}
