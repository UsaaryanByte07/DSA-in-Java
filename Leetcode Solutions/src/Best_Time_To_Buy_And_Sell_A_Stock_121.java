public class Best_Time_To_Buy_And_Sell_A_Stock_121 {
    public static void main(String[] args) {
        
    }
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else if(prices[i] - buy > profit){
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

/*
Learning:
How this Solution uses greedy Approach:
-> A Greedy algorithm is defined by making the "locally optimal choice" at each step. It looks at the current moment, takes whatever looks best right now, and never looks back to reconsider past decisions.
-> As you iterate through the days, your code constantly asks: *"Is today's price cheaper than the lowest price I have seen so far?"* If it is, you greedily snatch up that new low price. You are making the greedy assumption that buying at the absolute lowest historical point will yield the highest future profit.
-> If today is not a new low, you immediately evaluate it as a potential sell day. You ask: "If I sell today using my historically greedy buy price, is the profit bigger than my current record?" If yes, you greedily overwrite your profit variable.
-> Because you process the array sequentially and only ever keep the best immediate options (the lowest buy price seen so far and the highest profit seen so far), this is a pure Greedy approach.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/