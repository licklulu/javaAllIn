package sort;

import util.IUtil;

public class MergeSort {
    public void sort(int[] a, int left, int right) {

        if (left >= right)
            return;
        int center = (left + right) / 2;
        sort(a, left, center);
        sort(a, center + 1, right);
        Merge(a, left, center, right);
    }

    void Merge(int[] a, int left, int center, int right) {
        int[] la = new int[center - left + 1];
        int[] ra = new int[right - center];
        int p = 0;
        for (int i = left; i <= center; i++) {
            la[p] = a[i];
            p++;
        }
        int j = 0;
        for (int i = center + 1; i < right + 1; i++) {
            ra[j] = a[i];
            j++;
        }
        int m = 0, n = 0;
        for (int i = left; i < right + 1; i++) {
            if ((m == center-left+1) && (n < right-center)) {//m表示元素下标+1
                a[i] = ra[n];
                n++;
                continue;
            }
            if ((n == right-center) && (m < center-left+1)) {
                a[i] = la[m];
                m++;
                continue;
            }
            if (la[m] <= ra[n]) {
                a[i] = la[m];
                m++;

            } else {
                a[i] = ra[n];
                n++;

            }

        }
    }

    public static void main(String[] args) {
        int[] a = IUtil.getNotRepetationRandom(10, 100, 10);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        MergeSort ms = new MergeSort();
        int left = 0;
        int right = a.length - 1;
        System.out.println();
        ms.sort(a, left, right);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
