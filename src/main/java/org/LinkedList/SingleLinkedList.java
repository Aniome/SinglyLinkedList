package org.LinkedList;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int size;
    public void add(int data){
        if (head == null){
            head = new Node(data);
            tail = head;
        } else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index, int data){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        Node New = new Node(data);
        New.next = node.next;
        node.next = New;
        size++;
    }

    public void show(){
        Node node = head;
        for(int i = 0; i < size; i++){
            System.out.println(i + " = " + node.data);
            node = node.next;
        }
    }

    public int size(){
        return size;
    }



}
