package algorithm;

import java.util.ArrayDeque;
import java.util.HashMap;

public class BinaryTraversal {
    public static void main(String[] args) {
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
//        LRD(binTree);
//        LDR2(binTree);
//        BinTree newTree = new BinTree();
//        newTree.data = 1;
//        //test add node
//        BinTree add1 = new BinTree();
//        add1.data = 2;
//        newTree.left = add1;
//        LDR2(newTree);
//        BinTree newTree = copyTree(binTree);
//        LDR2(newTree);
        int depth = depth(binTree);
        System.out.println(depth);
        System.out.println("下面测试根据前序中序构建二叉树");
        int[] dlr = {3, 9, 20, 15, 7};
        int[] ldr = {9, 3, 15, 20, 7};
        BinTree tree = reconstruct(dlr, ldr);
        DLR(tree);
        System.out.println("=============");
        LDR(tree);
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

    //中序遍历非递归
    public static void LDR2(BinTree tree) {
        //用一个临时指针移动树
        BinTree temp = tree;
        ArrayDeque<BinTree> binTrees = new ArrayDeque<>();
        while (temp != null || !binTrees.isEmpty()) {
            if (temp != null) {
                //入栈
                binTrees.addFirst(temp);
                //遍历左节点
                temp = temp.left;
            } else {
                //没有节点了，打印当前节点，并出栈
                BinTree binTree = binTrees.removeFirst();
                System.out.println(binTree.data);
                //将temp置为栈顶元素的右子树
                temp = binTree.right;
            }
        }
    }

    //复制二叉树
    public static BinTree copyTree(BinTree oldTree) {
        if (oldTree == null) {
            return null;
        } else {
            //将此节点复制
            BinTree newTree = new BinTree();
            newTree.data = oldTree.data;
            //递归复制左右子树
            newTree.left = copyTree(oldTree.left);
            newTree.right = copyTree(oldTree.right);
            return newTree;
        }
    }

    /**
     * 这样运行结果不对
     * @param newTree
     * @param oldTree
     */
    public static void copyTree(BinTree newTree, BinTree oldTree) {
        if (oldTree == null) {
            newTree = null;
        } else {
            //将此节点复制
            newTree = new BinTree();
            newTree.data = oldTree.data;
            //递归复制左右子树
            copyTree(newTree.left, oldTree.left);
            copyTree(newTree.right, oldTree.right);
        }
    }

    //计算二叉树的深度
    public static int depth(BinTree tree) {
        if (tree == null) {
            return 0;
        } else {
            return (depth(tree.left) > depth(tree.right) ?
                    depth(tree.left) : depth(tree.right)) + 1;
        }
    }

    //根据二叉树的前序和中序构建二叉树
    //由于indexDlr用一次就要加一，将其设为静态
    public static int indexDlr = 0;
    public static BinTree reconstruct(int[] dlr, int[] ldr) {
        HashMap<Integer, Integer> indexForLdrOrders = new HashMap<>();
        for (int i = 0; i < ldr.length; i++) {
            //将中序遍历的结果存储到map，等下可以直接找到位置
            indexForLdrOrders.put(ldr[i], i);
        }
        return reconstructBinTree(dlr, 0, dlr.length - 1, indexForLdrOrders);
    }
    public static BinTree reconstructBinTree(int[] dlr, int ldrL, int ldrR,
                                             HashMap<Integer, Integer> indexForLdrOrders) {
        if (ldrL > ldrR) {
            //根节点没分出左右两部分，说明出现了null节点
            return null;
        }
        //将下面的代码抽取
//        HashMap<Integer, Integer> indexForLdrOrders = new HashMap<>();
//        for (int i = 0; i < ldr.length; i++) {
//            //将中序遍历的结果存储到map，等下可以直接找到位置
//            indexForLdrOrders.put(ldr[i], i);
//        }
        BinTree tree = new BinTree();
        //前序遍历开头必定是根节点
        tree.data = dlr[indexDlr++];
        //中序遍历中这个根节点恰好将他们分成两半
        tree.left = reconstructBinTree(dlr, ldrL, indexForLdrOrders.get(tree.data) - 1,
                indexForLdrOrders);
        tree.right = reconstructBinTree(dlr, indexForLdrOrders.get(tree.data) + 1, ldrR,
                indexForLdrOrders);
        return tree;
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

    //下面是为了实现复制算法添加的代码
    //还有根据二叉树的前序和中序构建二叉树
    public BinTree() {
    }
}
