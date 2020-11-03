import static org.junit.Assert.*;

import Board.Board;
import org.junit.Test;

public class BoardTest {
    Board b = new Board();

    @Test
    public void TestGetPosition(){
        assertEquals(b.getPosition(1, 2).getX(), 1);
        assertEquals(b.getPosition(1,2).getY(), 2);
    }
}
