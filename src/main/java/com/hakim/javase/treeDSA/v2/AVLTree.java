package com.hakim.javase.treeDSA.v2;

import com.hakim.javase.treeDSA.Node;
import com.hakim.javase.treeDSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
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
            updateHeight(node);
            return node;
        }

        updateHeight(node);
        System.out.println("Node :"+node.getData()+" height: "+node.getHeight());
        System.out.println("----------------------------");
        return applyRotate(node);
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
        levelOrderTraversal(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node == null) return;

        inOrderTraverse(node.getLeftNode());
        System.out.println(node.getData()+ "Height:"+node.getHeight() );
        inOrderTraverse(node.getRightNode());
    }

    private void levelOrderTraversal(Node<T> node) {
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
        int balance = balance(node);

        if(balance > 1){
            // left heavy situation

            //1. need to handle left-right situation
            if(balance(node.getLeftNode()) <=  1){
                node.setLeftNode(rotateLeft(node.getLeftNode()));
            }

            // 2. need right rotation
            return rotateRight(node);
        }

        if(balance < -1){
            // right heavy

            // 1. need to handle right-left situation
            if(balance(node.getRightNode()) >= 1){
                node.setRightNode(rotateRight(node.getRightNode()));
            }

            // 2. need left rotation
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        System.out.println("Doing a left rotation......");

        // store right node
        Node<T> rightNode = node.getRightNode();

        // store left node of rightNode
        Node<T> centerNode = rightNode.getLeftNode();

        // set the node as the left node of the rightNode
        rightNode.setLeftNode(node);
        node.setRightNode(null);

        // set the centerNode as the left node of node
        node.setLeftNode(centerNode);

        // update height of both node and rightNode
        updateHeight(node);
        updateHeight(rightNode);

        // return right node as the root
        return rightNode;
    }

    private Node<T> rotateRight(Node<T> node) {

        System.out.println("Doing right rotation......");
        // store left node
        Node<T> leftNode = node.getLeftNode();

        // store right node of the left node
        Node<T> centerNode = leftNode.getRightNode();

        // set node as the right node of leftNode
        leftNode.setRightNode(node);

        // set center node as the left node of the node
        node.setLeftNode(centerNode);

        // update height of both node and leftNode
        updateHeight(node);
        updateHeight(leftNode);

        // return leftNode as root
        return leftNode;
    }

    private int height(Node<T> node){
        return node == null ? 0 : node.getHeight();
    }

    private int balance(Node<T> node){
        return node != null ? height(node.getLeftNode()) - height(node.getRightNode())
                : 0;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(6);
        avl.insert(4);
        avl.insert(8);
        avl.insert(2);
        avl.insert(5);
        avl.insert(7);
        avl.insert(9);

        avl.traverse();
    }
}