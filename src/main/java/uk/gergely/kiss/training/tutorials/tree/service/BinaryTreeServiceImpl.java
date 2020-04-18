package uk.gergely.kiss.training.tutorials.tree.service;

import org.springframework.stereotype.Service;
import uk.gergely.kiss.training.tutorials.tree.vo.BinaryTree;
import uk.gergely.kiss.training.tutorials.tree.vo.Node;

import java.util.List;

@Service
public class BinaryTreeServiceImpl implements  BinaryTreeService{

    @Override
    public BinaryTree createTree(Node... node) {

        for (int i = 0; i< node.length; i++){

        }
        return null;
    }

    @Override
    public BinaryTree addNode(Long treeId, Node... node) {
        return null;
    }

    @Override
    public BinaryTree removeNode(Long treeId, Node... node) {
        return null;
    }

    @Override
    public Node findNodeByKey(Long treeId, Long key) {
        return null;
    }

    @Override
    public List<Node> postOrderTraverseTree(Long treeId) {
        return null;
    }

    @Override
    public List<Node> preOrderTraverseTree(Long treeId) {
        return null;
    }

    @Override
    public List<Node> inOrderTraverseTree(Long treeId) {
        return null;
    }
}

