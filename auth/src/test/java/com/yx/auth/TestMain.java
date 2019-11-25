package com.yx.auth;

public class TestMain {

    private static void test(){
        try{
            System.out.println(111);
        }finally {
            System.out.println(222);
        }
    }

    public static void main(String[] args) {
        TestMain.test();
    }
}
