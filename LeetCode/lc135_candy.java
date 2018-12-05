// LeetCode 135. Candy

class Solution {
    public int candy(int[] ratings) {
        int i =0;
        int sum = 0;
        int prev = 0;
        while (i< ratings.length) {
            int j = i+1;
            while (j < ratings.length && ratings[j] < ratings[j-1])
                j++;
            if (i>0 && ratings[i-1] == ratings[i]){
                prev = j-i;
            } else {
                prev = Math.max(prev+1, j-i); 
            }
            sum += prev;
            if (j > i+1) {
                int start = j-i-1;
                for (int k=i+1; k<j; k++) {
                    sum += start;
                    start --;
                }
                prev = 1;
            }
            i = j;
        }
        return sum;
    }
}