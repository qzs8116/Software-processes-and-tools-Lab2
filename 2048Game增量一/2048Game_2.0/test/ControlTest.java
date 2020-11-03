import static org.junit.Assert.*;

import Start.Control;
import org.junit.Test;

public class ControlTest {
    public Control c = new Control();

    @Test
    public void TestRemoveSquare(){
        c.removeSquare(2);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                assertTrue(c.getGame().getBoard().getPosition(i, j).getSquare() == null);
            }
        }
    }
}
