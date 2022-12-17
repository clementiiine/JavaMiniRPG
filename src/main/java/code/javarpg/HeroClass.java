package code.javarpg;

public enum HeroClass {

    WARRIOR("warrior", Weapon.SWORD, 0),
    HUNTER("hunter", Weapon.BOW, 10),
    MAGE("mage", Weapon.WAND, 10),
    HEALER("healer", Weapon.RING, 20);

    private final String id;
    private Weapon weapon;
    private final int staminaValue;

    HeroClass(String id, Weapon weapon, int staminaValue){
        this.id = id;
        this.weapon = weapon;
        this.staminaValue = staminaValue;
    }

    public String getId() {
        return id;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public int getStaminaValue() {
        return staminaValue;
    }

}
