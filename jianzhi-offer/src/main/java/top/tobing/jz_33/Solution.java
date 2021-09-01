package top.tobing.jz_33;

/**
 * @author tobing
 * @date 2021/9/1 10:58
 * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class Solution {

    /**
     * 递归+二叉搜索树后序遍历定义
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return rec(postorder, 0, postorder.length - 1);
    }


    /**
     * |左子树|右子树|根节点| >>>>> |<根节点|>根节点|根节点|
     */
    private boolean rec(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }

        // 根节点
        int rootVal = arr[right];
        // 左子树
        int lr = left;
        while (arr[lr] < rootVal) {
            lr++;
        }
        // 右子树
        int rr = lr;
        while (arr[rr] > rootVal) {
            rr++;
        }
        // 当前状态是否符合左右子树定义，符合则递归其左右子树
        return rr == right && rec(arr, left, lr - 1) && rec(arr, lr, right - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 6, 3, 2, 5};
        System.out.println(solution.verifyPostorder(test));
    }

}
