//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 710 👎 0

package com.lzc.leetcode.leetcode.editor.cn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws IOException {
        Solution solution = new SlidingWindowMaximum().new Solution();
//        int[][] test = new int[60][];
//        int[] k = new int[60];
//        Random random = new Random(435789315);
//        for(int i = 0; i < 60; i++){
//            test[i] = new int[random.nextInt(100000) + 1];
//            for(int j = 0; j < test[i].length; j++) {
//                test[i][j] = random.nextInt(20000) - 10000;
//            }
//            k[i] = random.nextInt(test[i].length) +1;
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("test.out"));
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 60; i++){
//            sb.append(Arrays.toString(test[i]) +"\n");
//        }
//        fileOutputStream.write(sb.toString().getBytes());
//        fileOutputStream.write("-------------------------------------------\n".getBytes());
//        fileOutputStream.write((Arrays.toString(k)+"\n").getBytes());
//        fileOutputStream.flush();
//        fileOutputStream.close();
//        fileOutputStream = new FileOutputStream(new File("result.out"));
//        Long t1 = System.currentTimeMillis();
//        for(int i = 0; i < 60; i++) {
//            fileOutputStream.write((Arrays.toString(solution.maxSlidingWindow(test[i],500)) + "\n").getBytes());
//        }
//        fileOutputStream.flush();
//        fileOutputStream.close();
//        Long t2 = System.currentTimeMillis();
//        System.out.println(t2-t1);
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || nums.length < 2){
                return nums;
            }
            LinkedList<Integer> list = new LinkedList<Integer>();
            int[] result = new int[nums.length-k+1];
            for(int i = 0; i < nums.length; i++) {
                while(!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                    list.pollLast();
                }
                list.addLast(i);
                if(list.peek() <= i - k){
                    list.poll();
                }
                if(i +1 >= k){
                    result[i + 1 - k] = nums[list.peek()];
                }
            }
            return result;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}