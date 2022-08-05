package easy;

import java.util.Stack;

public class _0020_ValidParentheses {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        int i = 0;

        while(i < s.length()){
            var c = s.charAt(i++);

            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            else {
                if(stack.size()==0){
                    return false;
                }

                var pop = stack.pop();

                if(c == ')' && pop == '('){
                    continue;
                }
                if(c == '}' && pop == '{'){
                    continue;
                }
                if(c == ']' && pop == '['){
                    continue;
                }

                return false;
            }
        }

        if(stack.size()>0){
            return false;
        }

        return true;
    }

    public void run() {
        System.out.println("_0020_ValidParentheses: ");
        System.out.println("Expected: true Actual:" + isValid("()"));
        System.out.println("Expected: true Actual:" + isValid("()[]{}"));
        System.out.println("Expected: false Actual:" + isValid("([)]"));
    }
}
