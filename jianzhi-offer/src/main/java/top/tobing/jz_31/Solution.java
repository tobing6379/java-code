package top.tobing.jz_31;

import java.util.Stack;

/**
 * @author tobing
 * @date 2021/8/30 10:14
 * @description 剑指 Offer 31. 栈的压入、弹出序列
 */
public class Solution {
    /**
     * 模拟
     * 第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[popIdx]) {
                // 如果栈顶元素与当前出栈元素一致，无需添加到stack，跳过该元素（相当于一次出栈）
                popIdx++;
                // 由于上面相当于是一次出栈操作，
                while (!stack.isEmpty() && popIdx < popped.length && stack.peek().equals(popped[popIdx])) {
                    stack.pop();
                    popIdx++;
                }
            } else {
                stack.push(pushed[i]);
            }
        }
        while (!stack.isEmpty()) {
            Integer tmp = stack.pop();
            if (!tmp.equals(popped[popIdx++])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 模拟简洁版
     */
    public boolean validateStackSequencesSimply(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIdx = 0;
        for (int element : pushed) {
            // 每次添加元素，判断栈顶元素是否可以出栈
            stack.push(element);
            while (!stack.isEmpty() && stack.peek().equals(popped[popIdx])) {
                stack.pop();
                popIdx++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] push = {1, 0, 3, 2};
        int[] pop = {0, 1, 2, 3};
        boolean res = solution.validateStackSequences(push, pop);
        System.out.println(res);
    }
}
