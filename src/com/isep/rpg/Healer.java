package com.isep.rpg;

public class Healer extends SpellCaster{

    private Weapon weapon = new Weapon("Sort de soin", 10);

    public Healer(String n, int hp, int mana) {
        super(n, hp=50, 10);
        this.name = n;
        this.mana = 10;
    }
    @Override
    public void Pertehp1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertehp(this.weapon.getDps());
    }

    @Override
    public int getDamage() {
        return this.weapon.getDps();}

    public void addMana(int n)
    {
        this.mana += n;
    }

    @Override
    public int getMana()
    {
        return this.mana;
    }
}
