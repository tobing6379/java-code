package top.tobing.jz_12;

import java.util.*;

/**
 * @Author tobing
 * @Date 2021/8/5 8:50
 * @Description 剑指 Offer 12. 矩阵中的路径
 */
public class Solution {
    /**
     * 定义一个节点类，用于去重
     */
    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 用于判断元素是否重复使用
     */
    private Set<Node> set = new HashSet<>();

    /**
     * 辅助Set
     */
    public boolean exist(char[][] board, String word) {
        // 遍历判断每一个点，以该点为起点的元素是否符合条件
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]
                        && (exist(board, word, i, j, 0, -1))) {
                    return true;
                }
                set.clear();
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
        if (set.contains(new Node(x, y))) {
            return false;
        }
        // 最后一位元素
        if (board[x][y] == word.charAt(index) && index == word.length() - 1) {
            return true;
        }
        boolean isSuccess = false;
        if (board[x][y] == word.charAt(index)) {
            set.add(new Node(x, y));
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
                set.remove(new Node(x, y));
            }
        }
        return isSuccess;
    }

    public static void main(String[] args) {
        boolean res = new Solution().exist(new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        }, "aaaaaaaaaaaaa");
        System.out.println(res);
    }
}
