package com.isep.rpg;

public class Mage extends SpellCaster {

    private Weapon weapon = new Weapon("Bâton de feu", 10);

    public Mage(String n, int hp, int mana) {
        super(n, 70, 10);
        this.name = name;
        this.mana = 10;
    }

    @Override
    public void Pertehp1(int damage) {

    }

    @Override
    public void fight(Combatant combatant) {
        combatant.Pertehp(this.weapon.getDps());
    }

    public void addMana(int n)
    {
        this.mana += n;
    }

    public int getMana()
    {
        return this.mana;
    }

    public int getDamage() {
        return this.weapon.getDps();}
}
