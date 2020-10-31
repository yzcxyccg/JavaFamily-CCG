package d14_剑指offer.b12_画图让抽象形象化;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Test19 {
    public static ArrayList<Integer> printMatrix1(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (left <= right && up <= down) {
            //向右
            for (int i = left; i <= right; i++)
                result.add(matrix[up][i]);
            //向下
            for (int i = up + 1; i <= down; i++)
                result.add(matrix[i][right]);
            //向左
            if (up < down)
                for(int i = right-1 ; i>=left ; i--)
                    result.add(matrix[down][i]);
            //向上
            if(left < right)
                for(int i = down-1 ; i >= up+1 ; i--)
                    result.add(matrix[i][left]);
            left++;right--;up++;down--;
        }
        return result;
    }



    public static ArrayList<Integer> printMatrix2(int[][] matrix) {
        // 走的方向：向右、向下、向左、向上
          int[] dx = {0, 1, 0, -1};
          int[] dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();

        int x = 0, y = 0, dir = 0;
        while (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y]) {
            list.add(matrix[x][y]);
            vis[x][y] = true;

            // 试着继续向dir的方向走
            while (x + dx[dir] >= 0 && x + dx[dir] < n && y + dy[dir] >= 0 && y + dy[dir] < m && !vis[x + dx[dir]][y + dy[dir]]) {
                x += dx[dir];
                y += dy[dir];
                list.add(matrix[x][y]);
                vis[x][y] = true;
            }
            // 走不动了换方向
            dir = (dir + 1) % 4;
            x += dx[dir];
            y += dy[dir];
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrix2(array));
    }
}
