public class Majority_Element_169 {
    public static void main(String[] args) {
        
    }

    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                major = nums[i];
                count++;
            }else if(major == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}

/* 
# Boyer-Moore Voting Algorithm

Learning:
-> The problem guarantees one number appears more than half the time which means its army has more soldiers than all other armies combined.
-> We start by picking the very first number in the array to be our candidate army and give it a soldier count of one.
-> We then walk through the rest of the numbers in the array one by one to see who we encounter.
-> If the next number matches our current candidate a friendly soldier has joined the ranks so we increase our count by one.
-> If the next number is different from our candidate an enemy soldier has appeared on the battlefield.
-> The enemy soldier and one of our candidate soldiers fight and cancel each other out so we decrease our count by one.
-> If our count drops all the way to zero it means our current candidate army has been completely wiped out.
-> When the count hits zero we immediately draft the current number we are looking at to be the new candidate army and reset the count to one.
-> Because the true majority army is mathematically larger than all other armies combined they can never be permanently defeated.
-> By the time we reach the end of the array the candidate army left standing is guaranteed to be the majority element.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/