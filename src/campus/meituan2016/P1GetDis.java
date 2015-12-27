package campus.meituan2016;

/**
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。 <br/>
 * 给定数组A及它的大小n，请返回最大差值。 <br/>
 * 测试样例： [10,5],2 <br/>
 * 返回：0
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
