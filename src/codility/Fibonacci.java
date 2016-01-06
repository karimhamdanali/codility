package codility;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Fibonacci {

	public static void main(String[] args) {
		// LongStream fibs = Stream.iterate(new long[] { 1, 1 },
		// f -> new long[] { f[1], f[0] + f[1] }).mapToLong(f -> f[0]);

		Stream<BigInteger> fibs = Stream.iterate(
				new BigInteger[] { BigInteger.ONE, BigInteger.ONE },
				f -> new BigInteger[] { f[1], f[0].add(f[1]) }).map(f -> f[0]);

		fibs.limit(4000).forEach(System.out::println);
	}
}
