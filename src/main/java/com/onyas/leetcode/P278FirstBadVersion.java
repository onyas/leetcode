package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/28
 * Time: 下午9:17
 * <p/>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search
 * Hide Similar Problems (M) Search for a Range (M) Search Insert Position
 */
public class P278FirstBadVersion {


    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;//不能直连用(left+right)/2，因为这样容易超过最大边界
            if (isBadVersion(middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version) {
        if (version >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P278FirstBadVersion().firstBadVersion(5));
    }

}
