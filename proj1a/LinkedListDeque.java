public class LinkedListDeque<T>{


    public class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(Node m, T i, Node n) {
            item = i;
            next = n;
            prev = m;
        }
        
        private T getRecursive(int index){
			if(index == 0){
				return this.item;
			}
			return next.getRecursive(index -1);
		}
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(T x){
        sentinel = new Node (null, null, null);
        sentinel.next = new Node (sentinel, null, sentinel);
        sentinel.prev = sentinel.next;
        size =1;
    }

    public LinkedListDeque(){
        sentinel = new Node (null, null, null);
        sentinel.next = sentinel;   
        sentinel.prev = sentinel;
        size =  0;
    }
    
    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel .prev;
        size += 1;
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int j = 0;
        Node c = sentinel.next;
        while(j<size){
            System.out.println(c.item);
            c=c.next;
            j++;
        }
    }

    public T removeFirst(){
        Node z = sentinel.next;
        if(isEmpty()){
            return null;
        }
        z.next.prev=sentinel;
        sentinel.next=z.next;
        size -=1;
        return z.item;
    }

    public T removeLast(){
        Node y = sentinel.prev;
        if(isEmpty()){
            return null;
        }
        y.prev.next=sentinel;
        sentinel.prev=y.prev;
        size -=1;
        return y.item;
    }

    public T get(int index){
        if(index>size){
            return null;
        }
        Node p = sentinel;
        for(int f = 0; f< index; f++){
            p = p.next;
        }
        return p.item;
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        for(int i=0;i<other.size;i++){
            addLast(other.get(i));
        }
    }


}
