public class Isomorphic_Strings_205_M2 {
    public static void main(String[] args) {
        
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(mapS[charS] != mapT[charT]) return false;
            mapS[charS] = i+1;
            mapT[charT] = i+1;
        }
        return true;
    }
}

/*
# Array Map Method:
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/