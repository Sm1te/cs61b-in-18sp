/**
 * @author Yijian Li
 * @create 2021-06-15 3:48 PM
 */
public interface Deque<Item> {
    public void addFirst(Item item);
    public void addLast(Item item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public Item get(int index);
    public Item removeFirst();
    public Item removeLast();
}
