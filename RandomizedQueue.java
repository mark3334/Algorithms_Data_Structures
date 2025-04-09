import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private Item[] arr;


    // construct an empty randomized queue
    public RandomizedQueue() {
        int startCapacity = 1;
        arr = (Item[]) new Object[startCapacity];
    }


    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    private void changeArrSize(int newCapacity) {
        // Capacity must always be greater than 0
        Item[] copy = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            copy[i] = arr[i];
        }
        arr = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Error: Item must not be null");
        if (size == arr.length) {
            changeArrSize(arr.length * 2);
        }
        arr[size++] = item;
    }


    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Error: RandomizedQueue is empty");
        int index = StdRandom.uniformInt(size);
        Item toRemove = arr[index];
        arr[index] = arr[size - 1];
        arr[size - 1] = toRemove;
        arr[size - 1] = null;
        size--;
        if (size > 0 && size == arr.length / 4) {
            changeArrSize(arr.length / 2);
        }
        return toRemove;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Error: RandomizedQueue is empty");
        int index = StdRandom.uniformInt(size);
        return arr[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current = size - 1;
        // private int[] order = StdRandom.permutation(size);
        private Item[] arrCopy;

        public RandomizedQueueIterator() {
            arrCopy = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                arrCopy[i] = arr[i];
            }
        }

        public boolean hasNext() {
            return current >= 0;
        }


        public Item next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException("Error: No more elements left!");
            int index = StdRandom.uniformInt(current + 1);
            // Swapping values does not affect RandomizedQueue functionality
            Item toRemove = arrCopy[index];
            arrCopy[index] = arrCopy[current];
            arrCopy[current] = toRemove;
            current--;
            return toRemove;
            // return arr[order[current++]];
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("Error: Operation not supported");
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
    }

    // public void printInfo() {
    //     System.out.println("Size : " + this.size);
    //     System.out.println("Capacity : " + this.capacity());
    //     for (Item i : this) {
    //         System.out.println(i);
    //     }
    //     System.out.println("Second iterator : ");
    //     for (Item i : this) {
    //         System.out.println(i);
    //     }
    //     System.out.println("Nested iterators : ");
    //     for (Item i : this) {
    //         System.out.println("i : " + i);
    //         for (Item j : this) {
    //             System.out.println("j : " + j);
    //         }
    //     }
    // }

    // private int capacity() {
    //     return arr.length;
    // }

}
