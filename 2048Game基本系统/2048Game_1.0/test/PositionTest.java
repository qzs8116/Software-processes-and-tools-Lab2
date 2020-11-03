import Board.Position;

import static org.junit.Assert.*;

import Square.Square;
import org.junit.Test;

public class PositionTest {
    Position p = new Position(1, 2);

    @Test
    public void testSetAndGetSquare(){
        p.setSquare(new Square(2));
        assertEquals(p.getSquare().getNum(), 2);
        p.removeSquare();
        assertTrue(p.getSquare()==null);
    }
}
