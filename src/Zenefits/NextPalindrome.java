package Zenefits;

import javax.sound.sampled.ReverbType;

public class NextPalindrome {
	/*
	 * idea:
	 * http://www.ardendertat.com/2011/12/01/programming-interview-questions-19-find-next-palindrome-number/
	 */
	public static void main(String args[]) {
		int input = 999;
		int ans = next(input);
		System.out.println("Answer= " + ans);
	}

	private static int next(int input) {
		int len = Integer.toString(input).length();
		if (len % 2 == 0) {
			// case for even length
			int x = (int) Math.pow(10, len / 2 - 1);
			int mid = (input / x) % (x * 10);
			if (mid == 99) {
				input = round(input);
			} else {
				if (mirror(input) > input)
					return mirror(input);
				input = input + x * 11;
			}

			return mirror(input);

		} else {
			// case for odd length
			int x = (int) Math.pow(10, len / 2);
			int mid = (input / x) % (10);
			if (mid == 9) {
				input = round(input);
			} else {
				if (mirror(input) > input)
					return mirror(input);
				input = input + x;
			}
			return mirror(input);
		}
	}

	private static int round(int in) {
		int len = Integer.toString(in).length();
		int increment = (int) Math.pow(10, ((len / 2) + 1));
		return ((in / increment) + 1) * increment;
	}

	private static int mirror(int in) {
		int len = Integer.toString(in).length();
		if (len % 2 == 0) {
			int x = (int) Math.pow(10, len / 2);
			int first_half = in / x;
			String temp = Integer.toString(first_half);
			Integer f = Integer.valueOf(new StringBuilder(temp).reverse()
					.toString());
			return first_half * x + f;
		} else {
			int x = (int) Math.pow(10, len / 2);
			int first_half = in / x;
			String temp = Integer.toString(first_half);
			Integer f = Integer.valueOf(new StringBuilder(temp).reverse()
					.toString());
			int mid = (in / x) % (10);
			return (first_half - mid) * x + f;
		}

	}
}
