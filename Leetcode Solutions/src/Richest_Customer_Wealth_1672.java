public class Richest_Customer_Wealth_1672 {
    public static void main(String[] args) {
        
    }   

    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length; i++){
            int wealth = 0;
            for(int j = 0; j < accounts[i].length; j++){
                wealth += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, wealth);
        }
        return maxWealth;
    }
}

/*
Summary:
Time Complexity = O(m*n)
Space Complexity = O(1)
*/