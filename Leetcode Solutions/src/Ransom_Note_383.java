import java.util.HashMap;

public class Ransom_Note_383 {
    public static void main(String[] args) {
        
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.replace(ch, map.get(ch)+ 1);
            }
        }
        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }else{
                map.replace(ch, map.get(ch)- 1);
            }
        }
        return true;
    }
}

/*
# HashMap Method
Summary:
Time Complexity = O(m + n) (m is length of ransomNote and n is length of magazine)
Space Complexity = O(1) (HashMap will be at most of 26 length(constant))
*/