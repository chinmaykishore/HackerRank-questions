package GFGDynamicProg;
/*

https://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/
https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

Given an array, we need to find maximum sum subarray, removing one element is also allowed to get the maximum sum.

Examples :

Input  : arr[] = {1, 2, 3, -4, 5}
Output : 11
Explanation : We can get maximum sum subarray by
removing -4.

Input 2 : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
Output : 9
Explanation : We can get maximum sum subarray by
removing -2 as, [4, -1, 1, 5] summing 9, which is
the maximum achievable sum.


If element removal condition is not applied, we can solve this problem using Kadane’s algorithm but here one element can be
removed also for increasing maximum sum.

This condition can be handled using two arrays, forward and backward array,
these arrays store the current maximum subarray sum from starting to ith index, and from ith index to ending respectively.

In below code, two loops are written, first one stores maximum current sum in forward direction in fw[]
and other loop stores the same in backward direction in bw[]. Getting current maximum and updation is same as Kadane’s algorithm.

fw, and bw for input 2 will be
Input 2 : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
fw[] = {0,0,4,3,1,2,7,4} ... start populating from front, whenver sum>0 else 0
bw[] = {2,4,7,3,4,6,5,0}  ... start populating from back, whenver sum>0 else 0
this is wrong for test case when all elements are < 0

so to handle that maxsofar will be used which is initialised with arr[0]

Now when both arrays are created, we can use them for one element removal conditions as follows,
at each index i, maximum subarray sum after ignoring i’th element will be fw[i-1] + bw[i+1]
so we loop for all possible i values and we choose maximum among them.

failing testcase
Input
[-1,-1,-1,-1]
Output
0
Expected
-1

Total time complexity and space complexity of solution is O(N)
 */

public class LargestSumContiguousSubArrayRemoving1EleMySoln {
    // Method returns maximum sum of all subarray where
    // removing one element is also allowed
    static int maxSumSubarrayRemovingOneEle(int arr[], int n)
    {

        // Maximum sum subarrays in forward and
        // backward directions
        int fw[] = new int[n];
        int bw[] = new int[n];
        int max_so_far = fw[0];

        fw[0] = Math.max(arr[0], 0);
        for (int i = 1; i < n; i++) {
            fw[i] = Math.max((fw[i - 1] + arr[i]), 0);
            if(fw[i]>max_so_far)
                max_so_far=fw[i];
        }

        bw[n - 1] = Math.max(arr[n - 1], 0);
        for (int i = n - 2; i >= 0; i--) {
            bw[i] = Math.max((bw[i + 1] + arr[i]), 0);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("fw= "+fw[i]+" bw= "+bw[i]);
        }

        /* Initializing final ans by max_so_far so that,
        case when no element is removed to get max sum
        subarray is also handled */
        int finalans = max_so_far;

        /*
        Input 2 : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
                   fw[] = {0,0,4,3,1,2,7,4} ... start populating from front, whenver sum>0 else 0
                   bw[] = {2,4,7,3,4,6,5,0}  ... start populating from back, whenver sum>0 else 0
         */

        // choosing maximum ignoring ith element
        for (int i = 1; i < n - 1; i++)
            finalans = Math.max(finalans, fw[i - 1] + bw[i + 1]);

        return finalans;
    }

    // Driver code
    public static void main(String arg[])
    {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;

        System.out.print(maxSumSubarrayRemovingOneEle(
                arr, n));
    }
}
