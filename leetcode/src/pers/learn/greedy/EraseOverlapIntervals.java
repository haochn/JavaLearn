package pers.learn.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 10^4<= starti< endi<= 5 * 10^4
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
