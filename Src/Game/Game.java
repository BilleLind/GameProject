package Game;

import java.util.Scanner;

public class Game extends Main{
    String choice;
    String action = choice, kill = "kill", wound = "wound", subdue = "subdue", winOver = "winOver";



    public void gameRunning(){
        boolean running = true;

        while (running) {
            Scanner input = new Scanner(System.in);
            System.out.println("Hello this is the menu for this game");
            System.out.println("************************************");
            System.out.println(" ");
            System.out.println("Please select Your character");
            int choice= input.nextInt();
            if (choice==1) {
                Player kvothe = new Player();           // instead of kvothe could be possible to make a input so that the object of Player would always would be the name of the character => all kvothe replaced with that input
                kvothe.setName("Kvothe");               // it would make the Calculation.calculateKilling(INPUT.getChanceOfKilling )   and so on so it would get updated automatically
                kvothe.setHealth(20);                   // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
                                                        //can customize to your desire
                kvothe.setNumberForChances(2);
                kvothe.setChanceOfKilling(0.1);
                kvothe.setChanceOfInjuring(0.2);
                kvothe.setChanceOfSubduing(0.12);
                kvothe.setChanceOfWinningOver(0.01);


                if (action.equals(kill)) {
                    double killingResult = Calculation.calculateKilling(kvothe.getChanceOfKilling(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    //killingResult returns 1 or 0 of result in Calculation.  so 1= opponent died, 0= opponents survived about 1/5 within 1000 tries dies
                }
                if (action.equals(wound)) {
                    double injuriedResult = Calculation.calculateInjuring(kvothe.getChanceOfInjuring(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // injured 2/5 in a 1000 tries 380-420 occurrence's
                }
                if (action.equals(subdue)) {
                    double subduedResult = Calculation.calculateSubduing(kvothe.getChanceOfSubduing(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // subdued 225-267 out of 1000 => 1/4
                }
                if (action.equals(winOver)) {
                    double winningOverResult = Calculation.calculateWinningOver(kvothe.getChanceOfWinningOver(), kvothe.getNumberForChances(), Calculation.generateRandomInt());
                    // 15-22 in 1000   0.02 => very rare
                }
                System.out.println("You have chosen character: " +choice);
                System.out.println("Your characters name is: " + kvothe.getName());
                System.out.println("Your character have: " + kvothe.getHealth() + " Health");
                System.out.println("Your character is generally skilled");

            } else {
                System.out.println("Error - please choose 1");
                choice = input.nextInt(); }

                                                                                                                            }
                                                                                                                              }

            public void choice() {   // the choice method -
                System.out.println("Please choose a Action");
                System.out.println();
                Scanner input = new Scanner(System.in);
                choice=input.next();
                if (choice=="kill") {
                    action="Kill";
                }else if (choice=="wound") {
                    action="wound";
                }else if (choice=="subdue") {
                    action="sudbue";
                }else if (choice=="winOver") {
                    action="winOver";
                }else {action=null;}
            }

            public void theDifferentActions() {
                System.out.println("");
            }





}
