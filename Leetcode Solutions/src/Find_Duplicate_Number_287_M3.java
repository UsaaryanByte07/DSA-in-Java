public class Find_Duplicate_Number_287_M3 {
    public static void main(String[] args) {
        
    }

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

/*
# Binary Search and Pigeon Hole principle:
Learning:
1. The Pigeonhole Principle is a simple, intuitive rule of discrete mathematics which states that if you have P pigeons and H holes, and you have more pigeons than holes (P > H), then at least one hole must contain more than one pigeon.
2. For example, if you have 5 pigeons but only 4 physical boxes to put them in, there is no physical or mathematical way to distribute them where every box gets only one pigeon. At least one box is forced to take 2 or more pigeons.
3. In the context of the Find the Duplicate Number problem on LeetCode number 287, we simply map the math concept to the problem's constraints.
4. The Pigeons (P) represent the total number of integers in the array. The problem states there are n + 1 integers.
5. The Holes (H) represent the possible values those integers can take. The problem states the values are in the range 1 to n, meaning there are exactly n possible unique numbers.
6. Because we have n + 1 integers (pigeons) but only n valid numbers they can be (holes), it is mathematically guaranteed that at least one number (hole) must be assigned to more than one integer in the array. That number is your guaranteed duplicate.
7. The Pigeonhole Connection applies further when we pick a number mid right in the middle of our range 1 to n.
8. If we count how many numbers in our actual array are less than or equal to mid, we can use the Pigeonhole Principle to deduce where the duplicate is hiding.
9. In this specific scenario, the Holes are the numbers from 1 up to mid. There are exactly mid holes available.
10. The Pigeons are the count of elements in the array that fall into that range (less than or equal to mid). Let us call this cnt.
11. The logic dictates that if cnt is greater than mid, you have more pigeons than holes. By the Pigeonhole Principle, the duplicate number must be somewhere in the range 1 to mid, so you can discard the upper half of your search space (high = mid).
12. Conversely, if cnt is less than or equal to mid, you do not have an excess of pigeons in the lower half. Therefore, the duplicate must be in the upper half of the range, and you discard the lower half (low = mid + 1).

Summary:
Time Complexity = O(nlogn) (BinarySearch Runs logn and times and each time we iterate the the whole array to count)
Space Complexity = O(1)
*/