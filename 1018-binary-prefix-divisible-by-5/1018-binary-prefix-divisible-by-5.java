import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int remainder = 0;
        
        for (int v : nums) {
            // Shift left by 1 (multiply by 2), add the new bit, and take modulo 5
            remainder = ((remainder << 1) | v) % 5;
            ans.add(remainder == 0);
        }
        
        return ans;
    }
}

