package codility;

import java.util.HashSet;

/**
 * https://codility.com/demo/results/trainingXPTFGE-5Y4/
 * https://codility.com/demo/results/trainingJWTZED-TWG/
 * 
 * @author karim
 *
 */
public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 1, 3, 2 }));
		System.out.println(solution(new int[] { 4, 1, 3 }));
		System.out.println(solution(new int[] { 2, 1, 3 }));
		System.out.println(solution(new int[] { 1, 1, 3 }));
		System.out.println(solution(new int[] { 3, 2, 1 }));
		System.out.println(solution(new int[] { 1 }));
		System.out.println(solution(new int[] { 1 }));
		System.out.println(solution(new int[] { 1000000000 }));
	}

	// Time: O(N)
	// Space: O(N)
	// 
	public static int solution(int[] A) {
		// write your code in Java SE 8
		boolean[] seen = new boolean[A.length + 1];

		// repeated elements
		for (int i = 0; i < A.length; i++) {
			if(A[i] < 1 || A[i] > A.length) return 0;
			if(seen[A[i]] == true) return 0;
			else seen[A[i]] = true;
		}
		
		return 1;
	}
	
	// Time: O(N)
	// Space: O(N)
	// This failed in many cases.
	public static int solution2(int[] A) {
		// write your code in Java SE 8
		HashSet<Integer> seen = new HashSet<Integer>();

		// repeated elements
		for (int i = 0; i < A.length; i++) {
			if(seen.add(A[i]) == false) return 0;
		}
		
		// permutation should be of size N
		if(seen.size() != A.length) return 0;
		
		// check for missing elements
		for(int i = 1 ; i < A.length; i++) {
			if(!seen.contains(i)) return 0;
		}

		return 1;
	}
}
