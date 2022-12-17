package code.javarpg;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Fight {

    static Scanner scanner = new Scanner(System.in);

    public void heroAttack(Hero hero, Enemy enemy, ArrayList<Enemy> enemies, ArrayList<Hero> heroes) {
        int damage = hero.getValueFight(); // damage = force d'attaque du hero
        if (Objects.equals(hero.getHeroClass(), HeroClass.WARRIOR.getId())) { // si le hero est un guerrier
            enemy.setHp(enemy.getHp() - damage); // l'ennemi perd de la vie
            System.out.println("\n" + hero.getName() + " attacked the " + enemy.getName() + " and made him lose " + damage + " hp."); // affiche le nom du hero, le nom de l'ennemi et la quantité de dégats infligés
        }
        if (Objects.equals(hero.getHeroClass(), HeroClass.HUNTER.getId())) { // si le hero est un chasseur
            if (hero.getArrows() > 0) { // si le hero a encore des flèches
                System.out.println(hero.getName() + " has " + hero.getArrows() + " arrows left!"); // affiche le nom du hero et le nombre de flèches restantes
                System.out.println("Do you want to use an arrow? (Y/N)"); // demande au joueur s'il veut utiliser une flèche
                String answer = scanner.nextLine();
                if (answer.equals("Y")) { // si le joueur répond "Y" (yes)
                    hero.setArrows(hero.getArrows() - 1); // le hero perd une flèche
                    enemy.setHp(enemy.getHp() - damage); // on inflige des dégats à l'ennemi
                    System.out.println("\n" + hero.getName() + " attacked the " + enemy.getName() + " and made him lose " + damage + " hp."); // affiche le nom du hero, le nom de l'ennemi et la quantité de dégats infligés
                }
                if (answer.equals("N")) { // si le joueur répond "N" (no)
                    System.out.println("Ok, no arrow used!");
                }
                else if (!answer.equals("Y") && !answer.equals("N")) { // si le joueur répond autre chose que "Y" ou "N"
                    System.out.println("Invalid answer! No arrow used!"); // affiche un message d'erreur
                }
            }
            else if (hero.getArrows() <= 0) { // si le hero n'a plus de flèches
                System.out.println(hero.getName() + " has no arrows left!"); // le hero perd son tour
            }
        }
        if (Objects.equals(hero.getHeroClass(), HeroClass.MAGE.getId())) { // si le hero est un mage
            if (hero.getMana() > 0) { // si le hero a encore de la mana
                System.out.println(hero.getName() + " has " + hero.getMana() + " mana left!"); // affiche le nom du hero et la quantité de mana restante
                System.out.println("Do you want to use a spell? (Y/N)"); // demande au joueur s'il veut utiliser un sort
                String answer = scanner.nextLine(); // récupère la réponse du joueur
                if (answer.equals("Y")) { // si le joueur répond "Y" (yes)
                    hero.setMana(hero.getMana() - 10); // le hero perd 10 de mana
                    enemy.setHp(enemy.getHp() - damage); // on inflige des dégats à l'ennemi
                    System.out.println("\n" + hero.getName() + " attacked the " + enemy.getName() + " and made him lose " + damage + " hp."); // affiche le nom du hero, le nom de l'ennemi et la quantité de dégats infligés
                }
                if (answer.equals("N")) { // si le joueur répond "N" (no)
                    System.out.println("Okay, no spell for now!"); // affiche un message
                }
                else if (!answer.equals("Y") && !answer.equals("N")) { // si le joueur répond autre chose que "Y" ou "N"
                    System.out.println("Invalid answer! No spell used!"); // affiche un message d'erreur
                }
            }
            else if (hero.getMana() <= 0) { // si le hero n'a plus de mana
                System.out.println(hero.getName() + " doesn't have enough mana to attack!");
                System.out.println(hero.getName() + " lost his turn!"); // le hero perd son tour
            }
        }
        if (Objects.equals(hero.getHeroClass(), HeroClass.HEALER.getId())) { // si le hero est un soigneur
            damage = 5; // le soigneur ne peut attaquer que de 5 pts son rôle est de guérir ses alliés
            if (hero.getMana() > 0) { // si le hero a encore de la mana
                System.out.println("\n" + hero.getName() + " have " + hero.getMana() + " mana left!"); // affiche le nom du hero et la quantité de mana restante
                System.out.println("\nDo you want to use a spell? (Y/N)"); // demande au joueur s'il veut utiliser un sort
                String answer = scanner.nextLine(); // récupère la réponse du joueur
                if (answer.equals("Y")) { // si le joueur répond "Y" (yes)
                    System.out.println("\nWhich hero do you want to heal?"); // demande au joueur quel hero il veut soigner
                    for (int i = 0; i < heroes.size(); i++) { // pour chaque hero
                        System.out.println(i + 1 + ". " + heroes.get(i).getName() + " (" + heroes.get(i).getHp() + " hp)"); // affiche le nom du hero et sa vie restante
                    }
                    int heroToHeal = scanner.nextInt(); // récupère le numéro du hero à soigner
                    if (heroes.get(heroToHeal - 1).getHp() + 10 > heroes.get(heroToHeal - 1).getHpMax()) { // si les hp du hero à soigner + 10 sont supérieurs à ses hp max
                        heroes.get(heroToHeal - 1).setHp(heroes.get(heroToHeal - 1).getManaMax()); // les hp du hero à soigner sont égaux à ses hp max
                    } else {
                        heroes.get(heroToHeal - 1).setHp(heroes.get(heroToHeal - 1).getHp() + hero.getValueFight()); // sinon on ajoute 10 aux hp du hero à soigner
                    }
                    System.out.println("\n" + heroes.get(heroToHeal - 1).getName() + " has " + heroes.get(heroToHeal - 1).getHp() + " hp."); // affiche le nom du hero à soigner et ses hp
                    hero.setMana(hero.getMana() - 10); // le hero perd 10 de mana
                    System.out.println("\n" + hero.getName() + " has " + hero.getMana() + " mana left!"); // affiche le nom du hero et la quantité de mana restante
                }
                if (answer.equals("N")) { // si le joueur répond "N" (no)
                    System.out.println("\nOkay, no spell for now!"); // affiche un message
                }
                else if (!answer.equals("Y") && !answer.equals("N")) { // si le joueur répond autre chose que "Y" ou "N"
                    System.out.println("\nInvalid answer! No spell used!"); // affiche un message d'erreur
                }
            } else if (hero.getMana() <= 0) { // si le hero n'a plus de mana
                System.out.println("\n" + hero.getName() + " has no mana left!"); // il ne peut pas soigner
            }
            enemy.setHp(enemy.getHp() - damage); // on inflige des dégats à l'ennemi
            System.out.println("\n" + hero.getName() + " attacked the " + enemy.getName() + " and made him lose " + damage + " hp."); // affiche le nom du hero, le nom de l'ennemi et la quantité de dégats infligés
        }
    }
    public void enemyAttack(Hero hero, Enemy enemy, ArrayList<Hero> heroes, ArrayList<Enemy> enemies, ArrayList<Consumable> foodlist) {
        if (enemy.getHp() <= 0) { // si l'ennemi à 0 ou moins de hp
            System.out.println("\nThe " + enemy.getName() + " has died!"); // on affiche que cet ennemi est mort
            enemies.remove(enemy); // on le retire de la liste des ennemis
        }
        else if (hero.getHp() > 0) { // si le hero a encore des hp
            System.out.println("\nThe " + enemy.getName() + " now has " + enemy.getHp() + " HP left!\n"); // affiche le nom de l'ennemi et ses hp restants
            int enemyDmg = enemy.getValueFight(); // enemyDmg = valeur de l'attaque de l'ennemi
            System.out.println("\nThe " + enemy.getName() + " attacks " + hero.getName() + "!\n"); // affiche que l'ennemi attaque tel ou tel hero
            hero.setHp(hero.getHp() - enemyDmg); // on retire les hp du hero en fonction de la valeur de l'attaque de l'ennemi
            System.out.println(hero.getName() + " lost " + enemyDmg + " HP!"); // affiche le nom du hero et la quantité de dégats subis
            if (hero.getHp() > 0) { // si le hero a encore des hp
                System.out.println("\n" + hero.getName() + " now has " + hero.getHp() + " HP left!"); // affiche le nom du hero et ses hp restants
            }
            else if (hero.getHp() <= 0) { // si le hero n'a plus de hp
                System.out.println("\n" + hero.getName() + " died!"); // affiche que le hero est mort
                System.out.println("This is your last chance of saving " + hero.getName() + "!");
                System.out.println("\nDo you want to use some food? (Y/N)"); // demande au joueur s'il veut utiliser de la nourriture pour le sauver
                String answer = scanner.nextLine(); // récupère la réponse du joueur
                if (Objects.equals(answer, "Y")) { // si le joueur répond "Y" (yes)
                    System.out.println("\nWhich food do you want to use?");
                    for (int i = 0; i < foodlist.size(); i++) { // pour chaque aliment de la liste de nourriture
                        System.out.println(i + 1 + ". " + foodlist.get(i).getName()); // affiche le nom de l'aliment
                    }
                    int foodChoice = scanner.nextInt(); // récupère le numéro de l'aliment choisi
                    hero.setHp(hero.getHp() + foodlist.get(foodChoice - 1).getHp()); // ajoute les hp du hero en fonction de la valeur des hp de l'aliment
                    System.out.println("\n" + hero.getName() + " went back to life and has " + hero.getHp() + " hp left!"); // affiche le nom du hero et ses hp restants
                }
                if (Objects.equals(answer, "N")) { // si le joueur répond "N" (no)
                    System.out.println("\nYou have chosen to let " + hero.getName() + " die!"); // affiche que le hero est mort
                    heroes.remove(hero); // on le retire de la liste des héros
                }
                else if (!answer.equals("Y") && !answer.equals("N")){ // si le joueur répond autre chose que "Y" ou "N"
                    System.out.println("\nInvalid answer! " + hero.getName() + " has died!"); // affiche que le hero est mort
                    heroes.remove(hero); // on le retire de la liste des héros
                }
            }
        }
    }

}