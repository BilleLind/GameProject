package Game;

import java.util.Scanner;

public class Game extends Main{
    Scanner input = new Scanner(System.in);
    String choice;
    String kill = "kill", wound = "wound", subdue = "subdue", winOver = "winOver", flee ="flee", talk="talk", cheat="cheat";

    int choiceNumber;



    public void gameRunning(){
        boolean running = true;

        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (only 1)");
        int yourChoice= input.nextInt();
        if (yourChoice==1) {
            Player kvothe = new Player();           // instead of kvothe could be possible to make a input so that the object of Player would always would be the name of the character => all kvothe replaced with that input
            kvothe.setName("Kvothe");               // it would make the Calculation.calculateKilling(INPUT.getChanceOfKilling )   and so on so it would get updated automatically
            kvothe.setHealth(20);                   // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
            //can customize to your desire
            kvothe.setNumberForChances(2);
            kvothe.setChanceOfKilling(0.1);
            kvothe.setChanceOfInjuring(0.2);
            kvothe.setChanceOfSubduing(0.12);
            kvothe.setChanceOfWinningOver(0.01); // this is un used at this moment




            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + kvothe.getName());  // to be displayed at the top of the program
            System.out.println("Your character have: " + kvothe.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else {
            System.out.println("Error - please choose 1");
            yourChoice = input.nextInt(); }


        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story
           Levels level = new Levels();
            Calculation calc= new Calculation();
           level.preStoryKvothe();
           System.out.println("");
           level.firstChoicesStory();
            level.firstChoices();

        System.out.println(level.getFirstchoiceinlevel());

           if (level.getFirstchoiceinlevel()==1) {
               System.out.println("you cheated!! number 2");
           }


           /*if(choices()==1) {
               // to be shortened and made into method later on
               System.out.println("Yeaah det virkede");
               break; // for now
           } else { System.out.println("øv :(");
               System.out.println(choices());} */



    }

   /* public void theDifferentActions() {
        Levels levelChoice = new Levels();

        if (choiceNumber == 1) {
            levelChoice.firstChoices();
        } else if (choiceNumber == 2) {

        }    } */

    public double choices() {   // the choice method -
        System.out.println("Please choose a Action");
        System.out.println();
        choice = input.next();
        if (choice.equals("kill")) {
            //  System.out.println("killed");

             return Calculation.calculateOneInFifth();
        }else if (choice.equals("wound")) {
            //  System.out.println("wound");
             return Calculation.calculateOneEight();

        }else if (choice.equals("subdue")) {
            //  System.out.println("subdue");

             return Calculation.calculateOneInHundred();
        }else if (choice.equals("winOver")) {
            //  System.out.println("winOver");

            return  Calculation.calculateOneInThousand();
        }else if (choice.equals("flee"))    {


            //  System.out.println("flee");
       return Calculation.calculateOneFourth();
        }else if (choice.equals("talk")) {
            //  System.out.println("talk");
             return Calculation.calculateOneInTenth();
        } else if (choice.equals("cheat")) {
            //  System.out.println("cheat");
                      return Calculation.calculateOne();}

        else {return 0;
            //System.out.println("failure");
        }}

   /* public double checkFirstChoice() {
        if (action=="kill") {
            return Calculation.calculateOneInFifth();

        }else if (action=="wound") {
            return Calculation.calculateOneEight();
        } else if (action=="subdue") {
            return Calculation.calculateOneInHundred();
        } else if (action=="winOver") {
            return Calculation.calculateOneInThousand();
        } else if (action=="flee") {
            return Calculation.calculateOneFourth();
        }else if (action=="talk") {
            return Calculation.calculateOneInTenth();
        }else if (action=="cheat") {
            return Calculation.calculateOne();
        }else {return 0;}   } */

        public void dividable() {
            Game c = new Game();

        }


}
