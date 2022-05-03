package Arrays_Questions;
import java.util.*;

// Find a pair with the given sum in an array

public class p1_pair_with_given_sum {
    public static void main(String[] args) {
        int[] nums = { 8, 7, 2, 5, 3, 1 };
        int target = 10;

        findPair(nums, target);
        findPairSorting(nums,target);
        findPairHashMap(nums,target);
    }
    public static void findPair(int[] nums, int target)
    {
        // consider each element except the last
        for (int i = 0; i < nums.length - 1; i++)
        {
            // start from the i'th element until the last element
            for (int j = i + 1; j < nums.length; j++)
            {
                // if the desired sum is found, print it
                if (nums[i] + nums[j] == target)
                {
                    System.out.println("Pair found (" + nums[i] + "," + nums[j] + ")");
                    return;
                }
            }
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }

    public static void findPairSorting(int[] nums, int target)
    {
        // sort the array in ascending order then apply Binary search
        Arrays.sort(nums);

        // maintain two indices pointing to endpoints of the array
        int low = 0;
        int high = nums.length - 1;

        // reduce the search space `nums[low…high]` at each iteration of the loop

        // loop till the search space is exhausted
        while (low < high)
        {
            // sum found
            if (nums[low] + nums[high] == target)
            {
                System.out.println("Pair found (" + nums[low] + "," +
                        nums[high] + ")");
                return;
            }

            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if (nums[low] + nums[high] < target) {
                low++;
            }
            else {
                high--;
            }
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }


    public static void findPairHashMap(int[] nums, int target)
    {
        // create an empty HashMap
        Map<Integer, Integer> map = new HashMap<>();

        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
            // check if pair (nums[i], target-nums[i]) exists

            // if the difference is seen before, print the pair
            if (map.containsKey(target - nums[i]))
            {
                System.out.printf("Pair found (%d, %d)",
                        nums[map.get(target - nums[i])], nums[i]);
                return;
            }

            // store index of the current element in the map
            map.put(nums[i], i);
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");
    }
}
