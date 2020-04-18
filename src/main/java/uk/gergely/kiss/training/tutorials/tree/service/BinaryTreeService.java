package uk.gergely.kiss.training.tutorials.tree.service;

import uk.gergely.kiss.training.tutorials.tree.vo.BinaryTree;
import uk.gergely.kiss.training.tutorials.tree.vo.Node;

import java.util.List;

public interface BinaryTreeService {

    BinaryTree createTree(Node... node);
    BinaryTree addNode(Long treeId, Node... node);
    BinaryTree removeNode(Long treeId, Node... node);
    Node findNodeByKey(Long treeId, Long key);

    List<Node> postOrderTraverseTree(Long treeId);
    List<Node> preOrderTraverseTree(Long treeId);
    List<Node> inOrderTraverseTree(Long treeId);

}
