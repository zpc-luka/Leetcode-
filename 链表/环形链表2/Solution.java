package 链表.环形链表2;

import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        
        ListNode pos = head;

        while(pos != null) {
            if(visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }

            pos = pos.next;
        }

        return null;
    }
}
