package test;

import java.util.*;

public class HackerRankMain {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String[] p_str = sc.nextLine().split(" ");
        int[] prices = new int[p_str.length];
        for(int i = 0;i<prices.length;i++){
            prices[i] = Integer.valueOf(p_str[i]);
        }
	}
}
