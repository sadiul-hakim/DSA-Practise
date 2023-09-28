package com.hakim.javase.treeDSA;

/**
 * We are sharing this Node amon many Tress like Binary Search Tree,AVL Tree, Red Black Tree and many more.
 * @param <T>
 */
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private int height; // for AVL Tree
    private Color color = Color.RED; // for Red Black Tree
    private Node<T> parent; // for Red Black Tree

    public Node(T data) {
        this.data = data;
    }

    public Node(){

    }

    public Node(T data, Color color) {
        this.data = data;
        this.color = color;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    /**
     * Used for Read Black Tress
     * @return
     */
    public boolean isLeftChild(){
        return this == parent.getLeftNode();
    }

    /**
     * Used for Red Black Trees
     */
    public void flipColor(){
        setColor(color == Color.RED ? Color.BLACK : Color.RED);
    }
}
