package pers.learn.forString;

/**
 * 696. 计数二进制子串
 * 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            //巧妙的用数学统计出来
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00111011"));
    }
}
