package ALevel;

import java.util.Scanner;

//https://codeforces.com/problemset/problem/1506/A
public class StrangeTable {
    public static void main(String[] args) {
        /*
        n=3 m=5
        from
        1 4 7 10 13
        2 5 8 11 14
        3 6 9 12 15
        to
        1  2  3  4  5
        6  7  8  9  10
        11 12 13 14 15
         */
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        while (t-->0) {
            long n = scan.nextLong();
            long m = scan.nextLong();
            long x = scan.nextLong();
            System.out.println(solve(n, m, x));
        }}

    private static long solve(long n, long m, long x) {
        long row= (x-1)/n;//1
        long column=(x-1)%n;//0
        return column*m+row+1;
    }
}
