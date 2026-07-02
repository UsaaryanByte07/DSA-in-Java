import java.util.ArrayList;
import java.util.List;

public class Last_Stone_Weight_1046 {
    public static void main(String[] args) {
        
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> stonesList = new ArrayList<>();
        for(int stone: stones){
            stonesList.add(stone);
        }
        
        heapify(stonesList);
        while(stonesList.size() > 1){
            int largest = popRoot(stonesList);
            int secondLargest = popRoot(stonesList);
            if(largest != secondLargest) insert(stonesList, largest - secondLargest);
        }
        return stonesList.isEmpty() ? 0 : stonesList.get(0);
    }

    public static int popRoot(List<Integer> nums){
        int len = nums.size();
        int root = nums.get(0);
        swap(nums, 0, len - 1);
        nums.remove(len - 1);

        // Only heapify down if elements remain
        if (nums.size() > 0) {
            heapifyDown(nums, 0);
        }
        return root;
    }

    public static void insert(List<Integer> nums, int num){
        nums.add(num);
        int i = nums.size() - 1;
        int parent = (i - 1)/2;

        // boundary check i > 0 to prevent negative parent index evaluation
        while (i > 0 && nums.get(parent) < nums.get(i)) {
            swap(nums, parent, i);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public static void heapify(List<Integer> nums){
        int len = nums.size();
        // Start from the last non-leaf node and sift down
        for(int i = (len/2) - 1; i >= 0; i--){
            heapifyDown(nums, i);
        }
    }

    //Helper function to sift a node down to its proper place
    public static void heapifyDown(List<Integer> nums, int i){
        int largest = i;
        int len = nums.size();
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Check if the left child exists and is strictly greater than the current largest
        if(left < len && nums.get(largest) < nums.get(left)){
            largest = left;
        }

        // Check if the right child exists and is strictly greater than the current largest
        if(right < len && nums.get(largest) < nums.get(right)){
            largest = right;
        }

        // If the largest is not the original root, swap them and continue sifting down
        if(largest != i){
            swap(nums, i, largest);
            // Recursively heapify the affected sub-tree
            heapifyDown(nums, largest);
        }
    }

    public static void swap(List<Integer> nums, int i , int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}

/*
Summary:
Time Complexity =  O(nlogn)  (Building the heap initially takes O(n) time. Extracting the two largest elements and inserting a new element takes O(log n) time per operation. In the worst-case scenario, this process repeats n- 1 times, bounding the total time to O(nlog n).
Space Complexity = O(n) 
*/