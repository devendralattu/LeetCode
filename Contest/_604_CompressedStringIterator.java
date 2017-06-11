/*
    Design and implement a data structure for a compressed string iterator. 
    It should support the following operations: next and hasNext.
    The given compressed string will be in the form of each letter followed by a positive integer 
    representing the number of this letter existing in the original uncompressed string.
    
    next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
    hasNext() - Judge whether there is any letter needs to be uncompressed. 
*/
package contest;

import java.util.ArrayList;
import java.util.List;

public class StringIterator {

	private static char c;
	private static int pointer;

	private List<Integer> occurrence;
	private List<Character> value;

	public StringIterator(String compressedString) {
		if (compressedString == null || compressedString.length() == 0) {
			c = ' ';
			pointer = -1;
		} else {
			occurrence = new ArrayList<>();
			value = new ArrayList<>();
			pointer = 0;

			while (pointer < compressedString.length() - 1) {
				int count = 0;
				c = compressedString.charAt(pointer++);
				value.add(c);

				char d = compressedString.charAt(pointer);
				while (pointer < compressedString.length() && Character.isDigit(d)) {
					count = count * 10 + Character.getNumericValue(d);
					pointer++;
					if (pointer >= compressedString.length()) {
						break;
					}
					d = compressedString.charAt(pointer);
				}
				occurrence.add(count);
			}

			pointer = 0;
		}
	}

	public char next() {
		if (pointer < 0 || pointer >= occurrence.size()) {
			return ' ';
		}

		if (occurrence.get(pointer) > 0) {
			occurrence.set(pointer, occurrence.get(pointer) - 1);
			return value.get(pointer);
		}
		pointer++;
		return next();
	}

	public boolean hasNext() {
		if (pointer >= occurrence.size()) {
			return false;
		} else if (occurrence.get(pointer) == 0) {
			pointer++;
			return hasNext();
		}

		return true;
	}

	public static void main(String args[]) {
		String str = "L12e3t1C1";
		StringIterator si = new StringIterator(str);

		for (int i = 0; i < 20; i++) {
			System.out.println(si.next());
			boolean nextElem = si.hasNext();
			System.out.println(nextElem);
		}

	}
}


/*
OUTPUT
L
true
L
true
L
true
L
true
L
true
L
true
L
true
L
true
L
true
L
true
L
true
L
true
e
true
e
true
e
true
t
true
C
false
 
false
 
false
 
false
*/
