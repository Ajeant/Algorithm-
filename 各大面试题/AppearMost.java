public class AppearMost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入一个字符串
        String s = sc.nextLine();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a[0]++;
            } else if (s.charAt(i) == 'b') {
                a[1]++;
            } else if (s.charAt(i) == 'c') {
                a[2]++;
            } else if (s.charAt(i) == 'd') {
                a[3]++;
            } else if (s.charAt(i) == 'e') {
                a[4]++;
            } else if (s.charAt(i) == 'f') {
                a[5]++;
            } else if (s.charAt(i) == 'g') {
                a[6]++;
            } else if (s.charAt(i) == 'h') {
                a[7]++;
            } else if (s.charAt(i) == 'i') {
                a[8]++;
            } else if (s.charAt(i) == 'j') {
                a[9]++;
            } else if (s.charAt(i) == 'k') {
                a[10]++;
            } else if (s.charAt(i) == 'l') {
                a[11]++;
            } else if (s.charAt(i) == 'm') {
                a[12]++;
            } else if (s.charAt(i) == 'n') {
                a[13]++;
            } else if (s.charAt(i) == 'o') {
                a[14]++;
            } else if (s.charAt(i) == 'p') {
                a[15]++;
            } else if (s.charAt(i) == 'q') {
                a[16]++;
            } else if (s.charAt(i) == 'r') {
                a[17]++;
            } else if (s.charAt(i) == 's') {
                a[18]++;
            } else if (s.charAt(i) == 't') {
                a[19]++;
            } else if (s.charAt(i) == 'u') {
                a[20]++;
            } else if (s.charAt(i) == 'v') {
                a[21]++;
            } else if (s.charAt(i) == 'w') {
                a[22]++;
            } else if (s.charAt(i) == 'x') {
                a[23]++;
            } else if (s.charAt(i) == 'y') {
                a[24]++;
            } else if (s.charAt(i) == 'z') {
                a[25]++;
            }
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
    }
}