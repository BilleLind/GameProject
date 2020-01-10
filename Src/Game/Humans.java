package Game;

public class Humans extends  Adversaries {

    Adversaries human1 = new Adversaries();
    Adversaries human2 = new Adversaries();
    public void human1Method() {
        human1.setAtk(3);
        human1.setDef(1);
        human1.setHp(5);
        human1.setName("Bandit 1");
    }
    public void human2Method() {
        human2.setAtk(2);
        human2.setDef(0);
        human2.setHp(6);
        human2.setName("Bandit 2");
    }
}
