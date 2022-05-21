package com.learn.forString;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 * <p>
 * 解题思路：
 * 做过前天那题的同学，很容易想到做一个int[26+26]数组来保存各字母的个数，但A～Z和a～z在ASCII表上是分开的喔，所以存数组的时候也要分开存哦
 * 如果某字母有偶数个，因为偶数有对称性，可以把它全部用来构造回文串；但如果是奇数个的话，并不是完全不可以用来构建，也不是只能选最长的那个，而是只要砍掉1个，剩下的变成偶数就可以全部计入了
 * 但奇数字母里，可以保留1个不砍，把它作为回文串的中心，所以最后还要再加回一个1
 * 但是！如果压根没有奇数的情况，这个1也不能随便加，所以还要分情况讨论
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int[] cnts = new int[58];
        //回文串的最大长度
        int maxLength = 0;
        //用来统计字母出现次数为奇数
        int odd = 0;
        //判断是否有字母出现的次数为奇数
        boolean flag = false;
        for (int i :
                s.toCharArray()) {
            cnts[i - 'A']++;
        }
        for (int j :
                cnts) {
            //出现次数为偶数，全部加起来
            if (j % 2 == 0 && j != 0) {
                maxLength += j;
            }
            //出现次数为偶数，-1后全部加起来
            if (j % 2 == 1) {
                odd += j - 1;
                flag = true;

            }
        }
        return flag ? maxLength + odd + 1 : maxLength + odd;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        int maxLen = longestPalindrome.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
        System.out.println(maxLen);
    }
}
