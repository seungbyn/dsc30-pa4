/*
    Name: TODO
    PID:  TODO
 */

/**
 * TODO
 *
 * @author David Oh
 * @since 5/1/24
 */

public class MyQueue<T> {
    
    /* instance variables, feel free to add if you need */

    /* ===separation=== */
    private DoublyLinkedList<Object> linkedList;

    public MyQueue() {
        linkedList = new DoublyLinkedList<>();
    }

    public boolean isEmpty() {
        if (this.linkedList.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.linkedList.size();
    }

    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.linkedList.add(data);
    }

    public T dequeue() {
        T returnObject = (T) this.linkedList.remove(0);
        return returnObject;
    }

    public T peek() {
        return (T) this.linkedList.get(0);
    }

    @Override
    public String toString(){

        return this.linkedList.toString();
    }
}
