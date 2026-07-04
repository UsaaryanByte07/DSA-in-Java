import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1_M2 {
    public static void main(String[] args) {
        
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

/*
#HashMap Approach:

Learning:
1) What if there are duplicate elements in the array but the hashmap Cannot have Duplicate keys ?
However, the logic of this specific algorithm is designed to bypass that limitation entirely. The code works precisely because of the **order of operations** inside the loop: it checks for the complement *before* it adds the current number to the map.
Here is the factual breakdown of exactly how it handles duplicates in two different scenarios.

### Scenario 1: The Duplicates Form the Target

Imagine `nums = [3, 3]` and `target = 6`.

1. **First Iteration (`i = 0`, `nums[0] = 3`):**
* Complement = `6 - 3 = 3`.
* Does the map contain `3`? No, the map is empty.
* Put it in the map: `numMap.put(3, 0)`. The map is now `{3: 0}`.


2. **Second Iteration (`i = 1`, `nums[1] = 3`):**
* Complement = `6 - 3 = 3`.
* Does the map contain `3`? **Yes.** We added it in the previous step.
* The `if` condition evaluates to `true`.
* The code immediately returns `new int[]{numMap.get(3), 1}`, which is `[0, 1]`.



**Conclusion:** The code never even reaches the `numMap.put(nums[1], i)` line for the second duplicate. It finds the answer and exits the function before a duplicate key collision can ever happen.

---

### Scenario 2: The Duplicates Do Not Form the Target

Imagine `nums = [3, 3, 4]` and `target = 7`.

1. **First Iteration (`i = 0`, `nums[0] = 3`):**
* Map gets `{3: 0}`.


2. **Second Iteration (`i = 1`, `nums[1] = 3`):**
* Complement = `7 - 3 = 4`.
* Does the map contain `4`? No.
* Put it in the map: `numMap.put(3, 1)`.
* **Here is the overwrite:** The map updates the key `3`. The map changes from `{3: 0}` to `{3: 1}`.


3. **Third Iteration (`i = 2`, `nums[2] = 4`):**
* Complement = `7 - 4 = 3`.
* Does the map contain `3`? Yes.
* It retrieves the value for `3`, which is now `1`.
* The code returns `[1, 2]`.



**Conclusion:** The map *did* overwrite the original index (`0`) with the new index (`1`). But this doesn't break the algorithm! If a future number (like the `4`) needs a `3` to reach the target, it doesn't matter which `3` it pairs with. By overwriting, the map simply keeps the *most recent* index of the duplicate, which still results in a perfectly valid pair.

In short: if the duplicate is the answer, it returns early. If the duplicate is not the answer, overwriting it is harmless.

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/