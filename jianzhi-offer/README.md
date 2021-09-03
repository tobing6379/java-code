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
+ [剑指 Offer 17. 打印从1到最大的n位](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)
  + 解法1：[普通解法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_17/Solution.java)：先取到n位数的上限，然后从1到n开始遍历填充到数组中:laughing:
  + 解法2：[全排序](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_17/Solution1.java)：题目符合全排序的性质，但未完全理解:no_entry:
+ [剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)
  + 解法1：[递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_18/Solution.java)：利用递归，如果递归的当前节点属于需要删除的节点，则不返回该节点，而是返回下一个节点:laughing:
  + 解法2：[迭代法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_18/Solution1.java)：利用虚拟头结点统一边界情况:laughing:
+ [剑指 Offer 19. 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)
  + 解法1：[动态规划](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_19/Solution.java)：粗略看懂，跪了，代码中有题解的地址。:no_entry::no_entry::no_entry:
+ [剑指 Offer 20. 表示数值的字符串](https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/)
  + 解法1：[暴力匹配法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_20/Solution.java)：字符串==>预处理==>分为带E和不带E==>带E分为两部分(前面和后面)前面是整数或小数，后面必须为整数==>不带E可以是整数或小数:worried:
+ [剑指 Offer 21. 调整数组顺序使奇数位于偶数](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)
  + 解法1：[双指针](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_21/Solution.java)：通过首尾指针，遇到刚好首是偶数，尾是奇数，直接交换，否则两个一直移动，终止条件注意一下。:laughing:
+ [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
  + 解法1：[全局变量法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_22/Solution.java)：利用全局变量记录k，递归到底返回时，维护k，k为0即为目标节点，直接返回。:laughing:
  + 解法2：[指针偏移法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_22/Solution1.java)：利用一个辅助节点，其为当前节点偏移k的节点，两个节点同时一定，辅助节点为NULL时，当前节点即为要求节点。:laughing:
+ [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)
  + 解法1：[递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_24/Solution.java)：递归到底开始反转，可以画图理解，直接看代码。:laughing:
+ [剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)
  + 解法1：[双指针法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_25/Solution.java)：通过两个指针在两条链表中遍历，不断比较两个指针的值，决定取哪个值:laughing:
+ [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)
  + 解法1：[遍历递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_26/Solution.java)：通过一个辅助函数来判断两棵树是否为同根子树，在原函数中遍历整棵树的所有节点:no_entry:
+ [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)
  + 解法1：[简单递归](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_27/Solution.java)：比较简单，没啥好说。:laughing:
+ [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)
  + 解法1：[辅助函数法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_28/Solution.java)：主要看辅助函数。:laughing:
+ [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)
  + 解法1：[模拟](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_29/Solution.java)：思路不难，实现较复杂。:no_entry:
+ [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)
  + 解法1：[双栈法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_30/Solution.java)：一个保存正常顺序，一保存递减顺序。:laughing:
+ [剑指 Offer 31. 栈的压入、弹出序列](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)
  + 解法1：[模拟](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_30/Solution.java)：使用栈模拟。:worried:
+ [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)
  + 解法1：[辅助队列](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_32_i/Solution.java)：利用辅助队列记录层序遍历的结果:worried:
+ [剑指 Offer 32 - II. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)
  + 解法1：[辅助队列](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_32_ii/Solution.java)：利用辅助队列记录，主要多了不同层的判断（利用queue.size记录）:worried:
  + 解法2：[递归法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_32_ii/Solution1.java)：利用递归辅助函数，每一层添加index，记录不同层的遍历。:worried:
+ [剑指 Offer 32 - III. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)
  + 解法1：[双向队列+奇偶分离](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_32_iii/Solution.java)：偶数正向添加，先放左节点，后放右节点；奇数反向添加，先放右节点，再放左节点。:worried:
  + 解法2：[数组反转+奇偶分离](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_32_iii/Solution1.java)：偶数不反转，奇数反转。:worried:
+ [剑指 Offer 33. 二叉搜索树的后序](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)
  + 解法1：[后序遍历定义](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_33/Solution.java)：|左子树|右子树|当前根| >>> |<当前根|>当前根|当前根|。:no_entry:
+ [剑指 Offer 34. 二叉树中和为某个值](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
  + 解法1：[辅助栈+回溯](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_34/Solution.java)：辅助栈记录到叶子节点路径，每次访问节点入栈，访问完节点回溯出栈。:no_entry:
+ [剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)
  + 解法1：[辅助Map+2轮遍历](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_35/Solution.java)：辅助Map记录oldNode到newNode的节点:worried:
  + 解法2：[拼接拆分+3轮遍历](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_35/Solution1.java)：第一轮复制，第二轮更新random，第三轮分离:no_entry:
+ [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)
  + 解法1：[全局变量+中序遍历法](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_36/Solution.java)：全局变量prev、head，中序遍历转换为链表:no_entry:

+ [剑指 Offer 37. 序列化二叉树](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/)
  + 解法1：[层序遍历](https://github.com/Tobingindex/java-code/blob/master/jianzhi-offer/src/main/java/top/tobing/jz_37/Solution.java)：层序遍历添加额外逻辑。:no_entry:















