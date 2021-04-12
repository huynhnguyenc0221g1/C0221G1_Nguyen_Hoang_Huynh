package ss9_dsa_list.bai_tap.ArrayList;


import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            System.out.println("Successful created, the size is " + capacity);
            elements = new Object[capacity];
        } else {
            System.out.println("Error!");
            throw new IllegalArgumentException("Capacity : " + capacity);
        }
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index : " + index);
        } else if (elements.length == index + 1) {
            ensureCapacity(1);
        }
        if (elements[index] == null) {
            size++;
            elements[index] = element;
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public MyArrayList<E> clone() {
        MyArrayList<E> cloneList = new MyArrayList<>();
        cloneList.elements = Arrays.copyOf(elements, size);
        cloneList.size = size;
        return cloneList;
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }


    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
            System.out.println("Successful created, the size is " + elements.length);
        } else {
            throw new IllegalArgumentException("minCapacity" + minCapacity);
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

}
