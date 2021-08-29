package top.tobing.algorithm.back_track;


/**
 * @author tobing
 * @date 2021/8/28 17:08
 * @description 回溯算法典型示例-八皇后问题
 */
public class Demo {

    /**
     * 下标表示行，值表示queen储存在那一列
     */
    int[] result = new int[8];

    /**
     * 计算8皇后
     */
    public void cal8queue(int row) {
        // 如果8个棋子都放置好，打印结果，并返回
        if (row == 8) {
            printQueens(result);
            return;
        }
        // 对于每一行有8种放法
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queue(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.cal8queue(0);
    }
}
