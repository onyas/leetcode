package leetcode;

/**
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/2
 * Time: 下午2:50
 */
public class P007ReverseInteger {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int num = Math.abs(x);
        int result = 0;
        while (num != 0) {
            if (result > (Integer.MAX_VALUE - num % 10) / 10) {
                return 0;
            }
            result = result * 10 + num % 10;
            num /= 10;
        }

        return x < 0 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new P007ReverseInteger().reverse(1111118999));
        System.out.println(new P007ReverseInteger().reverse(-321));
    }
}
