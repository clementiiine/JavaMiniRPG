package code.javarpg;

import static code.javarpg.Consumable.*;


public class ConsoleParser {

    public static void main(String[] args){

        foodlist.add(new Consumable("chocolate", 100, 0, 2));
        foodlist.add(new Consumable("pancake", 30, 0, 2));

        potionlist.add(new Consumable("coffee", 0, 100, 2));
        potionlist.add(new Consumable("apple juice", 0, 30, 2));

        Game game = new Game();
        game.start();
    }
}
