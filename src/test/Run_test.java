package test;

import java.util.Arrays;

import algorithm.Solution;

public class Run_test {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] test = new String[]{"Hello","Alaska","Dad","Peace"};
		String[] result = s.findWords(test);
		System.out.println(result);
	}
}
