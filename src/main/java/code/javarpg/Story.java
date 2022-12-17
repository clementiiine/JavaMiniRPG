package code.javarpg;

public class Story {

    public static void chapter1() {
        System.out.println("You are a young adventurer traveling in an unknown land.");
        System.out.println("Months ago, you were traveling with a group of adventurers, but one night your got attacked by an evil and sorcerer.");
        System.out.println("Many of them died. You were badly injured, but you managed to escape and hide with some of them.\n");
        System.out.println("The sorcerer is now gone, but you and your friends have one purpose: find the sorcerer and kill him.");
        System.out.println("You know that he is somewhere in a forest, but you don't know where exactly.\n");
        System.out.println("This forest is full of dangers, so you'll have to fight at some point !");
        System.out.println("Every time you'll win against an enemy, you'll get a to choose a reward");
        System.out.println("Be careful, your teammates only have 1 life ! If one dies, you'll have to continue the journey without him.\n");
    }
    public static void attack1(){
        System.out.println("You are walking in the forest, when you see a shadow moving on your left");
        System.out.println("You turn around and see some goblins. They are coming towards you.");
        System.out.println("What do you do?\n");
    }

    public static void chapter2(){
        System.out.println("Your fight was pretty tiring and you need to rest a bit.");
        System.out.println("You decide to stop and take nap.");
        System.out.println("While sleeping, you feel something jumping on you.");
        System.out.println("You get scared and prepare to fight back.");
        System.out.println("In the end it's just a rabbit. You look at it and wonder what to do:\n");
        System.out.println("(1) - Kill it and eat it.\nAfter-all if not by you, it'll get killed soon.\n");
        System.out.println("(2) - Leave it alone.\nYou're vegetarian anyway.\n");
        System.out.println("(3) - Adopt it.\nIt's too cute to leave it in this dangerous forest.\n");
        int choice = Game.ReadInteger("Enter your choice:\n", 3);
        switch (choice) {
            case 1 -> {
                System.out.println("You killed the rabbit and ate it. It was delicious.");
                System.out.println("You feel a bit better and continue your journey.\n");
            }
            case 2 -> {
                System.out.println("You left the rabbit alone.");
                System.out.println("You feel a bit better because you saved a life and continue your journey.\n");
            }
            case 3 -> {
                System.out.println("You adopted the rabbit. It'll be your pet hihi.");
                System.out.println("Let's hope it will live a long life with you!\n");
                System.out.println("You feel a bit better and continue your journey.\n");
            }
        }
    }
    public static void attack2(){
        System.out.println("It's been days since your last encounter with a monster");
        System.out.println("You seem to be lost and wonder why you didn't see any monster since the last fight.");
        System.out.println("You decide to go back to the place where you fought the goblin. Maybe you'll find something there.");
        System.out.println("Before even moving in this direction, some men appear in front of you.");
        System.out.println("They are wearing a black outfit and look like an assassin.");
        System.out.println("One of them says:\n He already knows you're here. We'll kill you before you reach him\n");
        System.out.println("What do you do?\n");
    }

    public static void chapter3(){
        System.out.println("After this fight, you found a map in one of the assassins' pocket.");
        System.out.println("It seems to show the location of the sorcerer you're looking for.");
        System.out.println("Good. With this, you'll be able to find him in no time!");
    }
    public static void attack3(){
        System.out.println("You arrive at the place indicated on the map after 2 days.");
        System.out.println("This place is actually a cave. Problem : some dragons are guarding it!");
        System.out.println("They seem quite strong, but maybe you have your chances.");
        System.out.println("What do you do?\n");
    }

    public static void chapter4(){
        System.out.println("Great, you defeated the dragons!");
        System.out.println("You can now search for the sorcerer. He must be hidden in the cavern...\n");
        System.out.println("You're careful not to get lost in the cavern. It's huge and you don't know where you are.");
        System.out.println("After a while, you find a door. You open it and see a big room.\n");
        System.out.println("In the middle of the room, you see a big table with books on it.\n");
        System.out.println("On the walls, there are a lot of shelves with books too.");
        System.out.println("You're curious and decide to look at the books.");
        System.out.println("You pick one of them randomly and start reading it.");
        System.out.println("You realize that you're reading a book about magic.");
        System.out.println("After a while, you find a page that seems interesting.\n");
        System.out.println("It's a spell that can make you invisible.");
        System.out.println("You're not sure if it's a good idea... Should you try it?\n");
        System.out.println("(1) - Yes, of course! No pain no gain 'v'\n");
        System.out.println("(2) - No... you don't want to turn into a vegetable by accident.\n");
        int choice = Game.ReadInteger("\nEnter your choice:\n", 2);
        if (choice == 1){
            System.out.println("You decide to try the spell.");
            System.out.println("You start chanting the spell and suddenly you feel a strange sensation.");
            System.out.println("You feel like you're floating in the air.");
            System.out.println("You look at your hands and see that they're transparent.");
            System.out.println("You're now invisible!");
            System.out.println("Oh! You can also fly now!");
            System.out.println("Wait... Maybe it's going a bit to far...");
            System.out.println("You want to stop the spell and go back to normal now!");
            System.out.println("Nothing works... You start panicking and scream for help.");
            System.out.println("Oh no! The sorcerer heard you!");
            System.out.println("Some sorcerers appear in front of you and start chanting a spell.");
            System.out.println("Goodbye cruel world...\n");
            System.out.println("Well... Good news, you're not invisible anymore.");
            System.out.println("Bad news, you'll need to fight them now.");
            System.out.println("What do you do?\n");

            System.out.println("");
        }
        else{
            System.out.println("You decide not to try the spell.");
            System.out.println("You put the book back on the shelf and continue your search.");
            System.out.println("You're walking in the cavern when you hear a noise.");
            System.out.println("You look around and see a big spider.");
            System.out.println("It's coming towards you.");
            System.out.println("Oh no! You're scared of spiders!");
            System.out.println("You start screaming!");
            System.out.println("The sorcerer heard you and appears in front of you.");
            System.out.println("You'll need to find them now.");
            System.out.println("What do you do?\n");
        }
    }

    public static void storyChoice(){
        System.out.println("(1) - Fight");
        System.out.println("(2) - Check your stats");
        System.out.println("(3) - Check your inventory");
        System.out.println("(4) - Run away");
        System.out.println("(5) - Quit the game\n");
    }

    public static void victoryHunter(){
        System.out.println("(1) - +10pts in arrow's attack");
        System.out.println("(2) - x10 arrows");
        System.out.println("(3) - x3 pancakes (+30 hp)");
        System.out.println("(4) - x1 chocolate (+100 hp)");
    }
    public static void victoryWarrior(){
        System.out.println("(1) - +10pts in attack");
        System.out.println("(2) - x3 pancakes (+30 hp)");
        System.out.println("(3) - x1 chocolate (+100 hp)");
    }
    public static void victoryHealer(){
        System.out.println("(1) - +10 pts in healing ability");
        System.out.println("(2) - +30 pts of mana");
        System.out.println("(3) - x3 pancake");
        System.out.println("(4) - x3 apple juice (+30 mana)");
        System.out.println("(5) - x1 chocolate (+100 hp)");
        System.out.println("(6) - x1 coffee (+100 mana)");
    }
    public static void victoryMage(){
        System.out.println("(1) - +10pts in spell's attacks\n");
        System.out.println("(2) - +30pts of mana\n");
        System.out.println("(3) - x3 pancake\n");
        System.out.println("(4) - x3 apple juice\n");
        System.out.println("(5) - x1 chocolate\n");
        System.out.println("(6) - x1 coffee\\n\"");
    }

    public static void finalVictory(){
        System.out.println("You finally found the sorcerer and killed him.");
    }

    public static void defeat(){
        System.out.println("The fight was intense and you died.\nToo bad.\nYou'll have to start over.\n");
    }


}
