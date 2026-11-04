class Solution {
    public int reverse(int x) {
               int reversedNumber = 0;

        // Process each digit from right to left
        while (x != 0) {
            // Check for potential overflow before multiplying by 10
            // Integer.MAX_VALUE = 2147483647, Integer.MIN_VALUE = -2147483648
            if (reversedNumber > Integer.MAX_VALUE / 10 || reversedNumber < Integer.MIN_VALUE / 10) {
                return 0;
            }

            // Extract the last digit and add it to the reversed number
            int lastDigit = x % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;

            // Remove the last digit from x
            x = x / 10;
        }

        return reversedNumber; 
    }
}
