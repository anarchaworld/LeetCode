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
    public int numComponents(ListNode head, int[] nums) {
        boolean[] seen = new boolean[10001];
        for (int n : nums){
            seen[n] = true;
        }

        int ans = 0;
        boolean count = false;
        while(head != null){
            if (!seen[head.val] && count){
                ans++;
            }
            count = seen[head.val];
            head = head.next;
        }

        return ans + (count? 1 : 0);
    }
}
