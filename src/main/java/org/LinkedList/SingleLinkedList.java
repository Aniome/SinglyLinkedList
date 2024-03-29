package org.LinkedList;

import java.util.Objects;

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

    public boolean remove(T data){
        Node<T> node = head;
        Node<T> prev = null;
        for (int i = 0; i < size; i++){
            if (node.data.equals(data)){
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

    public T removeByIndex(int index){
        if (index == size)
            return null;
        if (index == 0){
            Node<T> newHead = head.next;
            head.next = null;
            head.data = null;
            head = newHead;
            size--;
            return newHead.data;
        }
        Node<T> node, prev = head;
        for (int i = 0; i < index - 1; i++){
            prev = prev.next;
        }
        node = prev.next;
        prev.next = node.next;
        node.next = null;
        size--;
        return node.data;
    }

    public SingleLinkedList<T> inversion(){
        Node<T> previous, next = null, current = null;
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
        if (head == null) {
            return "List is empty";
        }
        StringBuilder SingleLinkedList = new StringBuilder();
        Node<T> node = head;
        for(int i = 0; i < size; i++){
            SingleLinkedList.append(i).append(" = ").append(node.data);
            if (i != size-1)
                SingleLinkedList.append("\n");
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
            node = node.next;
        }
        return false;
    }

    public void clear() {
        Node<T> previous = head, current = previous.next;
        for (int i = 0; i < size; i++){
            previous.data = null;
            previous.next = null;
            previous = current;
            if (current != tail)
                current = previous.next;
        }
        head = null;
        tail = null;
    }

    public int indexOf(T data) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        Node<T> node = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SingleLinkedList<?> that = (SingleLinkedList<?>) object;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }
}
