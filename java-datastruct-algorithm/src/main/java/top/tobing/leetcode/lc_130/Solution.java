package top.tobing.leetcode.lc_130;

import top.tobing.datastruct.linear.array.Array;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/9/19 11:50
 * @description 130. 被围绕的区域
 */
public class Solution {


    /**
     * 类似于往一个池子边上里倒水，边界假想使用#围上
     * *, #, #, #, #, #, #, *
     * #, O, O, O, O, X, X, #
     * #, O, O, O, O, O, O, #
     * #, O, X, O, X, O, O, #
     * #, O, X, O, O, X, O, #
     * #, O, X, O, X, O, O, #
     * #, O, X, O, O, O, O, #
     * *, #, #, #, #, #, #, *
     * 从边界开始到时，遇到X或#，则表示遇到了壁垒，可以返回
     * 遍历得到的地方使用#表示已经被水漫延
     * 最终剩下的地方就是被X包围的地方
     */
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int rowLen = board.length;
        if (rowLen == 0) {
            return;
        }
        int colLen = board[0].length;
        if (colLen == 0) {
            return;
        }

        // 从边界开始寻找可以被水漫延的节点
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (isEdge(board, i, j) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // 漫延之后，与边界连接的O都会被替换为#，剩下的O都被X包围
        // 只需将O更改为X，将#更改为O即可
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 判断节点是否为边界节点
     */
    private boolean isEdge(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }

    /**
     * 将问题转换为「寻找和边界联通的O」
     */
    private void dfs(char[][] board, int i, int j) {
        // 边界之外的接单直接返回【遇到壁垒，假想边界就是壁垒】
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        // 遇到X或#直接返回【遇到壁垒】
        if (board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        // 遍历得到的，将其置为#
        board[i][j] = '#';
        // 尝试向上下左右漫延
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] test1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

        char[][] test2 = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'},
        };
        char[][] test3 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        for (char[] chars : test3) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println();
        solution.solve(test3);
        for (char[] chars : test3) {
            System.out.println(Arrays.toString(chars));
        }
    }


}
