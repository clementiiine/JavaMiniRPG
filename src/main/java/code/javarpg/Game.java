package code.javarpg;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static code.javarpg.Consumable.foodlist;
import static code.javarpg.Consumable.potionlist;


// Logique du jeu
public class Game {

    private static final Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();
    private final CreateCharacters createChara = new CreateCharacters();
    private Fight fight = new Fight();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    private int nbEnemy;
    public ArrayList<Hero> heroes = new ArrayList<>();



    // méthode pour gérer les choix de l'utilisateur
    public static int ReadInteger(String enter, int userChoice) {
        int input;
        // boucle pour gérer les erreurs de saisie (si l'utilisateur ne rentre pas un nombre)
        do {
            System.out.print(enter);
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                input = -1;
                System.out.println("\nPlease enter a valid number\n ");
            }
        }
        while (input < 1 || input > userChoice);
        return input;
    }

    // Méthode pour effacer la console
    public void clearConsole() {
        for (int i = 0; i < 70; i++) {
            System.out.println();
        }
    }

    // Méthode pour afficher une ligne séparatrice
    public void line(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    // Méthode pour afficher un titre
    public void title(String title) {
        clearConsole();
        line(130);
        System.out.println("  >  " + title + "\n");
        line(130);
        System.out.println("");
    }

    // Méthode pour arrêter le jeu tant que rien n'est entré
    public void pause() {
        System.out.println("\n\n\nPress Enter to continue");
        scanner.nextLine();
        clearConsole();
    }

    // Affichage du menu
    public void start() {
        title("Menu");
        System.out.println("(1) Start a new game");
        System.out.println("(2) Exit\n");

        // choix de l'utilisateur
        int userChoice = ReadInteger("Enter your choice:\n", 2);
        switch (userChoice) {
            case 1 -> newGame();
            case 2 -> System.exit(0);
        }
    }

    // Choix des personnages
    public void chooseHero() {
        title("Creation of your team");
        System.out.println("Choose the number of heroes you want to play with (1 to 4)\n\n(NB: If you choose a Healer, you should choose at least one other hero because the Healer can't attack a lot.)\n");
        int nbHero = ReadInteger("\nEnter your choice:\n", 4);
        nbEnemy = nbHero; // choix du joueur pour le nombre de heros (= nombre d'ennemis)

        for (int i = 1; i <= nbHero; i++) {
            String crtName;
            boolean nameSet = false;
            boolean classSet = false;
            // choix du nom du personnage (tant que le nom n'est pas valide)
            do {
                System.out.printf("\nWhat is the name of your hero number %d?\n", i);
                crtName = scanner.next();
                System.out.printf("\nthe name of your hero number %d" + " is " + crtName + ".  Is that correct?\n", i);
                System.out.println("(1) Yes");
                System.out.println("(2) No\n");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    nameSet = true; // le nom est valide
                }
            } while (!nameSet); // tant que le nom n'est pas valide
            HeroClass crntHeroClass;
            // choix de la classe du personnage (tant que la classe n'est pas valide)
            do {
                System.out.printf("\nChoose a class for your hero number %d: ", i);
                System.out.println("\n(1) Warrior\n(2) Hunter\n(3) Mage\n(4) Healer:\n");
                crntHeroClass = switch (scanner.nextInt()) {
                    case 1 -> HeroClass.WARRIOR;
                    case 2 -> HeroClass.HUNTER;
                    case 3 -> HeroClass.MAGE;
                    case 4 -> HeroClass.HEALER;
                    default -> throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
                };
                System.out.printf("\nYou chose the class " + crntHeroClass + " for your hero number %d. Is that correct?\n", i);
                System.out.println("(1) Yes");
                System.out.println("(2) No\n");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    classSet = true; // la classe est valide
                }
            } while (!classSet); // tant que la classe n'est pas valide
            heroes.add(createChara.createHero(crtName, crntHeroClass)); // création du héros et ajout à la liste des héros
        }
    }

    // Début d'une nouvelle partie
    public void newGame() {
        chooseHero(); // choix des personnages
        pause(); // arrêt du jeu jusqu'à ce que l'utilisateur appuie sur Entrée
        gameMenu(); // affichage du menu de jeu

    }

    // Menu principal du jeu
    public void gameMenu() {
        int choice;
        // affichage du menu
        title("Game Menu");
        System.out.println("(1) Start the game");
        System.out.println("(2) Inventory");
        System.out.println("(3) Hero's information");
        System.out.println("(4) Exit\n");
        choice = ReadInteger("Enter your choice:\n", 4);
        switch (choice) {
            case 1 -> story1();
            case 2 -> {
                inventory(); // affichage de l'inventaire
                gameMenu();
            }
            case 3 -> {
                heroesInfo(); // affichage des informations des héros
                pause();
                gameMenu();
            }
            case 4 -> System.exit(0); // arrêt du jeu
        }
    }

    // Combat
    public void Action() {
        int choice;
        // choix de l'action
        do {
            for (int i = 0; i < heroes.size(); i++) {
                int target = 1;
                System.out.println("\nTurn of " + heroes.get(i).getName() + " of class " + heroes.get(i).getHeroClass() + "   -   " + heroes.get(i).getHp() + " HP\n");
                System.out.println("Choose an action:\n");
                System.out.println("(1) Attack");
                System.out.println("(2) Use an item\n");
                choice = ReadInteger("Enter your choice:\n", 2);
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nChoose a target:"); // choix de la cible
                        displayEnemies();
                        target = ReadInteger("", enemies.size()); // choix de la cible
                        fight.heroAttack(heroes.get(i), enemies.get(target - 1), enemies, heroes); // attaque du héros
                        fight.enemyAttack(heroes.get(i), enemies.get(target - 1), heroes, enemies, foodlist); // attaque de l'ennemi
                    }
                    case 2 -> {
                        useItem(); // utilisation d'un objet
                        pause();
                    }
                }
            }
        }while (enemies.size() > 0 && heroes.size() > 0); // tant que les héros et les ennemis sont vivants
    }

    // Méthode pour créer des ennemis différents à chaque tour (nombre d'ennemis = nombre de héros au départ)
    public void fight(int j) {
        title("Fight");
        pause();

        if (j == 0) { // création des ennemis au début du jeu
            for (int i = 0; i < nbEnemy; i++) {
                enemies.add(createChara.createEnemy(EnemyClass.GOBLIN));
            }
            Action(); // début du combat 1
        }
        if (j == 1) { // création des ennemis au début du combat 2
            for (int i = 0; i < nbEnemy; i++) {
                enemies.add(createChara.createEnemy(EnemyClass.ASSASSIN));

            }Action(); // début du combat 2
        }
        if (j == 2) { // création des ennemis au début du combat 3
            for (int i = 0; i < nbEnemy; i++) {
                enemies.add(createChara.createEnemy(EnemyClass.DRAGON));
            }
            Action(); // début du combat 3

        }
        else if (j == 3) { // création des ennemis au début du combat 4
            for (int i = 0; i < nbEnemy; i++) {
                enemies.add(createChara.createEnemy(EnemyClass.SORCERER));
            }
            Action(); // début du combat 4
        }
    }


    // 4 chapitres différents avec 1 combat par chapitre

    // Chapitre 1
    public void story1() {
        clearConsole();
        Story.chapter1(); // affichage du chapitre 1
        pause();
        Story.attack1(); // affichage du texte de la première attaque
        Story.storyChoice(); // choix de l'action
        int choice = ReadInteger("Enter your choice:\n", 5);
        switch (choice) {
            case 1 -> {
                fight(0); // début du combat 1
                pause();

                if (heroes.size() == 0) { // si les héros sont morts
                    Story.defeat(); // affichage du texte de défaite
                    pause();
                    start(); // retour au menu principal
                }
                else { // si les héros sont vivants (victoire)
                    heroesReward(foodlist, potionlist); // récompense des héros
                    story2(); // début du chapitre 2
                }
            }
            case 2 -> {
                heroesInfo(); // affichage des informations des héros
                pause();
                story1(); // retour au début du chapitre 1
            }
            case 3 -> {
                inventory(); // affichage de l'inventaire
                pause();
                story1(); // retour au début du chapitre 1
            }
            case 4 -> {
                System.out.println("You chose to run away.\n"); // choix de fuir (défaite)
                pause();
                gameMenu(); // retour au menu de jeu
            }
            case 5 -> System.exit(0); // arrêt du jeu
        }
    }
    // Chapitre 2
    public void story2(){
        clearConsole();
        Story.chapter2(); // affichage du chapitre 2
        pause();
        Story.attack2(); // affichage du texte de la 2nde attaque
        Story.storyChoice(); // choix de l'action
        int choice = ReadInteger("Enter your choice:\n", 5);
        switch (choice) {
            case 1 -> {
                fight(1); // début du combat 2
                pause();
                if (heroes.size() == 0) { // si les héros sont morts (défaite)
                    Story.defeat(); // affichage du texte de défaite
                    pause();
                    start(); // retour au menu principal
                }
                else {
                    heroesReward(foodlist, potionlist); // récompense des héros
                    story3(); // début du chapitre 3
                }
            }
            case 2 -> {
                heroesInfo(); // affichage des informations des héros
                pause();
                story2(); // retour au début du chapitre 2
            }
            case 3 -> {
                inventory(); // affichage de l'inventaire
                pause();
                story2(); // retour au début du chapitre 2
            }

            case 4 -> {
                System.out.println("You chose to run away.\nYou'll be able to fight later."); // choix de fuir (défaite)
                pause();
                gameMenu(); // retour au menu de jeu
            }
            case 5 -> System.exit(0); // arrêt du jeu
        }
    }
    // Chapitre 3
    public void story3(){
        clearConsole();
        Story.chapter3(); // affichage du chapitre 3
        pause();
        Story.attack3(); // affichage du texte de la 3ème attaque
        Story.storyChoice(); // choix de l'action
        int choice = ReadInteger("Enter your choice:\n", 5);
        switch (choice) {
            case 1 -> {
                fight(2); // début du combat 3
                pause();
                if (heroes.size() == 0) {
                    Story.defeat(); // affichage du texte de défaite
                    pause();
                    start(); // retour au menu principal
                }
                else {
                    heroesReward(foodlist, potionlist); // récompense des héros
                    story4(); // début du chapitre 4
                }
            }
            case 2 -> {
                heroesInfo(); // affichage des informations des héros
                pause();
                story3(); // retour au début du chapitre 3
            }
            case 3 -> {
                inventory(); // affichage de l'inventaire
                pause();
                story3(); // retour au début du chapitre 3
            }
            case 4 -> {
                System.out.println("You chose to run away.\n"); // choix de fuir (défaite)
                pause();
                gameMenu(); // retour au menu de jeu
            }
            case 5 -> System.exit(0); // arrêt du jeu
        }
    }
    // Chapitre 4
    public void story4(){
        clearConsole();
        Story.chapter4(); // affichage du chapitre 4 (+ texte de la 4ème attaque)
        Story.storyChoice(); // choix de l'action
        int choice = ReadInteger("Enter your choice:\n", 5);
        switch (choice) {
            case 1 -> {
                fight(3); // début du combat 4
                pause();
                if (heroes.size() == 0) { // si les héros sont morts (défaite)
                    Story.defeat(); // affichage du texte de défaite
                    pause();
                    start(); // retour au menu principal
                }
                else {
                    Story.finalVictory(); // affichage du texte de victoire finale
                    pause();
                    start(); // retour au menu principal (fin du jeu)
                }
            }
            case 2 -> {
                heroesInfo(); // affichage des informations des héros
                pause();
                story4(); // retour au début du chapitre 4
            }
            case 3 -> {
                inventory(); // affichage de l'inventaire
                pause();
                story4(); // retour au début du chapitre 4
            }
            case 4 -> {
                System.out.println("You chose to run away.\nYou'll have to start over"); // choix de fuir (défaite)
                pause();
                gameMenu(); // retour au menu de jeu
            }
            case 5 -> System.exit(0); // arrêt du jeu
        }
    }


    // En fin de combat, choix de récompense pour les héros (en cas de victoire)
    public void heroesReward(ArrayList<Consumable> foodlist, ArrayList<Consumable> potionlist) {
        System.out.println("Congrats! You killed the enemy. You can now claim your reward.\n");
        System.out.println("Each hero can choose a reward\n");
        for (Hero hero : heroes) { // pour chaque héros
            if (Objects.equals(hero.getHeroClass(), HeroClass.HUNTER.getId())) { // si le héros est un chasseur
                Story.victoryHunter(); // affichage du texte de victoire du chasseur
                hero.setArrows(10); // on lui remet 10 flèches
                int choice = Game.ReadInteger("Enter your choice:\n", 4); // choix de la récompense
                switch (choice) {
                    case 1 -> hero.setValueFight(hero.getValueFight() + 5); // +5 de force de combat
                    case 2 -> hero.setArrows(15); // +5 flèches
                    case 3 -> {
                        foodlist.set(1, new Consumable("pancake", 50, 0, 3)); // 3 pancakes
                        System.out.println("You now have " + foodlist.get(1).getQuantity() + " pancakes");
                    }
                    case 4 -> {foodlist.set(0, new Consumable("chocolate", 100, 0, 1)); // 1 chocolat
                        System.out.println("You now have " + foodlist.get(0).getQuantity() + " chocolates");
                    }
                }
                hero.setHpMax(hero.getHpMax() + 10); // +10 de hp max
                hero.setHp(hero.getHpMax()); // on remet les hp au max
            }
            if (Objects.equals(hero.getHeroClass(), HeroClass.MAGE.getId())){ // si le héros est un mage
                Story.victoryMage(); // affichage du texte de victoire du mage
                int choice = Game.ReadInteger("Enter your choice:\n", 6); // choix de la récompense
                switch (choice) {
                    case 1 -> hero.setValueFight(hero.getValueFight() + 5); // +5 de force de combat
                    case 2 -> hero.setManaMax(hero.getManaMax() + 20); // +20 de mana max
                    case 3 -> {
                        foodlist.set(1, new Consumable("pancake", 50, 0, 3)); // 3 pancakes
                        System.out.println("You now have " + foodlist.get(1).getQuantity() + " pancakes.");
                    }
                    case 4 -> {
                        potionlist.set(1, new Consumable("apple juice", 0, 50, 3)); // 3 jus de pomme
                        System.out.println("You now have " + potionlist.get(1).getQuantity() + " apple juices.");
                    }
                    case 5 -> {
                        foodlist.set(0, new Consumable("chocolate", 100, 0, 1)); // 1 chocolat
                        System.out.println("You now have " + foodlist.get(0).getQuantity() + " chocolates.");
                    }
                    case 6 -> {
                        potionlist.set(0, new Consumable("coffee", 0, 100, 2)); // 2 cafés
                        System.out.println("You now have " + potionlist.get(0).getQuantity() + " coffees.");
                    }
                }
                hero.setMana(hero.getManaMax()); // on remet le mana au max
                hero.setHpMax(hero.getHpMax() + 10); // +10 de hp max
                hero.setHp(hero.getHpMax());
            }
            if (Objects.equals(hero.getHeroClass(), HeroClass.HEALER.getId())){ // si le héros est un guérisseur
                Story.victoryHealer(); // affichage du texte de victoire du guérisseur

                int choice = Game.ReadInteger("Enter your choice\n", 5); // choix de la récompense
                switch (choice){
                    case 1 -> hero.setValueFight(hero.getValueFight() + 5); // +5pts en guérison
                    case 2 -> {
                        hero.setManaMax(hero.getManaMax() + 20); // +20 de mana max
                    }
                    case 3 -> {
                        foodlist.set(1, new Consumable("pancake", 50, 0, 3)); // 3 pancakes
                        System.out.println("You now have " + foodlist.get(1).getQuantity() + " pancakes.");
                    }
                    case 4 -> {
                        potionlist.set(1, new Consumable("apple juice", 0, 50, 3)); // 3 jus de pomme
                        System.out.println("You now have " + potionlist.get(1).getQuantity() + " apple juices.");
                    }
                    case 5 -> {
                        foodlist.set(0, new Consumable("chocolate", 100, 0, 1)); // 1 chocolat
                        System.out.println("You now have " + foodlist.get(0).getQuantity() + " chocolates.");
                    }
                    case 6 -> {
                        potionlist.set(0, new Consumable("coffee", 0, 100, 2)); // 2 cafés
                        System.out.println("You now have " + potionlist.get(0).getQuantity() + "coffees");}
                }
                hero.setMana(hero.getManaMax());
                hero.setHpMax(hero.getHpMax() + 10);
                hero.setHp(hero.getHpMax());
            }
            if (Objects.equals(hero.getHeroClass(), HeroClass.WARRIOR.getId())) { // si le héros est un guerrier
                Story.victoryWarrior(); // affichage du texte de victoire du guerrier
                int choice = Game.ReadInteger("Enter your choice\n", 5); // choix de la récompense
                switch (choice) {
                    case 1 -> hero.setValueFight(hero.getValueFight() + 5); // +5 de force de combat
                    case 2 -> {
                        foodlist.set(1, new Consumable("pancake", 50, 0, 3)); // 3 pancakes
                        System.out.println("You now have " + foodlist.get(1).getQuantity() + " pancakes.");
                    }
                    case 3 -> {foodlist.set(0, new Consumable("chocolate", 100, 0, 1)); // 1 chocolat
                        System.out.println("You now have " + foodlist.get(0).getQuantity() + " chocolates.");
                    }
                }
                hero.setHpMax(hero.getHpMax() + 10); // +10 de hp max
                hero.setHp(hero.getHpMax()); // on remet les hp au max
            }
        }
    }

    // Affichage des informations sur les ennemis à affronter
    public void displayEnemies() {
        for (int i = 0; i < enemies.size(); i++) { // pour chaque ennemi
            System.out.println("(" + (i + 1) + ") " + enemies.get(i).getName() + " (" + enemies.get(i).getHp() + " HP)"); // affichage du nom et des hp de l'ennemi
        }
    }

    // Affichage de l'inventaire
    public void inventory() {
        title("Inventory");
        System.out.println("You have :\n");
        Consumable.DisplayConsumables(); // affichage des consommables
        pause();
    }

    // Utilisation d'un objet
    public void useItem() {

        System.out.println("Which item do you want to use?\n");
        System.out.println("(1) Food");
        System.out.println("(2) Potion");
        System.out.println("(3) Exit");
        int choice2 = ReadInteger("\nEnter your choice:\n", 3); // choix de l'objet à utiliser
        switch (choice2) {
            case 1 -> {
                useFood(); // utilisation d'un aliment
                pause();
            }
            case 2 -> {
                usePotion(); // utilisation d'une potion
                pause();
            }
            case 3 -> pause();
        }
    }

    // Utilisation de nourriture
    public void useFood() {
        title("Use food");
        Consumable.eat(heroes, foodlist); // utilisation d'un aliment
    }

    // Utilisation d'une potion
    public void usePotion() {
        title("Use potion");
        Consumable.drink(heroes, potionlist); // utilisation d'une potion
    }

    // Affichage des informations sur les héros
    public void heroesInfo (){
        for (Hero hero : heroes) { // pour chaque héros
            System.out.println("\n  < " + hero.getName() + " >\n" + "class : " + hero.getHeroClass() + "\nhp : " + hero.getHp() + "\nmana :" +  hero.getMana()); // affichage des informations sur le héros
        }
    }
}

