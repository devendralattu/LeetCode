/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public boolean isValid(String s) {

    if(s == null || s.length() % 2 == 1) {
        return false;
    }

    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()) {
        if(c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if(stack.isEmpty()) {
                return false;
            }
            char p = stack.pop();
            if(!((p == '(' && c == ')') || (p == '{' && c == '}') || (p == '[' && c == ']'))) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}
