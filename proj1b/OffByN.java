/**
 * @author Yijian Li
 * @create 2021-06-15 3:44 PM
 */
public class OffByN implements CharacterComparator{
    int size;

    public OffByN(int size){
        this.size=size;
    }

    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == size;
    }
}
