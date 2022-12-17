package code.javarpg;

public enum Weapon{

    RING("ring", 15),
    SWORD("sword", 12),
    BOW("bow", 10),
    WAND("wand", 15);

    private String id;
    private int valueFight;

    Weapon(String id, int valueFight){
        this.id = id;
        this.valueFight = valueFight;
    }

    public String getId() {
        return id;
    }

    public int getValueFight() {
        return valueFight;
    }
}
