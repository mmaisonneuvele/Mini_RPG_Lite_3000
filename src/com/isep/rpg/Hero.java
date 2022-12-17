package com.isep.rpg;

public abstract class Hero extends Combatant {

    // Creation du sac d'items
    private Item[] baghero = new Item[5];


    public Hero(String n, int hp) {
        super(n, 50,10);

        // Ajout d'objet pour soigner les pv
        this.addItemToBaghero(new Food(), 0);
        this.addItemToBaghero(new Food(), 1);
        this.addItemToBaghero(new Food(), 2);
    }




    public Item[] getBaghero() {
        return this.baghero;}


    public void addItemToBaghero(Item i, int placement) {
        this.baghero[placement] = i;}


}
