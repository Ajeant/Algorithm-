package algorithm;

/**
 * 判断后序遍历序列是否是某二叉搜索树的后序遍历
 */
public class VerifySquenceOfBST {
    public static void main(String[] args){
        int[] sequence = {7, 11, 10, 30, 60, 50, 20};
        System.out.println(verifySquenceOfBST(sequence));
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public static boolean verify(int[] sequence, int l, int r) {
        if (r < l) {
            return true;
        }
        //由于后序遍历为左右根，最后一个必定为根节点，根节点将数组分成两部分，小的为左子树，大的为右子树
        int rootVal = sequence[r];
        //假定分界为开始位置
        int cutIndex = l;
        while (cutIndex < r && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        for (int i = cutIndex; i < r; i++) {
            //右子树小于根节点直接返回false
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return verify(sequence, l, cutIndex - 1) && verify(sequence, cutIndex, r - 1);
    }
}
