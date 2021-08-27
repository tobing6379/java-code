package top.tobing.jz_20;

import java.util.Arrays;

/**
 * @author tobing
 * @date 2021/8/27 10:01
 * @description 剑指 Offer 20. 表示数值的字符串
 */
public class Solution {
    /**
     * 【暴力匹配法】
     * 1、非空字符串
     * 2、取出空格
     * 3、包含e或E
     * 3.1）、判断e或E唯一性
     * 3.2）、将字符根据e/E分为两部分，第一部分可以是整数或浮点数，第二部分必须是整数（科学记数法的定义）
     * 3.3）、无论是整数还是小数，都将其正负号去除
     * 3.4）、对于整数，判断其整数部分是否为数字序列（0~9）
     * 3.5）、对于小数，首先判断小数点是否唯一，之后根据小数点「.」将数据分为两部分，前后分配判断是否为数字序列
     * 4、不包含e或E：按照3.3之后处理
     */
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim().toLowerCase();

        if (s.contains("e")) {
            // 科学计数法
            return isScientific(s);
        } else {
            // 普通表示法
            return isInteger(s) || isFloat(s);
        }
    }

    /**
     * 判断字符串是否为整数
     * 1）一个符号字符（'+' 或 '-'）【可选】
     * 2）全部字符在0~9之间
     */
    private boolean isInteger(String number) {
        if (number == null || number.length() == 0) {
            return false;
        }
        if (number.charAt(0) == '+' || number.charAt(0) == '-') {
            return isNumber(number, 1, number.length() - 1);
        } else {
            return isNumber(number, 0, number.length() - 1);
        }
    }

    /**
     * 判断字符串是否为小数
     * 1）一个符号字符（'+' 或 '-'）【可选】
     * 2.1）至少一位数字，后面跟着一个点 '.'
     * 2.2）至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     * 2.3）一个点 '.' ，后面跟着至少一位数字
     */
    private boolean isFloat(String number) {
        if (number == null || number.length() == 0) {
            return false;
        }
        if (number.charAt(0) == '+' || number.charAt(0) == '-') {
            number = number.replace("+", "").replace("-", "");
        }
        if (!number.contains(".")) {
            return false;
        }
        if (!isOnlyOne(number, ".")) {
            return false;
        }
        String[] numbers = number.split("\\.");
        if (numbers.length == 1) {
            return isNumber(number, 0, number.length() - 2);
        }
        if (numbers.length != 2) {
            return false;
        }
        return (numbers[0].length() == 0 || isNumber(numbers[0], 0, numbers[0].length() - 1))
                && (numbers[1].length() == 0 || isNumber(numbers[1], 0, numbers[1].length() - 1));
    }

    /**
     * 判断字符串number[start, end]是否符合数值串
     */
    private boolean isNumber(String number, int start, int end) {
        if (number == null || end < start) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断ch在str中出现的次数是否仅有一次
     */
    private boolean isOnlyOne(String str, String ch) {
        return str.indexOf(ch) == str.lastIndexOf(ch);
    }

    /**
     * 判断是否为科学记数法
     */
    private boolean isScientific(String number) {
        if (!isOnlyOne(number, "e")) {
            return false;
        }
        String[] numbers = number.split("e");
        if (numbers.length != 2) {
            return false;
        }
        return isInteger(numbers[1]) && (isFloat(numbers[0]) || isInteger(numbers[0]));
    }

    public static void main(String[] args) {
        String[] trueList = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123", "  .2 ", "3.  "};
        String[] falseList = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4", "0..", ".2.", "1.2.", ".1.2"};
        Solution solution = new Solution();
        StringBuilder res = new StringBuilder();
        res.append("===========> trueList\n");
        for (String s : trueList) {
            res.append(s);
            res.append(":\t\t");
            res.append(solution.isNumber(s));
            res.append("\n");
        }
        res.append("===========> falseList\n");
        for (String s : falseList) {
            res.append(s);
            res.append(":\t\t");
            res.append(solution.isNumber(s));
            res.append("\n");
        }
        res.append("===========> String#split(String)特殊情况\n");
        String[] special = new String[]{".1", "1.", ".1.1", "1.1.", "1.1"};
        for (String s : special) {
            res.append(s);
            res.append("\t\t");
            String[] strings = s.split("\\.");
            res.append(Arrays.toString(strings));
            res.append("\t\tlength:");
            res.append(strings.length);
            res.append("\n");
        }
        System.out.println(res.toString());
    }

}
