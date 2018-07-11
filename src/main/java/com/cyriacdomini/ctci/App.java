package com.cyriacdomini.ctci;

import com.cyriacdomini.ctci.chapters.Chapter04;
import com.cyriacdomini.ctci.types.BinaryTreeNode;

public class App {
    public static void main(String[] args){
        System.out.println("CTCI");
        BinaryTreeNode<Integer> test = new BinaryTreeNode<>(5);
        // test.left = new
        test.left = new BinaryTreeNode<Integer>(4);
        test.right = new BinaryTreeNode<Integer>(6);
        test.right.right = new BinaryTreeNode<Integer>(6);
        // test
        // System.out.println(Chapter04.isBalanced(test));
        // test.left.left.left = null ;
        System.out.println(Chapter04.isBST(test));
    }
}