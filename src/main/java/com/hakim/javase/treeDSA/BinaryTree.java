package com.hakim.javase.treeDSA;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A Tree data structure is a non-linear data structure which is used to store data.
 * A Tree data structure never forms circle. A tree node may have n number of child nodes.
 * A tree whose node has 0,1,2 child nodes called Binary tree.
 */
public class BinaryTree<T> {
    private Node<T> root;

    static class Node<T> {
        private T value;
        private Node<T> leftNode;
        private Node<T> rightNode;

        Node() {

        }

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> addToTree(T value, Node<T> parent) {
        Node<T> node = new Node<>(value);

        if (parent == null) {
            parent = node;
            return parent;
        }

        if (parent.leftNode == null) {
            parent.leftNode = node;
            return parent.leftNode;
        }

        parent.rightNode = node;
        return parent.rightNode;
    }

    // Tree DFS
    private void preOrderPrint(Node<T> root) {

        if (root == null) {
            return;
        }

        // First root
        System.out.print(root.value + ",");
        // Then left
        preOrderPrint(root.leftNode);
        // Then right
        preOrderPrint(root.rightNode);

    }

    // Tree DFS
    private void inOrderPrint(Node<T> root) {

        if (root == null) {
            return;
        }

        // Then left
        inOrderPrint(root.leftNode);
        // First root
        System.out.print(root.value + ",");
        // Then right
        inOrderPrint(root.rightNode);
    }

    // Tree DFS
    private void postOrderPrint(Node<T> root) {

        if (root == null) {
            return;
        }

        // Then left
        postOrderPrint(root.leftNode);

        // Then right
        postOrderPrint(root.rightNode);

        // First root
        System.out.print(root.value + ",");
    }

    // Tree BFS
    private void levelOrderPrint(Node<T> root){

        if(root == null) return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<T> node = queue.poll();
            System.out.print(node.value+",");
            if(node.leftNode != null) queue.offer(node.leftNode);
            if(node.rightNode != null) queue.offer(node.rightNode);
        }
    }

    private int findMax(Node<T> node){
        if(node == null) return Integer.MIN_VALUE;

        int data = (int) node.value;
        int leftData = findMax(node.leftNode);
        int rightData = findMax(node.rightNode);

        if(leftData > data) data = leftData;

        return Math.max(rightData, data);
    }

    private boolean isSymmetric(Node<T> node){
        if(node == null) return true;

        Stack<Node<T>> stack = new Stack<>();
        stack.push(node.leftNode);
        stack.push(node.rightNode);

        while (!stack.isEmpty()){
            Node<T> n1 = stack.pop();
            Node<T> n2 = stack.pop();

            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.value != n2.value) return false;

            stack.push(n1.leftNode);
            stack.push(n2.rightNode);
            stack.push(n1.rightNode);
            stack.push(n2.leftNode);
        }
        return true;
    }

    public int height(Node<T> root) {
        // Write your code here.

        if (root == null) return -1;

        int leftHeight = height(root.leftNode);
        int rightHeight = height(root.rightNode);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void dfs(Node<T> root){

        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){

            Node<T> node = stack.pop();
            if(node.leftNode != null) stack.add(node.leftNode);
            if(node.rightNode != null) stack.add(node.rightNode);
            System.out.println(node.value);
        }
    }

    public void dfs(){

        if(root == null) return;

        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){

            Node<T> node = stack.pop();
            if(node.leftNode != null) stack.add(node.leftNode);
            if(node.rightNode != null) stack.add(node.rightNode);
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {

        // Create Tree hierarchy
        BinaryTree<Integer> tree = new BinaryTree<>();

        Node<Integer> node0 = tree.addToTree(0, tree.root); // parent
        Node<Integer> node1 = tree.addToTree(1, node0); // left
        Node<Integer> node2 = tree.addToTree(2, node0); // right

        Node<Integer> node3 = tree.addToTree(3, node1); // left
        Node<Integer> node4 = tree.addToTree(4, node1); // right

        Node<Integer> node5 = tree.addToTree(5, node2); // left
        Node<Integer> node6 = tree.addToTree(6, node2); // right


//        tree.preOrderPrint(node0);
//        System.out.println();
//        tree.inOrderPrint(node0);
//        System.out.println();
//        tree.postOrderPrint(node0);
//        System.out.println();
//        tree.levelOrderPrint(node0);

        tree.dfs(node0);
    }
}
