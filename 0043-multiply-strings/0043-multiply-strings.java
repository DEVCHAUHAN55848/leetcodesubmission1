class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        // Initialize an array to store intermediate digit results
        int[] res = new int[m + n];
        
        // Loop backwards through both strings (right to left)
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Calculate the product of the two single digits
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Track positions for the product and the carry
                int p1 = i + j;
                int p2 = i + j + 1;
                int total = mul + res[p2];
                
                // Update the results array
                res[p2] = total % 10;
                res[p1] += total / 10;
            }
        }
        
        // Convert the integer array back to a string using StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int digit : res) {
            // Skip the leading zero if it remains unused
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        
        return sb.toString();
    }
}
