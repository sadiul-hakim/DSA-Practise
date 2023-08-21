package com.hakim.javase;

import java.util.concurrent.atomic.AtomicInteger;

public class Stack {
    private Node top;
    private int size = 0;

    static class Node {
        private AtomicInteger data;
        private Node next;

        public Node(int data) {
            this.data = new AtomicInteger(data);
            this.next = null;
        }

        public int getData() {
            return data.get();
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(int data) {

        if (isEmpty()) {
            top = new Node(data);
        } else {
            Node node = new Node(data);
            node.setNext(top);
            top = node;
        }
        ++size;
    }

    public int poll() {

        if (isEmpty()) return -1;

        Node node = top;
        top = top.getNext();

        --size;
        return node.getData();
    }

    public int peek() {

        if (isEmpty()) return -1;

        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void traverse() {
        if (isEmpty()) return;

        Node temp = top;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.add(8);

//        stack.traverse();
        System.out.println(stack.poll());
        System.out.println(stack.getSize());
        System.out.println();
        stack.traverse();

    }
}
