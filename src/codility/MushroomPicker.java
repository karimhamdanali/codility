package codility;

/**
 * 
 * 
 * @author karim
 *
 */
public class MushroomPicker {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 3, 7, 5, 1, 3, 9 }, 4, 6));
	}

	// Time: O(M + N)
	// Space: O(N)
	public static int solution(int[] A, int k, int m) {
		// write your code in Java SE 8
		
		// first, compute prefix of sums
		int[] prefix = new int[A.length];
		prefix[0] = A[0];
		for(int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i-1] + A[i];
		}
		
		int max = 0;
		// then use it to determine the maximum interval (between first and last)
		for(int i = 0; i < Math.min(k, m) ; i++) {
			int first = k - i;
			int last = Math.max(k, Math.min(k + (m - i * 2), A.length - 1));
			max = Math.max(max, first > 0 ? prefix[last] - prefix[first - 1] : prefix[last]);
		}
		
		return max;
	}
}
