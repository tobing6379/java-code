# 模块简介

剑指offer相关刷题代码，基于[leetcode](https://leetcode-cn.com/problem-list/xb9nqhhg/)。

## 题目

+ [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)
  + 解法一：[辅助Set](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_3/Solution.java)：Set具有元素唯一性，可以用于判重
  + 解法二：[原地交换](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_3/Solution1.java)：利用题目的限制，将元素放到对应的数组下标中实现判重
+ [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)
  + 解法一：[暴力解法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_4/Solution.java)：由于是数组，可以利用利用CPU缓存机制加速，性能仍然可以得到保证【O(N*M)】
  + 解法二：[二分法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_4/Solution1.java)：由于是有序的，可以考虑使用二分法，可以基于行/列二分查找，行能够更好利用CPU缓存机制【O(N*logM)】
  + 解法三：[去行消列法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_4/Solution2.java)：根据矩阵具有的顺序性质，选取最左下角的元素作为判断基准，当基准元素比target小，说明targe比基准所在列的所有元素都要大，消除该列，反之当基准元素比target大，说明target比基准元素所在行的所有元素都要小，消除行；消除行列的同时更新基准元素。【O(N+M)】
+ [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)
  + 解法一：[遍历替换](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_5/Solution.java)：Java中字符串操作使用StringBuilder比直接String拼接性能更高【O(N)】
+ [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
  + 解法一：[递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_6/Solution.java)：遍历链表，都可以往递归方向想
  + 解法二：[倒叙添加法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_6/Solution1.java)：顺序遍历，逆序添加
  + 解法三：[辅助栈法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_6/Solution2.java)：顺序入栈，顺序出栈
+ [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)
  + 解法一：[辅助Map](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_7/Solution.java)：首先搞懂如何通过画图的方式来将前序遍历序列和中序遍历序列构建二叉树，[参考博客](https://www.cnblogs.com/jiaxin359/p/9512348.html)



