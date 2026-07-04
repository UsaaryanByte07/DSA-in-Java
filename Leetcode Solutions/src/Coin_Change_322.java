import java.util.HashMap;
import java.util.Map;

public class Coin_Change_322 {
    public static void main(String[] args) {
        
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(coins, amount, map);
    }

    public static int helper(int[] coins, int amount, Map<Integer, Integer> map){
        if( amount == 0) return 0;
        if(amount < 0) return -1;

        if(map.containsKey(amount)) return map.get(amount);

        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int result = helper(coins, amount - coins[i], map);
            if(result != -1) minCount = Math.min(minCount , result + 1);
        }

        int finalResult = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        map.put(amount, finalResult);
        return finalResult;
    }
}

/*
# Dynamic Programming Approach:

Summary:
Time Complexity = O(S*N) (where S is Amount and N is Number of Coins)
Space Complexity = O(S)
*/