package com.learn.forHash;

import java.util.HashMap;

public class FindLHS {
    /**
     * 594. 最长和谐子序列
     * 题目规定的「和谐子序列」中的最值差值正好为 11，因而子序列排序后必然符合 [a,a,..,a+1,a+1][a,a,..,a+1,a+1] 形式，即符合条件的和谐子序列长度为相邻两数（差值为 11) 的出现次数之和。
     *
     * 我们可以使用「哈希表」记录所有 nums[i]nums[i] 的出现次数，然后通过 O(n)O(n) 的复杂度找出所有可能的数对（两数差值为 11)，并在所有符合条件的数对所能构成的「和谐子序列」长度中取最大值。
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int i : nums) {
            if (hashMap.containsKey(i - 1)) {
                ans = Math.max(ans, hashMap.get(i) + hashMap.get(i - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLHS findLHS = new FindLHS();
        findLHS.findLHS(new int[]{1,3,2,2,5,2,3,7});

    }
}
