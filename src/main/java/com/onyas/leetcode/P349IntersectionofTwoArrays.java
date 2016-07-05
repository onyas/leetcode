package com.onyas.leetcode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/2
 * Time: 上午10:00
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Hash Table Two Pointers Sort
 * Hide Similar Problems (E) Intersection of Two Arrays II
 */
public class P349IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> datas1 = new HashMap<Integer, Integer>(nums1.length);
        HashMap<Integer, Integer> datas2 = new HashMap<Integer, Integer>(nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            datas1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            datas2.put(nums2[i], i);
        }
        int k = 0;
        for (Integer key : datas1.keySet()) {
            if (datas2.containsKey(key)) {
                k++;
            }
        }
        int[] result = new int[k];
        k = 0;
        for (Integer key : datas1.keySet()) {
            if (datas2.containsKey(key)) {
                result[k++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new P349IntersectionofTwoArrays().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
