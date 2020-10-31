package d15_leetcode;

/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/4/8 1:46
 */

public class Test33 {
    public static void main(String[] args) {
        int count = 0;
        for(double i = 0 ; i < 500 ; i++){
            for(double j = 0 ; j < 500 ; j++){
                for(double k = 0 ; k < 500 ; k++){
                    double result = i-j-k;
                    if(result >= 0 && i%100 == k%100){
                        String str = i/100 + "-" + j/100 +"-"+k/100 + "=" + result/100;
                        System.out.println(str);
                        count++;
                    }
                }
            }
        }
        System.out.println("数量："+count);
    }

}
