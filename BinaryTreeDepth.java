import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

import static org.junit.Assert.*;

public class BinaryTreeDepth {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static boolean isBalanced(BinaryTreeNode treeRoot) {

        // determine if the tree is superbalanced
        // We wanna do a BFS and find the shallowest node and get it's depth and then keep going
        
        // to do a bfs let's use a que and then go over each node and put it's children in the que
        
        if(treeRoot == null) return true;
        
        int minDepth = -1;
        BinaryTreeNode node;
        Deque<BinaryTreeNode> q = new ArrayDeque<BinaryTreeNode>();
        
        treeRoot.value = 1;
        q.add(treeRoot);
        
        while(!q.isEmpty()){
            node = q.remove();
            int depth = node.value;
            if (node.left == null && node.right == null){
                // leaf
                if (minDepth == -1) minDepth = depth;
                if (minDepth > depth+1 || depth > minDepth+1) return false;
                if (minDepth > depth) minDepth = depth;
            }
            if (node.left!=null){
                node.left.value = depth+1;
                q.add(node.left);
            }
            if (node.right!=null){
                node.right.value = depth+1;
                q.add(node.right);
            }
        }
        
        
        return true;
    }
