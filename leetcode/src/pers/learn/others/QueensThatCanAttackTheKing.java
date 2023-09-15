package pers.learn.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 */
public class QueensThatCanAttackTheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        boolean[][] isQueen = new boolean[8][8];

        for (int[] queen : queens) {
            isQueen[queen[0]][queen[1]] = true;
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int[] direction : directions) {
            int x = king[0];
            int y = king[1];
            while (x > -1 && x < 8 && y > -1 && y < 8) {
                if (isQueen[x][y]) {
                    result.add(Arrays.asList(x, y));
                    break;
                }
                x += direction[0];
                y += direction[1];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] queues = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0,0};
        QueensThatCanAttackTheKing queensThatCanAttackTheKing = new QueensThatCanAttackTheKing();
        List<List<Integer>> lists = queensThatCanAttackTheKing.queensAttacktheKing(queues, king);
        System.out.println(lists);
    }
}
