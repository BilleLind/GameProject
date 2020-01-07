package Game;

import java.util.Scanner;

public class Game extends Main{
    Scanner input = new Scanner(System.in);
    String choice;
    String action = choice, kill = "kill", wound = "wound", subdue = "subdue", winOver = "winOver", flee ="flee", talk="talk";

    int choiceNumber;



    public void gameRunning(){
        boolean running = true;

        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character");
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
            kvothe.setChanceOfWinningOver(0.01);




            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + kvothe.getName());
            System.out.println("Your character have: " + kvothe.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else {
            System.out.println("Error - please choose 1");
            yourChoice = input.nextInt(); }


        while (running) {
           Levels level = new Levels();
           level.preStoryKvothe();
           System.out.println("");
           level.firstChoices();
           choice();


        }
    }

    public void theDifferentActions() {
        Levels levelChoice = new Levels();

        if (choiceNumber == 1) {
            levelChoice.firstChoices();
        } else if (choiceNumber == 2) {

        }
    }

    public String choice() {   // the choice method -
        System.out.println("Please choose a Action");
        System.out.println();
        Scanner input = new Scanner(System.in);
        choice=input.next();
        if (choice=="kill") {
            return action="Kill";
        }else if (choice=="wound") {
           return action="wound";
        }else if (choice=="subdue") {
            return action="sudbue";
        }else if (choice=="winOver") {
            return action="winOver";
        }else if (choice=="flee") {
           return action="flee";}
        else if (choice=="talk") {
            return action="talk";}
        else {return action=null;}

    }



}
