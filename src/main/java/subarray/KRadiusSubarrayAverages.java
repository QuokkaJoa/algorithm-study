package subarray;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] result = KRadiusSubarrayAverages.getAverages(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);

        if (k == 0){
            return nums;
        }
        if (2 * k + 1 > n) {
            return avgs;
        }

        long windowSum = 0;
        int windowSize = 2 * k + 1;

        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }
        avgs[k] = (int)(windowSum / windowSize);

        for (int i = k + 1; i <= n - k - 1; i++) {
            windowSum = windowSum - nums[i - k - 1] + nums[i + k];
            avgs[i] = (int)(windowSum / windowSize);
        }

        return avgs;
    }
}
