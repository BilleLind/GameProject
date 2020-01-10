package Game;

import java.lang.reflect.AccessibleObject;
import java.util.Scanner;

public class Game extends Main {
    Scanner input = new Scanner(System.in);
    String choice;
    String attack = "attack", wound = "wound", subdue = "subdue", winOver = "winOver", flee = "flee", talk = "talk", cheat = "cheat";
    Humans h = new Humans();
    Player player = new Player();


    public void gameRunning() {


        System.out.println("Hello this is the menu for this game");
        System.out.println("************************************");
        System.out.println(" ");
        System.out.println("Please select Your character (only 1)");
        int yourChoice = input.nextInt();
        if (yourChoice == 1) {
            // that would delete the requirement for the choice between 1 2 or 3.... and just ask for the name at the start or 1, 2, 3 and 4 are premade and the fifth are the one you
            //can customize to your desire


            player.setName("Kvothe");
            player.setHealth(20);
            player.setBornWithTalent(3);
            player.setWeapon(0);
            player.setEquipment(0);
            player.setAttack(3);
            player.setDefence(2);
            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + player.getName());  // to be displayed at the top of the program
            System.out.println("Your character have: " + player.getHealth() + " Health");
            System.out.println("Your character is generally skilled");

        } else if (yourChoice==2) {
            player.setName("Reshi");
            player.setHealth(18);
            player.setDefence(4);
            player.setAttack(4);
            player.setEquipment(0);
            player.setWeapon(0);
            player.setBornWithTalent(4);
            System.out.println("You have chosen character: " + yourChoice);
            System.out.println("Your characters name is: " + player.getName());
            System.out.println("Your character have: " + player.getHealth() + " Health");
        }else{
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

        if (level.getFirstchoiceinlevel()==1) {
            System.out.println("success");
            h.human1Method();
            h.human2Method();
            System.out.println(h.human1.getAtk());
            System.out.println(h.human2.getAtk());
            //make a combat method,
            // if (yourChoice==1) {kvothe.get....  => String playerName; => playerName=kvothe  so i only need to write the get methods one time
            if (yourChoice==1) {
                //player.getHealth();
                //System.out.println(player.getHealth());
                combatMethod();
            } else if (yourChoice==2) {

                System.out.println(player.getHealth());
            }

        } else if (level.getFirstchoiceinlevel()==5) {
            System.out.println("success 2");

        }




    }

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

   public void combatMethod() {


      while (player.isAlive() ||h.human1.opponentAlive() && h.human2.opponentAlive()) // how to do this with different opponents?
       {
           System.out.println("yeaah");

        }
      //else if (!player.isAlive()) {
          //System.out.println("more yeaah");
      //}

   }

}



