package com.onyas.campus.meituan2016;

/**
 * ��һ����Ϊn������A��������0��a��b<n��A[b]-A[a]�����ֵ�� <br/>
 * ������A����Ĵ�Сn���뷵������ֵ�� <br/>
 * �������� [10,5],2 <br/>
 * ���أ�0
 * 
 * @author Administrator
 *
 */
public class P1GetDis {

	public int getDis(int[] A, int n) {
		if (A.length <= 1) {
			return 0;
		}
		int max = 0;
		int min = A[0];
		for (int i = 0; i < n; i++) {
			if (A[i] - min > max) {
				max = A[i] - min;
			}
			if (A[i] < min) {
				min = A[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		P1GetDis p1 = new P1GetDis();
		System.out.println(p1.getDis(new int[] { 10, 5 }, 2));
	}

}
