package bai3;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

   public int size(){
        return size;
   }

   public boolean add(E e){
        ensureCapacity(size + 1);
       elements[size++] = e;
        return true;
   }

   public void add(int index, E element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        }
        ensureCapacity(size + 1);

        for(int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
   }

   public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
   }

   public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removed = (E) elements[index];

        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return removed;
   }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArr = new Object[newCapacity];

            for (int i = 0; i < size; i++) {
                newArr[i] = elements[i];
            }

            elements = newArr;
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public MyList<E> clone() {
        MyList<E> newList = new MyList<>(size);
        for (int i = 0; i < size; i++) {
            newList.add((E) elements[i]);
        }
        return newList;
    }





}
