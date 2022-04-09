package com.shf.test;

import java.util.ArrayList;

public class Demo03 {
    byte[] array = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new Demo03());
                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println("count:" + count);
            e.printStackTrace();
        }
    }
}
