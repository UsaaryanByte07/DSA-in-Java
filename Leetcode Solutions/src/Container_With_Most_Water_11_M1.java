public class Container_With_Most_Water_11_M1 {
    public static void main(String[] args) {
        
    }

    public int maxArea(int[] height) {
        int maxWater = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                if((height[i] <= height[j]) && (height[i]*(j-i) > maxWater)){
                    maxWater = height[i]*(j-i);
                }
                if((height[i] > height[j]) && (height[j]*(j-i) > maxWater)){
                    maxWater = height[j]*(j-i);
                }
            }
        }
        return maxWater;
    }
}


/*
# Un-Optimized Approach:
Summary:
Time Complexity = O(n^2)
Space Complexity = O(1)
*/