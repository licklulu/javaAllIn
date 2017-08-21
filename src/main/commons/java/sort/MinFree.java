package sort;

import java.util.Arrays;
import java.util.Random;



/**
 * 解决最小可用id问题： 在非负数组中找到最小的可分配的id
 */
public class MinFree {
    /**
     * 问题可转化为：n个正数的数组A，如果存在小于n的数不在数组中，必然存在大于n的数在数组中， 否则数组排列恰好为1到n
     * 新建长为n+1的数组F，初始值全为false，扫描原数组中的元素，小于n则将F[A[i]]记录为true
     * 最后再扫描F，返回第一个为false的元素的下标 注：有点类似于基数排序 O(n)但是浪费空间
     * 
     */
    public static int minFree(int[] a) {
        int n = a.length;
        boolean[] f = new boolean[n + 1];
        
        for (int e : a) {
            if (e <= n) {
                f[e] = true;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            
            if (!f[i]) {
                return i;
            }
        }
        return n + 1;
    }

    /**
     * 改进2，分区，递归
     * 
     * @param l
     * @param r
     * @param a
     * @return
     */
//  public static int minFree(int[] arr, int l, int r) {
//      int mid = (l + r) / 2;
//      if (l >= r)
//          return r;
//      int indexOfMid = Util.partition3(arr, l, r, mid)[0];
//      if (indexOfMid + 1 == mid) {
//          return minFree(arr, mid , r);
//      } else {
//          return minFree(arr, l, mid-1);
//      }
//
//  }

    public static void main(String[] args) {
        int[] randomArr = new int[9000];
        Random r=new Random(1000000);
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i]=r.nextInt();
        }
//        randomArr  = Util.getRandomArr(10, 1, 11);
        System.out.println(Arrays.toString(randomArr));
        System.out.println(minFree(randomArr));
    }
}