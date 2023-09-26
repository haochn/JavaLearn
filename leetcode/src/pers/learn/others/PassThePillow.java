package pers.learn.others;

public class PassThePillow {
    /**
     * 2582. 递枕头
     * n 个人站成一排，按从 1 到 n 编号。
     * <p>
     * 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
     * <p>
     * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
     * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
     * 输入：n = 4, time = 5
     * 输出：2
     * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
     * 5 秒后，枕头传递到第 2 个人手中。
     *
     * @param n
     * @param time
     * @return
     */
    public int passThePillow(int n, int time) {
        int result;
        boolean flag = (time / (n - 1)) % 2 == 0;
        if (flag) {
            result = 1 + time % (n - 1);
        }
        else {
            result = n - time % (n - 1);
        }
        return result;
    }
}
