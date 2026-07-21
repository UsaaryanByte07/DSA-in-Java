public class Best_Time_To_Buy_And_Sell_A_Stock_121_M2 {
    public static void main(String[] args) {
        
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];
            if (sell > buy) {
                maxProfit = Math.max(maxProfit, sell - buy);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}

/*
#Sliding Window Approach

Learning:
Think of the window's left edge as your buy day and the right edge as your sell day.
-> If your sell day price is higher than your buy day price, you calculate the profit and see if it is the best you have found so far.
-> If you ever find a sell day that is cheaper than your current buy day, you instantly close the old window and start a new one from that new low price. There is no mathematical reason to keep an old, more expensive buy price when a cheaper one exists further down the timeline.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/