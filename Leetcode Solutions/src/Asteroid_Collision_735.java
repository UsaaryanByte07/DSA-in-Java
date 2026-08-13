import java.util.Stack;

public class Asteroid_Collision_735 {
    public static void main(String[] args) {
        
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
    
    for (int asteroid : asteroids) {
        boolean isDestroyed = false;
        
        // We only care about collisions: Stack top moving right (> 0) AND current moving left (< 0)
        while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
            
            if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                // Stack top is smaller and destroyed. Current asteroid survives to check the next one.
                stack.pop();
                continue; 
            } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                // Both are the same size and destroy each other.
                stack.pop();
            }
            
            // If we reach here, the incoming asteroid is either equal or smaller, so it is destroyed.
            isDestroyed = true;
            break; 
        }
        
        // If the incoming asteroid survived all collisions, add it to the stack
        if (!isDestroyed) {
            stack.push(asteroid);
        }
    }
    
    // Build the result array directly from the stack
    int[] result = new int[stack.size()];
    for (int i = 0; i < result.length; i++) {
        result[i] = stack.get(i);
    }
    
    return result;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/