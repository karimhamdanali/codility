package codility;

/**
 * https://codility.com/demo/results/training72FVH7-YBG/
 * 
 * @author karim
 *
 */
public class TapeEquilibrium {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 1, 2, 4, 3}));
		System.out.println(solution(new int[] { 3, 1}));
		System.out.println(solution(new int[] { -3, -1, -2, -4, -3}));
		System.out.println(solution(new int[] { -3, -1, -2, 4, 3}));
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		int total = 0;

		for (int i = 0; i < A.length; i++)
			total += A[i];

		int diff = Integer.MAX_VALUE;
		int prev = 0;
		int next = total;

		for (int p = 1; p < A.length; p++) {
			prev += A[p - 1];
			next = total - prev;
			diff = Math.min(diff, Math.abs(prev - next));
		}

		return diff;
	}
}
