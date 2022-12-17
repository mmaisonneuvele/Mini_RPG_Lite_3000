package com.isep.rpg;

public abstract class Combatant {
    static String name;
    private static int pv;
    private Weapon weapon;
    int mana;

    public Combatant(String n, int hp, int mana) {
        this.name = n;
        this.pv = hp;
        this.mana = mana;
    }

    public void Pertehp(int damage) {
        this.pv = this.pv - damage;
    }

    public abstract void Pertehp1(int damage);

    // Classe abstraite
    public abstract void fight(Combatant combatant);
    public abstract int getDamage();


    // Accesseurs GET
    public static String getName() {
        return Combatant.name;}

    public static int getPointsvie() {
        return Combatant.pv;}

    public int getMana() {
        return this.mana;
    }

    public void addMana(int n){
        this.mana =+ n;
    }

    public void win(int hpp) {

        this.pv = 6 + pv;
    }
    public void def(int pointsvie) {

        this.pv = 2 + pointsvie;
    }
    public void consu(int pointsvie) {

        this.pv = 5 + pointsvie;
    }



    public void Damage(int n)
    {
        this.pv -= n;
        if(this.pv <= 0)
        {
            int rest = 0 - this.pv;
            this.pv = 0;
            this.pv -= rest;
            if(this.pv <= 0)
            {
                this.pv = 0;

            }
        }
    }


}
