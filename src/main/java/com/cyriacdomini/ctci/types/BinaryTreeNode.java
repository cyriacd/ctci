package com.cyriacdomini.ctci.types;

public class BinaryTreeNode<T>{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T value){
        data = value;
    }
}