package Game;

import java.util.Scanner;

public class Adversaries {
    //super class for all the different adversaries that the player will be fighting or encountering

private int hp;
private int atk;
private int def;
private String name;
private boolean inUse =false;
Player player = new Player();
Game game = new Game();
Scanner input = new Scanner(System.in);

public Adversaries(int hp, int atk, int def, String name) {
    this.hp = hp;
    this.atk = atk;
    this.def = def;
    this.name = name; }


    public  void combat(Adversaries adversaries, Adversaries adversaries2) {
    System.out.println("You have Encountered: " );
    System.out.println(adversaries.getName() + " With: " +adversaries.getHp() + " Health");
    if (adversaries2.getInUse()) {
        System.out.println(adversaries2.getName() + " With: " + adversaries2.getHp() + " Health"); }
    int addDamage = Calculation.generateRandomInt(adversaries.getAtk());
    int addDamage2 = Calculation.generateRandomInt(adversaries2.getAtk());
    int playerDamage = Calculation.generateRandomInt(player.getAttack());
    if (player.isAlive()) {
        System.out.println(player.getName() + " is alive");
        System.out.println(player.getHealth() + " Health left");
    } else if (!player.isAlive()) {
        System.out.println("You have been defeated!");
        //gameOver command something to stop it over in Game.class
        }
    if (adversaries.opponentAlive()) {
        System.out.println(adversaries.getName() + " is alive");
        System.out.println(adversaries.getHp() + " Health left");
    } else if (!adversaries.opponentAlive()) {
        System.out.println(adversaries.getName() + " Have been defeated");
    } if (adversaries2.opponentAlive() && adversaries2.getInUse()) {
        System.out.println(adversaries2.getName() + " is alive");
        System.out.println(adversaries2.getHp() + " Health left");
    }else if (!adversaries2.opponentAlive() && adversaries2.getInUse()) {
        System.out.println(adversaries2.getName() + " Have been defeated"); }

    if (adversaries2.getInUse()) {
        System.out.println("Choose which opponent you would attack!\n" +
                "Front/right = 1, Behind/left = 2");
        game.attackChoice=input.nextInt();
    } else {System.out.println("Attack the opponent!"); game.attackChoice=1; }

    if (game.attackChoice==1) {
        if (!adversaries.opponentAlive()) {
            System.out.println(adversaries.getName() + " is dead DimWit!!");
            game.attackChoice = 2; }
        System.out.println("You are attacking" + adversaries.getName());
        System.out.println("Damage dealt: " + playerDamage);
        adversaries.setHp(adversaries.getHp()-playerDamage +adversaries.getDef());
        System.out.println(adversaries.getHp() + " Add1 - health");
        if (adversaries.opponentAlive()) {
            System.out.println(adversaries.getName() + " Dealt you " + addDamage + " Damage");
            player.setHealth(player.getHealth() -addDamage + player.getDefence());}
    }else if (game.attackChoice==2) {
        if (!adversaries2.opponentAlive()) {
            game.attackChoice=1; }
        System.out.println("You are attacking" + adversaries2.getName());
        System.out.println("Damage dealt: " + playerDamage);
        adversaries.setHp(adversaries2.getHp()-playerDamage +adversaries2.getDef());
        System.out.println(adversaries2.getHp() + " Add2 - health");
        if (adversaries2.opponentAlive()) {
            System.out.println(adversaries2.getName() + " Dealt you " + addDamage2 + " Damage");
            player.setHealth(player.getHealth() -addDamage2 + player.getDefence());}
    }

}




    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public boolean getInUse() {
        return inUse;
    }

    public boolean opponentAlive() {
        return hp >0 ;
}

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }



}
