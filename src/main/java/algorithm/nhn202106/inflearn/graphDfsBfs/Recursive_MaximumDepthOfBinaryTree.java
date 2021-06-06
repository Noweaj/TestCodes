package algorithm.nhn202106.inflearn.graphDfsBfs;

public class Recursive_MaximumDepthOfBinaryTree {

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        new Recursive_MaximumDepthOfBinaryTree().solve();
    }

    private void solve() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        int result = getMaxDepth(root);
        System.out.println("Result: "+(result == 4)+" / answer: 4 / input: "+result);
    }

    private int getMaxDepth(TreeNode root){
        return doRecursive(root);
    }

    private int doRecursive(TreeNode node){
        if(node == null)
            return 0;

        int leftMax = doRecursive(node.left);
        int rightMax = doRecursive(node.right);
        return Math.max(leftMax, rightMax)+1;
    }
}
