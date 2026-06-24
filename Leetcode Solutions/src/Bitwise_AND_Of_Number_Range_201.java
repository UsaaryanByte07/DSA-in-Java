public class Bitwise_AND_Of_Number_Range_201 {
    public static void main(String[] args) {
        
    }

    public int rangeBitwiseAnd(int left, int right) {
        while(right>left) right = right & (right-1);
        return left&right;
    }
}

/*
Learning:
1. The core of this solution relies on a specific bitwise trick: n AND (n - 1).
2. Whenever you take a number n and bitwise-AND it with n - 1, the result always turns off the rightmost 1 bit of n. For example, 12 in binary is 1100. 11 in binary is 1011. If you do 12 AND 11, the result is 1000, which is 8. The rightmost 1 in 12 was turned into a 0. (You can visit the Leetcode #191)
3. In a continuous range of numbers, bitwise AND destroys 1s very quickly. The moment a bit becomes 0 in any number within your range, it stays 0 forever in the final cumulative result.
4. When you calculate 12 AND 11 and get 8, you are not just getting the result of those two numbers. You are actually getting the cumulative AND result of all the numbers from 12 down to 8.
5. If you look at the numbers in binary: 12 is 1100, 11 is 1011, 10 is 1010, 9 is 1001, and 8 is 1000. If you manually AND 12 and 11, you get 8. If you then AND that 8 with 10, you still get 8. If you AND that 8 with 9, you still get 8.
6. By doing right = right AND (right - 1), the algorithm fast-forwards. It knows that all the numbers between 12 and 8 will just result in 8 anyway, because those lower bits are constantly flipping between 0 and 1 in that sequence and will all eventually be wiped out by a 0.
7. The algorithm works backward from the right boundary, which is 12, and keeps chopping off the rightmost 1 bit until the right boundary drops to or below the left boundary, which is 5.
8. In the first iteration, our right boundary is 12 (1100). We do 12 AND 11, which gives us 8 (1000). We then ask if 8 is still greater than our left boundary of 5. Yes, it is. This means our range is wide enough that we have to keep going down.
9. In the second iteration, our new right boundary is 8 (1000). We do 8 AND 7. Since 7 in binary is 0111, doing 1000 AND 0111 gives us 0 (0000).
10. We just fast-forwarded again. The result of ANDing everything from 8 down to 0 is 0. We ask if 0 is greater than our left boundary of 5. No, it is not.
11. Because dropping that next bit took us below our starting point of 5, we know that somewhere between 5 and 12, that specific bit flipped to a 0. Therefore, the total result for the entire range from 5 to 12 is 0.

Summary:
Space Complexity = O(1)
Time Complexity = O(1) (The Algorithm Chops off One 1's bit in each iteration and a number in java can have max 32 1's bit as number in java takes 32 bits.. So the Loop will max run 32 times which is Constant Time)
*/