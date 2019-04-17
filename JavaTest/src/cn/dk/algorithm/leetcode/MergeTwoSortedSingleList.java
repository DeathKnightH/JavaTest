package cn.dk.algorithm.leetcode;

/**
 * 合并两个有序链表，链表结构在内部类中定义
 */
public class MergeTwoSortedSingleList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int i){
            this.val = i;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedSingleList mergeTwoSortedSingleList = new MergeTwoSortedSingleList();
        ListNode l1 = mergeTwoSortedSingleList.generateListNode(new int[]{1,2,4});
        ListNode l2 = mergeTwoSortedSingleList.generateListNode(new int[]{1,3,4});
        ListNode result = mergeTwoSortedSingleList.mergeTwoLists(l1,l2);
        do {
            System.out.println(result.val);
            result = result.next;
        }while (result != null);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        boolean flag = l1.val < l2.val;
        ListNode first =  flag ? l1 : l2;
        ListNode head = first;
        ListNode second = flag ? l2 : l1;
        while (first.next != null){
            if(first.next.val > second.val){
                ListNode temp = first.next;
                first.next = second;
                first = first.next;
                second = temp;
            }else{
                first = first.next;
            }
        }
        first.next = second;
        return head;
    }

    private ListNode generateListNode(int[] valueList){
        ListNode listNode = new ListNode(0);
        ListNode point = listNode;
        for (int i:valueList) {
            ListNode temp = new ListNode(i);
            point.next = temp;
            point = point.next;
        }
        return  listNode.next;
    }
}
