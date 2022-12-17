package Tests;
import code.javarpg.Enemy;
import code.javarpg.EnemyClass;
import org.junit.jupiter.api.Test ;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
    @Test
    void testname() {
        Enemy enemy = new Enemy(EnemyClass.GOBLIN);
        assert enemy.getName().equals("goblin");
    }
}
