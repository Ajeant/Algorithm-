package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

//100%
public class TelephoneCompose {
    //输入1-9的字符串
    char[][] c = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        //输入的数字
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            number.add(input.charAt(i) - '0');
        }
        //结果
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        new TelephoneCompose().aa(sb, number, 0, number.size(), res);
        System.out.println(res);
    }
    
    void aa (StringBuilder sb, ArrayList<Integer> number, int j, 
             int length, ArrayList<String> res) {
        for (int i = 0; i < c[number.get(j) - 2].length; i++) {
            sb.append(c[number.get(j) - 2][i]);
            j++;
            if (j < length) {
                aa(sb, number, j, length, res);
            }
            if (sb.length() == length)
                res.add(sb.toString());
            j--;
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
