class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] == 'B'){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }
}
