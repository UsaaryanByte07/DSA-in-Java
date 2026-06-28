import java.util.HashMap;

public class Valid_Anagram_242 {
    public static void main(String[] args) {
        
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; // The code will be correct without this line also but if you add this it will just improv the average case cmplexity as we don't have to do the further steps for this special case unneccesarily..
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(count.containsKey(t.charAt(i))){
                count.put(t.charAt(i), count.get(t.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        for(int c: count.values() ){
            if( c != 0) return false;
        }
        return true;
    }
}

/*
#HashMap technique
Learning:
1) Explanation of this technique:
-> Create an unordered map count to store the character frequencies. The key of the map represents a character, and the value represents its frequency.
-> Iterate over each character x in string s. For each character, increment its frequency in the count map by using the count[x]++ expression.
-> Iterate over each character x in string t. For each character, decrement its frequency in the count map by using the count[x]-- expression.
-> Iterate over each pair x in the count map. Each pair consists of a character and its corresponding frequency. Check if any frequency (x.second) is non-zero. If any frequency is non-zero, it means there is a character that appears more times in one string than the other, indicating that the strings are not anagrams. In that case, return false.
-> If all frequencies in the count map are zero, it means the strings s and t have the same characters in the same frequencies, making them anagrams. In this case, the function returns true.

2) Drawback of this technique:
HashMap Overhead (Performance Optimization)
The problem description for LeetCode 242 states: "s and t consist of lowercase English letters." Because you are strictly dealing with 26 lowercase letters, using a standard primitive array int[26] is vastly superior to a HashMap<Character, Integer>.

A HashMap requires calculating hash codes, handling potential collisions, and constantly autoboxing primitive int values into Integer objects.

An array simply uses continuous blocks of memory and direct index lookups, making it significantly faster and lighter on memory.

Summary:
Time Complexity = O(n)
Space Complexity = O(1) (The problem description for LeetCode 242 states: "s and t consist of lowercase English letters." Because you are strictly dealing with 26 lowercase letters we would need to store max 26 key value pairs)
*/