public class Best_Time_To_Buy_And_Sell_A_Stock_II_122 {
    public static void main(String[] args) {
        
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }
}

/*
Learning:
Understanding the Approach to this problem with the help Of Leetcode Problem #121(So understand #121 First):
### **The Conceptual Bridge: #121 vs. #122**

To solve #122 using your knowledge of #121, we have to look at the one critical rule change between the two problems:

* **LeetCode #121:** You can only buy **once** and sell **once**. You must find the single largest gap between a historical low and a future high.
* **LeetCode #122:** You can buy and sell **as many times as you want** (but you must sell your current stock before buying a new one).

Because you are no longer restricted to a single transaction, the Greedy strategy actually becomes *much simpler*. You no longer need to keep track of the "all-time lowest buy price" like you did in #121.

### **The Greedy Approach for #122**

If you can transact infinitely, the most optimal way to make money is to capture **every single upward price movement**.

If you know tomorrow's price is going to be higher than today's price, you should always "buy" today and "sell" tomorrow. Even if the price keeps going up for three days straight, mathematically, capturing the day-to-day profit yields the exact same total as buying on day one and selling on day three.

Let's look at an example array: `[7, 1, 5, 3, 6, 4]`

1. **Day 1 to 2 (7 to 1):** Price dropped. Do nothing.
2. **Day 2 to 3 (1 to 5):** Price went up! Greedily capture this. Profit = +4.
3. **Day 3 to 4 (5 to 3):** Price dropped. Do nothing.
4. **Day 4 to 5 (3 to 6):** Price went up! Greedily capture this. Profit = +3.
5. **Day 5 to 6 (6 to 4):** Price dropped. Do nothing.

**Total Profit:** `4 + 3 = 7`.

Notice how you avoid the loss between day 3 and 4 by "selling" at 5 and "buying" back in at 3. This is pure Greedy logic: you are making the best local choice every single day without worrying about the grand picture.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/