package com.lzc.source;
import java.io.*;
import java.util.*;
public class Test {
    /*
    链接：https://ac.nowcoder.com/acm/contest/10324/B
    来源：牛客网

    现在给定一个数组arr，和a,b两个数字，你要做的就是找到（i，j，k）。且满足
    1. 0 <= i < j < k < arr.size()
            2. |arr[i] - arr[j]| <= a
    3. |arr[j] - arr[k]| <= b
    统计满足条件的个数并返回(最后结果可能很大，请取1000000007的余数)。
    */

    public static int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] mm = new int[k];
        int len = jobs.length;
        for(int i = 0; i < k; i++){
            mm[i] = jobs[len - 1 - i];
        }
        int index;
        for(int i = jobs.length - k - 1; i>=0; i--){
            index = minIndex(mm);
            mm[index] = mm[index] + jobs[i];
        }
        return mm[maxIndex(mm)];
    }
    static int maxIndex(int[] jobs){
        int i = 0;
        for(int j = 1; j < jobs.length; j++){
            if(jobs[j] > jobs[i]){
                i = j;
            }
        }
        return i;
    }
    static int minIndex(int[] jobs){
        int i = 0;
        for(int j = 1; j < jobs.length; j++){
            if(jobs[j] < jobs[i]){
                i = j;
            }
        }
        return i;
    }
    public static int test(){
        try{
            return 1;
        }finally {
            return 0;
        }
    }
    public static void main(String[] args) throws Exception {
        try(Scanner sc = new Scanner(new File("c.txt"));
        OutputStream outputStream = new FileOutputStream(new File("210114.txt"))){
            while(sc.hasNext()){
                outputStream.write(sc.next().getBytes());
            }
        }
        System.out.println(test());
//        BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("c.txt")));
//        StringBuilder sb = new StringBuilder();
//        String ss;
//        while((ss = s.readLine()) != null){
//            sb.append(ss);
//        }
//        ListNode listNode = new ListNode(-1);
//        ListNode q = listNode;
//        int[] mm = new int[]{1,2,3,4,5};
//        for(int m :mm){
//            q.next = new ListNode(m, null);
//            q = q.next;
//        }
        long s1 = System.currentTimeMillis();
//        ListNode p = swapNodes(listNode.next,2);
//        while(p != null){
//            System.out.print(p.val +",");
//            p = p.next;
//        }
        System.out.println(minimumTimeRequired(new int[]{38,49,91,59,14,76,84},3));
        long s2 = System.currentTimeMillis();
        System.out.println("time:" + (s2 - s1) + "ms");
    }
}
