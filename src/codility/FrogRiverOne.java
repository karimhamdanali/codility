package codility;

import java.util.HashSet;
import java.util.Random;

/**
 * https://codility.com/demo/results/training8RQ5EU-P76/
 * https://codility.com/demo/results/trainingAQ2NJW-WZU/
 * 
 * @author karim
 *
 */
public class FrogRiverOne {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 5, 3, 2, 5 }));
		System.out.println(solution(5, new int[] { 1, 3, 1, 4, 5, 3, 5, 2 }));
		System.out.println(solution(2, new int[] { 1, 1, 1, 2 }));
		System.out.println(solution(10, new int[] { 10, 2, 5, 6, 7, 1, 3, 4, 7, 9, 8, 10, 9, 10, 10 }));
		System.out.println(solution(10, randomFill(100, 10)));
	}

	// Time: O(N)
	// Space: O(M)
	// This one scored 100/100
	public static int solution(int X, int[] A) {
		// write your code in Java SE 8
		HashSet<Integer> fallen = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X)
				fallen.add(A[i]);

			if (fallen.size() == X)
				return i;
		}

		return -1;
	}

	// Time: O(N)
	// Space: O(M)
	// That failed miserably! scored 27
	public static int solution4(int X, int[] A) {
		// write your code in Java SE 8
		int[] count = new int[X + 1];
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			if (count[A[i]] == 0) {
				sum++;
				count[A[i]] = 1;
			}

			if (A[i] == X && sum == X) {
				return i;
			}
		}

		return -1;
	}

	// Time: O(N * M)
	// Space: O(M)
	public static int solution3(int X, int[] A) {
		// write your code in Java SE 8
		int[] count = new int[X + 1];

		for (int i = 0; i < A.length; i++) {
			count[A[i]] = 1;

			if (A[i] == X) {
				boolean found = true;
				for (int j = 1; j <= X; j++) {
					if (count[j] == 0)
						found = false;
				}

				if (found) {
					return i;
				}
			}

		}

		return -1;
	}

	// Time: O(N * M)
	// Space: O(M)
	public static int solution2(int X, int[] A) {
		// write your code in Java SE 8
		HashSet<Integer> fallen = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			fallen.add(A[i]);

			if (A[i] == X) {
				boolean found = true;
				for (int j = 1; j <= X; j++) {
					found &= fallen.contains(j);
				}

				if (found) {
					return i;
				}
			}

		}

		return -1;
	}

	private static int[] randomFill(int n, int X) {
		int[] arr = new int[n];
		Random rand = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(X) + 1;
		}

		return arr;
	}
}
