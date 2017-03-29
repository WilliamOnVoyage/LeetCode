package algorithm;

public class TrappingRain {
	public int trap(int[] height) {
		int sum = 0;
		int left = 0, right = height.length - 1;
		int l_max = 0, r_max = 0;
		while (left < right) {
			l_max = Math.max(height[left], l_max);
			r_max = Math.max(height[right], r_max);
			if (l_max < r_max) {
				sum += l_max - height[left];
				left++;
			} else {
				sum += r_max - height[right];
				right--;
			}
		}
		return sum;
	}

	public int trapRainWater(int[][] heightMap) {
		int sum = 0;
		int x_left = 0, x_right = heightMap.length - 1;
		int y_left = 0, y_right = heightMap[0].length - 1;
		int x_lm = 0, x_rm = 0, y_lm = 0, y_rm = 0;
		while (x_left < x_right) {
			while (y_left < y_right) {
				x_lm = Math.max(heightMap[x_left][y_left], x_lm);
				x_rm = Math.max(heightMap[x_right][y_left], x_rm);
				x_lm = Math.max(heightMap[x_left][y_left], x_lm);
				x_lm = Math.max(heightMap[x_left][y_left], x_lm);
			}
		}
		return sum;

	}
}
