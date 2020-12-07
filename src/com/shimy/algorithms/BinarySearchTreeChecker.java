package com.shimy.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeChecker {

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

  public static boolean isBinarySearchTree(BinaryTreeNode root) {

    // use dfs with an array of the parents (all ancestors)
    // check each node's parents to make sure it's a valid path
    return isBinarySearchTree(root, new ArrayList<BinaryTreeNode>());
  }

  /**
   * Recursive depth first search method to check if a node and it's children are a valid  BST
   * This function's memory usage can be optimized by including only the upper and lower bounds instead of all ancestors
   * Runtime:  O(n)
   * Memory including recursion stack: O(log n) for a balanced tree and O(n^2) in the worst case
   * @param node The root of subtree to test
   * @param parents All ancestors of the node
   * @return True if the subtree is balanced and the ancestry path is valid
   */
  public static boolean isBinarySearchTree(BinaryTreeNode node, List<BinaryTreeNode> parents) {
    boolean isBinarySearchTree = true;
    for (int i = 0; i < parents.size() - 1; i++) {
      BinaryTreeNode parent = parents.get(i);
      BinaryTreeNode nextParent = parents.get(i + 1);
      if (parent.value >= node.value && parent.left != nextParent)
      {
        return false;
      }
      if (parent.value < node.value && parent.right != nextParent)
      {
        return false;
      }
    }
    if (!parents.isEmpty()) {
      BinaryTreeNode immParent = parents.get(parents.size() - 1);
      if (immParent.value >= node.value && immParent.left != node)
      {
        return false;
      }
      if (immParent.value < node.value && immParent.right != node)
      {
        return false;
      }
    }
    List<BinaryTreeNode> newParents = new ArrayList(parents);
    newParents.add(node);
    if (node.left != null) {
      isBinarySearchTree &= isBinarySearchTree(node.left, newParents);
    }
    if (node.right != null) {
      isBinarySearchTree &= isBinarySearchTree(node.right, newParents);
    }

    return isBinarySearchTree;
  }


  public static void main(String[] args) {
    final BinaryTreeNode root = new BinaryTreeNode(50);
    root.insertRight(70).insertRight(60).insertRight(80);
    final boolean result = isBinarySearchTree(root);
    assert(result == false);
  }
}
