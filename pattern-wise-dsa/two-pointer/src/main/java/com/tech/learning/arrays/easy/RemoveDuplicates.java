package com.tech.learning.arrays.easy;

/**
 * Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {

    static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(STR."Brute-Force Approach ---- Result of removed duplicates: \{bruteForceApproach(nums)}");

        System.out.println(STR."Optimal Approach ---- Result of removed duplicates: \{optimalApproach(nums)}");
    }


    private static int optimalApproach(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[k]) {
                j++;
            } else {
                nums[++k] = nums[j++];
            }
        }

        return k + 1;
    }


    private static int bruteForceApproach(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0;
        int[] result = new int[nums.length];
        result[k++] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                result[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
