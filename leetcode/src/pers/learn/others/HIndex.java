package pers.learn.others;

import java.util.Arrays;

public class HIndex {
    /**
     * 274. H 指数
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     * <p>
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
     * 输入：citations = [3,0,6,1,5]
     * 输出：3
     * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = n;
        for (int i = 0; i < n; i++) {
            if (citations[i] < h) {
                h--;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        hIndex.hIndex(new int[]{3, 0, 6, 1, 5});
    }
}
