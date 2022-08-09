package pers.learn.greedy;

public class IsSubsequence {
    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            // 找到 t 上第一个匹配的 ch
            while (i < t.length() && t.charAt(i) != ch) {
                i++;
            }
            // 如果 t 穷尽，跳出，注意始终对 i 加一
            if (i++ >= t.length()) {
                break;
            }
        }
        return i <= t.length();
    }
}
