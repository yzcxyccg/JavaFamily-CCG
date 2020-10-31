package 面试题;

/**
 * @author 程从广
 * @Description 根据输入的m x n 网格，找出一条从左上角到右下角的路径，使得路径上的数字总和为最小，并输出上述路径上的数字最小总和
 * @Date 创建于 2020/8/28 17:19
 */
public class YYTest3 {
    public static int moveMin(int[][] grid, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        if (x == grid.length - 1 && y < grid[0].length - 1) {
            return grid[x][y] + moveMin(grid, x, y + 1);
        }
        if (x < grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y] + moveMin(grid, x + 1, y);
        }
        int right = moveMin(grid, x, y + 1);
        int down = moveMin(grid, x + 1, y);
        return grid[x][y] + Math.min(right, down);
    }
    public static int minPathSum (int[][] grid) {
        return moveMin(grid, 0, 0);
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 1, 2}, {1, 5, 1, 3}, {3, 2, 1, 2}};
        System.out.println(minPathSum(array));
    }
}
