//两数相加
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode();   // 记录头结点
        ListNode cursor = res;           // 使用一个节点记录当前位置

        int flag = 0;
        while(p1 != null || p2 != null || flag != 0){
            int l1val = p1 == null ? 0 : p1.val;
            int l2val = p2 == null ? 0 : p2.val;
            int sumVal = l1val + l2val + flag;
            flag = sumVal / 10;               // 符号位，可以用除号，取首位

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        return res.next;

    }
}


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}