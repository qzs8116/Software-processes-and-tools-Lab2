import Action.Action;
import Board.Position;
import Square.Square;

import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {
    Position p1 = new Position(1, 2);
    Position p2 = new Position(1, 3);
    Position p3 = new Position(1, 4);

    Action a = new Action();

    @Test
    public void testMoveSquare(){
        p2.setSquare(new Square(2));
        p3.setSquare(new Square(2));
        assertFalse(a.moveSquare(p1, p2));
        assertTrue(a.moveSquare(p2, p3));
        assertEquals(p3.getSquare().getNum(), 4);
        assertTrue(p2.getSquare() == null);
        assertTrue(a.moveSquare(p3, p1));
        p2.setSquare(new Square(8));
        assertFalse(a.moveSquare(p1,p2));
    }
}
