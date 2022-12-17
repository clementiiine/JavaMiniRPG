package code.javarpg;

public class Enemy extends Combatant{
    private String name;
    private EnemyClass enemyClass;

    // Constructeur de la classe Enemy
    public Enemy (EnemyClass enemyClass) {
        this.enemyClass = enemyClass;
        this.name = enemyClass.getId();
        setHpMax(enemyClass.getMaxPv());
        setHp(enemyClass.getMaxPv());
        setValueFight(enemyClass.getAttackValue());
    }

    public String getName() {
        return name;
    }

}