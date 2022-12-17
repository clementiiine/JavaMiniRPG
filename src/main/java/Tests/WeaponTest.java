package Tests;
import code.javarpg.Weapon;
import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;


class WeaponTest {
    @Test
    void testid() {
        Weapon weapon = Weapon.SWORD;
        assert weapon.getId().equals("sword");
    }
    @Test
    void testvalueFight() {
        Weapon weapon = Weapon.SWORD;
        assert weapon.getValueFight() == 15;
    }
}

