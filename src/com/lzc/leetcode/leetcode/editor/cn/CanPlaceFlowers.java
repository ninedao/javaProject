//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
//，不能则返回False。 
//
// 示例 1: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
// 
//
// 注意: 
//
// 
// 数组内已种好的花不会违反种植规则。 
// 输入的数组长度范围为 [1, 20000]。 
// n 是非负整数，且不会超过输入数组的大小。 
// 
// Related Topics 贪心算法 数组 
// 👍 233 👎 0

package com.lzc.leetcode.leetcode.editor.cn;
public class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{0,1,0},1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        int len = flowerbed.length;
        if(n==0){
            return true;
        }
        if(len==1 && flowerbed[0] == 0){
            sum++;
            if(sum >=n){
                return true;
            }
        }
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            sum++;
            if(sum >=n){
                return true;
            }
        }
        if(len - 1 > 1 && flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0){
            flowerbed[len - 1] = 1;
            sum++;
            if(sum >=n){
                return true;
            }
        }
        for(int i = 1; i < len - 1; i++ ){
            if(flowerbed[i] == 1){
                i++;
                continue;
            }
            if(flowerbed[i-1]==0 && flowerbed[i+1]==0){
                sum++;
                flowerbed[i] = 1;
                if(sum >=n){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}