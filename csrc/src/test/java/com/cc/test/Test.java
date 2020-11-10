package com.cc.test;

/**
 * @Author:洛无极
 * @Date:2020/11/5
 */
public class Test {
    public static void main(String[] args) {
        String str ="   a b   c  e  f      g";
        String[] arr = str.split("\\s+");
        for(String ss : arr){
            System.out.print(ss);
        }
    }
}
