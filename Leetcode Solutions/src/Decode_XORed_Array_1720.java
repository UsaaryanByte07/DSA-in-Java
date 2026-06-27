public class Decode_XORed_Array_1720 {
    public static void main(String[] args) {
        
    }

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for(int i = 0; i < encoded.length; i++){
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/