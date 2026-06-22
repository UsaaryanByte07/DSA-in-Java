public class MaxDepth_Of_Binary_Tree_104 {
    public static void main(String[] args) {
        
    }

    public int maxDepth(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode node){
        if(node==null)return 0;
        int left=helper(node.left);
        int right=helper(node.right);
        return Math.max(left,right)+1;
    }
}

/*
Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (h is the Height of the tree. In worst case height of tree can be n and in best case can be logn)
Note:
Revisit after Learning DFS and BFS.
*/
