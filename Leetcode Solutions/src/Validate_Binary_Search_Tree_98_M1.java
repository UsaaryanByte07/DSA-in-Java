public class Validate_Binary_Search_Tree_98_M1 {
    public static void main(String[] args) {
        
    }   
    public boolean isValidBST(TreeNode root) {
        // We use Integer objects instead of primitives so we can pass 'null'
        return helper(root, null, null);
    }
    public static boolean helper(TreeNode root, Integer low, Integer high){
        // Base case: An empty tree is a valid BST
        if(root == null) return true;
        // Check if the current node's value violates the min/max boundaries
        if((low != null && root.val <= low) || (high != null && root.val >= high)) return false;
        // Recursively check the left and right subtrees with updated boundaries
        // Left subtree: The max limit becomes the current node's value
        // Right subtree: The min limit becomes the current node's value
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}

/*
# Recursive Approach:

Summary:
Time Complexity = O(n)
Space Complexity = O(H) (H = Height of tree)
*/