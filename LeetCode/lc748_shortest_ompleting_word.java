// Leetcode 748. Shortest Completing word

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[][] count = new int[words.length][26];
        for (int i=0; i< words.length; i++) {
            count[i] = new int[26];
            for (char ch : words[i].toLowerCase().toCharArray()) {
                count[i][ch - 'a'] ++;
            }
        }
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                for (int i=0; i<words.length; i++){
                    if (count[i]!= null && count[i][ch -'a'] > 0) {
                        count[i][ch - 'a'] --;
                    } else {
                        count[i] = null;
                    }
                }
            }
        }
        int minlength = Integer.MAX_VALUE;
        String s = "";
        for (int i=0; i<words.length; i++) {
            if (count[i] != null && words[i].length() < minlength){
                minlength = words[i].length();
                s = words[i];
            }
        }
        return s;
    }
}