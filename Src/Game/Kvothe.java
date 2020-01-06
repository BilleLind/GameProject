package Game;

public class Kvothe extends Player{
    //this is my start character/ test character
    // others will be made

    private void initiatePlayer() {
        Player p = new Player();
        p.setHealth(20);
        p.setNumberForChances(2);

        p.setChanceOfKilling(0.04);
        p.setChanceOfInjuring(0.2);
        p.setChanceOfSubduing(0.12);
        p.setChanceOfWinningOver(0.01);


    }



}
