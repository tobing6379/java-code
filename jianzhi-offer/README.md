# 模块简介

剑指offer相关刷题代码，基于[leetcode](https://leetcode-cn.com/problem-list/xb9nqhhg/)。

## 题目

+ [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)
  + 解法一：[辅助Set](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_03/Solution.java)：Set具有元素唯一性，可以用于判重:laughing:
  + 解法二：[原地交换](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_03/Solution1.java)：利用题目的限制，将元素放到对应的数组下标中实现判重:worried:
+ [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)
  + 解法一：[暴力解法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_04/Solution.java)：由于是数组，可以利用利用CPU缓存机制加速，性能仍然可以得到保证【O(N*M)】:laughing:
  + 解法二：[二分法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_04/Solution1.java)：由于是有序的，可以考虑使用二分法，可以基于行/列二分查找，行能够更好利用CPU缓存机制【O(N*logM)】:laughing:
  + 解法三：[去行消列法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_04/Solution2.java)：根据矩阵具有的顺序性质，选取最左下角的元素作为判断基准，当基准元素比target小，说明targe比基准所在列的所有元素都要大，消除该列，反之当基准元素比target大，说明target比基准元素所在行的所有元素都要小，消除行；消除行列的同时更新基准元素。【O(N+M)】:worried:
+ [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)
  + 解法一：[遍历替换](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_05/Solution.java)：Java中字符串操作使用StringBuilder比直接String拼接性能更高【O(N)】:laughing:
+ [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
  + 解法一：[递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_06/Solution.java)：遍历链表，都可以往递归方向想:laughing:
  + 解法二：[倒叙添加法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_06/Solution1.java)：顺序遍历，逆序添加:laughing:
  + 解法三：[辅助栈法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_06/Solution2.java)：顺序入栈，顺序出栈:laughing:
+ [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)
  + 解法一：[辅助Map](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_07/Solution.java)：首先搞懂如何通过画图的方式来将前序遍历序列和中序遍历序列构建二叉树，[参考博客](https://www.cnblogs.com/jiaxin359/p/9512348.html)。:worried:
+ [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)
  + 解法一：[普通栈](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_09/Solution.java)：核心思想是操作一个栈的时候，确保数据只在当前栈，如果另外一个栈存元素，全部放到该栈才操作。:laughing:
+ [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)
  + 解法一：[暴力递归](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_10_i/Solution.java)：暴力递归:laughing:
  + 解法二：[动态规划](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_10_i/Solution1.java)：递推公式比较简单:laughing:
+ [剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)
  + 解法一：[动态规划](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_10_ii/Solution.java)：递推公式比较简单:laughing:
+ [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)​​
  + 解法一：[普通遍历法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_11/Solution.java)：性质可知，第一个递减元素为最小值，直接返回；不存在则表示不转账，直接返回最左边元素:laughing:
  + 解法二：[二分法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_11/Solution1.java)：涉及到有序都可以想到二分法，由于存在转折点，二分法比较难想。:no_entry:
+ [剑指 Offer 12. 矩阵中的路径](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)
  + 解法一：[辅助Set](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_12/Solution.java)：在board的遍历时，使用Set来记录已经遍历过的元素:worried:
  + 解法二：[辅助二维数组](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_12/Solution1.java)：在board的遍历时，使用二维数组来记录已经遍历过的元素:worried:
  + 解法三：[dfs](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_12/Solution2.java)：在board的遍历时，不使用使用额外的数据结构记录遍历的元素，直接原来board记录，在返回时，将该位置上的值复原即可:no_entry:
+ [剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)
  + 解法一：[dfs](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_13/Solution.java)：上一题不同，上一题判断图(board)中有没有一条遍历路径与给定的路径相同，而这一题是要判断能够到达的所有位置，因此本题遍历过的元素不必复原。:no_entry:
+ [剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)
  + 解法一：[暴力递归](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_14_i/Solution.java)：难点是理解如何将绳子分成m端，求出分出m端的最大值:worried:
  + 解法一：[动态规划](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_14_i/Solution1.java)：看代码:worried:
  + 解法一：[贪心-数学](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/)：不会:no_entry::no_entry:
+ [剑指 Offer 14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/)
  + 解法一：[动态规划](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_14_ii/Solution.java)：思想和上一条类似，主要是范围变大了，不能用int直接储存，因为要求余:worried:
  + 解法一：[贪心-数学](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/)：不会:no_entry::no_entry:
+ [剑指 Offer 15. 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)
  + 解法1：[简单位移法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_15/Solution.java)：最直观的思路每次将其右移以为，如果移位之后对2求余，不为零则表示当前位为1，依次统计:laughing:
  + 解法2：[位运算法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_15/Solution1.java)：将上面的对2求余，转换为位运算，Java支持为运算:laughing:
  + 解法3：[JavaAPI解法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_15/Solution2.java)：Java提供了对二进制位的统计，采用的是一种很巧妙的方式，此处不展开:no_entry::no_entry:
+ [剑指 Offer 16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)
  + 解法1：[暴力运算](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_16/Solution.java)：最直观简答的做法，就是每次用一个变量，每次乘上x，循环n次:laughing:
  + 解法2：[快速幂](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_16/Solution1.java)：这个是用来降低复杂度的，方法非常巧妙，利用上了二进制的性质:no_entry::no_entry:



