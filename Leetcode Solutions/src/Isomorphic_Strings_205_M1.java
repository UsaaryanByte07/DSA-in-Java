import java.util.HashMap;

public class Isomorphic_Strings_205_M1 {
    public static void main(String[] args) {
        
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map.containsKey(charS)) {
                if( map.get(charS) != charT) return false;
            } else {
                if(map.containsValue(charT)) return false;
                map.put(charS, charT);
            }
        }
        return true;
    }
}

/*
# HashMap Approach
Summary:
Time Complexity = O(n^2)
Space Complexity = O(1)
*/