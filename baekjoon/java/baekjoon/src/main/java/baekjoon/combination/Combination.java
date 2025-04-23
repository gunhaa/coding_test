package baekjoon.combination;

public class Combination {

    static int[][] dp;

    private static int combination(int n, int m) {
        dp = new int[n + 1][m + 1];
        return combinationRecursive(n,m);
    }

    private static int combinationRecursive(int n, int m){
        if(n == m || m == 0){
            return 1;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        dp[n][m] = combinationRecursive(n - 1, m - 1) + combinationRecursive(n - 1, m);
        return dp[n][m];
    }


    public static void main(String[] args) {
        // nCr 을 구하는 방법
        // 5 C 2
        // 10
        System.out.println(combination(5, 2));
        // 120
        System.out.println(combination(10, 3));
    }

}
