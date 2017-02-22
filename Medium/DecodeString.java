import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String str = "dev1[2[ab]xy3[cd5[pp]]ij]zz";
		System.out.println(str);
		System.out.println(decodeString(str));
	}

	public static String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> countStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		int index = 0;

		while (index < s.length()) {

			char c = s.charAt(index);

			if (Character.isLetter(c)) {
				sb.append(c);
				index++;
			} else if (Character.isDigit(c)) {
				int num = 0;
				while (Character.isDigit(c)) {
					num = num * 10 + (c - '0');
					index++;
					c = s.charAt(index);
				}
				countStack.push(num);
			} else if (c == '[') {
				stringStack.push(sb.toString());
				sb.setLength(0);
				index++;

			} else if (c == ']') {
				StringBuilder tempSB = new StringBuilder(stringStack.pop());
				int iter = countStack.pop();
				String tempStr = sb.toString();
				int i = 0;
				while (i++ < iter) {
					tempSB.append(tempStr);
				}
				sb = new StringBuilder(tempSB);
				tempSB = null;
				index++;
			}
		}

		return sb.toString();
	}
}
