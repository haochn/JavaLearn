package pers.learn.greedy;

public class CheckPossibility {
    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int cnt = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0 && nums[i + 1] >= nums[i - 1]) {
                    nums[i] = nums[i - 1];
                } else if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
                cnt++;
            }
        }
        return cnt < 2;
    }

    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        checkPossibility.checkPossibility(new int[]{4, 2, 1});
        //4, 2, 3
        //1, 4, 2, 3
        //3, 4, 2, 3
    }
}
