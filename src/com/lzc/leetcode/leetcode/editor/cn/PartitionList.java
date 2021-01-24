//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 296 👎 0

package com.lzc.leetcode.leetcode.editor.cn;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode head = init(new int[]{1,4,3,2,5,2});

        visit(solution.partition(head,3));
        //System.out.println(1);
    }
    static ListNode init(int[] nums){
        ListNode p  = new ListNode(-1);
        ListNode q = p;
        for(int  s : nums){
            p.next = new ListNode(s);
            p = p.next;
        }
        return q.next;
    }
    static void visit(ListNode list){
        ListNode p = list;
        while(p != null) {
            System.out.print(p.val +",");
            p = p.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode p = new ListNode(-1), q = new ListNode(-1);
            ListNode result1 = p, result2 = q;
            while(head != null){
                if(head.val < x){
                    p.next = head;
                    p = p.next;
                }else{
                    q.next = head;
                    q = q.next;
                }
                head = head.next;
            }
            q.next = null;
            p.next = result2.next;
            return result1.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}