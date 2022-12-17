package com.isep.rpg;

import java.util.*;

public class Game {
    boolean gameOver = false;
    boolean win = false;
    int manche = 1;

    Combatant[] list_hero;
    Combatant[] list_enemy;

    Combatant[] list_boss = new Combatant[1];

    public Game() {

        this.chooseNbHeros();
        this.createAllHeros();
        this.createenemy();


        while (gameOver==false || win==false) {
            this.afficheJeu();
            System.out.println("");


            Combatant[] list_combatant = new Combatant[this.list_hero.length + this.list_enemy.length];
            System.arraycopy(this.list_hero, 0, list_combatant, 0, this.list_hero.length);
            System.arraycopy(this.list_enemy, 0, list_combatant, this.list_hero.length, this.list_enemy.length);
            //System.out.println("Concatenated Array : " + Arrays.toString(list_combatant));
            List<Combatant> list = Arrays.asList(list_combatant);
            Collections.shuffle(list);
            list.toArray(list_combatant);
            //System.out.println("Random Array : " + Arrays.toString(list_combatant));

            Random r = new Random();
            Scanner scanner = new Scanner(System.in);

            for (Combatant fighter : list_combatant) {
                List<Combatant> liste = Arrays.asList(this.list_enemy);
                if (liste.contains(fighter)) {
                    int randomNumber = r.nextInt(this.list_hero.length);
                    Combatant enemy = list_hero[randomNumber];
                    fighter.fight(enemy);
                    System.out.println(fighter.getName() + " attaque " + enemy.getName() + " et inflige " + fighter.getDamage() + " points de dégâts.");

                    if (enemy.getPointsvie() <= 0) {
                        this.list_hero = this.removeElement(this.list_hero, randomNumber);
                        System.out.println(enemy.getName() + " est mort !");
                    }
                } else {
                    System.out.println("Que voulez-vous faire ? : 1= attaquer, 2= défendre, 3= utiliser un consommable");
                    int type_action = scanner.nextInt();
                    int randomNumber = r.nextInt(this.list_enemy.length);
                    Combatant enemy = list_enemy[randomNumber];


                    if (type_action == 1) {
                        System.out.println(fighter.getName() + " attaque " + enemy.getName());
                        fighter.fight(enemy);

                    } else if (type_action == 2) {
                        System.out.println(fighter.getName() + " se protège et perds 3 points de vie.");
                        fighter.def(fighter.getPointsvie());

                    } else if (type_action == 3) {
                        System.out.println(fighter.getName() + "utilise un consommable");
                        //private ArrayList<Consumable> liste_consommable = new ArrayList<Consumable>();
                        // public void useConsommable(Combatant Gentil, Combatant Mechant)

                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Choisissez un consommable : 1= Lembas, 2= Poulet , 3= Potion pour récupérer du mana");
                        int consommable = scanner1.nextInt();

                        if (consommable == 1) {
                            fighter.win(fighter.getPointsvie());
                            System.out.print("Le lembas me fait gagner des pv à " + fighter.getName());
                        } else if (consommable == 2) {
                            fighter.consu(fighter.getPointsvie());
                            System.out.print("Le poulet me fait gagner des pv à " + fighter.getName());

                        }
                        //uniquement pour SpellCaster
                        else if (consommable == 3) {
                            fighter.consu(fighter.getMana());
                            System.out.print("Grâce à la potion,le mana de " + fighter.getName() + " est à : " + fighter.getMana() +".");

                        } else {
                            System.out.println("Vous devez rentrer un numéro entre 1 et 3.");
                        }

                        fighter.fight(fighter);
                        System.out.println(fighter.getName() + " attaque " + enemy.getName() + " et inflige " + fighter.getDamage() + " de dégâts.");

                        this.list_enemy = this.removeElement(this.list_enemy, randomNumber);
                        System.out.println(getClassName(enemy.getClass()) + enemy.getName() + " est mort !");
                    }
                }
                if (this.list_enemy.length == 0) {
                    this.gameOver = true;
                    System.out.println("Vous avez tué tous les ennemis, vous avez terminé cette manche.");
                    break;
                }
                if (this.list_hero.length == 0) {
                    this.gameOver = true;
                    System.out.println("Tous vos héros sont morts, vous avez perdu.");
                    break;
                }
                if (manche == 5 ) {

                    this.afficheJeu();
                    list_boss[0] = new BOSS("Boss final !!", 100);

                    System.out.println("\nLes survivants vont combattre le boss");

                    System.out.println(list_boss[0].getName());
                    System.out.println(fighter.getName() + " attaque : " + BOSS.getName() + " | Degats = " + fighter.getDamage());

                    // Si l'attakant est mort
                    if (BOSS.getPointsvie() <= 0) {
                        this.list_boss = this.removeElement(this.list_boss, 0);
                        System.out.println(BOSS.getName() + " est mort !");
                        win = true;
                    }
                    if (this.list_hero.length == 0) {
                        this.gameOver = true;
                        System.out.println("Tous vos héros sont morts, vous avez perdu.");
                        break;
                    }

            }


               }
            this.manche++;

        }
        this.manche++;
    }





    public Combatant[] removeElement( Combatant [] arr, int index ){
        Combatant[] arrDestination = new Combatant[arr.length - 1];
        int remainingElements = arr.length - ( index + 1 );
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
        //System.out.println("Elements -- "  + Arrays.toString());
        return arrDestination;
    }






    public void Testavecheros() {
        this.list_hero = new Combatant[4];
        this.list_enemy = new Combatant[4];
        this.list_hero[0] = new Hunter("hunter", 50);
        this.list_hero[1] = new Warrior("warrior", 100);
        this.list_hero[2] = new Healer("healer", 50, 10);
        this.list_hero[3] = new Mage("mage", 70, 10);
    }


    public void chooseNbHeros() {
        // Choix du nombre de Heros
        int nbCombatant = SafeIntScanner("Choisissez le nombre de héros : ");
        // Liste des Heros du joueur
        if (nbCombatant > 5){
            System.out.println("Vous ne pouvez choisir que 5 héros maximum.");
            chooseNbHeros();
        }
        this.list_hero = new Combatant[nbCombatant];
        // Liste des Enemy
        this.list_enemy = new Combatant[nbCombatant];
    }


    public void createAllHeros() {
        // Creation des heros
        for (int i = 0; i < this.list_hero.length; i++) {
            String name = SafeStringScanner("Comment voulez-vous appeler votre héros n° " + (i+1) + " ? ");

            // Selection de la classe et creation du hero
            boolean confirm = false;
            int user;
            while (!confirm) {
                // Selection de la classe
                user = SafeIntScanner("Choisissez la classe du héros \" 1 : Hunter 2 : Warrior 3: Mage 4: Healer");
                // Creation du hero en fonction de sa classe si
                switch (user) {
                    case 1 : {this.list_hero[i] = new Hunter(name, 50); confirm = true;}
                    case 2 : {this.list_hero[i] = new Warrior(name, 100); confirm = true;}
                    case 3 : {this.list_hero[i] = new Mage(name, 70, 10); confirm = true;}
                    case 4 : {this.list_hero[i] = new Healer(name, 50, 10); confirm = true;}
                    default : {System.out.println("Veuillez entrer un nombre entre 1 et 4");}
                        //createAllHeros();}
                }
            }
        }
    }

    public void createenemy() {
        for (int j = 0; j < this.list_enemy.length; j++) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println( "Comment voulez-vous appeler votre ennemi n° " + (j+1) + " ? ");
            String enemy = scanner2.next();
            this.list_enemy[j] = new Dragon(enemy, 50);
        }
    }



    public static String getClassName(Class c) {
        String className = c.getName();
        int firstChar;
        firstChar = className.lastIndexOf('.') + 1;
        if (firstChar > 0) {
            className = className.substring(firstChar);
        }
        return className;
    }

    public void afficheJeu(){
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println(("Vague numéro : " + this.manche + "\n"));
        for (Combatant c : this.list_hero) {
            System.out.println(getClassName(c.getClass())
                    + "[" + c.getName()
                    + "] : Points de vie restants = "
                    + c.getPointsvie()
                    + " | Dégâts infligés ="
                    + c.getDamage()
            );
        }
        for (Combatant c :this.list_enemy) {
            System.out.println(getClassName(c.getClass())
                    + "[" + c.getName()
                    + "] : Points de vie restants= "
                    + c.getPointsvie()
                    + " | Dégâts infligés = "
                    + c.getDamage()
            );
        }
        System.out.println("___________________________________________________________________________________");
    }

    public void afficheCamp(Combatant[] camp, String type){
        System.out.println("\n-----------------------------------------------------------------------------------");
        for (Combatant c : camp) {
            System.out.println(c.getClass() + " - " + c.getName() + " - " + c.getPointsvie());
            if (Objects.equals(type, "g")) {
                // Affiche une list pour les combattants de class fille heros
                System.out.println("                             " + Arrays.toString(((Hero) c).getBaghero()));
            }
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public int SafeIntScanner(String text) {
        System.out.println(text);
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez choisir un numero entre 1 et 4 ! ");
            }
        }
    }

    public String SafeStringScanner(String text) {
        System.out.println(text);
        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("Veuillez choisir un numéro entre 1 et 4 !");
            }
        }
    }


}
