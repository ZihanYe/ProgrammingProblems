// LeetCode 17. Combination of a Phone number

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> comb = new ArrayList<>();
        if (digits == null || digits.length() == 0) return comb;
        for (char ch : getLetters(digits.charAt(0)).toCharArray()) {
                comb.add(Character.toString(ch));
        }
        return helper(digits.substring(1,digits.length()), comb);
    }
    
    public List<String> helper(String digits, List<String> words) {
        if (digits.length() == 0) return words;
        List<String> newwords = new ArrayList<>();
        for (String sb : words) {
            for (char ch : getLetters(digits.charAt(0)).toCharArray()) {
                newwords.add(sb + Character.toString(ch));
            }
        }
        return helper(digits.substring(1,digits.length()), newwords);
    }
    
    private String getLetters(char digit) {
        if (digit == '0') return " ";
        if (digit == '1') return "*";
        if (digit == '2') return "abc";
        if (digit == '3') return "def";
        if (digit == '4') return "ghi";
        if (digit == '5') return "jkl";
        if (digit == '6') return "mno";
        if (digit == '7') return "pqrs";
        if (digit == '8') return "tuv";
        if (digit == '9') return "wxyz";
        return "";
    }
}