package org.LinkedList;

import java.util.Collections;
import java.util.List;

public class SingleLinkedList<T> {

    private Node head;
    private Node tail;
    private int size;
    public void add(T data){
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

    public void add(int index, T data){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        Node New = new Node(data);
        New.next = node.next;
        node.next = New;
        size++;
    }

    public boolean remove(Object object){


        return true;
    }

    public Integer remove(int index){

        return 0;
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

    //remove(Object) (index)
    //inversion
    //get
    //set
    //contains
    //toString
    //isEmpty
    //clear
    //indexOf(Object) equals
    //lastIndexOf(Object)

}
