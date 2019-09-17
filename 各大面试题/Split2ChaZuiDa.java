package algorithm;

import java.util.Arrays;
import java.util.Scanner;

//100%
public class Split2ChaZuiDa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //输入N个元素，数组中的N个数字，分组，求相差最小
        int N = sc.nextInt();
        int[] Ns = new int[N];
        for (int i = 0; i < N; i++) {
            Ns[i] = sc.nextInt();
        }
        Arrays.sort(Ns);
        //求和
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Ns[i];
        }
        int sum2 = sum / 2;
        //求出最接近sum的1/2
        int temp = 0;
        int cha = 0;
        for (int i = N - 1; i>= 0; i--) {
            temp += Ns[i];
            cha = sum - 2 * temp;
            if (temp == sum2 && sum % 2 == 0) {
                System.out.println(0);
                return;
            } else if (temp == sum2) {
                System.out.println(1);
                return;
            } else if (temp > sum2) {
                temp -= Ns[i];
                if (cha > sum - 2 * temp)
                    cha = sum - 2 * temp;
            }
        }
        System.out.println(cha);
    }
}
