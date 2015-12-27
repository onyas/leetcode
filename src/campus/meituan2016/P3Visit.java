package campus.meituan2016;

/***
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，但是由于城市道路交通的原因，<br>
 * 他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。<br>
 * 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，<br>
 * 请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。<br>
 * 测试样例：<br>
 * [[0,1,0],[2,0,0]],2,3<br>
 * 返回：2<br>
 * 
 * @author Administrator
 *
 */
public class P3Visit {

	/**
	 * 到dp解决 1.首先找到1和2的位置，这里要注意一点，从1走到2与从2走到1所得的路径数相同，即以1为起点或以2为起点是等价的。所以我做的处理是，<br/>
	 * 统一从行坐标小的位置走到行坐标大的位置，即向下走。<br/>
	 * 2.1和2的相对位置可以归纳如下：<br/>
	 * （1）两者位于主对角线上 <br/>
	 * （2）两者位于副对角线上<br/>
	 * （3）两者位置重合或处于同一行或同一列（该特殊情形可以合并到（1）（2）中）<br/>
	 * 
	 * @param map
	 * @param n
	 * @param m
	 * @return
	 */
	public int countPath(int[][] map, int n, int m) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		// 1、首先到1,2的位置
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					x1 = i;
					y1 = j;
				}
				if (map[i][j] == 2) {
					x2 = i;
					y2 = j;
				}
			}
		}

		if (x1 == x2 && y1 == y2) {// 两点重合
			return 1;
		}
		if (x1 > x2) {// x1,y1用于保存行下标的较小者
			x1 = x1 ^ x2 ^ (x2 = x1);
			y1 = y1 ^ y2 ^ (y2 = y1);
		}

		int dp[][] = new int[n][m];
		if (y1 < y2) {// 两点处在主对角线上
			dp[x1][y1] = 1;
			for (int i = x1 + 1; i <= x2; i++) {// 初始化同一列的数据
				dp[i][y1] = map[i][y1] == -1 ? 0 : map[i - 1][y1];
			}
			for (int j = y1 + 1; j <= y2; j++) {// 初始化同一行的数据
				dp[x1][j] = map[x1][j] == -1 ? 0 : map[x1][j - 1];
			}
			for (int i = x1 + 1; i <= x2; i++) {// dp推导方程
				for (int j = y1 + 1; j <= y2; j++) {
					dp[i][j] = map[i][j] == -1 ? 0 : dp[i - 1][j]
							+ dp[i][j - 1];
				}
			}
		} else {// 两点处在副对角线上或同一列中
			dp[x1][y1] = 1;
			for (int i = x1 + 1; i <= x2; i++) {
				dp[i][y1] = map[i][y1] == -1 ? 0 : map[i - 1][y1];
			}
			for (int j = y1 - 1; j >= y2; j--) {
				dp[x1][j] = map[x1][j] == -1 ? 0 : map[x1][j + 1];
			}
			for (int i = x1 + 1; i <= x2; i++) {
				for (int j = y1 - 1; j >= y2; j--) {
					dp[i][j] = map[i][j] == -1 ? 0 : dp[i - 1][j]
							+ dp[i][j + 1];
				}
			}
		}
		return dp[x2][y2];
	}

	public static void main(String[] args) {

	}

}
