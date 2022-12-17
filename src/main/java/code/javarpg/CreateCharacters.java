package code.javarpg;

public class CreateCharacters {

    public Hero createHero(String name, HeroClass heroClass) {
        Hero hero = switch (heroClass) {
            case WARRIOR -> new Hero.Builder(name, heroClass).build();
            case HUNTER -> new Hero.Builder(name, heroClass).arrows(heroClass.getStaminaValue()).build();
            case MAGE, HEALER -> new Hero.Builder(name, heroClass).manaMax(heroClass.getStaminaValue()).build();
        };
        return hero;
    }

    public Enemy createEnemy(EnemyClass enemyClass) {
        return new Enemy(enemyClass);
    }

}
