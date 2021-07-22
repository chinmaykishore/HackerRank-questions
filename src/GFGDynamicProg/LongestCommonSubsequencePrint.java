package GFGDynamicProg;
/*
LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

In order to find out the complexity of brute force approach, we need to first know the number of possible different subsequences
of a string with length n, i.e., find the number of subsequences with lengths ranging from 1,2,..n-1.
Recall from theory of permutation and combination that number of combinations with 1 element are nC1.
Number of combinations with 2 elements are nC2 and so forth and so on. We know that nC0 + nC1 + nC2 + … nCn = 2n.
So a string of length n has 2n-1 different possible subsequences since we do not consider the subsequence with length 0.
This implies that the time complexity of the brute force approach will be O(n * 2n). Note that it takes O(n) time to check
if a subsequence is common to both the strings. This time complexity can be improved using dynamic programming.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between
two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

The naive solution for this problem is to generate all subsequences of both given sequences and find the longest matching
subsequence. This solution is exponential in term of time complexity. Let us see how this problem possesses both important
properties of a Dynamic Programming (DP) Problem.

1) Optimal Substructure:
Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1]) be the
length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )

Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)

longest-common-subsequence

2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be
written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.

2) Overlapping Subproblems:
Following is simple recursive implementation of the LCS problem. The implementation simply follows the recursive structure
mentioned above.

Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens
when all characters of X and Y mismatch i.e., length of LCS is 0.

Considering the above implementation, following is a partial recursion tree for input strings “AXYT” and “AYZX”

                         lcs("AXYT", "AYZX")
                       /
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /                              /
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
In the above partial recursion tree, lcs(“AXY”, “AYZ”) is being solved twice. If we draw the complete recursion tree,
then we can see that there are many subproblems which are solved again and again. So this problem has Overlapping
Substructure property and recomputation of same subproblems can be avoided by either using Memoization or Tabulation.
Following is a tabulated implementation for the LCS problem.


 */
/*
Following is detailed algorithm to print the LCS. It uses the same 2D table L[][].

1) Construct L[m+1][n+1] using the steps discussed in previous post.

2) The value L[m][n] contains length of LCS. Create a character array lcs[] of length equal to the length of
lcs plus 1 (one extra to store \0).

2) Traverse the 2D array starting from L[m][n]. Do following for every cell L[i][j]
…..a) If characters (in X and Y) corresponding to L[i][j] are same (Or X[i-1] == Y[j-1]),
then include this character as part of LCS.
…..b) Else compare values of L[i-1][j] and L[i][j-1] and go in direction of greater value.
 */
public class LongestCommonSubsequencePrint
{
    /*
    Time Complexity of the above implementation is O(mn) which is much better than the worst-case time complexity of Naive Recursive implementation.
The above algorithm/code returns only length of LCS. Please see the following post for printing the LCS.
Printing Longest Common Subsequence
https://www.geeksforgeeks.org/printing-longest-common-subsequence/
You can also check the space optimized version of LCS at
Space Optimized Solution of LCS
https://www.geeksforgeeks.org/space-optimized-solution-lcs/
     */

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs( char[] S1, char[] S2)
    {
        int m = S1.length;
        int n = S2.length;
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of S1[0..i-1] and S2[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (S1[i-1] == S2[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        /*
        0 G X T X A Y B   ---> S2
        A 0 0 0 0 1 1 1
        G 1 1 1 1 1 1 1
        G 1 1 1 1 1 1 1
        T 1 1 2 2 2 2 2
        A 1 1 2 2 3 3 3
        B 1 1 2 2 3 3 4
        ^
        |
        S1
         */

        /*
        0 0 0 0 0 0 0 0
        0 0 0 0 0 1 1 1
        0 1 1 1 1 1 1 1
        0 1 1 1 1 1 1 1
        0 1 1 2 2 2 2 2
        0 1 1 2 2 3 3 3
        0 1 1 2 2 3 3 4
         */

        //printing for understanding
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                //System.out.println("L["+i+"]["+j+"]= "+L[i][j]);
                if(i==0 && j==0)
                    System.out.print(0+" ");
                else if(i==0)
                    System.out.print(S2[j-1]+" ");
                else if(j==0)
                    System.out.print(S1[i-1]+" ");
                else
                System.out.print(L[i][j]+" ");
            }
            System.out.println();
        }

        printlcs(L, S1, S2);

        return L[m][n];
    }

    private static void printlcs(int[][] L, char[] S1, char[] S2) {
        // Following code is used to print LCS
        int m = S1.length;
        int n = S2.length;
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index+1];
        lcs[index] = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (S1[i-1] == S2[j-1])
            {
                // Put current character in result
                lcs[index-1] = S1[i-1];

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of "+String.valueOf(S1)+" and "+String.valueOf(S2)+" is ");
        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);
    }

    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();

        System.out.println("Length of LCS is" + " " + lcs( X, Y) );
    }

}
