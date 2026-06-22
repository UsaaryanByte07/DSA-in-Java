import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class Binary_Tree_Preorder_Traversal_144_M1 {
    public static void main(String[] args) {
        
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePreOrder(root, result);
        return result;
    }

    public static void traversePreOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        traversePreOrder(root.left, result);
        traversePreOrder(root.right, result);
    };
}

/*
#Recursive Approach:
Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (where h is the height of the tree (due to the stack size), which evaluates to O(n) in the worst-case scenario of a skewed tree.)
*/