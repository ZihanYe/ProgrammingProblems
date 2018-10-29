// Leetcode 150. Evaluate RPN

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens){
            if (t.equals("+")) {
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v1+v2);
            } else if (t.equals("-")){
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v2-v1);
            } else if (t.equals("*")){
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(v1*v2);
            } else if (t.equals("/")){
                int v1 = s.pop();
                int v2 = s.pop();
                s.push(Math.round(v2 / v1));
            } else {
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
}