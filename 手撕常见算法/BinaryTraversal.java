package algorithm;

import java.util.ArrayDeque;

public class BinaryTraversal {
    public static void main(String[] args){
        BinTree binTree = new BinTree(1,
                new BinTree(2,
                        new BinTree(4, null, null),
                        new BinTree(5, null, null)),
                new BinTree(3,
                        new BinTree(6, null, null),
                        new BinTree(7, null, null)));
//        BFSOrder(binTree);
//        DLR(binTree);
//        LDR(binTree);
        LRD(binTree);
    }

    //层次遍历
    public static void BFSOrder(BinTree tree) {
        if (tree == null) {
            return;
        }
        ArrayDeque<BinTree> binTrees = new ArrayDeque<>();
        binTrees.add(tree);
        while (!binTrees.isEmpty()) {
            //获取当前节点
            tree = binTrees.poll();
            //打印
            System.out.println(tree.data);
            //左右节点先入队，稍后打印
            if (tree.left != null) {
                binTrees.add(tree.left);
            }
            if (tree.right != null) {
                binTrees.add(tree.right);
            }
        }
    }

    //前序遍历 degree left right
    public static void DLR(BinTree tree) {
        System.out.println(tree.data);
        if (tree.left != null) {
            DLR(tree.left);
        }
        if (tree.right != null) {
            DLR(tree.right);
        }
    }

    //中序遍历 degree left right
    public static void LDR(BinTree tree) {
        if (tree.left != null) {
            LDR(tree.left);
        }
        System.out.println(tree.data);
        if (tree.right != null) {
            LDR(tree.right);
        }
    }

    //后序遍历 degree left right
    public static void LRD(BinTree tree) {
        if (tree.left != null) {
            LRD(tree.left);
        }
        if (tree.right != null) {
            LRD(tree.right);
        }
        System.out.println(tree.data);
    }
}

class BinTree {
    public int data;
    public BinTree left;
    public BinTree right;

    public BinTree(int data, BinTree left, BinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
