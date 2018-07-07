package com.cyriacdomini.ctci.chapters;

import com.cyriacdomini.ctci.types.BinaryTreeNode;

public class Chapter04{
    // Question 4
    // Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
    // this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
    // node never differ by more than one. 
    // Methods Used:
    // isBalanced
    // getMaxDepth
    // getMinDepth
    public static <T> boolean isBalanced(BinaryTreeNode<T> n){
        int min = Math.min(getMinDepth(n.left), getMinDepth(n.right));
        int max = Math.max(getMaxDepth(n.left), getMaxDepth(n.right));
        if(max-1 > min){
            return false;
        }
        return true;
    }
    public static <T> int getMaxDepth(BinaryTreeNode<T> n){
        int lDepth = 0, rDepth = 0;
        lDepth = n.left != null ? getMaxDepth(n.left) + 1 : 0;
        rDepth = n.right != null ? getMaxDepth(n.right) + 1 : 0;
        return Math.max(lDepth ,rDepth);
    }
    public static <T> int getMinDepth(BinaryTreeNode<T> n){
        int lDepth = 0, rDepth = 0;
        lDepth = n.left != null ? getMinDepth(n.left) + 1 : 0;
        rDepth = n.right != null ? getMinDepth(n.right) + 1 : 0;
        return Math.min(lDepth ,rDepth);
    }
}