package com.CK;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return -1;
        Arrays.sort(nums);
        int left, right, min = Integer.MAX_VALUE, t, returnInt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            t = target - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (Math.abs(t - (nums[left] + nums[right])) < min) {
                    min = Math.abs(t - (nums[left] + nums[right]));
                    returnInt = nums[left] + nums[right] + nums[i];
                }
                if (t - (nums[left] + nums[right]) == 0) break;
                else if (t - (nums[left] + nums[right]) < 0) right--;
                else if (t - (nums[left] + nums[right]) > 0) left++;
            }
        }
        return returnInt;
    }
}