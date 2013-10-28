import java.util.Scanner;


/*
给定一个数串和一个数S，在数串中找出大于等于S的一个连续子列！且该子列是满足上述条件的最短子列！
数串数字个数N：10<N<100000,每个数小于10000。
比如：
    10 15 
    5 1 3 5 10 7 4 9 2 8         最短为2；
    5 11
    1 2 3 4 5                          最短为3。
*/

public class SubsequenceTest {
    
    public static int [] nums = new int[1000000];
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        int len = scan.nextInt();
        int key = scan.nextInt();
        
        scan = new Scanner(System.in);
        for(int i = 0;i<len;++i){
            nums[i] = scan.nextInt();
        }
        
        //计算
        int b = 0;
        int e = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(e < len){
            
            while(e < len && sum < key){
                sum += nums[e];
                ++e;
            }
            
            if(sum >= key){
                while(sum >= key){
                    sum -= nums[b];
                    ++b;
                }
                min = min > e - b + 1 ? e - b + 1 :min;
            }

        }
        
        System.out.println(min);
//        for(int i = 0;i<len;++i){
//            System.out.println(nums[i]);
//        }
        

    }

}
