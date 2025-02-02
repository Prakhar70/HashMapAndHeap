package Level2;

public class Q041_PairsWithGivenSum {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int i =0;
        int j= n*n-1;
        int cnt = 0;
        while(i<(n*n) && j>=0){
            if(mat1[i/n][i%n] + mat2[j/n][j%n] == x){
                cnt++;
                i++;
                j--;
            }else if(mat1[i/n][i%n]+mat2[j/n][j%n] > x){
                j--;
            }else{
                i++;
            }
        }
        return cnt;
    }
}
