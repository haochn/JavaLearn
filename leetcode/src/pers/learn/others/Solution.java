package pers.learn.others;

public class Solution {

    /**
     * 828. 统计子串中的唯一字符
     * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
     * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
     * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
     * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
     *
     * 本解法会超时
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
}
