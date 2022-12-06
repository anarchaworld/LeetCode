https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/discuss/2180645/2-Codes-or-Iterative-or-Recursive-or-Factorial-or-O(n)-or-Java
class Solution {
    int M = (int)1e9+7;
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        long[] fact = new long[n];
        long[] invFact = new long[n];
        long[] inv = new long[n];
        fact[1]=fact[0]=invFact[0]=invFact[1]=inv[1]=1;
        for (int i = 2; i < n; i++){
            fact[i] = fact[i-1]*i%M;
            inv[i] = M-M/i*inv[M%i]%M;
            invFact[i] = invFact[i-1]*inv[i]%M;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.computeIfAbsent(prevRoom[i], o -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[]{1};
        solve(0, fact, invFact, map, ans);
        return (int)ans[0];
    }

    private int solve(int i, long[] fact, long[] invFact, Map<Integer, List<Integer>> map, long[] ans){
        int sum = 0;
        for (int next : map.getOrDefault(i, List.of())){
            int cur = solve(next, fact, invFact, map, ans);
            ans[0] = ans[0] * invFact[cur] % M;
            sum += cur;
        }
        ans[0] = ans[0] * fact[sum] % M;
        return sum+1;
    }
}

// class Solution {
//     int M = (int)1e9+7;
//     public int waysToBuildRooms(int[] prevRoom) {
//         int n = prevRoom.length;
//         long[] fact = new long[n];
//         long[] invFact = new long[n];
//         long[] inv = new long[n];
//         fact[1]=fact[0]=invFact[0]=invFact[1]=inv[1]=1;
//         for (int i = 2; i < n; i++){
//             fact[i] = fact[i-1]*i%M;
//             inv[i] = M-M/i*inv[M%i]%M;
//             invFact[i] = invFact[i-1]*inv[i]%M;
//         }

//         Node[] nodes = new Node[n];
//         int[] ind = new int[n];
//         for (int i = 0; i < n; i++){
//             nodes[i]=new Node(i);
//             if (i>0){
//                 ind[prevRoom[i]]++;
//             }
//         }

//         Queue<Node> queue = new ArrayDeque<>();
//         for (int i = 0; i < n; i++){
//             if (ind[i]==0){
//                 queue.offer(nodes[i]);
//             }
//         }

//         long ans = 1;
//         while(!queue.isEmpty()){
//             Node cur = queue.poll();
//             ans = ans * fact[cur.sum] % M;
//             for (int count : cur.childCount){
//                 ans = ans * invFact[count] % M;
//             }
//             if (cur.idx!=0){
//                 Node parent = nodes[prevRoom[cur.idx]];
//                 parent.sum += cur.sum+1;
//                 parent.childCount.add(cur.sum+1);
//                 if (--ind[prevRoom[cur.idx]]==0){
//                     queue.offer(parent);
//                 }
//             }
//         }

//         return (int)ans;
//     }

//     private class Node {
//         List<Integer> childCount = new ArrayList<>();
//         int sum = 0;
//         int idx;
//         Node(int idx){
//             this.idx = idx;
//         }
//     }
// }
