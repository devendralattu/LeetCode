import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstUniqueInteger {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> l = new LinkedHashSet<Integer>();

		System.out.println("Enter integer stream :");
		while (in.hasNextInt()) {

			int e = in.nextInt();

			// initial condition: can be taken out of loop by assigning
			// input[0] in set and linkedhashset for non streaming data.
			if (set.isEmpty()) {

				set.add(e);
				l.add(e);
				printElem(e);

			} else {

				if (set.contains(e)) {
					// remove element from linked hash set
					l.remove(e);
				} else {
					// add element to end of linked hash set
					set.add(e);
					l.add(e);
				}

				// get the fist element from linked hash set which will be
				// unique
				if (l.size() > 0) {
					Iterator<Integer> i = l.iterator();
					printElem(i.next());
				} else {
					printElem(-1);
				}
			}

		}
	}

	private static void printElem(int e) {
		System.out.println("First Unique element = " + e);
	}

}
