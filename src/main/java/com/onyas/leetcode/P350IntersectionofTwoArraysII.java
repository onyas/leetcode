package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/7/4
 * Time: 上午9:26
 * <p/>
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Hash Table Two Pointers Sort
 * Hide Similar Problems (E) Intersection of Two Arrays
 */
public class P350IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> datas1 = new HashMap<Integer, Integer>(nums1.length);
        for (int i : nums1) {
            if (datas1.containsKey(i)) {
                datas1.put(i, datas1.get(i) + 1);
            } else {
                datas1.put(i, 1);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (int i : nums2) {
            if (datas1.containsKey(i)) {
                if (datas1.get(i) > 1) {
                    datas1.put(i, datas1.get(i) - 1);
                } else {
                    datas1.remove(i);
                }
                resultList.add(i);
            }
        }

        int[] result = new int[resultList.size()];
        int k = 0;
        for (int i : resultList) {
            result[k++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] result = new P350IntersectionofTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
//        int[] result = new P350IntersectionofTwoArraysII().intersect(new int[]{1, 1}, new int[]{1});
        int[] result = new P350IntersectionofTwoArraysII().intersect(new int[]{1}, new int[]{1, 1});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
