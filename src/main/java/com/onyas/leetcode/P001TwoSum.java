package com.onyas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P001TwoSum {


	/***
	 * O(n) space O(n) time
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		int[] res = new int[2];

		HashMap<Integer,Integer> numMaps = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(numMaps.get(target-nums[i])!=null){
				res[0] = numMaps.get(target-nums[i])+1;
				res[1] = i+1;
				break;
			}
			numMaps.put(nums[i],i);
		}

		return res;
	}



	/**
	 * O(n^2)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					break;
				}
			}
		}
		return result;
	}

	public int[] twoSum2(int[] nums, int target) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			numbers.add(nums[i]);
		}
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int second = target - nums[i];
			if (numbers.lastIndexOf(second) != -1
					&& numbers.lastIndexOf(second) != i) {
				result[0] = i + 1;
				result[1] = numbers.lastIndexOf(second) + 1;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = new P001TwoSum().twoSum2(new int[] { 0, 4, 3, 0 }, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
