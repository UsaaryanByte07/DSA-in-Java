import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree_98_M2 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> sortedListOfNodes = new ArrayList<>();
        traverseInorder(root, sortedListOfNodes);
        for(int i = 0; i < sortedListOfNodes.size() - 1; i++){
            if(sortedListOfNodes.get(i) >= sortedListOfNodes.get(i + 1)){
                return false;
            }
        }
        return true;
    }
    public static void traverseInorder(TreeNode root, List<Integer> result){
        if(root == null) return;
        traverseInorder(root.left, result);
        result.add(root.val);
        traverseInorder(root.right, result);
    }
}

/*
# Inorder Traversal Approach:

Summary:
Time Complexity = O(n)
Space Complexity = O(n) (Its has to store all nodes in ArrayList)
*/
