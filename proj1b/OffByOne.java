/**
 * @author Yijian Li
 * @create 2021-06-15 3:44 PM
 */
public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == 1;
    }
}
