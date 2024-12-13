package Algorithm;

/**
 * @author 刘浩彬
 * @date 2023/8/8
 * 二分查找法
 */

//左闭右闭写法
    class Solution1{
        public int search(int[]nums, int target){
            if (target < 0 || target > nums[nums.length-1]){
                return -1;
            }
            int left = 0;
            int right = nums.length-1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target){
                    return mid;
                }
                else if (nums[mid] < target){
                    left = mid + 1;
                }
                else if (nums[mid] > target){
                    right = mid - 1;
                }
            }
            return -1;
        }
}


//左闭右开写法
class Solution {
    public int search(int[] nums, int target) {
        if (target < 0 || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] > target){
                right = mid;
            }
        }
        return -1;
    }
}


public class BinarySearchMethod {
}
