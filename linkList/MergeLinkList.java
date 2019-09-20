package algorithm.linkList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MergeLinkList {
    public static void main(String[] args){
        int[] data1 = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            data1[i] = random.nextInt(100) + 1;
        }
        Arrays.sort(data1);
        LinkList linkList1 = MethodOfLinkList.createLinkListByHead(data1);
        System.out.print("链表1为:");
        MethodOfLinkList.traverse(linkList1);
        System.out.println();
        int[] data2 = new int[10];
        for (int i = 0; i < 10; i++) {
            data2[i] = random.nextInt(100) + 1;
        }
        Arrays.sort(data2);
        LinkList linkList2 = MethodOfLinkList.createLinkListByHead(data2);
        System.out.print("链表2为:");
        MethodOfLinkList.traverse(linkList2);
        System.out.println();
        LinkList linkList3 = new MergeLinkList().mergeList(linkList1, linkList2);
        System.out.print("合并后链表为:");
        MethodOfLinkList.traverse(linkList3);
        System.out.println();
    }

    LinkList mergeList(LinkList a, LinkList b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        //到时将a返回
        //将b中的值插入到a中
        LinkList res = a;
        while (a.data < b.data) {
            //将b中数据大的前插到a中
            LinkList node = new LinkList(b.data);
            node.next = a;
            a = node;
            res = a;
            //b后移
            b = b.next;
        }
        while (a.next != null && b != null) {
            if (a.next.data >= b.data) {
                //a向后移动
                a = a.next;
            } else {
                //将b的节点插入到a节点的前面
                LinkList node = new LinkList(b.data);
                node.next = a.next;
                a.next = node;
                //b往后移动
                b = b.next;
            }
        }
        if (b != null) {
            a.next = b;
        }
        return res;
    }
}
