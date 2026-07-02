import java.util.PriorityQueue;

public class Find_the_Kth_Largest_Element_215_M1 {
    public static void main(String[] args) {
        
    }

    public int findKthLargest(int[] nums, int k) {
        //In Java a PriorityQueue By default acts as a Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k ; i++){
            minHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(minHeap.peek() < nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}

/*
#Min Heap Approach:
1) Understanding of Approach;
The main idea of this solution is to use a min-heap with a maximum size of k. By doing this, we ensure that the smallest of the k largest elements is always on the top of the heap.

Key Data Structures:
heap:
This is a min-heap containing the first k elements of nums. As we progress, we will modify this heap to ensure it contains the k largest elements.

Step-by-step Breakdown:
i) Initialization:
Create a heap with the first k elements of nums.
Transform this list into a min-heap.
Iterate through the List:

ii) For each of the remaining elements in nums:
If the element is larger than the smallest element in the heap (i.e., the top of the heap):
-> Remove the top element from the heap.
-> Insert the current element into the heap.
Result:

iii) After processing all elements in nums, the top of the heap will contain the kth largest element. Return this element.

2) Dry Run Example:
Consider the list nums = [3,2,1,5,6,4] with k = 2.

Here's the evolution of the heap:

Initial State:

heap: [3,2]
After processing index 2 (element = 1):

heap remains unchanged as 1 is not larger than 2.
After processing index 3 (element = 5):

heap: [3,5]
After processing index 4 (element = 6):

heap: [5,6]
After processing index 5 (element = 4):

heap: [5,6]
The final state of the heap shows that the kth largest element is 5.

Summary:
Time Complexity = O(nlogk) (Iterating through the array takes O(n) time. For each of the n elements, inserting into a heap of size k takes O(log k) time)
Space Complexity = O(k)
*/