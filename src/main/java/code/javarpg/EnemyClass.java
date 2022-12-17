package code.javarpg;

public enum EnemyClass {

    GOBLIN("goblin", 80, 10),
    ASSASSIN("assassin", 100,20),
    DRAGON("dragon", 120,30),
    SORCERER("sorcerer", 140, 50);

    private int attackValue;
    private String id;
    private int maxPv;

    EnemyClass(String id, int maxPv, int attackValue){
        this.id = id;
        this.maxPv = maxPv;
        this.attackValue = attackValue;
    }

    public String getId() {
        return id;
    }

    public int getMaxPv() {
        return maxPv;
    }

    public int getAttackValue() {
        return attackValue;
    }
}
