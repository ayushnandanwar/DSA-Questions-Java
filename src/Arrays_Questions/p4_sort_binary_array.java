package Arrays_Questions;

import java.util.*;

//Sort binary array in linear time
//        Given a binary array, sort it in linear time and constant space.
//        The output should print all zeroes, followed by all ones.

public class p4_sort_binary_array {
    public static void main(String[] args) {
        int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

        sort(A);

        // print the rearranged array
        System.out.println(Arrays.toString(A));
    }

    public static void sort(int[] A)
    {
        // count number of 0's
        int zeros = 0;
        for (int value: A)
        {
            if (value == 0) {
                zeros++;
            }
        }

        // put 0's at the beginning
        int k = 0;
        while (zeros-- != 0) {
            A[k++] = 0;
        }

        // fill all remaining elements by 1
        while (k < A.length) {
            A[k++] = 1;
        }
    }

    public static void sort1(int[] A)
    {
        // `k` stores index of next available position
        int k = 0;

        // do for each element
        for (int i: A)
        {
            // if the current element is zero, put 0 at the next free
            // position in the array
            if (i == 0) {
                A[k++] = 0;  ////// while counting, fill zeros
            }
        }

        // fill all remaining indices by 1
        for (int i = k; i < A.length; i++) {
            A[k++] = 1;
        }
    }

    public static void sort2(int[] A)  // quick sort strategy
    {
        int pivot = 1;
        int j = 0;

        // each time we encounter a 0, `j` is incremented, and
        // 0 is placed before the pivot
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] < pivot)
            {
                swap(A, i, j);
                j++;
            }
        }
    }

    // Utility function to swap elements at two indices in the given array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
