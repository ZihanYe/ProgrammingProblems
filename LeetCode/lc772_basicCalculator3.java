// LeetCode 772. Basic Calculator 3

class Solution {
    enum Sign {
        ADD, SUB, DIV, MUL;
    }
    public int calculate(String s) {
        int[] res = helper(s, 0);
        return res[0];
    }
    
    // [value, index]
    int[] helper(String s, int start) {
        Stack<Integer> vals = new Stack<>();
        int i = start;
        int v = 0;
        Sign sign = Sign.ADD;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                v = v * 10 + (ch - '0');
                i++;
                continue;
            }
            if (ch == ' ') {
                i ++;
                continue;
            }
            if (ch == ')')
                break;
            if (ch == '(') {
                int[] valueInside = helper(s, i+1);
                i = valueInside[1] + 1;
                v = valueInside[0];
                continue;
            }
            int value = exec(vals, sign, v);
            vals.push(value);
            v = 0;
            if (ch == '+')
                sign = Sign.ADD;
            else if (ch == '-')
                sign = Sign.SUB;
            else if (ch == '/')
                sign = Sign.DIV;
            else if (ch == '*')
                sign = Sign.MUL;
            i ++;
        }
        vals.push(exec(vals, sign, v));
        return new int[] {evaluate(vals), i};
    }
        
    int exec(Stack<Integer> vs, Sign s, int val) {
        if (s == Sign.ADD)
            return val;
        if (s == Sign.SUB)
            return -1 * val;
        if (s == Sign.DIV) {
            int d = vs.pop();
            return d/val;
        }
        int d = vs.pop();
        return d * val;
    }
        
    int evaluate(Stack<Integer> s) {
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
    
}