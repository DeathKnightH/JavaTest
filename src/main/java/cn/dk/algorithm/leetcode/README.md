# leetcode-cn 个人题解

## 0. Introduction

记录 leetcode-cn 上做题的思路和代码，具体的写法和详细思路在代码注释。

## 1. Index

| No.  | title                                                        | 个人思路                         | discuss 看到的更高效的思路或者改进方案 |
| ---- | ------------------------------------------------------------ | -------------------------------- | -------------------------------------- |
| 2    | [Add two numbers](/AddTwoNumbers.java)                       | 递归                             | 单循环代替递归                         |
| 3    | [Longest Substring Without Repeating Characters](/LongestSubstringWithoutRepeatingCharacters.java) | hashmap辅助单循环                | hashset 辅助单循环                     |
| 4    | [MedianOfTwoSortedArrays](/MedianOfTwoSortedArrays.java)     | 单循环                           |                                        |
| 5    | [Longest Palindrome](/LongestPalindrome.java)                | 中心扩散                         | 动态规划                               |
| 7    | [ReverseInteger](/ReverseInteger.java)                       | 单循环                           |                                        |
| 9    | [Palindrome Number](/PalindromeNumber.java)                  | 转换字符串对比                   |                                        |
| 13   | [RomanToInteger](/RomanToInteger.java)                       | 转换为整型数组再根据规则整体计算 |                                        |
| 14   | [Longest Common Prefix](/LongestCommonPrefix.java)           | 嵌套循环                         |                                        |
| 20   | [ValidParentheses](/ValidParentheses)                        | 使用栈结构进行配对               |                                        |
| 21   | [MedianOfTwoSortedArrays](/MedianOfTwoSortedArrays.java)     | 单循环                           |                                        |
| 27   | [Remove Element](/RemoveElement.java)                        | 嵌套循环                         | 双指针，单循环                         |
| 28   | [Implement strStr()](/ImplementStrStr.java)                  | 嵌套循环                         |                                        |
| 35   | [SearchInsertPosition](/SearchInsertPosition.java)           | 二分法                           |                                        |
| 62   | [UniquePaths](/UniquePaths.java)                             | 动态规划                         |                                        |
| 64   | [MinimumPathSum](/MinimumPathSum.java)                       | 动态规划                         |                                        |
| 70   | [ClimbingStairs](/ClimbingStairs.java)                       | 动态规划                         |                                        |
| 167  | [TwoSumiiInputArrayIsSorted](/twopointers/TwoSumiiInputArrayIsSorted.java) | 双指针，单循环                   |                                        |
| 198  | [HouseRobber](/HouseRobber.java)                             | 动态规划                         |                                        |
| 213  | [House Robber II](/HouseRobberII.java)                       | 动态规划                         |                                        |
| 279  | [Perfect Squares](/PerfectSquares.java)                      | 动态规划                         |                                        |
| 303  | [RangeSumQueryImmutable](/RangeSumQueryImmutable.java)       | 动态规划                         |                                        |
| 322  | [Coin Change](/CoinChange.java)                              | 递归                             | 动态规划                               |
| 343  | [Integer Break](/IntegerBreak.java)                          | 动态规划                         |                                        |
| 345  | [ReverseVowelsOfAString](/twopointers/ReverseVowelsOfAString.java) | 双指针，单循环                   |                                        |
| 394  | [Decode String](/DecodeString.java)                          | stack                            |                                        |
| 413  | [Arithmetic Slices](/ArithmeticSlices.java)                  | 动态规划/数学公式+单循环         |                                        |
| 633  | [SumOfSquareNumbers](/twopointers/SumOfSquareNumbers.java)   | 双指针，单循环                   |                                        |



## 2.常见解题思路

| 思路     | 描述                                             | 典型例题 |
| -------- | ------------------------------------------------ | -------- |
| 双指针   | 常用于线性结构的数据，用头尾两个指针协同完成任务 | 167，633 |
| 动态规划 |                                                  |          |
|          |                                                  |          |

