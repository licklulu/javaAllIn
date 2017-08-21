package exam1;

public class Solution {
    public static long m1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return m1(n - 1) + m1(n - 2);
    }
    public static long mm1(int n) {
        long tmp[] = new long[n + 1];
        tmp[0] = 0;
        tmp[1] = 1;
        tmp[2] = 2;
        return mm1(tmp, n);
    }

    private static long mm1(long[] tmp, int n) {
        if (tmp[n] != 0 || n == 0)
            return tmp[n];

        tmp[n] = mm1(tmp, n - 2) + mm1(tmp, n - 1);
        return tmp[n];

    }
    public static void main(String[] args) {
        long starttime=System.currentTimeMillis();
        long a=mm1(1000);
//        m1(50);
        long endtime=System.currentTimeMillis();
        System.out.println(a);
        System.out.println((endtime-starttime)+"ms");
    }
}
