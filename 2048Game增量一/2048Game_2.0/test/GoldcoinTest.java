import static org.junit.Assert.*;

import GoldCoin.Goldcoin;
import org.junit.Test;

import java.security.PublicKey;

public class GoldcoinTest {
    public Goldcoin gc = new Goldcoin();

    @Test
    public void TestAddAndMinus(){
        gc.addNum(1);
        assertEquals(gc.getNum(), 1);
        assertEquals(gc.getPer_num(), 0);
        gc.addNum(2);
        assertEquals(gc.getNum(), 3);
        assertEquals(gc.getPer_num(), 0);
        gc.setPer_num(gc.getNum());
        assertEquals(gc.getPer_num(), 3);
    }
}
