package ru.itis;

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;

/**
 * 04.04.2018
 * BinarySearchTreeImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

    private class TreeNode {
        private T value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(T value) {
            this.value = value;
        }
    }

    private TreeNode root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    @Override
    public void insert(T element) {
        this.root = insert(root, element);
    }

    private TreeNode insert(TreeNode root, T element) {
        if (root == null) {
            root = new TreeNode(element);
        } else if (root.value.compareTo(element) >= 0) {
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }
        return root;
    }

    @Override
    public boolean remove(T element) {
        this.root = remove(root, element);
        return true;
    }

    private TreeNode remove(TreeNode root, T element){
        if(root != null) {
            if (root.value.compareTo(element) == 0) {
                if(root.left != null) {
                    TreeNode rootRight = root.right;
                    root = root.left;
                    insertTree(root, rootRight);
                }if(root.right != null){
                    root = root.right;
                }else{
                    root = null;
                }
            } else {
                root.left =  remove(root.left, element);
                root.right = remove(root.right, element);
            }
        }
        return root;
    }


    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(TreeNode root, T element){
        if(root != null){
            if(root.value.compareTo(element) == 0){
                return true;
            }else{
                return contains(root.left, element) || contains(root.right, element);
            }
        }else{
            return false;
        }
    }

    @Override
    public void print() {
        print(this.root);
    }

    private void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    @Override
    public void printByLevels() {
        printByLevels(root);
    }
    public void printByLevels(TreeNode root){
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(root);
        while(!arrayDeque.isEmpty()){
            TreeNode node = (TreeNode)arrayDeque.pollFirst();
            System.out.println(node.value);
            if(node.left != null){
                arrayDeque.add(node.left);
            }
            if(node.right != null) {
                arrayDeque.add(node.right);
            }
        }

    }

    private TreeNode insertTree(TreeNode root, TreeNode tree) {
        if (root == null) {
            root = tree;
        } else if (root.value.compareTo(tree.value) >= 0) {
            root.left = insertTree(root.left, tree);
        } else {
            root.right = insertTree(root.right, tree);
        }
        return root;
    }
}
