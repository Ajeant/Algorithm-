public class NBinaryYiHuoK {
    /**
     * 输入两个整数N，K，N表示二进制数有N为，如5 2表示二进制数有5位，00100，K表示异或K次
     * 输入字符串s，N+K-1长度，可以由上面的K进制数异或K次，表示
     *                   00100
     *                    00100
     *                   001100
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //两个整数N,K
        int N = in.nextInt();
        int K = in.nextInt();
        //二进制字符串N+K-1
        //在此之前先将回车读取
        in.nextLine();
        String s = in.nextLine();
        //很容易知道应该从后往前推导
//        int temp = (int)(s.charAt(s.length() - 1) - '0');
//        System.out.println(temp);
        //后K位的逆序，因为这K位容易求出，每一位都可以根据后一位得出，
        // 如发现后面是1，这位是0，那么对应的K位二进制就是1
        StringBuffer res = new StringBuffer();
        for (int i = s.length() - 1; i >= s.length() - K; i--) {
            if (i == s.length() - 1) {
                //最后一个，不管，直接加进来
                res.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '0') {
                //跟前一个相同，因为同为0异为1嘛
                res.append(s.charAt(i + 1));
            } else {
                //跟前一个不同
                if (s.charAt(i + 1) == '0') {
                    res.append('1');
                } else {
                    res.append('0');
                }
            }
        }
//        System.out.println(res.reverse().toString());
        //此时需要与前面得出的值配合
        int j = 0;
        //从倒数K-1位开始
        for (int i = s.length() - K - 1; i > K - 2; i--) {
            if (s.charAt(i) == '0') {
                //根据前面求出来的，逆向求出减少一位，之后步骤同上，
                //比如从上到下为010（倒数第四列），我们可以知道01求出来的值，要求第三列的0
                //01可以从倒数第二列的001，与上面的sb配合求出
                //然后01和下面的s求出第三列的值
                //00100
                // 00100
                //  00100
                //0011100
                if (res.charAt(j) == '0' && s.charAt(i + 1) == '0') {
                    res.append('0');
                } else if (res.charAt(j) == '0' && s.charAt(i + 1) == '1') {
                    res.append('1');
                } else if (res.charAt(j) == '1' && s.charAt(i + 1) == '0') {
                    res.append('1');
                } else if (res.charAt(j) == '1' && s.charAt(i + 1) == '1') {
                    res.append('0');
                }
            } else if (s.charAt(i) == '1') {
                if (res.charAt(j) == '0' && s.charAt(i + 1) == '0') {
                    res.append('1');
                } else if (res.charAt(j) == '0' && s.charAt(i + 1) == '1') {
                    res.append('0');
                } else if (res.charAt(j) == '1' && s.charAt(i + 1) == '0') {
                    res.append('0');
                } else if (res.charAt(j) == '1' && s.charAt(i + 1) == '1') {
                    res.append('1');
                }
            }
            j++;
        }

        System.out.println(res.reverse().toString());
    }
}