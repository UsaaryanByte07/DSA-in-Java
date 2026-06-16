package Bit_Manipulation;

public class ShiftOperators {
    public static void main(String[] args) {
        System.out.println("--- 1. Signed Left Shift (<<) ---");
        /*
         * The Signed Left Shift (<<) shifts the bits of the number to the left
         * by the specified number of positions. Zeroes are added to the right.
         * * MATHEMATICAL EXPLANATION (Multiplication by power of 2):
         * Shifting a number left by 'n' positions is equivalent to multiplying
         * that number by 2^n.
         * Formula: x << n = x * (2^n)
         */
        int a = 5; // Binary: 0000 0101
        int leftShiftResult = a << 2; // Shifts bits left by 2: 0001 0100 (which is 20)

        System.out.println("Original number (a): " + a);
        System.out.println("a << 2: " + leftShiftResult);
        System.out.println("Math equivalent: 5 * (2^2) = 5 * 4 = 20\n");

        System.out.println("--- 2. Signed Right Shift (>>) ---");
        /*
         * The Signed Right Shift (>>) shifts the bits of the number to the right
         * by the specified number of positions.
         * The sign bit (leftmost bit) is used to fill the trailing positions.
         * If the number is positive, 0 is used. If negative, 1 is used.
         * * MATHEMATICAL EXPLANATION (Division by power of 2):
         * Shifting a number right by 'n' positions is equivalent to dividing
         * that number by 2^n (and discarding the remainder / flooring the result).
         * Formula: x >> n = x / (2^n)
         */
        int b = 20; // Binary: 0001 0100
        int rightShiftResult = b >> 2; // Shifts bits right by 2: 0000 0101 (which is 5)

        System.out.println("Original number (b): " + b);
        System.out.println("b >> 2: " + rightShiftResult);
        System.out.println("Math equivalent: 20 / (2^2) = 20 / 4 = 5\n");

        // Example with a negative number to show sign extension
        int negativeNum = -20;
        System.out.println("Negative number: " + negativeNum);
        System.out.println("-20 >> 2: " + (negativeNum >> 2));
        System.out.println("Math equivalent: -20 / 4 = -5\n");

        System.out.println("--- 3. Unsigned Right Shift (>>>) ---");
        /*
         * The Unsigned Right Shift (>>>) shifts the bits to the right, but unlike
         * the signed right shift, it ALWAYS fills the leftmost positions with 0,
         * regardless of whether the original number was positive or negative.
         * * Note: For positive numbers, >> and >>> produce the exact same result.
         * For negative numbers, >>> changes the sign bit to 0, turning the
         * negative number into a very large positive number. Therefore, it does
         * NOT act as simple division for negative numbers.
         */
        int c = 20;
        int unsignedRightShiftPositive = c >>> 2;

        System.out.println("Positive number (c): " + c);
        System.out.println("c >>> 2: " + unsignedRightShiftPositive + " (Same as >> for positive numbers)");

        int d = -20; // Binary (32-bit): 11111111 11111111 11111111 11101100
        int unsignedRightShiftNegative = d >>> 2; // Fills with 0s on the left

        System.out.println("Negative number (d): " + d);
        System.out.println("d >>> 2: " + unsignedRightShiftNegative);
        System.out.println(
                "Notice how the negative number became a large positive number because the sign bit was overwritten with zero.");
    }

}
