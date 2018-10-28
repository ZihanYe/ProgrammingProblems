// leetcode 229. Bulls and Cows

class Solution {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        int bulls = 0;
        int cows = 0;
        int[][] digits = new int[10][2];
        for (int i=0; i< len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls ++;
            } else {
                digits[secret.charAt(i) - '0'][0] ++;
                digits[guess.charAt(i) - '0'][1] ++;
            }
        }
        for (int i=0; i<= 9; i++){
            cows += Math.min(digits[i][0], digits[i][1]);
        }
        return (bulls + "A" + cows + "B");
    }
}