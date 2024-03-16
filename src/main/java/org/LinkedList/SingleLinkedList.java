package org.LinkedList;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void add(T data){
        if (head == null){
            head = new Node<>(data);
            tail = head;
        } else {
            Node<T> node = new Node<>(data);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int index, T data){
        Node<T> node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        Node<T> New = new Node<>(data);
        New.next = node.next;
        node.next = New;
        size++;
    }

    public boolean remove(Object object){
        Node<T> node = head;
        Node<T> prev = null;
        for (int i = 0; i < size; i++){
            if (node.data.equals(object)){
                remove(node, prev);
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    private void remove(Node<T> node, Node<T> prev){
        if (prev == null){
            if (head == tail)
                tail = null;
            head = node.next;
        } else {
            if (tail == node){
                tail = prev;
            }
            prev.next = node.next;
        }
        node.next = null;
        node.data = null;
        size--;
    }

    public T remove(int index){
        if (index == size)
            return null;
        if (index == 0){
            Node<T> newHead = head.next;
            head.next = null;
            head.data = null;
            head = newHead;
            return newHead.data;
        }
        Node<T> node, prev = head;
        for (int i = 0; i < index - 1; i++){
            prev = prev.next;
        }
        node = prev.next;
        prev.next = node.next;
        node.next = null;
        return node.data;
    }

    public void show(){
        Node<T> node = head;
        for(int i = 0; i < size; i++){
            System.out.println(i + " = " + node.data);
            node = node.next;
        }
    }

    public SingleLinkedList<T> inversion(){
        Node<T> previous = null, next = null, current = null;
        for (int i = 0; i < size; i++){
            if (i == 0){
                current = head;
                next = current.next;
                tail = current;
            } else if (i == size-1){
                previous = current;
                current = next;
                current.next = previous;
                head = current;
            } else {
                previous = current;
                current = next;
                next = next.next;
                current.next = previous;
            }
        }
        return this;
    }

    public T get(int index){
        return getNode(index).data;
    }

    public T set(int index, T data){
        Node<T> node = getNode(index);
        node.data = data;
        return node.data;
    }

    private Node<T> getNode(int index){
        Node<T> node = head;
        for (int i = 0; i <= index; i++){
            node = node.next;
        }
        return node;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder SingleLinkedList = new StringBuilder();
        Node<T> node = head;
        for(int i = 0; i < size; i++){
            SingleLinkedList.append(i).append(" = ").append(node.data).append("\n");
            node = node.next;
        }
        return SingleLinkedList.toString();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean contains(T data){
        Node<T> node = head;
        for (int i = 0; i <= size; i++){
            if (node.data.equals(data)){
                return true;
            }
        }
        return false;
    }

    //contains
    //clear
    //indexOf(Object) equals
    //lastIndexOf(Object)

}
