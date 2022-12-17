package Tests;
import code.javarpg.Hero;
import code.javarpg.HeroClass;
import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;


public class HeroTest {
    @Test
    void testname() {
        Hero hero = new Hero.Builder("warrior", HeroClass.WARRIOR).build();
        assert hero.getName().equals("hero");
    }
    @Test
    void testheroClass() {
        Hero hero = new Hero.Builder("warrior", HeroClass.WARRIOR).build();
        assert hero.getHeroClass().equals("warrior");
    }
    @Test
    void testarrows() {
        Hero hero = new Hero.Builder("hunter", HeroClass.HUNTER).arrows(10).build();
        assert hero.getArrows() == 10;
    }
    @Test
    void testmana() {
        Hero hero = new Hero.Builder("mage", HeroClass.MAGE).build();
        assert hero.getMana() == 100;
    }
    @Test
    void testmanaMax() {
        Hero hero = new Hero.Builder("mage", HeroClass.MAGE).build();
        assert hero.getManaMax() == 100;
    }
    @Test
    void testdmg() {
        Hero hero = new Hero.Builder("warrior", HeroClass.WARRIOR).build();
        assert hero.getValueFight() == 10;
    }
    @Test
    void testhp() {
        Hero hero = new Hero.Builder("warrior", HeroClass.WARRIOR).build();
        assert hero.getHp() == 100;
    }
    @Test
    void testhpMax() {
        Hero hero = new Hero.Builder("warrior", HeroClass.WARRIOR).build();
        assert hero.getHpMax() == 100;
    }
}
