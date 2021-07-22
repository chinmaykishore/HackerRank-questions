package GFGDynamicProg;
/*
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
Explanation:
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
Explanation:
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
Explanation:
The longest common substring is “abcdez” and is of length 6.

Approach:
Let m and n be the lengths of first and second strings respectively.
A simple solution is to one by one consider all substrings of first string and for every substring check
if it is a substring in second string. Keep track of the maximum length substring. There will be O(m^2) substrings
and we can find whether a string is subsring on another string in O(n) time (See this). So overall time complexity
of this method would be O(n * m2)

Dynamic Programming can be used to find the longest common substring in O(m*n) time. The idea is to find length of the
longest common suffix for all substrings of both strings and store these lengths in a table.

The longest common suffix has following optimal substructure property.

If last characters match, then we reduce both lengths by 1
LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]

If last characters do not match, then result is 0, i.e.,
LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])

Now we consider suffixes of different substrings ending at different indexes.
The maximum length Longest Common Suffix is the longest common substring.
LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j <= n

 */

public class LongestCommonSubstring {
        static int LCSubStr(char X[], char Y[])
        {
            // Create a table to store
            // lengths of longest common
            // suffixes of substrings.
            // Note that LCSuff[i][j]
            // contains length of longest
            // common suffix of
            // X[0..i-1] and Y[0..j-1].
            // The first row and first
            // column entries have no
            // logical meaning, they are
            // used only for simplicity of program

            int m = X.length;
            int n = Y.length;
            int LCStuff[][] = new int[m + 1][n + 1];

            // To store length of the longest
            // common substring
            int result = 0;

            // Following steps build
            // LCSuff[m+1][n+1] in bottom up fashion
            for (int i = 0; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    if (i == 0 || j == 0)
                        LCStuff[i][j] = 0;
                    else if (X[i - 1] == Y[j - 1])
                    {
                        LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                        result = Integer.max(result, LCStuff[i][j]);
                    }
                    else
                        LCStuff[i][j] = 0;
                }
            }
            /*
            0 G e e k s Q u i z
            G 1 0 0 0 0 0 0 0 0
            e 0 2 1 0 0 0 0 0 0
            e 0 1 3 0 0 0 0 0 0
            k 0 0 0 4 0 0 0 0 0
            s 0 0 0 0 5 0 0 0 0 
            f 0 0 0 0 0 0 0 0 0
            o 0 0 0 0 0 0 0 0 0
            r 0 0 0 0 0 0 0 0 0
            G 1 0 0 0 0 0 0 0 0
            e 0 2 1 0 0 0 0 0 0
            e 0 1 3 0 0 0 0 0 0
            k 0 0 0 4 0 0 0 0 0
            s 0 0 0 0 5 0 0 0 0
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
                        System.out.print(Y[j-1]+" ");
                    else if(j==0)
                        System.out.print(X[i-1]+" ");
                    else
                        System.out.print(LCStuff[i][j]+" ");
                }
                System.out.println();
            }
            return result;
        }

        // Driver Code
        public static void main(String[] args)
        {
            String X = "GeeksforGeeks";
            String Y = "GeeksQuiz";

            System.out.println(LCSubStr(X.toCharArray(), Y.toCharArray()));
        }
    }
    //Output
   // Length of Longest Common Substring is 10
   // Time Complexity: O(m*n)
