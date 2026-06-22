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

public class Binary_Tree_Inorder_Traversal_94_M1 {
    public static void main(String[] args) {
        
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseInOrder(root, result);
        return result;
    }

    public static void traverseInOrder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        traverseInOrder(root.left, result);
        result.add(root.val);
        traverseInOrder(root.right, result);
    };
}

/*
#Recursive Approach:
Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (h is the Height of the tree. In worst case height of tree can be n and in best case can be logn)
*/