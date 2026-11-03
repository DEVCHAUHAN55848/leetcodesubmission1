class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to prevent overflow during negation
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int result = 0;

        // Shift divisor left until it's larger than dividend, then subtract
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;
            
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
