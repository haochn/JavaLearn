package pers.learn.binarySearch;

public class NextGreatestLetter {
    /**
     * 744. 寻找比目标字母大的最小字母
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
     * 在比较时，字母是依序循环出现的。举个例子：
     * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        char result = letters[0];
        for (char letter : letters) {
            if (letter - target > 0) {
                result = letter;
                return result;
            }
        }
        return result;
    }
}
