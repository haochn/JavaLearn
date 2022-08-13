package pers.learn.greedy;

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int max = nums[0];
        int cnt = 0;
        for (int num : nums) {
            if (num >= max) {
                max = num;
            } else {
                cnt++;
                max = num;
            }
        }
        return cnt < 2;
    }

    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        checkPossibility.checkPossibility(new int[]{3,4,2,3});
    }
}
