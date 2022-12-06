/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;

        while(a != b){
            a = a == null? b : a.parent;
            b = b == null? a : b.parent;
        }

        return a;

        //OR you can use a hashset
        // HashSet<Integer> set = new HashSet<>();
        // while(p != null){
        //     set.add(p.val);
        //     p = p.parent;
        // }

        // while(q != null){
        //     if (set.contains(q.val))
        //         return q;
        //     q = q.parent;
        // }

        // return null;
    }
}
