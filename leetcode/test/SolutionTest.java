import org.junit.Test;
import pers.learn.others.Solution;

public class SolutionTest {
    @Test
    public void minimumFuelCostTest() {
        Solution solution = new Solution();
        int[][] roads = new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        solution.minimumFuelCost(roads, 2);
    }

    @Test
    public void buyChocoTest() {
        Solution solution = new Solution();
        int[] prices = new int[]{3, 2, 3};
        solution.buyChoco(prices, 3);
    }

    @Test
    public void deleteDuplicates() {
        Solution solution = new Solution();
        Solution.ListNode four = solution.new ListNode(0);
        Solution.ListNode three2 = solution.new ListNode(0, four);
        Solution.ListNode three = solution.new ListNode(0, three2);
        Solution.ListNode two = solution.new ListNode(-1, three);
        Solution.ListNode one = solution.new ListNode(-3, two);
        Solution.ListNode listNode = solution.deleteDuplicates(one);
    }

    @Test
    public void capitalizeTitleTest() {
        Solution solution = new Solution();
        solution.capitalizeTitle("capiTalIze tHe titLe");
    }

    @Test
    public void maximumOddBinaryNumberTest() {
        Solution solution = new Solution();
        solution.maximumOddBinaryNumber("010");
    }
}
