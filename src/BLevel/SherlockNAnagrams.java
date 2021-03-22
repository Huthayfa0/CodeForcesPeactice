package BLevel;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SherlockNAnagrams {

    private static final Scanner scanner = new Scanner(System.in);
    private static final HashMap<Character, Integer> charSet = new HashMap<>(28);
    private static final int maximumCharCapacity = 7;//for 100 we need 7 bits

    static BigInteger get(char c) {
        return BigInteger.valueOf(1).shiftLeft(charSet.get(c) * maximumCharCapacity);
    }
    static BigInteger sum(BigInteger[] sums ,int start,int end){
        if (start==0)return sums[end];
        return sums[end].subtract(sums[start-1]);
    }
    static int sherlockAndAnagrams(String s) {
        BigInteger[] sums = new BigInteger[s.length()];
        char[] chars = s.toCharArray();
        sums[0] = get(chars[0]);
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1].add(get(chars[i]));
        }
        int count = 0;
        for (int len = 0; len < sums.length; len++)
            for (int i = 0; i+len < sums.length; i++)
                for (int j = i+1; j+len < sums.length; j++)
                    if (sum(sums,i,i+len).equals(sum(sums,j,j+len)))
                        count++;
        return count;
    }


    public static void main(String[] args) throws IOException {

        {
            int i = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                charSet.put(c, i);
                i++;
            }
        }
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }



        scanner.close();
    }
}
/*
static boolean isAnagram(String a, String b) {
        // Complete the function
        int N = 26;
        if (a.length() != b.length()) return false;
        int []countA = new int[N];
        int []countB = new int[N];

        for (char c : a.toCharArray()) {
            countA[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            countB[c - 'a']++;
        }

        for (int i = 0; i < N; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;

    }
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {


        int count = 0;
        int length = s.length();

        List<String> subsets = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                subsets.add(s.substring(i, i + j));
            }
        }

        for (int i = 0; i < subsets.size(); i++) {
            for (int j = i + 1; j < subsets.size(); j++) {
                String s1 = subsets.get(i);
                String s2 = subsets.get(j);
                if (i != j &&
                        isAnagram(s1, s2)) {
                    count++;
                }
            }
        }
        return count;
    }
 */