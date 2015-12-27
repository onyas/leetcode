package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p/>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p/>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 上午10:05
 */
public class P015ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //avoid duplicate solutions
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;
                int negtive = -nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == negtive) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        res.add(tmp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[start] + nums[end] < negtive) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new P015ThreeSum().threeSum(new int[]{1, 2, 3, -1, 0}));
        System.out.println(new P015ThreeSum().threeSum(new int[]{0,0,0}));
    }

}
