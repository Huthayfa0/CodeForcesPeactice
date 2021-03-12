package CLevel;

import java.util.HashSet;
import java.util.Scanner;

public class SumofCubes {
    static HashSet<Long> set=new HashSet<>(10000);
    public static void main(String[] args) {
        for (long i=1;i<=10000;i++)
            set.add(i*i*i);
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        here:while (t-->0){
            long l= scan.nextLong();
            long x=1;
            while(x*x*x<l){
                if (set.contains(l-x*x*x)){
                    System.out.println("Yes");
                    continue here;
                }
                x++;
            }
            System.out.println("No");
        }
    }
}
