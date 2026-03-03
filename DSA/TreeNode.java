
import java.util.ArrayList;
import java.util.List;



  public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {

    public List<Integer> topView(TreeNode root) {
        //your code goes here
        List<Integer> l1 = new ArrayList<>();
        top(root, l1);
        return l1;
    }

    private void top(TreeNode node, List<Integer> l1) {
        if (node == null) {
            return;
        }

        top(node.left, l1);

        top(node.right, l1);
        l1.add(node.data);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        Solution sol = new Solution();
        List<Integer> topViewList = sol.topView(root);
        System.out.println("Top View of the Binary Tree: " + topViewList);
    }
}
