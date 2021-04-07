public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 3;
    private int nextLast = 4;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public T get(int index){
        return items[index];
    }

    public void printDeque(){
        for(T item:items){
            System.out.print(item + " ");
        }
    }

    public void resize(){
        T[] revisedone = (T[]) new Object[items.length * 4];
        System.arraycopy(items, 0, revisedone, (items.length*2)-(items.length/2), items.length);//calculate the position of nextFirst;
        nextFirst = items.length *3/2 -1;
        nextLast = items.length *5/2 +1;
    }

    public ArrayDeque(ArrayDeque other){

    }

    public void addFirst(T item){
        if(nextFirst == -1){
            nextFirst = items.length -1;
        }
        if(nextFirst == nextLast){
            resize();
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    public void addLast(T item){
        if(nextLast == items.length){
            nextLast = 0;
        }
        if(nextFirst == nextLast){
            resize();
        }
        items[nextLast] = item;
        nextLast++;
        size++;
    }
    
    public T removeFirst(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        if(nextFirst >= items.length){
            nextFirst = 0;
        }
        T result = items[nextFirst+1];
        items[nextFirst+1] = null;
        nextFirst++;
        size--;
        return result;
    }
    public T removeLast(){
        if(isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        if(nextLast== -1){
            nextLast = items.length - 1;
        }
        T result = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        return result;
    } 
}
