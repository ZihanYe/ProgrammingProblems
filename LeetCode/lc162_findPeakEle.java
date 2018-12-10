// Leetcode 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left+2 <= right) {
            int mid = (left + right) /2;
            if ((mid == 0 || nums[mid] > nums[mid-1])
               && (mid == nums.length -1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if (mid > 0 && nums[mid-1] >= nums[mid])
                right = mid-1;
            else
                left = mid +1;
        }
        if (left == right) return left;
        return nums[left] > nums[right] ? left : right;
        
    }
}