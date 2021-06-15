import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    public static void main(String[] args) {
        assertFalse(offByOne.equalChars('a','a'));
        assertTrue(offByOne.equalChars('b','a'));
        assertFalse(offByOne.equalChars('A','A'));
    }
}
