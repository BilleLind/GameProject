package Game;

public class Humans extends Creature {
    public boolean inUse =false;
    public Humans(int hp, int atk, int def, String name) {
        this.setHealth(hp);
        this.setAttack(atk);
        this.setDefence(def);
        this.setName(name);
      }

    @Override
    public int getAttack() {
        return super.getAttack();
    }

    @Override
    public int getDefence() {
        return super.getDefence();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public String getName() {
        return super.getName();
    }



}
