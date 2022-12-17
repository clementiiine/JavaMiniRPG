package code.javarpg;

public class Hero extends Combatant{

    private final String name;
    private final String heroClass;
    private int arrows;
    private int mana;
    private int manaMax;

    // Constructeur de la classe Hero (builder pour les paramètres facultatifs)
    public Hero(Builder builder) {
        this.name = builder.name;
        this.heroClass = builder.heroClass;
        setHpMax(100);
        setHp(getHpMax());
        this.manaMax = builder.manaMax;
        this.mana = this.manaMax;
        this.arrows = builder.arrows;
        setValueFight(builder.dmg);
    }

    public String getName() {
        return name;
    }
    public String getHeroClass() {
        return heroClass;
    }
    public int getArrows() {
        return arrows;
    }
    public void setArrows(int arrows) {
        this.arrows = arrows;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getManaMax() {
        return manaMax;
    }
    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public static class Builder {
        private final String name;
        private final String heroClass;
        private final int dmg;
        private int arrows;
        private int manaMax;

        public Builder(String name, HeroClass heroClass) {
            this.name = name;
            this.heroClass = heroClass.getId();
            this.dmg = heroClass.getWeapon().getValueFight();
        }
        public Builder arrows(int arrows) {
            this.arrows = arrows;
            return this;
        }
        public Builder manaMax(int manaMax) {
            this.manaMax = manaMax;
            return this;
        }
        public Hero build() {
            return new Hero(this);
        }

    }

}
