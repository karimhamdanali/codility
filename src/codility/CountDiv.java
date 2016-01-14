package codility;

/**
 * https://codility.com/demo/results/training59B8HE-3MB/
 * 
 * I suffered a lot with this problem!
 * 
 * @author karim
 *
 */
public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(6, 11, 1));
		System.out.println(solution(6, 11, 2));
		System.out.println(solution(6, 11, 3));
		System.out.println(solution(6, 11, 4));
	}

	// Time: O(1)
	// Space: O(1)
	public static int solution(int A, int B, int K) {
        // write your code in Java SE 8
		return (B/K) - (A/K) + (A%K == 0 ? 1 : 0);
    }
}
