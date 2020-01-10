package Game;

import java.lang.reflect.AccessibleObject;
import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    String attack = "attack", wound = "wound", subdue = "subdue", winOver = "winOver", flee = "flee", talk = "talk", cheat = "cheat";
    Humans h = new Humans();



    public void gameRunning() {


        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (only 1)");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
            //can customize to your desire

            Player kvothe = new Player();
            kvothe.setName("Kvothe");
            kvothe.setHealth(20);
            kvothe.setBornWithTalent(3);
            kvothe.setWeapon(0);
            kvothe.setEquipment(0);
            kvothe.setAttack(3);
            kvothe.setDefence(2);
            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + kvothe.getName());  // to be displayed at the top of the program
            System.out.println("Your character have: " + kvothe.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else {
            System.out.println("Error - please choose 1");
            yourChoice = input.nextInt();
        }


        //TODO START OF "PROGRAM" perhaps not a loop as it goes back instead and reads the story
        Levels level = new Levels();
        Calculation calc = new Calculation();
        level.preStoryKvothe();
        System.out.println("");
        level.firstChoicesStory();
        level.firstChoices();

        if (level.getFirstchoiceinlevel()==10) {
            System.out.println("succes");
            h.human1Method();
            h.human2Method();
            System.out.println(h.human1.getAtk());
            System.out.println(h.human2.getAtk());



        } else if (level.getFirstchoiceinlevel()==5) {
            System.out.println("succes 2");

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

    public void choices() {   // the choice method -
        System.out.println("Please choose a Action");
        System.out.println();
        choice = input.next();
        switch (choice) {
            case "attack":
                System.out.println("attack");
             //   setFirstchoiceinlevel(1);

                break;
            case "wound":
                System.out.println("wound");
                //setFirstchoiceinlevel(2);

                break;
            case "subdue":
                System.out.println("subdue");
               // level.setFirstchoiceinlevel(3);

                break;
            case "winOver":
                System.out.println("winOver");
              //  level.setFirstchoiceinlevel(4);

                break;
            case "flee":
               /// level.setFirstchoiceinlevel(5);

                System.out.println("flee");

                break;
            case "talk":
                System.out.println("talk");
              //  level.setFirstchoiceinlevel(6);
                break;
            case "cheat":
                System.out.println("cheat");
             //   level.setFirstchoiceinlevel(10);
                break;
            default:
                System.out.println("failure");
                break;
        }
    }

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

}



