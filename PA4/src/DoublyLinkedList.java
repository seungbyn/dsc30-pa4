/*
 * NAME: David Oh
 * PID: A18111523
 */

import java.util.AbstractList;

/**
 * Implementing a Doubly Linked List with two dummy nodes.
 * @author David Oh
 * @since 5/1/24
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         * @param element element to put into node
         */
        private Node(T element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         * @return returns element within Node
         */
        public T getElement() {
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            Node sucNode = this.getNext();
            Node prevNode = this.getPrev();
            sucNode.setPrev(prevNode);
            prevNode.setNext(sucNode);
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        Node headNode = new Node(null);
        Node tailNode = new Node(null);

        headNode.setNext(tailNode);
        tailNode.setPrev(headNode);

        this.head = headNode;
        this.tail = tailNode;
        this.nelems = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        this.nelems++;
        Node newNode = new Node(element, this.tail, this.tail.getPrev());
        this.tail.getPrev().setNext(newNode);
        this.tail.setPrev(newNode);
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * @param element data to be added
     * @param index index for data to be added
     * @throws NullPointerException if data received is null
     * @throws IndexOutOfBoundsException if index outside range [0, size]
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node suc = this.head;
        for (int i = 0; i < index + 1; i++) {
            suc = suc.getNext();
        }
        Node pre = suc.getPrev();
        Node newNode = new Node(element, suc, pre);
        suc.setPrev(newNode);
        pre.setNext(newNode);
        this.nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element checks if element is in linkedlist
     * @return whether or not element is in linkedlist
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node cur = this.head.getNext();
        for (int i = 0; i < this.size(); i++) {
            if (cur.getElement() == element) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index to get value of in linkedlist
     * @return value within Node at index
     * @throws IndexOutOfBoundsException if index less than 0 or greater than size -1
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = this.head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.getNext();
        }
        return cur.getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @param index index of which node to get
     * @return Node of nth index
     */
    private Node getNth(int index) {
        Node cur = this.head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.getNext();
        }
        return cur;
    }

    /**
     * Determine if the list empty
     *
     * @return whether or not linked list is empty
     */
    @Override
    public boolean isEmpty() {
        if (this.nelems == 0) {
            return true;
        }
        return false;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index of which node to remove from linked list
     * @return data within removed Node
     * @throws IndexOutOfBoundsException if index not in [0, size -1]
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = this.head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.getNext();
        }
        Node suc = cur.getNext();
        Node prev = cur.getPrev();
        suc.setPrev(prev);
        prev.setNext(suc);
        this.nelems--;
        return cur.getElement();
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index index to set data
     * @param element to change Node at index to
     * @return old element
     * @throws IndexOutOfBoundsException if index not in [0, size-1]
     * @throws NullPointerException if element is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }

        Node cur = this.head;
        for (int i = 0; i < index + 1; i++) {
            cur = cur.getNext();
        }
        T old = cur.getElement();
        cur.setElement(element);
        return old;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return number of elements in linked list
     */
    @Override
    public int size() {
        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * @return String representation of linked list
     */
    @Override
    public String toString() {
        String linkList = "[(head) -> ";
        Node cur = this.head;
        for (int i = 0; i < this.size(); i++) {
            cur = cur.getNext();
            linkList += String.valueOf(cur.getElement());
            if (i != this.size() - 1) {
                linkList += " -> ";
            }

        }
        if (!this.isEmpty()) {
            linkList += " -> ";
        }
        linkList += "(tail)]";
        return linkList;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Mimic Python list slicing, modify list in place
     *
     * TODO: javadoc comments
     */
    public void slice(int start, int end, int step) {
        // TODO: complete implementation       
    }

    /**
     * Recursively swaps halves of list for n recursive layers
     *
     * TODO: javadoc comments
     */
    public void swapHalves(int n, int start, int end) {
        // TODO: complete implementation
    }

}
