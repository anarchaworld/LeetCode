https://leetcode.com/problems/string-without-aaa-or-bbb/discuss/1892941/Java-Greedily-Adding-%22aab%22-or-%22bba%22
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int x = Math.min(a, Math.min(b, Math.abs(a - b)));
        if (a > b){
            sb.append("aab".repeat(x));
            b -= x;
            a -= 2 * x;
        }
        if (a < b){
            sb.append("bba".repeat(x));
            b -= 2 * x;
            a -= x;
        }
        if (a == b){
            sb.append("ab".repeat(a));
        }
        if (a == 0){
            sb.append("b".repeat(b));
        }
        if (b == 0){
            sb.append("a".repeat(a));
        }
        return sb.toString();
    }
}
