package codility;

/**
 * https://codility.com/demo/results/training4Q95AG-2KU/
 * 
 * @author karim
 *
 */
public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
		System.out.println(solution(1, 1000000000, 30));
		System.out.println(solution(1, 1000000000, 1));
		System.out.println(solution(1000000000, 1000000000, 1000000000));
	}

	public static int solution(int X, int Y, int D) {
		// write your code in Java SE 8
		int steps = (Y - X) / D;
		int extras = (Y - X) % D > 0 ? 1 : 0;
		return steps + extras;
	}
}
