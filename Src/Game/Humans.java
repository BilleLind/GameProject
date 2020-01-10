package Game;

public class Humans extends  Adversaries {

    public Humans(String name, int hp, int damage, int atk, int def) {
        super(name, hp, damage, atk, def);
    } // in the Game or Calc? where it uses calculations for the values and set it afterwards gets?




    public void combatAdversarie(Humans humans) {
        System.out.println("You are facing down:" + humans.getName());


    }



}
