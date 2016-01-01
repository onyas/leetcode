package com.onyas.leetcode;

/**
 * 罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。按照下述的规则可以表示任意正整数。需要注意的是罗马数字中没有“0”，
 * 与进位制无关。一般认为罗马数字只用来记数，而不作演算。
 * <p/>
 * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
 * <br>
 * 右加左减：
 * 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。<br>
 * 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。<br>
 * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV<br>
 * 但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）<br>
 * 左减数字必须为一位，比如8写成VIII，而非IIX。<br>
 * 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）<br>
 * <br>
 * 加线乘千：<br>
 * 在罗马数字的上方加上一条横线或者加上下标的Ⅿ，表示将这个数乘以1000，即是原数的1000倍。<br>
 * 同理，如果上方有两条横线，即是原数的1000000（1000^{2}）倍。<br>
 * <br>
 * 数码限制：
 * 同一数码最多只能出现三次，如40不可表示为XXXX，而要表示为XL。<br>
 * 例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替IV。<br>
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/3
 * Time: 下午3:00
 */
public class P012Int2Roman {

    public String intToRoman(int num) {
        String res = "";
        String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res += symbol[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new P012Int2Roman().intToRoman(980));
        System.out.println(new P012Int2Roman().intToRoman(99));
    }
}
