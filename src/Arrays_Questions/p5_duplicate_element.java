package Arrays_Questions;

import java.util.*;

//Find the duplicate element in a limited range array
//        Given a limited range array of size n containing elements between
//        1 and n-1 with one element repeating, find the duplicate number in
//        it without using any extra space.


public class p5_duplicate_element {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4 };

        System.out.println("The duplicate element is " + findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) // Hashing
    {
        // create a visited array of size `n+1`
        // we can also use a map instead of a visited array
        boolean visited[] = new boolean[nums.length + 1];

        // mark each array element as visited and
        // return it if seen before
        for (int value: nums)
        {
            // if the element is seen before
            if (visited[value]) {
                return value;
            }

            // mark element as visited
            visited[value] = true;
        }

        // no duplicate found
        return -1;
    }

    public static int findDuplicateArrayIndices(int[] nums)
    {
        int duplicate = -1;

        // do for each array element
        for (int i: nums)
        {
            // get the positive value of the current element
            int val = (i < 0) ? -i : i;

            // make element at index `val` negative if it is positive
            if (nums[val] >= 0) {
                nums[val] = -nums[val];
            }
            else {
                // if the element is already negative, it is repeated
                duplicate = val;
                break;
            }
        }

        // restore the original array before returning
        for (int i = 0; i < nums.length; i++)
        {
            // make negative elements positive
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }

        // return duplicate element
        return duplicate;
    }
}
