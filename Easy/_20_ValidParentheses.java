/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

/*
//Old code
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
*/

public boolean isValid(String s) {
    if(s == null || s.length() == 0) return true;
    if(s.length() % 2 == 1) return false;
    Stack<Character> stack = new Stack<>();

    // boolean isValidString = validateString(s); // check for indexOf() on brackets
    for(char c : s.toCharArray()) {
        if(isOpenBrace(c)) {
            stack.push(c);
        } else {
            // empty stack or invaild opening brace
            if(!isValidClosing(stack, c)) {
                return false;
            } else {
                stack.pop();
            }
        }
    }

    return stack.isEmpty();
}

private static boolean isOpenBrace(char c) {
    return c == '(' || c == '{' || c == '[';
}
private static boolean isValidClosing(Stack<Character> stack, char c) {
    if (stack.isEmpty()) {
        return false;
    }
    char open = stack.peek();
    return (open == '(' ? c == ')' : (open == '{' ? c == '}' : (open == '[' ? c == ']' : false)));
}
