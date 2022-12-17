package code.javarpg;

import java.util.ArrayList;
import java.util.Scanner;


public class Consumable {
    static Scanner scanner = new Scanner(System.in);

    private final String name;
    private int mana;
    private int hp;
    private int quantity;
    public static ArrayList<Consumable> foodlist = new ArrayList<>();
    public static ArrayList<Consumable> potionlist = new ArrayList<>();

    public Consumable(String name, int hp, int mana, int quantity) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.quantity = quantity;

    }

    public int getHp() {
        return hp;
    }
    public int getMana() {
        return mana;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    // Méthode utilisée pour afficher les consommables disponibles
    public static void DisplayConsumables() {
        System.out.println("Food:");
        for (int i = 0; i < foodlist.size(); i++) { // Pour chaque élément de la liste foodlist
            System.out.println(i + 1 + ". " + foodlist.get(i).getName() + "    - +" + foodlist.get(i).getHp() + " HP -    " +" (" + foodlist.get(i).getQuantity() + " left)"); // Affiche le nom, la quantité et les HP du consommable
        }
        System.out.println("\nPotions:");
        for (int i = 0; i < potionlist.size(); i++) { // Pour chaque élément de la liste potionlist
            System.out.println(i + 1 + ". " + potionlist.get(i).getName() + "    - +" + potionlist.get(i).getMana() + " mana -    "  + " (" + potionlist.get(i).getQuantity() + " left)"); // Affiche le nom, la quantité et les mana du consommable
        }
    }


    // Méthode pour utliiser de la nourriture
    public static void eat(ArrayList<Hero> heroes, ArrayList<Consumable> foodlist) {
        System.out.println("Write the name of the following hero you'd like to feed:\n");
        for (int i = 0; i < heroes.size(); i++) { // Pour chaque héros
            System.out.println(i + 1 + ". " + heroes.get(i).getName() + " (" + heroes.get(i).getHp() + " hp)"); // Affiche le nom et les HP du héros
        }
        int heroChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Which food would you like to give to " + heroes.get(heroChoice - 1).getName() + "?\n"); // Demande à l'utilisateur de choisir un héros à nourrir
        for (int i = 0; i < foodlist.size(); i++) { // Pour chaque élément de la liste foodlist
            System.out.println(i + 1 + ". " + foodlist.get(i).getName() + "    - +" + foodlist.get(i).getHp() + " hp -    "+ " (" + foodlist.get(i).getQuantity() + " left)");
        }
        int foodChoice = scanner.nextInt();
        scanner.nextLine();
        if (foodlist.get(foodChoice - 1).getQuantity() == 0) { // Si la quantité de nourriture est égale à 0
            System.out.println("There is no more " + foodlist.get(foodChoice - 1).getName() + " left."); // Affiche qu'il n'y a plus de nourriture
            foodlist.remove(foodChoice - 1); // Supprime l'élément de la liste
        } else { // Si la quantité de nourriture est supérieure à 0
            heroes.get(heroChoice - 1).setHp(heroes.get(heroChoice - 1).getHp() + foodlist.get(foodChoice - 1).getHp()); // Ajoute les HP de la nourriture aux HP du héros
            foodlist.get(foodChoice - 1).setQuantity(foodlist.get(foodChoice - 1).getQuantity() - 1); // Enlève 1 à la quantité de nourriture
            System.out.println(heroes.get(heroChoice - 1).getName() + " ate " + foodlist.get(foodChoice - 1).getName() + " and now has " + heroes.get(heroChoice - 1).getHp() + " hp."); // Affiche le nom du héros, le nom de la nourriture et les HP du héros
        }
    }

    // Méthode pour utiliser une potion
    public static void drink(ArrayList<Hero> heroes, ArrayList<Consumable> potionlist) {
        System.out.println("Write the name of the following hero you'd like to feed:\n");

        for (int i = 0; i < heroes.size(); i++) { // Pour chaque héros
            System.out.println(i + 1 + ". " + heroes.get(i).getName() + " (" + heroes.get(i).getMana() + " mana)"); // Affiche le nom et les mana du héros
        }
        int heroChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Which potion would you like to give to " + heroes.get(heroChoice - 1).getName() + "?\n"); // Demande à l'utilisateur de choisir un héros à nourrir
        for (int i = 0; i < potionlist.size(); i++) { // Pour chaque élément de la liste potionlist
            System.out.println(i + 1 + ". " + potionlist.get(i).getName() + "    - +" + potionlist.get(i).getMana() + " mana -    " + " (" + potionlist.get(i).getQuantity() + " left)"); // Affiche le nom, la quantité et les mana du consommable
        }
        int potionChoice = scanner.nextInt();
        scanner.nextLine();
        if (potionlist.get(potionChoice - 1).getQuantity() == 0) { // Si la quantité de potion est égale à 0
            System.out.println("There is no more " + potionlist.get(potionChoice - 1).getQuantity() + " left."); // Affiche qu'il n'y a plus de potion
            potionlist.remove(potionChoice - 1); // Supprime l'élément de la liste
        } else {
            heroes.get(heroChoice - 1).setMana(heroes.get(heroChoice - 1).getMana() + potionlist.get(potionChoice - 1).getMana()); // Ajoute les mana de la potion aux mana du héros
            potionlist.get(potionChoice - 1).setQuantity(potionlist.get(potionChoice - 1).getQuantity() - 1); // Enlève 1 à la quantité de potion
            System.out.println(heroes.get(heroChoice - 1).getName() + " drank " + potionlist.get(potionChoice - 1).getName() + " and now has " + heroes.get(heroChoice - 1).getMana() + " mana."); // Affiche le nom du héros, le nom de la potion et les mana du héros

        }
    }


}
