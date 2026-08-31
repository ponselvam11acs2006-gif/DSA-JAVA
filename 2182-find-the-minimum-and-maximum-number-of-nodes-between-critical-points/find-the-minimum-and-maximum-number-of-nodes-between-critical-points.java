/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        int minDist = Integer.MAX_VALUE;
        int firstCriticalIndex = -1;
        int prevCriticalIndex = -1;
        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1;
        while (curr.next != null) {
            ListNode next = curr.next;
            boolean isLocalMaxima = curr.val > prev.val && curr.val > next.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < next.val;
            if (isLocalMaxima || isLocalMinima) {
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = position;
                } else {
                    minDist = Math.min(minDist, position - prevCriticalIndex);
                }
                prevCriticalIndex = position;
            }
            prev = curr;
            curr = next;
            position++;
        }
        if (minDist == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int maxDist = prevCriticalIndex - firstCriticalIndex;
        return new int[]{minDist, maxDist};
    }
}