package com.learn.forBits;

public class HammingDistance {
    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z > 0) {
            if ((z & 1) == 1) {
                cnt++;
            }
            z = z >> 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        hammingDistance.hammingDistance(1, 4);
    }
}
