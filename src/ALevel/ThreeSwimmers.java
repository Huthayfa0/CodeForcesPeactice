package ALevel;

import java.math.BigInteger;
import java.util.Scanner;

public class ThreeSwimmers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String[] constants = scan.nextLine().split(" ");
            BigInteger answer = calculate(new BigInteger(constants[0]), new BigInteger(constants[1]), new BigInteger(constants[2]), new BigInteger(constants[3]));
            System.out.println(answer);
        }
    }

    private static BigInteger calculate(BigInteger p, BigInteger a, BigInteger b, BigInteger c) {
        if (p.mod(a).equals(BigInteger.valueOf(0))||p.mod(b).equals(BigInteger.valueOf(0))||p.mod(c).equals(BigInteger.valueOf(0)))
            return BigInteger.valueOf(0);
        return a.subtract(p.mod(a)).min(b.subtract(p.mod(b))).min(c.subtract(p.mod(c)));
    }
}
