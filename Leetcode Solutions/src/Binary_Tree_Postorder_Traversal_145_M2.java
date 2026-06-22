import java.util.ArrayList;
import java.util.LinkedList;
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

public class Binary_Tree_Postorder_Traversal_145_M2 {
    public static void main(String[] args) {
        
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // Use LinkedList so we can add to the FRONT in O(1) time
        LinkedList<Integer> result = new LinkedList<>(); 
        if (root == null) {
            return result;
        }
        
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.remove(stack.size() - 1);
            
            // Add to the FIRST position (this naturally reverses the output)
            result.addFirst(curr.val);
            
            // Push LEFT first, then RIGHT 
            // (So RIGHT is popped first, processed, and pushed further back in the result)
            if (curr.left != null) {
                stack.add(curr.left);
            }
            if (curr.right != null) {
                stack.add(curr.right);
            }
        }
        
        return result;
    }
}

/*
#Iterative Approach:
Learning:
The "Reverse Preorder" Trick:
1) Standard Preorder is: Root -> Left -> Right
2) If we tweak our stack pushes to visit Right before Left, 
we get: Root -> Right -> Left
3) If we simply reverse that entire result at the very end, 
we get: Left -> Right -> Root (which is Postorder!)
4) Instead of actually reversing the list at the end, we can use a LinkedList and constantly add new values to the front of the list.

Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (h is the Height of the tree. In worst case height of tree can be n and in best case can be logn)
*/