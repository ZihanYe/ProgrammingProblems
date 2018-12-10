// LeetCode 658. Find K closest element

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = bs(arr,x);
        ArrayDeque<Integer> less = new ArrayDeque<>();
        ArrayDeque<Integer> more = new ArrayDeque<>();
        int lq = pos-1;
        int h = pos;
        while (k > 0) {
           if (h >= arr.length || (lq >= 0 && x - arr[lq] <= arr[h]-x)) {
               less.offerFirst(arr[lq]);
               lq--;
           } else { // h < arr.length && (lq<0 || x-arr[lq] > x-arr[h])
               more.offerLast(arr[h]);
               h++;
           }
            k --;
        }
        
        List<Integer> res = new ArrayList<>(less);
        res.addAll(more);
        return res;
    }
    
    int bs(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        while (left < right) {
            int mid = (left+right) /2;
            if (arr[mid] < target)
                left = mid +1;
            else
                right = mid;
        }
        return left;
    }
}