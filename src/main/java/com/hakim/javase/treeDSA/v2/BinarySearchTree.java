package com.hakim.javase.treeDSA.v2;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {

        root = insertV2(data, root);
        return this;
    }

    private void insert(T data, Node<T> node) {
        if (node.getData().compareTo(data) < 0) {
            if (node.getLeftNode() == null) {
                node.setLeftNode(new Node<>(data));
            } else {
                insert(data, node.getLeftNode());
            }
        } else {
            if (node.getRightNode() == null) {
                node.setRightNode(new Node<>(data));
            } else {
                insert(data, node.getRightNode());
            }
        }
    }

    private Node<T> insertV2(T data, Node<T> node) {
        if (node == null) {
            node = new Node<>(data);
            return node;
        }

        if (node.getData().compareTo(data) < 0) {
            node.setLeftNode(insertV2(data, node.getLeftNode()));
            return node.getLeftNode();
        } else {
            node.setRightNode(insertV2(data, node.getRightNode()));
            return node.getRightNode();
        }
    }

    @Override
    public void delete(T data) {

    }

    private Node<T> delete(T data, Node<T> node) {
        if(node == null) return null;

        if(data.compareTo(node.getData()) < 0){
            node.setLeftNode(delete(data,node.getLeftNode()));
        } else if(data.compareTo(node.getData()) > 0){
            node.setRightNode(delete(data,node.getRightNode()));
        } else{
            if(node.getLeftNode() == null) return node.getRightNode();
            if(node.getRightNode() == null) return node.getLeftNode();

            node.setData(getMax(node.getLeftNode()));
            delete(node.getData(),node.getLeftNode());
        }

        return node;
    }

    @Override
    public void traverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node == null) return;

        inOrderTraverse(node.getLeftNode());
        System.out.println(node.getData());
        inOrderTraverse(node.getRightNode());
    }

    @Override
    public T getMax() {
        if (isEmpty()) return null;

        Node<T> node = root;
        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }

        return node.getData();
    }

    public T getMax(Node<T> node) {
        if (node == null) return null;

        while (node.getRightNode() != null) {
            node = node.getRightNode();
        }

        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty()) return null;

        Node<T> node = root;
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }

        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        System.out.println(node.getData().compareTo(3));
    }
}
