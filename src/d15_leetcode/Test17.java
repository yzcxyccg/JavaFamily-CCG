package d15_leetcode;

/**
 * gas-station
 * 环形路上有n个加油站，第i个加油站的汽油量是gas[i].你有一辆车，车的油箱可以无限装汽油。从
 * 加油站i走到下一个加油站（i+1）花费的油量是cost[i]，你从一个加油站出发，刚开始的时候油箱里面没有
 * 汽油。求从哪个加油站出发可以在环形路上走一圈。返回加油站的下标，如果没有答案的话返回-1。
 * 注意：答案保证唯一。
 */
public class Test17 {
        public int canCompleteCircuit1(int[] gas, int[] cost) {
            if(gas == null || cost == null)return -1;
            int n = gas.length;
            for(int i = 0 ; i < n-1 ; i++){
                int count = 0,index = 0;
                int j = i;
                while(1>0){
                    if(j == n)j = j%n;
                    count += gas[j];
                    count -= cost[j];
                    if(count < 0)break;
                    if(index == n-1)return i+1;
                    j++;index++;
                }
            }
            return -1;
        }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if(gas == null || cost == null)return -1;
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while(start > end){
            if(sum >= 0){
                sum += gas[end] - cost[end];
                ++end;
            }else{
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum >=0 ? start : -1;
    }
}
