package Tests;
import code.javarpg.HeroClass;
import code.javarpg.Weapon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroClassTest {
    @Test
    void testid(){
        HeroClass heroClass = HeroClass.WARRIOR;
        assert heroClass.getId().equals("warrior");
    }
    @Test
    void testweapon(){
        HeroClass heroClass = HeroClass.WARRIOR;
        assert heroClass.getWeapon().equals(Weapon.SWORD);
    }
    @Test
    void teststaminaValue(){
        HeroClass heroClass = HeroClass.WARRIOR;
        assert heroClass.getStaminaValue() == 10;
    }
}
