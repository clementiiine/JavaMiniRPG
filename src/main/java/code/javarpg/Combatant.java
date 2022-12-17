package code.javarpg;

abstract public class Combatant {
    protected int hp, hpMax, valueFight;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getValueFight() {
        return valueFight;
    }

    public void setValueFight(int valueFight) {
        this.valueFight = valueFight;
    }

}
