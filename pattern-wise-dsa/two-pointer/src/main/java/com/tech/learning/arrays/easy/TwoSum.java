package com.tech.learning.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question: https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    static void main() {
        int[] nums = {2, 1, 8, 7, 11, 10, 14};
        int target = 21;

        int[] bruteResult = bruteForceApproach(nums, target);
        System.out.println(STR."Brute-Force -- Two Sum Result: \{Arrays.toString(bruteResult)}");

        int[] optimalResult = optimalApproach(nums, target);
        System.out.println(STR."Optimal Approach -- Two Sum Result: \{Arrays.toString(optimalResult)}");
    }


    private static int[] bruteForceApproach(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] optimalApproach(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
