package com.cyriacdomini.ctci.types;

public class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode(T value){
        data = value;
        left = null;
        right = null;
    }
} 