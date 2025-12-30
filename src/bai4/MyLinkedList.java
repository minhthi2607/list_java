package bai4;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes =0 ;

    public MyLinkedList() {
        head = null;
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(e);
        numNodes++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(element);
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E data = (E) head.data;
            head = head.next;
            numNodes--;
            return data;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        E data = (E) prev.next.data;
        prev.next = prev.next.next;
        numNodes--;

        return data;
    }

    public boolean remove(E e) {
        if (head == null) return false;

        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(e)) {
                current.next = current.next.next;
                numNodes--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int size() {
        return numNodes;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return (E) temp.data;
    }

    public E getFirst() {
        if (head == null) return null;
        return (E) head.data;
    }

    public E getLast() {
        if (head == null) return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        return (E) temp.data;
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    public int indexOf(E e) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data.equals(e)) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();

        Node temp = head;
        while (temp != null) {
            newList.addLast((E) temp.data);
            temp = temp.next;
        }

        return newList;
    }












}
