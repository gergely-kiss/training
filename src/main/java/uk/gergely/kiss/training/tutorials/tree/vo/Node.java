package uk.gergely.kiss.training.tutorials.tree.vo;

import java.util.StringJoiner;

public class Node {

    private Long key;
    private String name;
    private Node leftChild;
    private Node rightChild;

    Node(Long key, String name) {
        this.setKey(key);
        this.setName(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("key=" + getKey())
                .add("name='" + getName() + "'")
                .toString();
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}