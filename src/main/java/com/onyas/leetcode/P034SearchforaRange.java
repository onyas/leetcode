package com.onyas.leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/28
 * Time: 下午7:56
 * <p/>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * Subscribe to see which companies asked this question
 * Hide Tags Binary Search Array
 * Hide Similar Problems (E) First Bad Version
 * <p/>
 * 如果我们不寻找那个元素先，而是直接相等的时候也向一个方向继续夹逼，如果向右夹逼，最后就会停在右边界，而向左夹逼则会停在左边界，
 * 如此用停下来的两个边界就可以知道结果了，只需要两次二分查找。代码如下：
 */
public class P034SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        int[] d = {-1, -1};
        if (nums == null || nums.length == 0) {
            return d;
        }

        //找左边界
        int ll = 0, lr = nums.length - 1;
        while (ll <= lr) {
            int middle = ll + (lr - ll) / 2;
            //如果相等的时候，不会停下来而是继续向左边寻找
            if (nums[middle] < target) {
                ll = middle + 1;
            } else {
                lr = middle - 1;
            }
        }

        //找右边界
        int rl = 0, rr = nums.length - 1;
        while (rl <= rr) {
            int middle = rl + (rr - rl) / 2;
            //如果相等的时候，不会停下来而是继续向右边寻找
            if (nums[middle] <= target) {
                rl = middle + 1;
            } else {
                rr = middle - 1;
            }
        }

        if (ll <= rr) {
            d[0] = ll;
            d[1] = rr;
        }
        return d;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = new P034SearchforaRange().searchRange(nums, 8);
        for (int s : result) {
            System.out.print(s);
        }
    }
}
