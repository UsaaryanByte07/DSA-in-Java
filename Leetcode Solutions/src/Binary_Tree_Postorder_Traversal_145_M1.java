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

public class Binary_Tree_Postorder_Traversal_145_M1 {
    public static void main(String[] args) {
        
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversePostOrder(root, result);
        return result;
    }

    public static void traversePostOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        traversePostOrder(root.left, result);
        traversePostOrder(root.right, result);
        result.add(root.val);
        return;
    };
}

/*
#Recursive Approach:
Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (h is the Height of the tree. In worst case height of tree can be n and in best case can be logn)
*/
