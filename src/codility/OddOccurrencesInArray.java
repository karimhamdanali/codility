package codility;

import java.util.HashSet;

/**
 * https://codility.com/demo/results/trainingWBEZM7-HET/
 * https://codility.com/demo/results/trainingBEV3E8-7Y5/
 * 
 * @author karim
 *
 */
public class OddOccurrencesInArray {
	// A is non-empty
	// N is odd
	// It contains pairs, need to return value of unpaired element

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 9 }));

	}

	// Time: O(N)
	// Space: O(1)
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
	}
	
	// Time: O(N)
	// Space: O(N)
	public static int solution2(int[] A) {
		// write your code in Java SE 8
		HashSet<Integer> dups = new HashSet<Integer>();
		int elem = -1;

		for (int i = 0; i < A.length; i++) {
			if (dups.add(A[i])) {
				elem = A[i];
			}
		}
		return elem;
	}

	// Time: O(N^2)
	// Space: O(1)
	public static int solution3(int[] A) {
		// write your code in Java SE 8
		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < A.length; j++) {
				if (A[i] == A[j] && i != j) {
					A[i] = -1;
					A[j] = -1;
					j = A.length;
				}
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] != -1)
				return A[i];
		}

		return 0; // should never happen
	}
}
