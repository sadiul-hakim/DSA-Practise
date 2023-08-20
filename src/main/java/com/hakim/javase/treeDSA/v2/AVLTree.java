package com.hakim.javase.treeDSA.v2;

public class AVLTree<T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {

        root = insertV2(data, root);
        return this;
    }

    private Node<T> insertV2(T data, Node<T> node) {
        if (node == null) {
            node = new Node<>(data);
        }
        System.out.println("Inserting node "+data+" parent: "+node.getData());
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insertV2(data, node.getLeftNode()));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRightNode(insertV2(data, node.getRightNode()));
        } else{
            System.out.println("Inserter node "+data+", Height: "+node.getHeight());
            System.out.println("----------------------------");

            return node;
        }

        updateHeight(node);
        System.out.println("Node :"+node.getData()+" height: "+node.getHeight());
        System.out.println("----------------------------");
        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data,root);
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

        updateHeight(node);
        return applyRotate(node);
    }

    @Override
    public void traverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node == null) return;

        inOrderTraverse(node.getLeftNode());
        System.out.println(node.getData()+ "Height:"+node.getHeight() );
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

    private void updateHeight(Node<T> node){
        int maxHeight = Math.max(
                height(node.getLeftNode()),
                height(node.getRightNode())
        );

        node.setHeight(maxHeight + 1);
    }

    private Node<T> applyRotate(Node<T> node){
        return null;
    }

    private int height(Node<T> node){
        return node == null ? 0 : node.getHeight();
    }

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(6);
        avl.insert(4);
        avl.insert(3);
        avl.insert(8);

//        avl.traverse();
    }
}
