// LeetCode 153. find minimum in rotated sorted array

class Solution {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length-1]) return nums[0];
        int left = 0;
        int right = nums.length;
        while (left < right-2) {
            int mid = (left+right) /2;
            if (nums[mid] > nums[mid+1]) return nums[mid+1];
            if (nums[left] > nums[mid]) right = mid +1;
            else left = mid+1;
        }
        int min = nums[left];
        if (left+1 < right) min = Math.min(nums[left+1],min);
        return min;
    }
}