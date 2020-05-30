import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {
    CharacterComparator cc=new OffByN(4);
    @Test
    public void equalChars(){
        assertTrue(cc.equalChars('a','e'));
        assertFalse(cc.equalChars('a','d'));
        assertTrue(cc.equalChars('A','E'));
    }
}
