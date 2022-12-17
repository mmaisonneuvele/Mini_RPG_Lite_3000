package com.isep.rpg;

public class Warrior extends Hero{


    private Weapon weapon = new Weapon("Hache", 10);

    public Warrior(String n, int hp) {
        super(n, hp);
    }


    @Override
    public void Pertehp1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertehp(this.weapon.getDps());
    }

    public int getDamage() {
        return this.weapon.getDps();}
}
