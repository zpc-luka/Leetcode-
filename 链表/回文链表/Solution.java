class Solution{
    public boolean isPanlindrome(LIistNode head){
        if(head == null || head.next == null)
            return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        /**
         * 申请两个指针，一个快指针一个慢指针
         * 快指针每次走两次 慢指针每次走一次
         * 如果是奇数最后慢指针会走到中间
         * 如果是偶数到n/2
         */
        while(true){
            if(fast.next == null){
                break;
            }

            slow = slow.next;
            fast = fast.next.next==null ? fast.next : fast.next.next;
        }
        
        /**
         * 将中间的指针以后的进行翻转
         * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
         * 第二个指针 cur 指向 head，然后不断遍历 cur。
         * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
         * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
        */


        ListNode reverseNode = null;
        ListNode cur = slow;
        while(true){
            if(cur == null){
                break;
            }
            ListNode temp = cur.next;
            cur.next = reverseNode;
            reverseNode = cur;
            cur = temp;
        }

        while(true){
            if(reverseNode == null || head == null)
                break;
            
            if(reverseNode.val != head.val){
                return false;
            }
            reverseNode = reverseNode.next;
            head = head.next;
        }
        return true;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}