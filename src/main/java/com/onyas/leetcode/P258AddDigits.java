package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/26
 * Time: 上午9:29
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * Hint:
 * A naive implementation of the above process is trivial. Could you come up with other methods?
 * What are all the possible results?
 * How do they occur, periodically or randomly?
 * You may find this Wikipedia article useful.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Math
 * Hide Similar Problems (E) Happy Number
 * 先列举前20个数，我们可以得出规律，每9个一循环，所有大于9的数的树根都是对9取余，那么对于等于9的数对9取余就是0了，为了得到其本身，
 * 而且同样也要对大于9的数适用，我们就用(n-1)%9+1这个表达式来包括所有的情况，所以解法如下：
 */
public class P258AddDigits {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args){
        System.out.println(new P258AddDigits().addDigits(9));
        System.out.println(new P258AddDigits().addDigits(10));
    }
}
