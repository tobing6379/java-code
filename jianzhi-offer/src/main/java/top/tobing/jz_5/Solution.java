package top.tobing.jz_5;

/**
 * @Author tobing
 * @Date 2021/8/2 10:56
 * @Description 剑指 Offer 05. 替换空格
 */
public class Solution {
    public String replaceSpace(String s) {
        // 特殊情况处理
        if (s == null || s.length() == 0) {
            return s;
        }
        // 使用StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            stringBuilder.append(temp == ' ' ? "%20" : temp);
        }

        return stringBuilder.toString();
    }
}
