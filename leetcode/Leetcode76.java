//leetcode76题，滑动窗口
public class Leetcode76 {
    public static void main(String[] args){
        Main main = new Main();
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        String s = "aaflslflsldkalskaaa";
//        String t = "aaa";
//        String s = "acbbaca";
//        String t = "aba";
        String s = "bba";
        String t = "ba";
        String res = main.minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        if (t == null || "".equals(t) || t.length() > s.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        //map存储需要匹配的字符串
        HashMap<String, Integer> tt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tt.containsKey(String.valueOf(t.charAt(i)))) {
                tt.replace(String.valueOf(t.charAt(i)), tt.get(String.valueOf(t.charAt(i))) + 1);
                continue;
            }
            tt.put(String.valueOf(t.charAt(i)), 1);
        }
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        int len = s.length() + 1;
        for (int r = 0, l = 0; r < s.length(); r++) {
            //遍历确定left
            if (count == 0) {
                for (; l < s.length(); l++) {
                    if (tt.containsKey(String.valueOf(s.charAt(l)))) {
                        break;
                    }
                }
            }
            //计数，看看匹配了几个
            if (tt.containsKey(String.valueOf(s.charAt(r)))) {
                tt.put(String.valueOf(s.charAt(r)), tt.get(String.valueOf(s.charAt(r))) - 1);
                if (tt.get(String.valueOf(s.charAt(r))) >= 0) {
                    count++;
                }
            }
            if (count == t.length()) {
                //看看最左边可不可以去掉，小于0说明可以去掉
                while (tt.containsKey(String.valueOf(s.charAt(l))) &&
                        tt.get(String.valueOf(s.charAt(l))) < 0) {
                    tt.put(String.valueOf(s.charAt(l)), tt.get(String.valueOf(s.charAt(l))) + 1);
                    //重新确定left
                    l++;
                    for (; l <= s.length() - t.length(); l++) {
                        if (tt.containsKey(String.valueOf(s.charAt(l)))) {
                            break;
                        }
                    }
                }
                //完全包含
                if (count == t.length() && len >= r - l + 1) {
                    left = l;
                    right = r;
                    len = r - l + 1;
                }
                //将最前面那个加回去
                tt.put(String.valueOf(s.charAt(l)), tt.get(String.valueOf(s.charAt(l))) + 1);
                if (tt.get(String.valueOf(s.charAt(l))) > 0) {
                    count--;
                }
                //重新确定left
                l++;
                for (; l <= s.length() - t.length(); l++) {
                    if (tt.containsKey(String.valueOf(s.charAt(l)))) {
                        break;
                    }
                }
            }
        }
        return len == s.length() + 1 ? "" : s.substring(left, right + 1);
    }
}