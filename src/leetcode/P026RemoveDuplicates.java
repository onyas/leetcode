package leetcode;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/4
 * Time: 下午8:54
 */
public class P026RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }


    public static void main(String[] args) {
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 2}));
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new P026RemoveDuplicates().removeDuplicates(new int[]{1, 2, 2, 3}));
    }
}
