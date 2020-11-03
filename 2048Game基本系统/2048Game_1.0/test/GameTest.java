import static org.junit.Assert.*;

import Game.Game;
import Square.Square;
import org.junit.Test;

public class GameTest {
    Game g = new Game();

    @Test
    public void testMovequare(){
        g.getBoard().getPosition(1, 2).setSquare(new Square(2));
        g.getBoard().getPosition(2,2).setSquare(new Square(2));
        g.getBoard().getPosition(2,3).setSquare(new Square(4));
        g.getBoard().getPosition(3, 3).setSquare(new Square(8));
        g.upSquare();
        assertEquals(g.getBoard().getPosition(1,3).getSquare().getNum(), 2);
        assertEquals(g.getBoard().getPosition(2,2).getSquare().getNum(), 2);
        assertEquals(g.getBoard().getPosition(2,3).getSquare().getNum(), 4);
        assertEquals(g.getBoard().getPosition(3,3).getSquare().getNum(), 8);
        g.downSquare();
        assertEquals(g.getBoard().getPosition(1,0).getSquare().getNum(), 2);
        assertEquals(g.getBoard().getPosition(2,0).getSquare().getNum(), 2);
        assertEquals(g.getBoard().getPosition(2,1).getSquare().getNum(), 4);
        assertEquals(g.getBoard().getPosition(3,0).getSquare().getNum(), 8);
        g.leftSquare();
        assertEquals(g.getBoard().getPosition(0,0).getSquare().getNum(), 4);
        assertEquals(g.getBoard().getPosition(1,0).getSquare().getNum(), 8);
        assertEquals(g.getBoard().getPosition(0,1).getSquare().getNum(), 4);
        assertTrue(g.getBoard().getPosition(3,0).getSquare() == null);
        g.rightSquare();
        assertEquals(g.getBoard().getPosition(2,0).getSquare().getNum(), 4);
        assertEquals(g.getBoard().getPosition(3,0).getSquare().getNum(), 8);
        assertEquals(g.getBoard().getPosition(3,1).getSquare().getNum(), 4);
    }

    @Test
    public void TestCheckGameOver(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                g.getBoard().getPosition(i, j).setSquare(new Square(2));
            }
        }
        assertTrue(g.checkAroundSquareSame(g.getBoard().getPosition(1,3)));
    }
}
