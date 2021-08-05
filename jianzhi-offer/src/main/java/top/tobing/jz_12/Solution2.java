package top.tobing.jz_12;

/**
 * @Author tobing
 * @Date 2021/8/5 8:50
 * @Description 剑指 Offer 12. 矩阵中的路径
 */
public class Solution2 {


    /**
     * dfs
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 对board进行dfs，将符合word序列的元素进行标记
     */
    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        // 将走过的路进行标记
        board[x][y] = '\0';
        boolean isSuccess = dfs(board, word, x - 1, y, index + 1)
                || dfs(board, word, x, y - 1, index + 1)
                || dfs(board, word, x + 1, y, index + 1)
                || dfs(board, word, x, y + 1, index + 1);

        // 还原标记
        board[x][y] = word.charAt(index);
        return isSuccess;
    }


    public static void main(String[] args) {
        boolean res = new Solution2().exist(new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}
        }, "aaaaaaaaaaaaa");
        System.out.println(res);
    }


}
