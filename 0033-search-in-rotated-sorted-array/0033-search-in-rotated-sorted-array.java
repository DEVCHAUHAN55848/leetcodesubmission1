
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
           
            int mid = left + (right - left) / 2;

         
            if (nums[mid] == target) {
                return mid;
            }

           
            if (nums[left] <= nums[mid]) {
               
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1;  // Search right
                }
            } 
          
            else {
                
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }

        // Target not found
        return -1;
    }
}
