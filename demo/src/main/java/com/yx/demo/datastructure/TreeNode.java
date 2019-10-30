package com.yx.datastructure;


import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    //求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量
    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);

        if (left * right > 0) {
            return (left > right ? right : left) + 1;
        } else {
            return (left > right ? left : right) + 1;
        }
    }

//  求给定的二叉树的前序遍历 非递归
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null) {
            return al;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            al.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return al;
    }

}
