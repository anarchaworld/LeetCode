class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0, openIdx = -1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '[' && ++count == 1) openIdx = i;
            if (arr[i] == ']' && --count == 0) {
                int start = openIdx - 1;
                while(start >= 0 && Character.isDigit(arr[start])) start--;
                int dup = Integer.parseInt(s.substring(start + 1, openIdx));
                ans.append(decodeString(s.substring(openIdx + 1, i)).repeat(dup));
                openIdx = -1;
            }
            if (openIdx == -1 && Character.isAlphabetic(arr[i])) ans.append(arr[i]);
        }

        return ans.toString();
    }
}
