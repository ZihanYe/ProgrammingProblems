// LeetCode 34. Find First and Last position of Element in a sorted array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int[] res = new int[] {-1,-1};
        // find first target
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0 || pos >= nums.length || nums[pos] != target)
            return res;
            
        // extend to the left
        int rightbound = pos;
        while (rightbound > 0 && nums[rightbound-1] == target) {
            int newpos = Arrays.binarySearch(nums, 0, rightbound, target);
            if (newpos < 0 || newpos >= rightbound || nums[newpos] != target)
                break;
            rightbound = newpos;
        }
        res[0] = rightbound;
        
        int leftbound = pos+1;
        while (leftbound < nums.length && nums[leftbound] == target) {
            int newpos = Arrays.binarySearch(nums, leftbound, nums.length, target);
            if (newpos< leftbound || newpos >= nums.length || nums[newpos] != target)
                break;
            leftbound = newpos+1;
        }
        res[1] = leftbound -1;
        return res;
    }
    
}