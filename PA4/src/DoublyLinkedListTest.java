import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @BeforeEach
    public void setUp() {
        LinkedList<Object> listName = new LinkedList<>();
    }

    @Test
    public void listConstructorTest() {
        DoublyLinkedList<Integer> listName = new DoublyLinkedList<>();
        assertEquals(listName.size(), 0);

        Assertions.assertThrows(NullPointerException.class, () -> {
            LinkedList<Integer> test1 = new LinkedList<>(null);
        });

        DoublyLinkedList<Integer> test2 = new DoublyLinkedList<>();
        assertTrue(test2.size() == 0);

    }

    @Test
    public void addTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        assertEquals(test1.add(1), true);

        assertEquals(test1.size(), 1);

        assertTrue(test1.add(2));
    }

    @Test
    public void addAtIndexTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0, 1);
        test1.add(0, 2);

        assertEquals(2, test1.get(0));

        test1.add(2, 3);
        assertEquals(3, test1.get(2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test1.add(5, 1);
        });

    }


    @Test
    public void addAllTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        ArrayList<Integer> group = new ArrayList<Integer>();
        group.add(1);
        group.add(2);

        test1.addAll(1, group);

        assertEquals(3, test1.size());
        assertEquals(2, test1.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test1.addAll(4, group);
        });
    }

    @Test
    public void clearTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        test1.add(1);
        test1.add(2);
        test1.add(3);

        assertEquals(4, test1.size());
        test1.clear();
        assertEquals(0, test1.size());
        test1.add(0);
        assertEquals(0, test1.get(0));
    }

    @Test
    public void equalsTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        DoublyLinkedList<Integer> test2 = new DoublyLinkedList<>();
        test2.add(0);
        DoublyLinkedList<Integer> test3 = new DoublyLinkedList<>();
        test3.add(1);

        assertTrue(test1.equals(test2));
        assertFalse(test1.equals(test3));
        assertFalse(test2.equals(test3));
    }

    @Test
    public void getTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        test1.add(1);
        test1.add(2);
        test1.add(3);

        assertEquals(1, test1.get(1));
        assertEquals(3, test1.get(3));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test1.get(4);
        });
    }

    @Test
    public void indexOfTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        test1.add(1);
        test1.add(2);
        test1.add(3);

        assertEquals(1, test1.indexOf(1));
        assertEquals(-1, test1.indexOf(5));
        assertEquals(2, test1.indexOf(2));
    }

    @Test
    public void lastIndexOfTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(1);

        assertEquals(4, test1.lastIndexOf(1));
        assertEquals(-1, test1.lastIndexOf(5));
        assertEquals(2, test1.lastIndexOf(2));
    }

    @Test
    public void removeTest() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0);
        test1.add(1);
        test1.add(2);
        test1.add(3);

        assertEquals(4, test1.size());
        assertEquals(3, test1.remove(3));
        assertEquals(3, test1.size());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test1.remove(3);
        });
    }


}