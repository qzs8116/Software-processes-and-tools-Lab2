import static org.junit.Assert.*;

import Score.Score;
import org.junit.Test;

public class ScoreTest {
    public Score s = new Score();

    @Test
    public void TestAddAndInit(){
        s.addScore(1);
        assertEquals(s.getSco(),1);
        s.init_Score();
        assertEquals(s.getSco(), 0);
    }
}
