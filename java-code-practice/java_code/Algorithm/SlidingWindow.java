package Algorithm;

/**
 * @author 刘浩彬
 * @date 2023/8/10
 */

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */

//暴力
class Solution5{
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    result = Math.min(result,j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

//滑动窗口

class Solution2323 {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        int length = 0;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while(sum >= target){
                length = j - i + 1;
                result = Math.min(result,length);
                sum -= nums[i++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

public class SlidingWindow {
}
