import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    @Test
    public void constructorTest() {
        MyQueue queue = new MyQueue();
    }

    @Test
    public void isEmptyTest() {
        MyQueue queue = new MyQueue();

        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void sizeTest() {
        MyQueue queue = new MyQueue();

        assertEquals(0, queue.size());

        queue.enqueue(0);
        queue.enqueue(0);
        queue.enqueue(0);

        assertEquals(3, queue.size());

        queue.dequeue();
        queue.dequeue();

        assertEquals(1, queue.size());
    }

    @Test
    public void enqueueTest() {
        MyQueue queue = new MyQueue();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue.enqueue(null);
        });

        queue.enqueue(0);
        queue.enqueue(1);

        assertEquals(0, queue.peek());

        queue.enqueue(2);

        assertEquals(3, queue.size());
    }

    @Test
    public void peekTest() {
        MyQueue queue = new MyQueue();

        queue.enqueue(0);
        queue.enqueue(1);

        assertEquals(0, queue.peek());

        queue.dequeue();

        assertEquals(1, queue.peek());

        queue.enqueue(1000);
        queue.dequeue();
        assertEquals(1000, queue.peek());
    }

    @Test
    public void dequeueTest() {
        MyQueue queue = new MyQueue();

        queue.enqueue(0);
        queue.enqueue(1);

        assertEquals(2, queue.size());

        assertEquals(0, queue.dequeue());

        assertEquals(1, queue.size());
    }

    @Test
    public void toStringTest() {
        MyQueue queue = new MyQueue();

        assertEquals("[]", queue.toString());

        queue.enqueue(0);
        assertEquals("[0]", queue.toString());
        queue.enqueue(1);
        assertEquals("[0 -> 1]", queue.toString());
    }
}