package campus.meituan2016;

/***
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),<br>
 * 右下角坐标为(4,4),现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。<br>
 * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。<br>
 * 测试样例：<br>
 * [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]<br>
 * 返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]<br>
 * 
 * @author Administrator
 *
 */
public class P2FlipChess {

	public int[][] flipChess(int[][] A, int[][] f) {
		int row = A.length;
		int col = A[0].length;

		for (int i = 0; i < f.length; i++) {
			int pointRow = f[i][0] - 1;
			int pointCol = f[i][1] - 1;
			// 上右下左四个点的坐标
			int[] rows = { pointRow - 1, pointRow, pointRow + 1, pointRow };
			int[] cols = { pointCol, pointCol + 1, pointCol, pointCol - 1 };

			for (int j = 0; j < 4; j++) {
				// 如果这四个点在A内，则进行反转
				if (rows[j] >= 0 && rows[j] < row && cols[j] >= 0
						&& cols[j] < col)
					A[rows[j]][cols[j]] = A[rows[j]][cols[j]] == 1 ? 0 : 1;
			}
		}

		return A;
	}

	public static void main(String[] args) {

	}

}
