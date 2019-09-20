package algorithm.linkList;

public class MethodOfLinkList {

    public static void main(String[] args){
//        LinkList linkList = new LinkList(1, new LinkList(2, new LinkList(3,
//                new LinkList(4, new LinkList(5, null)))));
//        System.out.println(getElement(linkList, 2));
//        traverse(linkList);
//        traverse(getBeforeLinkListByElem(linkList, 3));
//        traverse(getAfterLinkListByElem(linkList, 3));
//        traverse(linkList);

//        String a = "ab";
//        String bb = "b";
//        String b = "a" + bb;
//        String c = "a" + "b";
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(b == c);
//        System.out.println('0' - '0' == 0);
//        System.out.println('2' - '0');
        int[] data = {1, 2, 3, 4, 5, 6};
//        int[] data = {1};
        //测试尾插法
        LinkList linkList = createLinkListByTail(data);
        traverse(linkList);
        System.out.println();
        //测试头插法
//        LinkList linkList = createLinkListByHead(data);
//        traverse(linkList);
        //测试根据位置获取数据
//        int res = getElement(linkList, 9);
//        System.out.println(res);
        //测试插入数据
        int elem = 10;
        boolean b = insertElem(linkList, elem, 7);
        System.out.println(b + "插入后排序如下:");
        traverse(linkList);
        System.out.println();
        //测试删除数据
        boolean b1 = deleteElem(linkList, 7);
        System.out.println(b1 + "删除后链表如下:");
        traverse(linkList);
    }

    /**
     * 尾插法创建数组
     * @param data 用数组传递链表中的数据
     * @return 返回链表
     */
    static LinkList createLinkListByTail(int[] data) {
        LinkList res = null;
        for (int d : data) {
            if (res == null) {
                //第一个元素直接new出来
                res = new LinkList(d);
            } else {
                LinkList temp = res;
                //找到最后的节点
                while (temp.next != null) {
                    temp = temp.next;
                }
                //插入进去
                temp.next = new LinkList(d);
            }
        }
        return res;
    }

    /**
     * 遍历打印链表
     * @param linkList
     */
    static void traverse(LinkList linkList) {
        LinkList temp = linkList;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /**
     * 头插法
     * @param data
     * @return
     */
    static LinkList createLinkListByHead(int[] data) {
        LinkList res = null;
        for (int d : data) {
            //创建新节点
            LinkList temp = new LinkList(d);
            //让新节点的后一个节点指向res
            temp.next = res;
            //修改res的指针到一条链中的最前方
            res = temp;
        }
        return res;
    }

    /**
     * 根据位置获取元素
     * @param linkList
     * @param i
     * @return
     */
    static int getElement(LinkList linkList, int i) {
        //不能在原链表上查找，否则会修改原链表
        LinkList temp = linkList;
        //元素位置
        int j = 1;
        while (temp != null && j < i) {
            temp = temp.next;
            ++j;
        }
        if (temp == null || j > i) {
            //没找到，暂时用0表示
            return 0;
        }
        return temp.data;
    }

    /**
     * 在链表的第i个位置插入elem值，i的范围为1-链表长度+1
     * @param linkList
     * @param elem
     * @param i
     * @return
     */
    static boolean insertElem(LinkList linkList, int elem, int i) {
        if (i <= 0) {
            //规定开始为1
            return false;
        }
        //1的位置要特殊处理一下
        if (i == 1) {
            //这里修改链表，并没有修改到参数里面的
            //因为拿到的参数只是指针，并没有修改调用者的指针
//            linkList = node;
            //只好这么做了
            //第一个节点修改为elem
            //我简直太聪明了哈哈哈
            int temp = linkList.data;
            linkList.data = elem;
            elem = temp;
            i = 2;
        }
        //用临时指针操作链表
        LinkList temp = linkList;
        int j = 1;
        //找到i的位置
        while (temp != null && j < i - 1) {
            temp = temp.next;
            j++;
        }
        if (temp == null) {
            //找到末尾也没找到
            return false;
        } else {
            //先把节点new出来
            LinkList node = new LinkList(elem);
            node.next = temp.next;
            temp.next = node;
            return true;
        }
    }

    /**
     * 根据位置删除元素，位置1-链表长度
     * @param linkList
     * @param i
     * @return
     */
    static boolean deleteElem(LinkList linkList, int i) {
        if (i <= 0) {
            return false;
        }
        LinkList temp = linkList;
        int j = 1;
        //找到i的位置
        while (temp != null && j < i - 1) {
            temp = temp.next;
            j++;
        }
        if (temp == null) {
            return false;
        } else {
            temp.next = temp.next.next;
            return true;
        }
    }
}
