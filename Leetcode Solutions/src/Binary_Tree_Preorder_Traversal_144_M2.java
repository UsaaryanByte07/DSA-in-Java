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

public class Binary_Tree_Preorder_Traversal_144_M2 {
    public static void main(String[] args) {
        
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // We can use an ArrayList to act as our Stack
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root); // Start by pushing the root
        
        while (!stack.isEmpty()){
            // 1. Pop the top node and add its value to the result
            TreeNode curr = stack.removeLast();
            result.add(curr.val);
            
            // 2. Push the RIGHT child first
            if (curr.right != null) {
                stack.add(curr.right);
            }

            // 3. Push the LEFT child second
            // Because it was pushed last, it will be popped first (LIFO)
            if (curr.left != null) {
                stack.add(curr.left);
            }
        }
        
        return result;
    }
}

/*
#Iterative Approach:
Learning:
Instead of storing the parents and trying to figure out where to go next, we should store the actual nodes we want to visit in the future.In Preorder (
Root -> Left -> Right), when we are at a node, we want to process its Left child immediately, but we need to remember to process its Right child later. Because a stack is LIFO (Last-In, First-Out), we push the Right child first, then the Left child.

Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (where h is the height of the tree (due to the stack size), which evaluates to O(n) in the worst-case scenario of a skewed tree.)
*/