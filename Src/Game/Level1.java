package Game;

public class Level1 extends Levels {

    public void preStoryKvothe(){
        System.out.println("in the times before one of the small wars considering the ancient wars all know\n" +
                "there were one who grew up among those who many saw lesser than them self's\n" +
                "he grew up among the Edema Ruh - son of one who mastered the stage and who one came from\n" +
                "higher standing than most" +" he was called kvothe");




    }

    public void firstChoices(){
        Game c = new Game();
        c.choiceNumber=1;
        System.out.println("After wandering many miles and months, locked away all the part that was wounded\n" +
                "you finally became awoken by the strange rustling of the leaves\n" +
                "Suddenly you have been blocked by 2 men on in front of you, the other behind you\n" +
                "with the roads blocked and thick trees and uncertainty blocking both sides\n" +
                "you are left with 3 choices");
        System.out.println("choice 1: Attack the on in front");
        System.out.println("choice 2: Take to the trees and flee");
        System.out.println("choice 3: ");
    }


}
