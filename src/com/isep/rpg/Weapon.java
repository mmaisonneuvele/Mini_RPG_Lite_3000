package com.isep.rpg;

public class Weapon extends Item{
    String name;
    int durability;
    int munition;
    String nameMun;

    public Weapon(String name, int pvarme) {
        super(name, 10);
        this.name = name;
        this.durability = pvarme;
        this.munition = munition;
        this.nameMun = nameMun;

    }


   /*public int canAttak(int totMun) {

        if (this.munition - totMun >= 0) {
            return true;
        }
        return false;
    }*/

    //public String getName() {return this.name;}
    public int getDps() {return this.durability;}
    // public int getNumition() {return this.munition;}
    //public String getNameMun() {return this.nameMun;}
}
