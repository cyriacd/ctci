package com.cyriacdomini.ctci.chapters;

import java.util.*;
import com.cyriacdomini.ctci.types.BinaryTreeNode;

public class Chapter04{

    // Question 2
    // Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo-
    // rithm to create a binary search tree with minimal height.
    // methods involved:
    // minimalTree
    // createBSTForMinimalTree
    public static BinaryTreeNode<Integer> minimalTree(int[] array){
        return createBSTForMinimalTree(array, 0, array.length-1);
    }
    public static BinaryTreeNode<Integer> createBSTForMinimalTree(int[] array, int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(array[mid]);
        root.left = createBSTForMinimalTree(array, start, mid-1);
        root.right = createBSTForMinimalTree(array, mid+1, end);
        return root;
    }

    // Question 3
    // List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
    // at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists)
    public static <T> LinkedList<LinkedList<BinaryTreeNode<T>>> listOfDepths(BinaryTreeNode<T> n){
        if(n==null){
            return null;
        }
        LinkedList<LinkedList<BinaryTreeNode<T>>> listOfDepths = new LinkedList<>();
        LinkedList<BinaryTreeNode<T>> currentDepth = new LinkedList<>();
        currentDepth.add(n);
        while(!currentDepth.isEmpty()){
            LinkedList<BinaryTreeNode<T>> nextDepth = new LinkedList<>();
            for (BinaryTreeNode<T> curTreeNode :currentDepth) {
                nextDepth.add(curTreeNode.left);
                nextDepth.add(curTreeNode.right);
            }
            listOfDepths.add(currentDepth);
            currentDepth = nextDepth;
        }
        return listOfDepths;
    }

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

    public static <T extends Comparable<T>> boolean isBST(BinaryTreeNode<T> n){
        if(n == null){ return true; }
        if((n.left != null && n.data.compareTo(n.left.data)<0)||(n.right != null && n.data.compareTo(n.right.data)>=0)){
            return false;
        }
        return (isBST(n.left)&&isBST(n.right));
    }
}