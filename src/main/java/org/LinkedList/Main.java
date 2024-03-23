package org.LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(3);
        singleLinkedList.add(2);
        singleLinkedList.add(4);
        singleLinkedList.add(0, 0);
        System.out.println("Remove 4 by data: " + singleLinkedList.remove(4));
        System.out.println("Remove by index 0: " + singleLinkedList.removeByIndex(0));
        System.out.println("Inversion: " + singleLinkedList.inversion());
        System.out.println("Get 2 node: " + singleLinkedList.get(2));
        System.out.println("Set 2 node: " + singleLinkedList.set(2, 10));
        System.out.println("size: " + singleLinkedList.size());
        System.out.println(singleLinkedList);
        System.out.println("last index of 3: " + singleLinkedList.lastIndexOf(3));
        System.out.println("index of 0: " + singleLinkedList.indexOf(0));
        System.out.println("contains 10: " + singleLinkedList.contains(10));
        singleLinkedList.clear();
        System.out.println("is empty: " + singleLinkedList.isEmpty());
    }
}