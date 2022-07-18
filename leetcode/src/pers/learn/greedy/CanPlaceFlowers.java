package pers.learn.greedy;

public class CanPlaceFlowers {
    /**
     * 605. 种花问题
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给你一个整数数组flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
     * 另有一个数n ，能否在不打破种植规则的情况下种入n朵花？能则返回 true ，不能则返回 false。
     * <p>
     * 1 <= flowerbed.length <= 2 * 104
     * flowerbed[i] 为 0 或 1
     * flowerbed 中不存在相邻的两朵花
     * 0 <= n <= flowerbed.length
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 1) {
                i++;
            } else if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n -= 1;
                flowerbed[i] = 1;
                i++;
            } else if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n -= 1;
                flowerbed[i] = 1;
                i++;
            }
        }
        if (flowerbed.length > 1 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            n -= 1;
        }
        if (flowerbed.length == 1) {
            return (n & flowerbed[0]) == 0;
        }
        return n < 1;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        boolean b = canPlaceFlowers.canPlaceFlowers(new int[]{0}, 1);
        System.out.println(b);
    }


}
