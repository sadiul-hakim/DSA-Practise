package com.hakim.javase.treeDSA;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree is a special type of Binary Tree.
 * This type of tree is specially used for fast search and insertion.
 * In Binary Search Tree left nodes of a Parent node would be smaller and right nodes would be bigger.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

    private Node<T> root;


    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }

    private Node<T> insert(T data,Node<T> node){

        if(node == null){
            node = new Node<>(data);
            return node;
        }

        if(data.compareTo(node.getData()) < 0){
            if(node.getLeftNode() == null){
                node.setLeftNode(new Node<>(data));
            }else {
                insert(data,node.getLeftNode());
            }
        }else {
            if(node.getRightNode() == null){
                node.setRightNode(new Node<>(data));
            }else {
                insert(data,node.getRightNode());
            }
        }

        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data,root);
    }

    private Node<T> delete(T data,Node<T> node){

        if(node == null) return null;

        if(data.compareTo(node.getData()) < 0){
            node.setLeftNode(delete(data,node.getLeftNode()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(delete(data,node.getRightNode()));
        }else{
            if(node.getLeftNode() == null) return node.getRightNode();
            if(node.getRightNode() == null) return node.getLeftNode();

            node.setData(getMax(node.getLeftNode()));
            node.setLeftNode(delete(node.getData(),node.getLeftNode()));
        }

        return node;
    }

    @Override
    public void traverse() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node<T> node){

        if (node == null) return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node<T> poll = queue.poll();
            System.out.println(poll.getData());

            if(poll.getLeftNode() != null) queue.offer(poll.getLeftNode());
            if(poll.getRightNode() != null) queue.offer(poll.getRightNode());
        }
    }

    @Override
    public T getMax() {

        if(root == null) return null;

        Node<T> temp = root;
        while(temp.getRightNode() != null){
            temp = temp.getRightNode();
        }

        return temp.getData();
    }

    public T getMax(Node<T> node) {

        if(node == null) return null;

        Node<T> temp = node;
        while(temp.getRightNode() != null){
            temp = temp.getRightNode();
        }

        return temp.getData();
    }

    @Override
    public T getMin() {

        if(root == null) return null;

        Node<T> temp = root;
        while(temp.getLeftNode() != null){
            temp = temp.getLeftNode();
        }

        return temp.getData();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(10);
        tree.insert(4);
        tree.insert(14);
        tree.insert(2);
        tree.insert(6);
        tree.insert(12);
        tree.insert(16);

        tree.delete(14);

        tree.traverse();
    }
}
