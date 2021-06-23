package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     *
     * @param x
     */

    public void enqueue(T x) {

        if (last == this.capacity) {
            last = 0;
        }

        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        rb[last] = x;
        last = last + 1;
        fillCount += 1;
    }
    // TODO: Enqueue the item. Don't forget to increase fillCount and update last.


    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        if (first >= this.capacity) {
            first = 0;
        }
        T result = rb[first];
        rb[first] = null;
        first += 1;
        fillCount = fillCount - 1;
        return result;
    }
    // TODO: Dequeue the first item. Don't forget to decrease fillCount and update


    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (first == this.capacity) {
            first = 0;
        }
        if (this.isEmpty()) {
            throw new RuntimeException("there is nothing");
        }
        return rb[first];
        // TODO: Return the first item. None of your instance variables should change.
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {

        private int start;

        public ArrayRingBufferIterator() {
            start = first;
        }

        public boolean hasNext() {
            if (start == capacity - 1) {
                start = 0;
            }
            return (start != last);
        }

        public T next() {
            if (hasNext()) {
                T result = rb[start];
                start = start + 1;
                return result;
            } else {
                throw new RuntimeException("Ring Buffer Underflow");
            }
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
