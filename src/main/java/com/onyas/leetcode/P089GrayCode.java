package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/5/27
 * Time: 上午8:43
 * <p/>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * Subscribe to see which companies asked this question
 */
public class P089GrayCode {

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        } else {
            List<Integer> pre = grayCode(n - 1);
            result.addAll(pre);
            for (int i = pre.size() - 1; i >= 0; --i) {
                result.add((int) Math.pow(2.0, n - 1) + pre.get(i));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P089GrayCode().grayCode(1));
        System.out.println(new P089GrayCode().grayCode(2));
        System.out.println(new P089GrayCode().grayCode(3));
        System.out.println(new P089GrayCode().grayCode(4));
    }

}
