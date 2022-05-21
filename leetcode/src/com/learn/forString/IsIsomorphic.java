package com.learn.forString;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * <p>
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 解题：
 * 我们可以利用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，假设当前遇到的字母分别是 c1 和 c2 。
 * <p>
 * 如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。
 * <p>
 * 如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同。
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct) {
                    return false;
                }
            } else {
                map.put(cs, ct);
            }
        }
        return true;
    }
}
