package codility;

/**
 * https://codility.com/demo/results/trainingEQ279Q-E8E/
 * https://codility.com/demo/results/trainingAMCBPD-SRK/
 * https://codility.com/demo/results/trainingD4KS35-VXN/
 * 
 * Notes: make sure all variables are declared as {@code long}, otherwise, 
 * {@code sum} will overflow
 * 
 * @author karim
 *
 */
public class PermMissingElem {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 3, 1, 2 }));
		System.out.println(solution(new int[] { 2, 1 }));
		System.out.println(solution(new int[] { 1 }));
		System.out.println(solution(new int[] { 2 }));
		System.out.println(solution(new int[] { 10, 8, 1, 2, 3, 5, 9, 4, 6 }));
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		long N = A.length + 1;
		long sum = N * (N + 1) / 2;
		for (int i = 0; i < A.length; i++) sum -= A[i];
		return (int) sum;
	}
}
