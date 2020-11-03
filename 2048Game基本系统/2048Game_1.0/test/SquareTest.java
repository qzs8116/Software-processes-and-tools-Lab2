import static org.junit.Assert.*;
import Square.Square;
import org.junit.Test;

public class SquareTest {
    Square s1 = new Square(2);
    Square s2 = new Square(4);
    Square s3 = new Square(8);

    @Test
    public void testSquareChange(){
        s1.squareChange();
        s2.squareChange();
        s3.squareChange();
        assertEquals(s1.getNum(), 4);
        assertEquals(s2.getNum(), 8);
        assertEquals(s3.getNum(), 16);
    }
}
