class Solution {
    public String reverseStr(String s, int k) {
        // Convert the string to a mutable char array
        char[] c = s.toCharArray();
        
        // Loop through the string, jumping by 2k characters each time
        for (int i = 0; i < c.length; i += 2 * k) {
            int start = i;
            // Reverse up to k characters, or till the end of the string if fewer than k remain
            int end = Math.min(i + k - 1, c.length - 1);
            
            // Two-pointer approach to reverse the selected chunk
            while (start < end) {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
        
        // Convert the character array back to a string
        return String.valueOf(c);
    }
}
