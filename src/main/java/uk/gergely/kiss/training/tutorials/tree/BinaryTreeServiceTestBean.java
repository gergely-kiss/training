package uk.gergely.kiss.training.tutorials.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import uk.gergely.kiss.training.tutorials.tree.vo.BinaryTree;
import uk.gergely.kiss.training.tutorials.tree.vo.Node;

import java.util.List;

@Component
public class BinaryTreeServiceTestBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryTree.class);

    public void test() {

        BinaryTree theTree = new BinaryTree();
        theTree.addNode(50L, "Boss");
        theTree.addNode(25L, "Vice PRes");
        theTree.addNode(15L, "Office Manager");
        theTree.addNode(30L, "Secretary");
        theTree.addNode(75L, "Sales Manager");
        theTree.addNode(85L, "Salesman 1");

        LOGGER.warn("inOrderTraversed");
        List<Node> inOrderTraversedNodeList = theTree.inOrderTraverseTree(theTree.getRoot());
        for(Node node : inOrderTraversedNodeList){
            LOGGER.warn("inOrderTraversedNodeList {}",node);
        }
        LOGGER.warn("preOrderTraversed");
        List<Node> preOrderTraversedNodeList = theTree.preOrderTraverseTree(theTree.getRoot());
        for(Node node : preOrderTraversedNodeList){
            LOGGER.warn("preOrderTraversedNodeList {}",node);
        }
        LOGGER.warn("postOrderTraversed");
        List<Node> postOrderTraversedNodeList = theTree.postOrderTraverseTree(theTree.getRoot());
        for(Node node : postOrderTraversedNodeList){
            LOGGER.warn("postOrderTraversedNodeList {}",node);
        }

        LOGGER.warn("Search for node with key 30");
        LOGGER.warn(theTree.findNodeByKey(30).toString());

        LOGGER.warn("Remove key 25");
        theTree.removeByKey(25);

        LOGGER.warn("postOrderTraversed");
        postOrderTraversedNodeList = theTree.postOrderTraverseTree(theTree.getRoot());
        for(Node node : postOrderTraversedNodeList){
            LOGGER.warn("postOrderTraversedNodeList {}",node);
        }

    }
}
