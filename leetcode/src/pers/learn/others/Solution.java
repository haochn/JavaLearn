package pers.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 828. 统计子串中的唯一字符
     * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
     * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
     * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
     * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
     * <p>
     * 本解法会超时
     *
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {
        int result = 0;
        int length = s.length();
        int i = 0;
        while (i < length) {
            for (int j = i; j < length; j++) {
                result += countUniqueChars(s.substring(i, j + 1));
            }
            i++;
        }
        return result;
    }

    private int countUniqueChars(String subString) {
        int result = 0;
        int[] ints = new int[26];
        int length = subString.length();
        for (int i = 0; i < length; i++) {
            ints[subString.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ints[i] == 1) {
                result++;
            }
        }
        return result;
    }

    /**
     * 2477. 到达首都的最少油耗
     * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
     * 每个城市里有一个代表，他们都要去首都参加一个会议。
     * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
     * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
     * 请你返回到达首都最少需要多少升汽油。
     *
     * @param roads
     * @param seats
     * @return
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1];
            g[x].add(y); // 记录每个点的邻居
            g[y].add(x);
        }

        dfs(0, -1, g, seats);
        return ans;
    }

    private long ans;

    private int dfs(int x, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int y : g[x]) {
            if (y != fa) { // 递归子节点，不能递归父节点
                size += dfs(y, x, g, seats); // 统计子树大小
            }
        }
        if (x > 0) { // x 不是根节点
            ans += (size - 1) / seats + 1; // ceil(size/seats)
        }
        return size;
    }

}
