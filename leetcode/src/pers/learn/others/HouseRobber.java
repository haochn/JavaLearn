package pers.learn.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }


    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] tmp2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robHelper(tmp2), robHelper(tmp));
    }

    private int robHelper(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    /**
     * 337. 打家劫舍 III
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     */
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归
    public int rob3_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += rob3_1(root.left.left) + rob3_1(root.left.right);
        }
        if (root.right != null) {
            money += rob3_1(root.right.left) + rob3_1(root.right.right);
        }
        return Math.max(money, rob3_1(root.left) + rob3_1(root.right));
    }

    // 递归 + 使用map记忆化
    public int rob3_2(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>(16);
        return rob3_2Helper(root, map);
    }

    public int rob3_2Helper(TreeNode root, Map map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return (Integer) map.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += rob3_2Helper(root.left.left, map) + rob3_2Helper(root.left.right, map);
        }
        if (root.right != null) {
            money += rob3_2Helper(root.right.left, map) + rob3_2Helper(root.right.right, map);
        }
        int max = Math.max(money, rob3_2Helper(root.left, map) + rob3_2Helper(root.right, map));
        map.put(root, max);
        return max;
    }

    public int rob3_3(TreeNode root) {
        int[] result = rob3_3Helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] rob3_3Helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = rob3_3Helper(root.left);
        int[] right = rob3_3Helper(root.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }

}
