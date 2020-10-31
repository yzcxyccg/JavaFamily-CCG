package d15_leetcode;

import java.util.HashMap;

/**
 * max-points-on-a-line
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class Test3 {
    public int maxPoints(Point[] points) {
        if(points == null)return 0;
        if(points.length <= 2)return points.length;
        HashMap<Double,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0 ; i < points.length ; i++){
            int count = 0,max = 0,row = 0,col = 0,num = 0;
            map.clear();
            for(int j = i+1 ; j < points.length ; j++){
                double gapx = new Double(points[j].x) - new Double(points[i].x);
                double gapy = new Double(points[j].y) - new Double(points[i].y);
                if(gapx == 0 && gapy == 0){
                    count++;
                    continue;
                }else if(gapx == 0){
                    col++;
                    max = Math.max(col,max);
                }else if(gapy == 0){
                    row++;
                    max = Math.max(row,max);
                }else{
                    double k = gapy/gapx;
                    if(map.containsKey(k)){
                        map.put(k,map.get(k)+1);
                    }else{
                        map.put(k,1);
                    }
                    max = Math.max(map.get(k),max);
                }
            }
            result = Math.max(result,max+1+count);
        }
        return result;
    }
}
