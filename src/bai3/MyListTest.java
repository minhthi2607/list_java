package bai3;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.add(1, 15);

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Contains 20: " + list.contains(20));

        list.remove(2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
