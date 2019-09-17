public class SuperficalArea {
    /**
     * 求表面积，此立方体由M*N的底上面累几个1*1的正方体累成，具体看代码就能看懂
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //N行
        int N = in.nextInt();
        //M个整数
        int M = in.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        //来一个计算一个
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    if (j == 0) {
                        res = res + 2 + 4 * matrix[i][j];
                    } else {
                        res = res + 4 * matrix[i][j] + 2 - 2 * (matrix[i][j] >
                                matrix[i][j - 1] ? matrix[i][j - 1] : matrix[i][j]);
                    }
                } else {
                    if (j == 0) {
                        res = res + 4 * matrix[i][j] + 2 - 2 * (matrix[i][j] >
                                matrix[i - 1][j] ? matrix[i - 1][j] : matrix[i][j]);
                    } else {
                        res = res + 4 * matrix[i][j] + 2 - 2 * (matrix[i][j] >
                                matrix[i - 1][j] ? matrix[i - 1][j] : matrix[i][j]) - 2 * (matrix[i][j] >
                                matrix[i][j - 1] ? matrix[i][j - 1] : matrix[i][j]);
                    }
                }
            }
        }
        System.out.println(res);
    }
}