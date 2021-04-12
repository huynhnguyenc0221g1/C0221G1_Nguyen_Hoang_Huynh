package ss9_dsa_list.bai_tap.LinkedList;

public class MyLinkedList<E> {

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numberOfNodes = 0;


    public MyLinkedList() {
    }

    public void add(E element, int index) {
        Node tempNode = head;
        Node holder;
        for (int i = 0; i < index - 1 && tempNode.next != null; i++) {
            tempNode = tempNode.next;
        }
        holder = tempNode.next;
        tempNode.next = new Node(element);
        tempNode.next.next = holder;
        numberOfNodes++;
    }

    public void addFirst(E element) {
        Node tempNode = head;
        head = new Node(element);
        head.next = tempNode;
        numberOfNodes++;
    }

    public void addLast(E element) {
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = new Node(element);
        numberOfNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index > numberOfNodes) {
            throw new IllegalArgumentException();
        }
        Node tempNode = head;
        Object removedData;
        if (index == 0) {
            removedData = tempNode.data;
            head = head.next;
            numberOfNodes--;
        } else {
            for (int i = 0; i < index - 1 && tempNode.next != null; i++) {
                tempNode = tempNode.next;
            }
            removedData = tempNode.next.data;
            tempNode.next = tempNode.next.next;
            numberOfNodes--;
        }
        return (E) removedData;
    }

    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                if (tempNode.next.data.equals(element)) {
                    tempNode.next = tempNode.next.next;
                    numberOfNodes--;
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    public Object get(int index) {
        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    public int size() {
        return numberOfNodes;
    }

    public void printList() {
        Node tempNode = head;
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }
    }

    public MyLinkedList<E> clone() {
        if (numberOfNodes == 0) {
            throw new IllegalArgumentException();
        }
        MyLinkedList<E> clonedLinkedList = new MyLinkedList<>();
        Node clonedNode = head;
        clonedLinkedList.addFirst((E) clonedNode.data);
        clonedNode = clonedNode.next;
        while (clonedNode != null) {
            clonedLinkedList.addLast((E) clonedNode.data);
            clonedNode = clonedNode.next;
        }
        return clonedLinkedList;
    }

    public boolean contains(E element) {
        Node tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.data.equals(element)) {
                return true;
            }
            tempNode = tempNode.next;
        }
        if (tempNode.data.equals(element)) {
            return true;
        }
        return false;
    }

    public int indexOf(E element) {
        Node tempNode = head;
        for (int i = 0; i < numberOfNodes; i++) {
            if (tempNode.getData().equals(element)) {
                return i;
            }
            tempNode = tempNode.next;
        }
        return -1;
    }




}
