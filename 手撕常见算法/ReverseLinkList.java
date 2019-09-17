package algorithm;

public class ReverseLinkList {
    public static void main(String[] args) {
        LinkList linkList = new LinkList(1);
        createLinkList(linkList, new int[]{2, 3, 4, 5, 6});
//        traverse(linkList);
        traverse(reverse(linkList));
    }

    static void createLinkList(LinkList linkList, int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            insertTail(linkList, datas[i]);
        }
    }

    static void insertTail(LinkList linkList, int data) {
        if (linkList == null) {
            linkList = new LinkList(data);
        } else {
            LinkList temp = linkList;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new LinkList(data);
        }
    }

    static void traverse(LinkList linkList) {
        while (linkList != null) {
            System.out.println(linkList.data);
            linkList = linkList.next;
        }
    }

    static LinkList reverse(LinkList head) {
        LinkList pre = null;
        while (head != null) {
            LinkList next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class LinkList {
    public int data;
    public LinkList next;

    public LinkList(int data) {
        this.data = data;
    }
}
