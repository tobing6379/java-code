package top.tobing.jz_12;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author tobing
 * @Date 2021/8/5 8:50
 * @Description 剑指 Offer 12. 矩阵中的路径
 */
public class Solution1 {


    /*
     * 辅助矩阵
     */
    private boolean[][] map;


    /**
     * 辅助Set
     */
    public boolean exist(char[][] board, String word) {
        map = new boolean[board.length][board[0].length];
        // 遍历判断每一个点，以该点为起点的元素是否符合条件
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]
                        && (exist(board, word, i, j, 0, -1))) {
                    return true;
                }
                clear(map);
            }
        }
        return false;
    }

    /**
     * 判断 word 0~index字符是否存在于board中
     * state=0; 上 ↑
     * state=1; 右 →
     * state=2; 下 ↓
     * state=3; 左 ←
     * 向上：x-1,y
     * 向右：x,y+1
     * 向下：x+1,y
     * 向左：x,y-1
     */
    private boolean exist(char[][] board, String word, int x, int y, int index, int state) {
        // 边界条件判断
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        // 是否已经存在过
        if (map[x][y]) {
            return false;
        }
        // 最后一位元素
        if (board[x][y] == word.charAt(index) && index == word.length() - 1) {
            return true;
        }
        boolean isSuccess = false;
        if (board[x][y] == word.charAt(index)) {
            map[x][y] = true;
            switch (state) {
                case 0: {
                    isSuccess = exist(board, word, x - 1, y, index + 1, 0)
                            || exist(board, word, x, y + 1, index + 1, 1)
                            || exist(board, word, x, y - 1, index + 1, 3);
                    break;
                }
                case 1: {
                    isSuccess = exist(board, word, x - 1, y, index + 1, 0)
                            || exist(board, word, x, y + 1, index + 1, 1)
                            || exist(board, word, x + 1, y, index + 1, 2);
                    break;
                }
                case 2: {
                    isSuccess = exist(board, word, x, y + 1, index + 1, 1)
                            || exist(board, word, x + 1, y, index + 1, 2)
                            || exist(board, word, x, y - 1, index + 1, 3);
                    break;
                }
                case 3: {
                    isSuccess = exist(board, word, x - 1, y, index + 1, 0)
                            || exist(board, word, x + 1, y, index + 1, 2)
                            || exist(board, word, x, y - 1, index + 1, 3);
                    break;
                }
                default: {
                    isSuccess = exist(board, word, x - 1, y, index + 1, 0)
                            || exist(board, word, x, y + 1, index + 1, 1)
                            || exist(board, word, x + 1, y, index + 1, 2)
                            || exist(board, word, x, y - 1, index + 1, 3);
                }
            }
            if (!isSuccess) {
                map[x][y] = false;
            }
        }
        return isSuccess;
    }

    private void clear(boolean[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[0].length; i1++) {
                map[i][i1] = false;
            }
        }
    }

    public static void main(String[] args) {
        boolean res = new Solution1().exist(new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        }, "aaaaaaaaaaaaa");
        System.out.println(res);
    }


}
