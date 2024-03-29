package pers.learn.others;

import java.util.*;

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


    /**
     * 2706. 购买两块巧克力
     * 给你一个整数数组 prices ，它表示一个商店里若干巧克力的价格。同时给你一个整数 money ，表示你一开始拥有的钱数。
     * 你必须购买 恰好 两块巧克力，而且剩余的钱数必须是 非负数 。同时你想最小化购买两块巧克力的总花费。
     * 请你返回在购买两块巧克力后，最多能剩下多少钱。如果购买任意两块巧克力都超过了你拥有的钱，请你返回 money 。注意剩余钱数必须是非负数。
     */
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) {
            return money;
        }
        return money - prices[0] - prices[1];
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     */
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>(8);
        map.put(head.val, 1);
        ListNode nextNode = head.next;
        while (null != nextNode) {
            // 遍历链表
            if (map.containsKey(nextNode.val)) {
                map.put(nextNode.val, map.get(nextNode.val) + 1);
            }
            else {
                map.put(nextNode.val, 1);
            }
            nextNode = nextNode.next;
        }
        ListNode result = null;
        ListNode pre = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ListNode tmp = new ListNode(entry.getKey());
                if (null == result) {
                    result = tmp;
                    pre = tmp;
                    continue;
                }
                pre.next = tmp;
                pre = tmp;
            }
        }
        return result;
    }

    /**
     * 2129. 将标题首字母大写
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母大写 ：
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title
     *
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        StringBuilder ans = new StringBuilder();
        String[] words = title.split(" ");
        for (String word : words) {
            if (word.length() > 2) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
            else {
                word = word.toLowerCase();
            }
            ans.append(word).append(" ");
        }
        return ans.substring(0, ans.length() - 1).toString();
    }

    /**
     * 2864. 最大二进制奇数
     * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
     * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
     * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
     * 注意 返回的结果字符串 可以 含前导零。
     *
     * @param s
     * @return
     */
    public String maximumOddBinaryNumber(String s) {
        char[] array = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char c : array) {
            if (49 == c) {
                ans.append(c);
            }
        }
        if (s.length() != ans.length()) {
            int i = s.length() - ans.length();
            // 去掉最后一位
            ans = new StringBuilder(ans.substring(0, ans.length() - 1));
            while (i > 0) {
                // 中间补0
                ans.append('0');
                i--;
            }
            // 补上最后一位
            ans.append('1');
        }
        return ans.toString();
    }
}
