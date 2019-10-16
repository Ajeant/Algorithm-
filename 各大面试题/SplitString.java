package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    //MPMPCPMCMDEFEGDEHINHKLIN
    //输出9 7 8
    //将上面字符串分隔，使得一个字母只出现在一个分组，并且希望分组尽可能多
    //如上面的MPMPCPMCM   DEFEGDE   HINHKLIN
    //虽然MPMPCPMCMDEFEGDE   HINHKLIN也可以，但是不是尽可能多，所以不符合条件
    //思路：动态规划
    //将相同的用1表示
    //将1进行分块，每一块则是一个分组，具体看代码吧 QAQ 表达不出来
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = 1;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int temp = 0;
        //从dp中找等于1的块
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (dp[i][j] == 1) {
                    temp = j;
                }
            }
            //上面为假设第一个出现的字母刚好在起始和结束
            for (int j = i + 1; j < temp; j++) {
                //从下一行到temp减一
                for (int k = temp + 1; k < chars.length; k++) {
                    if (dp[j][k] == 1) {
                        //temp必须往后
                        temp = k;
                    }
                }
            }
            res.add(temp);
            //i从temp+1继续
            i = temp;
        }
//        System.out.println(res);
        for (int i = 0; i < res.size(); i++) {
            if (i == 0) {
                System.out.print((res.get(i) + 1) + " ");
            }else if (i == res.size() - 1) {
                System.out.print(res.get(i) - res.get(i - 1));
            } else {
                System.out.print((res.get(i) - res.get(i - 1)) + " ");
            }
        }
    }
}
