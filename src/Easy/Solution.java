package Easy;

public class Solution {
	
	public static void main(String[] args){
		System.out.println("Leetcode practice");
	}
	// *********Reverse String
	String reverseString(String s) {
		String new_s = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			new_s += s.charAt(i);
		}
		return new_s;
	}

	// *********Nim Game
	public boolean canWinNim(int n) {
		return (n % 4 != 0);
	}

	// *********Integer addition (bit operation)
	public int getSum(int a, int b) {
		for (; b != 0; b <<= 1) {
			int temp = a ^ b;
			b = a & b;
			a = temp;
		}
		return a;
	}

	// ********* Single number (bit operation, 2's complement, sign bit)
	public int singleNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum ^ nums[i];
		}
		return sum & -1;
	}
}
