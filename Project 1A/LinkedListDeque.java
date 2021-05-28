public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(Node n1, T i, Node n2) {
            item = i;
            prev = n1;
            next = n2;
        }
    }

    public LinkedListDeque() {
        size=0;

    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        } else {
            Node now = sentinel;
            while (index >= 0) {
                now = now.next;
                index--;
            }
            return now.item;
        }
    }

    private int size;
    private Node sentinel = new Node(null, null, null);

    public boolean isEmpty() {
        return size == 0;
    }

    //size must take constant time.
    public int size() {
        return size;
    }

    public void printDeque() {
        Node now = sentinel;
        for (int i = size(); i > 0; i--) {
            now = now.next;
            System.out.print(now.item + " ");
        }
    }

    //get must use iteration, not recursion.
    public T get(int index) {
        if (index > size) {
            return null;
        } else {
            Node now = sentinel;
            while (index >= 0) {
                now = now.next;
                index--;
            }
            return now.item;
        }
    }

    //add and remove operations must not involve any looping or recursion.
// A single such operation must take “constant time”,
// i.e. execution time should not depend on the size of the deque.
    public void addFirst(T item) {
        if (size > 0) {
            Node First = new Node(sentinel, item, sentinel.next);
            sentinel.next.prev = First;
            sentinel.next = First;
        } else {
            Node Fisrt = new Node(sentinel, item, sentinel);
            sentinel.next = Fisrt;
            sentinel.prev = Fisrt;
        }
        size += 1;
    }

    public T removeFirst() {
        if (size > 0) {
            Node First1 = sentinel.next;
            sentinel.next = First1.next;
            First1.next.prev = sentinel;
            size -= 1;
            return First1.item;
        } else {
            return null;
        }
    }

    public void addLast(T item) {
        if (size > 0) {
            Node Last = new Node(sentinel.prev, item, sentinel);
            sentinel.prev.next = Last;
            sentinel.prev = Last;
        } else {
            Node Last = new Node(sentinel, item, sentinel);
            sentinel.next = Last;
            sentinel.prev = Last;
        }
        size += 1;
    }

    public T removeLast() {
        if (size > 0) {
            Node Last1 = sentinel.prev;
            sentinel.prev = Last1.prev;
            Last1.prev.next = sentinel;
            size -= 1;
            return Last1.item;
        } else {
            return null;
        }
    }


}
