class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // We are on the ascending slope, so the peak must be to the right
                left = mid + 1;
            } else {
                // We are on the descending slope or at the peak
                right = mid;
            }
        }
        
        // left and right converge to the peak index
        return left;
    }
}
