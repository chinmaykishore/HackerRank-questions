package GFGDynamicProg;
/*
Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character
at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.

Examples:

Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a'
(second). Note that 'b' cannot be considered
as part of subsequence as it would be at same
index in both.
Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
This problem is just the modification of Longest Common Subsequence problem.
The idea is to find the LCS(str, str) where str is the input string with the restriction that when both the characters are same,
they shouldn’t be on the same index in the two strings.
 */

public class LongestRepeatedSubsequence {
}
