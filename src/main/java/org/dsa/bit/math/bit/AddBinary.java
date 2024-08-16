package org.dsa.bit.math.bit;

public class AddBinary {

    //Given two binary strings a and b, return their sum as a binary string.
    //
    //
    //
    //Example 1:
    //
    //Input: a = "11", b = "1"
    //Output: "100"
    //Example 2:
    //
    //Input: a = "1010", b = "1011"
    //Output: "10101"

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
        System.out.println(addBinaryManual("11","1"));
    }

    public static String addBinary(String a, String b) {
        int s1 = Integer.parseInt(a, 2);
        int s2 = Integer.parseInt(b, 2);
        int s3 = s1 + s2;
        return Integer.toBinaryString(s3);

    }
    public static String addBinaryManual(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int a1 = a.length()-1;
        int b1 = b.length() -1;
        int carry =0;

        while (a1>=0 || b1>=0){
            int sum = carry;
            if (a1 >= 0) sum += a.charAt(a1--) -'0';
            if (b1 >= 0) sum += b.charAt(b1--) -'0';
            sb.append(sum % 2);
            carry = sum/2;
        }
        if(carry!= 0)sb.append(carry);
        return sb.reverse().toString();
    }
}
