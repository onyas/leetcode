package com.onyas.campus.meituan2016;

/***
 * ��4x4�������ϰ����˺ڰ����ӣ��ڰ���ɫ��λ�ú���Ŀ����������Ͻ����Ϊ(1,1),<br>
 * ���½����Ϊ(4,4),����������һЩ��ת������Ҫ��һЩ��֧�����Ϊ���ĵ����������ĸ����ӵ���ɫ���з�ת����������ת���������ɫ��<br>
 * ����������A��f,�ֱ�Ϊ��ʼ���̺ͷ�תλ�á����з�תλ�ù���3�����뷵�ط�ת������̡�<br>
 * ��������<br>
 * [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]<br>
 * ���أ�[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]<br>
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
			// ���������ĸ�������
			int[] rows = { pointRow - 1, pointRow, pointRow + 1, pointRow };
			int[] cols = { pointCol, pointCol + 1, pointCol, pointCol - 1 };

			for (int j = 0; j < 4; j++) {
				// ������ĸ�����A�ڣ�����з�ת
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
