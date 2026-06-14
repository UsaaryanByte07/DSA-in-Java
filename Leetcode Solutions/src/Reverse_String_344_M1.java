public class Reverse_String_344_M1 {
    public static void main(String[] args) {
        
    }

    public void reverseString(char[] s) {
        for(int i = 0; i < (s.length/2); i++){
            s[i] = (char)(s[s.length - i -1]^s[i]);
            s[s.length - i -1] = (char)(s[s.length - i -1]^s[i]);
            s[i] = (char)(s[s.length - i -1]^s[i]);
        }
    }
}
/*
#Implicit Two-Pointer Method
Learning:
1) Readability and Maintainability: Your XOR logic s[i] = (char)(s[s.length - i -1]^s[i]); takes a moment to mentally parse, whereas char temp = s[left]; is universally and instantly understood. In production code, readability almost always trumps "clever" one-liners.
2) Performance Misconceptions: There is a common misconception that avoiding a temp variable makes the code faster or saves memory. In reality, modern compilers are incredibly smart and will optimize a standard temp variable swap into fast CPU registers.
3) CPU Pipelining Bottlenecks: Modern CPUs execute instructions in parallel (pipelining). An XOR swap forces a strict data dependency chain—step 2 cannot start until step 1 finishes, and step 3 cannot start until step 2 finishes. A standard temp variable swap allows the CPU to parallelize the memory reads and writes much more efficiently.
4) Recalculation Overhead: You are recalculating s.length - i - 1 multiple times per iteration. While a good Java compiler might optimize this away, an explicit right pointer avoids the math entirely.
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/