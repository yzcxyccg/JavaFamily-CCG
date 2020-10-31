package 面试题;

import java.util.Scanner;

public class MTTest1 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] map = new char[2][n];
        for(int i = 0 ; i < 2 ; i++)
            map[i] = scanner.next().toCharArray();
        System.out.println(dfs(0,0,n,map));
    }
    public static int dfs(int x,int y,int n,char[][]map){
        if(n <= 1)return -1;
        if(x == 1 && y == n-1 && map[x][y] == '.')
            return 1;
        if(x+1 < 2 && map[x+1][y] == '.'){
            if(dfs(x+1,y,n,map)==1)count++;
        }
        if(x+1 < 2 && y+1 < n && map[x+1][y+1] == '.'){
            if(dfs(x+1,y+1,n,map) == 1)count++;
        }
        if(x-1 < 2 && y+1 < n && map[x][y+1] == '.'){
            if(dfs(x,y+1,n,map) == 1)count++;
        }
        if(count == 0)return -1;
        return count;
    }
}
