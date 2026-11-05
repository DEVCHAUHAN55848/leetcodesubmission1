class Solution {
    public int firstUniqChar(String s) {
        
        int[] charCounts = new int[26];
        
        // First pass: count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        
        // Second pass: find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (charCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
       
        return -1;
    }
}
