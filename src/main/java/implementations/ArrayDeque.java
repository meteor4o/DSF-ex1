package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private static final int DEFAULT_CAPACITY = 7;

    private int head;
    private int tail;
    private int size;

    private Object[] elements;

    public ArrayDeque(Object[] elements) {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;
    }

    @Override
    public void add(E element) {
        this.addLast(element);
    }

    private void grow() {
        Object[] newElements = new Object[this.elements.length * 2];

    }

    @Override
    public void offer(E element) {
        this.addFirst(element);
    }

    @Override
    public void addFirst(E element) {
        if(this.size == 0) {
            this.elements[this.head] = element;
        } else {
            if(this.head ==0 ) {
                this.grow();
            }
            this.elements[--this.head] = element;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        this.addLast(element);
    }

    @Override
    public void insert(int index, E element) {
        if(index < 0 || index < this.size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            this.addFirst(element);
        } else if(index == this.size) {
            this.addLast(element);
        } else {
            if(this.tail == this.elements.size-1 ) {
                this.grow();
            }
            this.tail++;
            for (int i = this.tail; i >= this.head+index; i--) {
                this.elements[i] = elements[i-1];
            }
            this.elements[this.head+index] = element;
        }
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public E peek() {
        if(this.size == 0) {
            return null;
        }
        return valueof(this.elements[this.head]);
    }

    private E valueof(Object element) {
        return (E) element;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E get(int index) {
        return valueof(this.elements[this.head+index]);
    }

    @Override
    public E get(Object object) {
        for (int i = this.head; i <= this.tail ; i++) {
            if(this.elements[i].equals(object)) {
                return valueof(this.elements[i]);
            }
        }
    return null;
    }

    @Override
    public E remove(int index) {
        if(this.isEmpty()) {
            return null;
        }
        E elementToReturn = null;

        if(index == 0) {
            elementToReturn = valueof(this.elements[this.head]);
            this.head++;
        } else if(index == this.size-1) {
            elementToReturn = valueof(this.elements[this.size-1]);
            this.tail--;
        } else {
            for (int i = this.head+index; i < this.tail; i++) {
                this.elements[i] = this.elements[i+1];
                this.tail--;
            }
        }


        return null;
    }

    @Override
    public E remove(Object object) {
        for (int i = this.head; i <= this.tail; i++) {
            if(this.elements[i].equals(object)) {
                return this.remove(i);
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(this.size-1);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
