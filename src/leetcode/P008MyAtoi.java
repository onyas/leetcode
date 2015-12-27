package leetcode;

/**
 * Implement atoi to convert a string to an integer.
 * <br>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what
 * are the possible input cases.
 * <br>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <br>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p/>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/2
 * Time: 下午3:07
 */
public class P008MyAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        str = str.trim();
        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '+') {
            i++;
        } else if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }

        double result = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-') {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;

    }

    public static void main(String[] args){
        System.out.println(new P008MyAtoi().myAtoi("1"));
        System.out.println(new P008MyAtoi().myAtoi("010"));
    }

}
