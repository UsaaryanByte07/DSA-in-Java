import java.util.ArrayList;
import java.util.List;

public class Kids_With_Greatest_Number_Of_Candies_1431 {
    public static void main(String[] args) {
        
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for(int i = 1; i < candies.length; i++){
            max = Math.max(max , candies[i]);
        }
        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= max) res.add(true);
            else res.add(false); 
        }
        return res;
    }
}

/*
Summary:
Time Complexity = O(2n)
Space Complexity = O(1) (Excluding the Result List)
*/