package Tests;
import code.javarpg.EnemyClass;
import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyClassTest {
    @Test
    void testid(){
        EnemyClass enemyClass = EnemyClass.GOBLIN;
        assert enemyClass.getId().equals("goblin");
    }
    @Test
    void testattackvalue(){
        EnemyClass enemyClass = EnemyClass.GOBLIN;
        assert enemyClass.getAttackValue() == 10;
    }
    @Test
    void testmaxpv(){
        EnemyClass enemyClass = EnemyClass.GOBLIN;
        assert enemyClass.getMaxPv() == 20;
    }
}
