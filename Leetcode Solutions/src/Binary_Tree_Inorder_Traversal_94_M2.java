import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Tree_Inorder_Traversal_94_M2 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> stack = new ArrayList<>();
        TreeNode curr = root;

        // Loop continues as long as there are nodes to process OR nodes in the stack
        while (curr != null || !stack.isEmpty()) {

            // 1. Drill down to the furthest left node
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            // 2. Pop the top node (it has no unvisited left children)
            curr = stack.removeLast();

            // 3. Process the node
            result.add(curr.val);

            // 4. Move to the right child and repeat
            curr = curr.right;
        }

        return result;
    }
}

/*
#Iterative Approach:
Learning:
The strategy here is to mimic the call stack. You must aggressively "drill down" to the furthest left node before you can process anything.
The Logic:
1) Start at the root. Go left, left, left, pushing every node onto the stack until you hit null.
2) When you hit null, pop the top node from the stack.
3) Add its value to your result.
4) Move your current pointer to its right child, and repeat the process.

Summary:
Time Complexity = O(n) (Every Node is visited Once)
Space Complexity = O(h) (h is the Height of the tree. In worst case height of tree can be n and in best case can be logn)
*/