class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256]; // For extended ASCII
        // Initialize all values to -1
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If we've seen this character before and it's within our current window
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }
            
            lastIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
