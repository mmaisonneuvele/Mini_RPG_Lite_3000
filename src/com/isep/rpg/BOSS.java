package com.isep.rpg;

public class BOSS extends Enemy {

    private Weapon weapon = new Weapon("force surdimensionnée", 10);
    private static int pv;

    public BOSS(String name, int pvv) {
        super("Boss final !!", 100);
    }

    public static int getPointsvie() {
        return BOSS.pv;
    }


    @Override
    public void Pertehp1(int damage) {
        this.pv = this.pv - damage;
    }



    @Override
    public void fight(Combatant combatant) {

    }

    public void win(int hpp) {

        this.pv = 6 + pv;
    }



    public int getDamage() {
        return this.weapon.getDps();}


}


