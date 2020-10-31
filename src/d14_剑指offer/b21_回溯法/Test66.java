package d14_剑指offer.b21_回溯法;

/**
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向
 * 移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格
 * （35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能
 * 够达到多少个格子？
 */
public class Test66 {
    private final int dx[] = {1, -1, 0, 0};
    private final int dy[] = {0, 0, 1, -1};
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <=0 || cols <=0)return 0;
        boolean flag[][] = new boolean[rows][cols];
        return move(flag,threshold,rows,cols,0,0)+1;

    }
    public int move(boolean[][]flag,int threshold, int rows, int cols,int x,int y){
        flag[x][y] = true;
        int count = 0;
        for(int i = 0 ; i < 4 ;i++){
            x = x+dx[i];
            y = y+dy[i];
            if(x>=0 && x<rows && y>=0 && y<cols &&!flag[x][y] && isNeed(x)+isNeed(y) <= threshold)
                count = count + move(flag,threshold,rows,cols,x,y) + 1;
        }
        return count;
    }
    public int isNeed(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Test66 test66 = new Test66();
        System.out.println(test66.movingCount(10,1,100));
    }
}
