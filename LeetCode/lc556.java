// LeetCode 556. Next Greater Element 3

class Solution {
    public int nextGreaterElement(int n) {
        String s = new Integer(n).toString();
        char[] digits = s.toCharArray();
        TreeMap<Character, Integer> dcount = new TreeMap<>();
        for (int i=digits.length-1; i>=0; i--) {
            Character ch = dcount.higherKey(digits[i]);
            if (ch!= null) {
                int index = dcount.get(ch);
                //swap digits[index] and digits[i]
                digits[index] = digits[i];
                digits[i] = ch;
                // sort the char array digits[i+1..digits.length) in increasing order
                Arrays.sort(digits, i+1, digits.length);
                int res = -1;
                try {
                    res = Integer.parseInt(new String(digits));
                } catch (Exception e){ }
                return res;
            }
            if (!dcount.containsKey(digits[i])) dcount.put(digits[i],i);
        }
        return -1;
    }
}