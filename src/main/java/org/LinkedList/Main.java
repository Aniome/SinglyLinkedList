package org.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(3);
        singleLinkedList.add(2);
        singleLinkedList.add(4);
        singleLinkedList.add(0, 0);
        singleLinkedList.remove(4);
        //singleLinkedList.inversion();
        //singleLinkedList.clear();
        System.out.println(singleLinkedList.lastIndexOf(3));
        System.out.println(singleLinkedList);

        LinkedList<Integer> list = new LinkedList<>();
        list.remove(34);
    }
}