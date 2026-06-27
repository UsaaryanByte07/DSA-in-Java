public class Find_The_Encrypted_String_3210 {
    public static void main(String[] args) {
        
    }

    public String getEncryptedString(String s, int k) {
        StringBuilder encodedString = new StringBuilder();
        for(int i = 0; i< s.length(); i++){
            encodedString.append(s.charAt((i + k)%s.length()));
        }
        return encodedString.toString();
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/