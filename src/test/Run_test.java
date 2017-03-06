package test;

import java.util.Arrays;

import algorithm.Simple_solutions;

public class Run_test {
	public static void main(String[] args) {
		Simple_solutions s = new Simple_solutions();
		String[] test = new String[]{"Hello","Alaska","Dad","Peace"};
		String[] result = s.findWords(test);
		System.out.println(result);
	}
}
