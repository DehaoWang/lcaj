package leetcode.lc11;

/**
 * Created by wangdehao on 18/4/21.
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height = {2,4,3};
        System.out.println(maxArea(height));
        System.out.println(maxAreaGS(height));

    }

    public static int maxArea(int[] height){
        int max = 0;

        for(int i = 0; i < height.length-1; i++){
            for(int j = i+1; j < height.length; j++){
                int area = (j-i) * Math.min(height[i], height[j]);
                max = area > max ? area : max;
            }

        }
        return max;
    }

//    1 2 3 4 5 6
//  1 x ------- o
//  2 x x - o o o
//  3 x x x o | |
//  4 x x x x | |
//  5 x x x x x |
//  6 x x x x x x


    public static int maxAreaGS(int[] height) {
        int max = 0;
        int i = 0, j = height.length-1;
        while (i < j){
            int area = (j-i) * Math.min(height[i], height[j]);
            max = area > max ? area : max;
            if(height[i] < height [j]){
                i++;
            }
            else {
                j--;
            }
        }
        return max;
    }
}
