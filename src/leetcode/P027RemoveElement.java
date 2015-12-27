package leetcode;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/5
 * Time: 上午10:22
 */
public class P027RemoveElement {

    public int removeElement(int[] nums, int val) {

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
