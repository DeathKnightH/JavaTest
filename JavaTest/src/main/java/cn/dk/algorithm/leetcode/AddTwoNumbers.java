package cn.dk.algorithm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode generateListNode(int[] valueList){
        ListNode first = new ListNode(0);
        ListNode temp = first;
        for (int i:valueList) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return first.next;
    }

    public static void main(String[] args) {

    }

    /**
     * leetcode access success
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode first = new ListNode(0);
        ListNode temp = first;
        int buffer = 0;
        while (l1 != null || l2 != null || buffer != 0){
            if (l1 != null){
                buffer += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                buffer += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(buffer % 10);
            buffer /= 10;
            temp = temp.next;
        }
        return first.next;
    }

    /// 递归，实现细节上有问题
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
//        int value = l1.val + l2.val;
//        int nextStep = value > 9 ? 1 : 0;
//        ListNode node = new ListNode(value % 10);
//        node.next = addTwoNode(l1.next, l2.next, nextStep);
//        return node;
//    }
//
//    public static ListNode addTwoNode(ListNode l1, ListNode l2, int step){
//        if(l1 == null){
//            if (l2 == null){
//                if (step != 0){
//                    return new ListNode(1);
//                }else{
//                    return null;
//                }
//            }else {
//                int value = l2.val + step;
//                if (value == 10){
//                    ListNode node = new ListNode(0);
//                    node.next = new ListNode(1);
//                    return node;
//                }else {
//                    return new ListNode(value);
//                }
//            }
//        }else {
//            if (l2 == null){
//                int value = l1.val + step;
//                if (value == 10){
//                    ListNode node = new ListNode(0);
//                    node.next = new ListNode(1);
//                    return node;
//                }else {
//                    return new ListNode(value);
//                }
//            }else {
//                int value = l1.val + l2.val + step;
//                int nextStep = value > 9 ? 1 : 0;
//                ListNode node = new ListNode(value % 10);
//                node.next = addTwoNode(l1.next, l2.next, nextStep);
//                return node;
//            }
//        }
//    }
}
