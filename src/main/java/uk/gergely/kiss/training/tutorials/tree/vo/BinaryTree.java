package uk.gergely.kiss.training.tutorials.tree.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BinaryTree {

    private Node root;

    public void addNode(Long key, String name) {
        if (root == null) {
            root = new Node(key, name);
        } else {
            addNonRootNode(key, name);
        }
    }

    private void addNonRootNode(Long key, String name) {
        Node focusNode = root;
        while (true) {
            Node parent = focusNode;
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
                if (focusNode == null) {
                    parent.setLeftChild(new Node(key, name));
                    return;
                }
            } else {
                focusNode = focusNode.getRightChild();
                if (focusNode == null) {
                    parent.setRightChild(new Node(key, name));
                    return;
                }
            }
        }
    }

    public Node findNodeByKey(int key) {

        Node focusNode = root;

        while (focusNode.getKey() != key) {
            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else focusNode = focusNode.getRightChild();
            if (focusNode == null)
                return null;
        }
        return focusNode;
    }

    public void removeByKey(int key) {
        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while (focusNode.getKey() != key) {
            parent = focusNode;
            if (key < focusNode.getKey()) {
                isItALeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItALeftChild = false;
                focusNode = focusNode.getRightChild();
            }
            if (focusNode == null) {
                throw new NullPointerException("Node not find by key");
            }
        }

        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {
            processIfBothChildNodeIsNull(focusNode, parent, isItALeftChild);
        } else if (focusNode.getRightChild() == null) {
            processIfRightChildNodeIsNull(focusNode, parent, isItALeftChild);
        } else if (focusNode.getLeftChild() == null) {
            processIfLeftChildNodeIsNull(focusNode, parent, isItALeftChild);
        } else {
            processIfNoChildNodeIsNull(focusNode, parent, isItALeftChild);
        }
    }
    private void processIfBothChildNodeIsNull(Node focusNode, Node parent, boolean isItALeftChild) {
        if (focusNode == root) {
            root = null;
        } else if (isItALeftChild) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private void processIfRightChildNodeIsNull(Node focusNode, Node parent, boolean isItALeftChild) {
        if (focusNode == root) {
            root = focusNode.getLeftChild();
        } else if (isItALeftChild) {
            parent.setLeftChild(focusNode.getLeftChild());
        } else {
            parent.setRightChild(focusNode.getLeftChild());
        }
    }
    private void processIfLeftChildNodeIsNull(Node focusNode, Node parent, boolean isItALeftChild) {
        if (focusNode == root) {
            root = focusNode.getRightChild();
        } else if (isItALeftChild) {
            parent.setLeftChild(focusNode.getRightChild());
        } else {
            parent.setRightChild(focusNode.getRightChild());
        }
    }

    private void processIfNoChildNodeIsNull(Node focusNode, Node parent, boolean isItALeftChild) {
        Node replacement = replaceNode(focusNode);
        if (focusNode == root) {
            root = replacement;
        } else if (isItALeftChild) {
            parent.setLeftChild(replacement);
        } else {
            parent.setRightChild(replacement);
        }
        replacement.setLeftChild(focusNode.getLeftChild());
    }

    private Node replaceNode(Node nodeToReplace) {
        Node replacementParent = nodeToReplace;
        Node replacement = nodeToReplace;
        Node focusNode = nodeToReplace.getRightChild();

        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();
        }
        if (replacement != nodeToReplace.getRightChild()) {
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(nodeToReplace.getRightChild());
        }
        return replacement;
    }

    public List<Node> inOrderTraverseTree(Node focusNode) {
        List<Node> traverseNodeList = new ArrayList<>();
        inOrderTraverseTreeConsumer(traverseNodeList, focusNode);
        return traverseNodeList;
    }

    private void inOrderTraverseTreeConsumer(List<Node> traverseNodeList, Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTreeConsumer(traverseNodeList, focusNode.getLeftChild());
            traverseNodeList.add(focusNode);
            inOrderTraverseTreeConsumer(traverseNodeList, focusNode.getRightChild());
        }
    }

    public List<Node> preOrderTraverseTree(Node focusNode) {
        List<Node> traverseNodeList = new ArrayList<>();
        preOrderTraverseTreeConsumer(traverseNodeList, focusNode);
        return traverseNodeList;
    }

    private void preOrderTraverseTreeConsumer(List<Node> traverseNodeList, Node focusNode) {
        if (focusNode != null) {
            traverseNodeList.add(focusNode);
            preOrderTraverseTreeConsumer(traverseNodeList, focusNode.getLeftChild());
            preOrderTraverseTreeConsumer(traverseNodeList, focusNode.getRightChild());
        }
    }

    public List<Node> postOrderTraverseTree(Node focusNode) {
        List<Node> traverseNodeList = new ArrayList<>();
        postOrderTraverseTreeConsumer(traverseNodeList, focusNode);
        return traverseNodeList;
    }

    private void postOrderTraverseTreeConsumer(List<Node> traverseNodeList, Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTreeConsumer(traverseNodeList, focusNode.getLeftChild());
            postOrderTraverseTreeConsumer(traverseNodeList, focusNode.getRightChild());
            traverseNodeList.add(focusNode);
        }
    }

    public Node getRoot() {
        return root;
    }
}

