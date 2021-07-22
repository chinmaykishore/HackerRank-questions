package GFGDynamicProg;
/*
Given an array containing n integers. The problem is to find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
Examples:


Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
Output : -6
Subarray is {-4, 2, -3, -1} = -6

Input : arr = {2, 6, 8, 1, 4}
Output : 1


Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Naive Approach: Consider all the contiguous subarrays of different sizes and find their sum. The subarray having the smallest(minimum) sum is the required answer.
Efficient Approach: It is a variation to the problem of finding the largest sum contiguous subarray based on the idea of Kadane’s algorithm.
Algorithm:


smallestSumSubarr(arr, n)
    Initialize min_ending_here = INT_MAX
    Initialize min_so_far = INT_MAX

    for i = 0 to n-1
        if min_ending_here > 0
            min_ending_here = arr[i]
        else
            min_ending_here += arr[i]
        min_so_far = min(min_so_far, min_ending_here)

    return min_so_far
 */

public class SmallestSumContiguousSubArrayKadane {
}
