package com.isep.rpg;

public abstract class SpellCaster extends Hero{

    public SpellCaster(String n, int hp, int mana) {
        super(n, 50);

        // Ajout d'objet pour regen les pv
        super.addItemToBaghero(new Potion(), 3);
        super.addItemToBaghero(new Potion(), 4);


    }
}
