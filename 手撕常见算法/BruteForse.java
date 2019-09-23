package algorithm;

public class BruteForse {
    public static void main(String[] args){
        String s = "ababcabcacbabfjabaabcacfj";
//        String t = "ba";
//        String t = "abca";
//        String t = "aa";
//        String t = "bab";
//        String t = "abab";
        //测试暴力匹配
//        int res = new BruteForse().indexBF(s, t, 0);
//        System.out.println(res);

        //测试KMP
//        String t = "abaabc";
        String t = "abaabcac";
//        String t = "aaaaab";
//        String t = "asd";
//        int res = new BruteForse().indexKMP(s, t, 0);
//        System.out.println(res);
    }
    
    /**
     * 子串的定位运算通常称为串的模式匹配或者串匹配
     * 下面这个是暴力求解，可以指定从字符串的任意位置开始匹配
     * @param s
     * @param t
     * @param pos
     * @return
     */
    int indexBF(String s, String t, int pos) {
        //指定位置
        int i = pos;
        //从第一个位置开始匹配
        int j = 0;
        while (i < s.length() && j < t.length()) {
            //没有到末尾就继续匹配
            if (s.charAt(i) == t.charAt(j)) {
                //相等，继续向下比较
                ++i;
                ++j;
            } else {
                //i回退
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == t.length()) {
            return i - t.length();
        } else {
            //假设-1是匹配失败
            return -1;
        } 
    }

    /**
     * 用KMP求最大字串，主要是有一些会出现重复匹配，那么直接跳过，从这些匹配的后面开始匹配
     * @param s
     * @param t
     * @param pos
     * @return
     */
    int indexKMP(String s, String t, int pos) {
        //存储失败后应当回退到哪里
        int[] next = new int[t.length()];
        getNext(t, next);

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                //可以匹配，毫无疑问下一个
                i++;
                j++;
            } else {
                //不相等，开始跳
                if (next[j] == -1) {
                    j = 0;
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        if (j == t.length()) {
            //匹配成功
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 我用的是-1表示字符串后移一个位置，从匹配串的0位置开始
     * 如果是其他数字，那么从那个位置开始，并且字符串不后移
     * @param t
     * @param next
     */
    void getNext(String t, int[] next) {
        //初始化，为了后面判断是否已经修改过了
        for (int i = 0; i < next.length; i++) {
            next[i] = -2;
        }
        //-1表示从头开始匹配，并且字符串后移一个
        next[0] = -1;
        int i = 1;
        int j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == t.charAt(j)) {
                if (next[i] == -2) {
                    next[i] = next[j];
                }
                ++i;
                ++j;
            } else {
                //先看下有没有修改过了
                if (next[i] == -2) {
                    //没有修改才修改
                    next[i] = j;
                }
                if (j == 0) {
                    i++;
                } else {
                    //置回j=0
                    j = 0;
                }
            }
        }
    }
}
