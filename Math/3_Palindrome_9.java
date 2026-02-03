class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Also numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int original = x;
        int reversed = 0;
        
        // Reverse the number
        while (x > 0) {
            int digit = x % 10;
            // Check for overflow (though not necessary for palindrome check)
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return false; // Actually won't happen for palindrome since input is int
            }
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        // Check if original equals reversed
        return original == reversed;
    }
}
