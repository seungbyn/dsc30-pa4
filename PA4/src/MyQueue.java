/*
    Name: David Oh
    PID:  A18111523
 */

/**
 * Implements Queue ADT using linked list
 *
 * @author David Oh
 * @since 5/1/24
 */

public class MyQueue<T> {
    
    /* instance variables, feel free to add if you need */

    /* ===separation=== */
    private DoublyLinkedList<Object> linkedList;

    /**
     * Constructor
     *
     *
     */
    public MyQueue() {
        linkedList = new DoublyLinkedList<>();
    }

    /**
     * checks if queue is empty
     *
     * @return whether or not queue is empty
     */
    public boolean isEmpty() {
        if (this.linkedList.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * checks size of queue
     *
     * @return number of elements in queue
     */
    public int size() {
        return this.linkedList.size();
    }

    /**
     * adds element to queue
     *
     * @param data to be added to queue
     * @throws IllegalStateException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.linkedList.add(data);
    }

    /**
     * removes element from queue
     *
     * @return element that was dequeued
     */
    public T dequeue() {
        T returnObject = (T) this.linkedList.remove(0);
        return returnObject;
    }

    /**
     * checks first element in queue
     *
     * @return first element in queue
     */
    public T peek() {
        return (T) this.linkedList.get(0);
    }

    /**
     * String representation of queue
     *
     * @return String representation of queue
     */
    @Override
    public String toString() {
        String linkList = "[";

        for (int i = 0; i < this.linkedList.size(); i++) {
            linkList += this.linkedList.get(i);
            if (i != this.size() - 1) {
                linkList += " -> ";
            }
        }
        linkList += "]";
        return linkList;
    }
}
