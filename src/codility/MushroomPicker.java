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


/**
* Explanation of the loop lines[29..33]:
*
* In the text that was supposed to help to explain, they say that the optimal way to move from a given start
* position `k` is to traverse in an initial direction and then (I'd add only if necessary) to go in the 
* opposite direction.
* 
* If we're able to keep going in one direction for all our moves `m` that's the best case.
* The worse case would be for us to lose our cool and zig-zag, wasting our moves! Hence we only change direction once.
* But how far do we move in the first direction and how many in the second... This part isn't made clear.
*
* What do we know this far:
*
* Prefix are good for simplifying sums to a point and sums withing a range of an array can be calc'd:
* prefix[last] - prefix[first - 1] : prefix[last]) // Seen on line 32.. hmm!
*
* What's happening (It's really concise!):
* The loop is set up with `for(int i = 0; i < Math.min(k, m) ; i++)`
* This is acknowledging that our starting position k is based on an offset from the beginning of the array. This means that
* if our amount of initial left step moves `m` could take us out of range i.e. before the the beginning, then don't!
* In this case just use the start position amount of iterations as the maximum amount of left iterations.
*
* The algorithm works by using the `i` as the amount of left steps and then moving as far to the right as the moves would allow
* to get the right (end slice).
*
* Keep in mind that traversing in the opposite direction still uses up a move!
* 
* On our first iteration we move zero steps `i` to the left. This sets up our `first` to be the start position. (line 30)
* Having used 0 moves we attempt to move all the moves `m` to the right (see below).
* 
* On the second iteration `i=1` we move one step to the left (start `k` minus our steps `i` - line 30) this sets up our `first`
* (aka slice start).
* We need to set the right most slice. However until we get back to where we started from `k`, our right moves make no real 
* progress rightward as we're only retracing our left steps. To make things worse, there are a couple of nasty cases that
* we wish to avoid:
*
* 1) We don't have enough moves to make it back to our start position.
* 2) We make it beyond the start position and sadly beyond the end of the array (or mushroom road!).
*
* (This is where the smart use of the min/max are used instead of traditional if/else combo making this code concise/complex.)
*
* In the first case we've travelled from `k` to `first` and made it back as far as `?` collecting mushrooms inbetween.
* Our furthest rightmost progress in this case was `k`. We want nothing lower because we started here. For this reason we use
* max(`k`, `whereever you manage to get whilst going right` -aka- `?`) and this problem is solved. If we don't make it back
* then `?` will be lower than `k` and `k` will be max. If however we have enough moves then the higher value will be used as `?`. 
* 
* Arriving at our second case we now have a result for our rightward movement. Unfortunately it may be out of bounds `A.length`.
* We use the same trick, this time in the opposite direction to wrap the previous calculation. This limits it to be within
* range if the rightward moves above brought us to a higher value than the end of mushroom road.
*
* k + (m - i * 2) -> means:
* Calculate the `moves used` to get me to and from the `first` position back to were I started. (i * 2)
* Deduct `moves used` from my move allowance `m` to give me `moves remaining`
* Add `moves remaining` to `k` to give me the amount of real progress moves to the right (if any)
* 
* We return our attention to the line 32: prefix[last] - prefix[first - 1] : prefix[last])
* Given that we now have a maxiumum range of movement based on `i` steps to the left lets work out the total within that range
* We keep that total for each iteration of `i` and switch it only if a range yeilds a higher total - typical max loop!
*/
