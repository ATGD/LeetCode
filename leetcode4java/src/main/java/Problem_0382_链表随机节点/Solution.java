package Problem_0382_链表随机节点;

import java.util.ArrayList;
import java.util.Iterator;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next;


    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) next = iterator.next();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasNext()) {
            int tmp = next;
            next = iterator.hasNext() ? iterator.next() : null;
            return tmp;
        } else return null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}

class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator pi = new PeekingIterator(list.iterator());

        System.out.println(pi.next());
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
    }
}

