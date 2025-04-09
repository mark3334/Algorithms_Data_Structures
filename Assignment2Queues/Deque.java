import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;

        public Node(Item item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    // construct an empty deque
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Error: Item must not be null");
        Node newNode = new Node(item, head, null);
        if (isEmpty()) tail = newNode;
        else head.prev = newNode;
        head = newNode;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        // tail = tail.next = new Node(item, null);
        if (item == null) throw new IllegalArgumentException("Error: Item must not be null");
        Node newNode = new Node(item, null, tail);
        if (isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }


    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Error: Deque is empty");
        Item theItem = head.item;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        size--;
        return theItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Error: Deque is empty");
        Item theItem = tail.item;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
        size--;
        return theItem;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("Error: No more elements left!");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("Error: Operation not supported");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> dq = new Deque<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        dq.removeFirst();
        dq.removeLast();
        System.out.println("Size : " + dq.size);
        for (Integer i : dq) {
            System.out.println(i);
        }
        Integer[] a = { 1, 2, 3 };
        System.out.println("Len : " + a.length);
    }

}