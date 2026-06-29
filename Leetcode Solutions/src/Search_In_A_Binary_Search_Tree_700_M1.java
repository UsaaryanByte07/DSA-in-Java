public class Search_In_A_Binary_Search_Tree_700_M1 {
    public static void main(String[] args) {
        
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val){
            return root;
        }else if(root.val > val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }
    }
}

/*
#Recursive Approach:

Summary:
Time Complexity = O(H) (H = Height of Tree)
Space Complexity = O(H) (Due to Call Stack)
*/