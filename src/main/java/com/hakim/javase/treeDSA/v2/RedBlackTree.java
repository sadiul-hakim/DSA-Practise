package com.hakim.javase.treeDSA.v2;

import com.hakim.javase.treeDSA.Color;
import com.hakim.javase.treeDSA.Node;
import com.hakim.javase.treeDSA.Tree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        Node<T> node = new Node<>(data);
        root = insert(root, node);
        recolorAndRotate(node);
        return this;
    }

    private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            return nodeToInsert;
        }

        if (nodeToInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), nodeToInsert));
            node.getLeftNode().setParent(node);
        } else if (nodeToInsert.getData().compareTo(node.getData()) > 0) {
            node.setRightNode(insert(node.getRightNode(), nodeToInsert));
            node.getRightNode().setParent(node);
        }

        return node;
    }

    private void recolorAndRotate(Node<T> node) {
        Node<T> parent = node.getParent();

        if (node != root && parent.getColor() == Color.RED) {

            // We broke RB Tree rules
            Node<T> grandParent = node.getParent().getParent();
            Node<T> uncle = parent.isLeftChild() ? grandParent.getRightNode() : grandParent.getLeftNode();

            if (uncle != null && uncle.getColor() == Color.RED) {

                // We do not need rotation just recolor
                handleRecoloring(parent, uncle, grandParent);
            } else if (parent.isLeftChild()) {

                // we have left-heavy or left-right situation
                // need to rotate and recolor
                handleLeftSituations(node, parent, grandParent);
            } else if (!parent.isLeftChild()) {

                // we have right-heavy or right-left situation
                // need to rotate and recolor
                handleRightSituations(node, parent, grandParent);
            }
        }

        root.setColor(Color.BLACK);
    }

    private void handleRecoloring(Node<T> parent,
                                  Node<T> uncle,
                                  Node<T> grandParent) {

        // Here we recolor and fix coloring issue
        parent.flipColor();
        uncle.flipColor();
        grandParent.flipColor();

        // Now, Our grandparent can be left or right node of other node.
        // So, Fix recursively
        recolorAndRotate(grandParent);
    }

    private void handleLeftSituations(Node<T> node, Node<T> parent, Node<T> grandParent) {

        if (!node.isLeftChild()) {

            // As uncle and node are the right child and uncle is black,
            // It is a left-right situation
            rotateLeft(parent);
        }

        // We need to flip the color first. Otherwise.
        // parent is child now
        parent.getParent().flipColor();
        grandParent.flipColor();
        rotateRight(grandParent);

        if (node.getParent() != null) {
            recolorAndRotate(node.isLeftChild() ? parent : grandParent);
        }
    }

    private void handleRightSituations(Node<T> node, Node<T> parent, Node<T> grandParent) {

        if (node.isLeftChild()) {

            // As uncle and node are the left child and uncle is black,
            // It is a right-left situation
            rotateRight(parent);
        }

        // We need to flip the color first. Otherwise, Parent would be changed.
        parent.flipColor();
        grandParent.flipColor();
        rotateLeft(grandParent);

        if (node.getParent() != null) {
            recolorAndRotate(node.isLeftChild() ? grandParent : parent);
        }
    }

    private void rotateLeft(Node<T> node) {

        // store right node
        Node<T> rightNode = node.getRightNode();
        node.setRightNode(rightNode.getLeftNode());

        if (node.getRightNode() != null) {
            node.getRightNode().setParent(node);
        }

        // set the node as the left node of the rightNode
        rightNode.setLeftNode(node);
        rightNode.setParent(node.getParent());
        updateChildrenOfParentNode(node, rightNode);
        node.setParent(rightNode);
    }

    private void rotateRight(Node<T> node) {

        // store left node
        Node<T> leftNode = node.getLeftNode();

        node.setLeftNode(leftNode.getRightNode());
        if (node.getLeftNode() != null) {
            node.getLeftNode().setParent(node);
        }

        // set node as the right node of leftNode
        leftNode.setRightNode(node);

        leftNode.setParent(node.getParent());

        updateChildrenOfParentNode(node, leftNode);

        node.setParent(leftNode);
    }

    private void updateChildrenOfParentNode(Node<T> node, Node<T> tempNode) {

        // Here we link our tempNode (new parent, node is a type of parent) with grandparent;
        // We are here to replace node with tempNode
        if (node.getParent() == null) {

            // node is root
            root = tempNode;
        } else if (node.isLeftChild()) {
            node.getParent().setLeftNode(tempNode);
        } else {
            node.getParent().setRightNode(tempNode);
        }
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void traverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node == null) return;

        inOrderTraverse(node.getLeftNode());
        System.out.println(node.getData() + " => " + node.getColor().name());
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
        Tree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree = redBlackTree.insert(40);

        redBlackTree = redBlackTree.insert(30);
        redBlackTree = redBlackTree.insert(50);

        redBlackTree = redBlackTree.insert(20);
        redBlackTree = redBlackTree.insert(35);

        redBlackTree = redBlackTree.insert(45);
        redBlackTree = redBlackTree.insert(55);

        redBlackTree = redBlackTree.insert(15);
        redBlackTree = redBlackTree.insert(25);

        redBlackTree = redBlackTree.insert(33);
        redBlackTree = redBlackTree.insert(38);

        redBlackTree = redBlackTree.insert(43);
        redBlackTree = redBlackTree.insert(48);

        redBlackTree = redBlackTree.insert(53);
        redBlackTree = redBlackTree.insert(58);

        redBlackTree.traverse();
    }

}
