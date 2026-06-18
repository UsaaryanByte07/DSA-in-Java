public class Container_With_Most_Water_11_M2 {
    public static void main(String[] args) {
        
    }

    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}

/*
#Optimized Two Pointer Approach
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/
