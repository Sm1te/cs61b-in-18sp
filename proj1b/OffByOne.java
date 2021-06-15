/**
 * @author Yijian Li
 * @create 2021-06-15 3:44 PM
 */
public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
