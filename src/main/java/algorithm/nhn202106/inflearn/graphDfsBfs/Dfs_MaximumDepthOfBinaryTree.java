package algorithm.nhn202106.inflearn.graphDfsBfs;

import java.util.Stack;

public class Dfs_MaximumDepthOfBinaryTree {

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        new Dfs_MaximumDepthOfBinaryTree().solve();
    }

    private void solve() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        int result = dfs(root);
        System.out.println("Result: "+(result == 4)+" / answer: 4 / input: "+result);
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        Stack<TreeNode> mStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        mStack.push(root);
        valueStack.push(1);
        int max = 0;
        while(!mStack.isEmpty()){
            TreeNode curNode = mStack.pop();
            int curValue = valueStack.pop();
            max = Math.max(max, curValue);
            if(curNode.left != null) {
                mStack.push(curNode.left);
                valueStack.push(1+curValue);
            }
            if(curNode.right != null) {
                mStack.push(curNode.right);
                valueStack.push(1+curValue);
            }

        }
        return max;
    }
}
