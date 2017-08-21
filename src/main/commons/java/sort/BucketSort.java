package sort;


import util.Util;

import java.util.Arrays;

/**
 * 桶排序<br />
 * 思路：见http://www.cs.usfca.edu/~galles/visualization/BucketSort.html<br />
 * 工作的原理是将数组分到有限数量的桶子里。<br />
 * 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）。<br />
 * 桶排序是鸽巢排序的一种归纳结果。当要被排序的数组内的数值是均匀分配的时候，桶排序使用线性时间（Θ（n））。<br />
 * 但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。<br />
 *
 * 时间复杂度： O(N+C)，其中C=N*(logN-logM)<br />
 * 空间复杂度：N+M，M为桶的个数<br />
 * 非原址排序<br />
 * 稳定性：稳定<br />
 *
 * 桶排序假设数据会均匀入桶，在这个前提下，桶排序很快！
 */
public class BucketSort {
  // 根据桶的个数来确定hash函数，这份代码适合桶的个数等于数组长度
  private static int hash(int element, int max, int length) {
    return (element * length) / (max + 1);
  }

  public static void main(String[] args) {
    int[] arr = Util.getRandomArr( 10, 1, 100 );
    System.out.println( "begin..." + Arrays.toString( arr ) );
    new BucketSort().sort( arr );
    System.out.println( "final..." + Arrays.toString( arr ) );
  }

  private void sort(int[] arr) {
    int length = arr.length;
    LinkedNode[] bucket = new LinkedNode[length];  // 桶的个数可以是
    int max = Util.maxOf( arr );
    // 入桶
    for (int i = 0; i < length; i++) {
      int value = arr[i];
      int hash = hash( arr[i], max, length );
      if (bucket[hash] == null) {
        bucket[hash] = new LinkedNode( value ); // 初始化链表表头
      } else {
        insertInto( value, bucket[hash], bucket, hash ); // 插入链表
      }
    }
    int k = 0; // 记录数组下标
    for (LinkedNode node : bucket) {
      if (node != null) {
        while (node != null) {
          arr[k++] = node.value;
          node = node.next;
        }
      }
    }
  }

  private void insertInto(int value, LinkedNode head, 
          LinkedNode[] bucket, int hash) {
    LinkedNode newNode = new LinkedNode( value );
    if (value <= head.value) {
      newNode.next = head;
      // 替换头节点
      bucket[hash] = newNode;
      return;
    }
    LinkedNode p = head;
    LinkedNode pre = p;
    while (p != null && value > p.value) {
      pre = p;
      p = p.next;
    }
    if (p == null) { // 跑到末尾了
      pre.next = newNode;
    } else { // 插入pre和p之间
      pre.next = newNode;
      newNode.next = p;
    }
  }

  class LinkedNode {
    int value;
    LinkedNode next;

    public LinkedNode(int value) {
      this.value = value;
    }
  }
}