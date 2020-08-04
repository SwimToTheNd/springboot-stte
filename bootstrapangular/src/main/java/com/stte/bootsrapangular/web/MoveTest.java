package com.stte.bootsrapangular.web;

/**
 * create by BloodFly at 2020/3/26
 */
public class MoveTest {

    private static String str = "wKy7+Lmry76jrLra0MTG89K1";

    public static void main(String[] args) {
        char[] chars = str.toCharArray();
        char[] out = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            out[i] = (char) (chars[i] - 3);
        }
        System.out.println(out);
    }
}
