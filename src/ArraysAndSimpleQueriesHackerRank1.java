/*
Given two numbers N and M. N indicates the number of elements in the array A[]
and M indicates number of queries.
You need to perform two types of queries on the array .

You are given  queries. Queries can be of two types, type 1 and type 2.

Type 1 queries are represented as 1 i j : Modify the given array by removing elements from i to j and adding them to the front.

Type 2 queries are represented as 2 i j : Modify the given array by removing elements from i to j and adding them to the back.

Your task is to simply print A[i] to A[n] of the resulting array after the
execution of M queries followed by the resulting array.

Note While adding at back or front the order of elements is preserved.

Input Format

First line consists of two space-separated integers, N and M.
Second line contains N integers, which represent the elements of the array.
M queries follow. Each line contains a query of either type 1 or type 2 in the form
type i j

Constraints



Output Format

Print the absolute value i.e. abs(A[1]-A[N]) in the first line.
Print elements of the resulting array in the second line. Each element should be seperated by a single space.

Sample Input

8 4
1 2 3 4 5 6 7 8
1 2 4
2 3 5
1 4 7
2 1 4
Sample Output

1
2 3 6 5 7 8 4 1
Explanation

Given array is .
After execution of query 124 , the array becomes {2,3,4,1,5,6,7,8}.
After execution of query 235, the array becomes {2,3,6,7,8,4,1,5}.
After execution of query 147, the array becomes {7,8,4,1,2,3,6,5}.
After execution of query 214, the array becomes {2,3,6,5,7,8,4,1}.
Now abs(A[1]-A[N]) is  abs(2-1) i.e. 1 and the array is {2,3,6,5,7,8,4,1}
 */
import java.util.*;
import java.io.*;

public class ArraysAndSimpleQueriesHackerRank1 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 8;//s.nextInt(); // size of array
        int m = 4;//s.nextInt(); // no. of queries

        //int[] arr = new int[n];// array input
        int[] arr = {1,2,3,4,5,6,7,8};

        /*
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }*/

        //int[][] queries = new int[m][3];
        int[][] queries = { {1,2,4},{2,3,5},{1,4,7},{2,1,4} };
        /*
        for (int i = 0; i < queries.length; i++) {
            queries[i][0] = s.nextInt();
            queries[i][1] = s.nextInt();
            queries[i][2] = s.nextInt();
        }*/
        int[] res = new int[1];

        for (int i = 0; i < queries.length; i++) {

            if (queries[i][0] == 1) {
                res = toFront(arr, queries[i][1] - 1, queries[i][2] - 1);

            }
            if (queries[i][0] == 2) {
                res = toBack(arr, queries[i][1] - 1, queries[i][2] - 1);
            }
        }

        System.out.println(Math.abs(arr[0] - res[res.length - 1]));
        for (int val : res) {
            System.out.print(val + " ");
        }

    }

    static int[] toFront(int[] arr, int s, int e) {

        for (int x = s; x <= e; x++) {
            int temp = arr[e];

            for (int i = e; i >= 1; i--) {
                arr[i] = arr[i - 1];

            }
            arr[0] = temp;
        }
        return arr;
    }

    static int[] toBack(int[] arr, int s, int e) {
        for (int x = s; x <= e; x++) {
            int temp = arr[s];

            for (int i = s + 1; i <= arr.length - 1; i++) {
                arr[i - 1] = arr[i];

            }
            arr[arr.length - 1] = temp;
        }

        return arr;
    }

}