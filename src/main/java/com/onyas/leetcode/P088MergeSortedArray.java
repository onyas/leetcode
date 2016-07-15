package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/5
 * Time: 上午9:48
 * <p/>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * Subscribe to see which companies asked this question
 * Hide Tags Array Two Pointers
 * Hide Similar Problems (E) Merge Two Sorted Lists
 * <p/>
 * 关键点是nums的长度大于等于m+n，所以思路就是指针从后向前走，先填充后面的空间。最后要考虑的是nums2的数据可能没有填充完，要单独处理
 */
public class P088MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }

        while (n > 0) {
            nums1[m + n - 1] = nums2[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        new P088MergeSortedArray().merge(nums1, 3, new int[]{2, 4, 6}, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
