package com.hakim.javase.treeDSA;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree is a special type of Binary Tree.
 * This type of tree is specially used for fast search and insertion.
 * In Binary Search Tree left nodes of a Parent node would be smaller and right nodes would be bigger.
 */
public class BinarySearchTree {
    private Node root;

    static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;

        Node() {

        }

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node insert(Node parent, int value) {

        if (parent == null) {
            parent = new Node(value);
            return parent;
        }

        if (parent.getValue() > value) {
            parent.leftNode = insert(parent.leftNode, value);
            return parent.leftNode;
        } else {
            parent.rightNode = insert(parent.rightNode, value);
            return parent.rightNode;
        }
    }

    private Node delete(int key,Node node){
        if(node == null) return null;

        if(node.getValue() > key){
            node.leftNode = delete(key,node.leftNode);
        }else if(node.getValue() < key){
            node.rightNode = delete(key,node.rightNode);
        }else{
            if(node.leftNode == null){
                return node.rightNode;
            }else if(node.rightNode == null){
                return node.leftNode;
            }
            node.leftNode.rightNode=node.rightNode; // todo: wrong
            node = node.leftNode;
        }

        return node;
    }

    private void print(Node root) {

        // pre order
        if (root == null) return;

        System.out.print(root.value + ",");
        print(root.leftNode);
        print(root.rightNode);
    }

    private void printLevelOrder(Node root){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value+",");
            if(node.leftNode != null) queue.offer(node.leftNode);
            if(node.rightNode != null) queue.offer(node.rightNode);
        }
    }

    private Node search(Node node, int key) {
        if (node == null || node.getValue() == key) return node;

        if (node.getValue() > key) {
            return search(node.leftNode, key);
        } else {
            return search(node.rightNode, key);
        }
    }

    private boolean validate(Node node,int min,int max){
        if(node == null) return true;

        if(node.getValue() <= min || node.getValue() >= max) return false;
        boolean isLeft = validate(node.leftNode,min,node.getValue());
        if (isLeft){
            return validate(node.rightNode,node.getValue(),max);
        }

        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        Node node6 = tree.insert(tree.root, 6);
        Node node4 = tree.insert(node6, 4);
        Node node8 = tree.insert(node6, 8);

        Node node2 = tree.insert(node4, 2);
        Node node5 = tree.insert(node4, 5);

        Node node7 = tree.insert(node8, 7);
        Node node9 = tree.insert(node8, 9);

        tree.printLevelOrder(node6);
        node6=tree.delete(4,node6);
        System.out.println();
        tree.printLevelOrder(node6);


    }
}
