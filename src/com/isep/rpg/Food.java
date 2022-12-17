package com.isep.rpg;

// Soigne les points de vie
public class Food extends Consumable{


    private int addhp = 10;

    public Food(String name) {
        super(name);
    }

    public Food() {
        super("Potion de soin");
    }


    public int getAddhp() {
        return this.addhp;}
}
