public class ArrayDeque<T> {
    private T[] items;
    private int firstnext = 7;
    private int lastnext = 0;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        return items[index];
    }

    public void printDeque() {
        for (T item : items) {
            System.out.print(item + " ");
        }
    }
    private void resize(){
        T[] resizedArray = (T[])new Object[items.length * 2];
        System.arraycopy(items, 0, resizedArray, 0, firstnext + 1);
        if((firstnext + 1) != items.length){
            System.arraycopy(items, firstnext + 1, resizedArray, items.length + firstnext + 1, items.length - firstnext - 1);
        }
        items = resizedArray;
        firstnext = firstnext + resizedArray.length / 2;
    }

    public void addFirst(T item) {
        if (firstnext == lastnext) {
            resize();
        }
        if(firstnext == -1){
            firstnext=items.length-1;
        }
        items[firstnext] = item;
        firstnext--;
        size++;
    }
    public void addLast(T x){

        if(lastnext == items.length){
            lastnext = 0;
        }

        if(lastnext == firstnext){
            resize();
        }

        items[lastnext] = x;
        lastnext = lastnext + 1;
        size += 1;
    }
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        if(firstnext == items.length){
            firstnext = 0;
        }
        T first=items[firstnext+1];
        items[firstnext+1]=null;
        firstnext++;
        size--;
        return first;
    }
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        if(lastnext <0){
            lastnext = items.length-1;
        }
        T last=items[lastnext-1];
        items[lastnext-1]=null;
        lastnext--;
        size--;
        return last;
    }


}
