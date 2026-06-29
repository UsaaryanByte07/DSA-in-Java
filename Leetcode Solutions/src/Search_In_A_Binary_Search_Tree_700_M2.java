public class Search_In_A_Binary_Search_Tree_700_M2 {
    public static void main(String[] args) {
        
    }

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == val){
                return curr;
            }else if(curr.val > val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return null;
    }
}

/*
#Iterative Approach:

Summary:
Time Complexity = O(H) (H = Height of Tree)
Space Complexity = O(1)
*/