import org.junit.Test;
import pers.learn.others.Solution;

public class SolutionTest {
    @Test
    public void minimumFuelCostTest() {
        Solution solution = new Solution();
        int[][] roads = new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        solution.minimumFuelCost(roads, 2);
    }
}
