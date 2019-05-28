package com.company.pb;

/**
 * 基本数据类型与常量池
 */
public class Demo01 {
    public static void main(String[] args) {
        /**
         * 自动拆箱和装箱
         * 基本数据类型的常量池是-128到127之间,在这个范围中的基本数据类的包装类可以自动拆箱，比较时直接比较数值大小。
         */
        Integer a1 = 128;
        Integer a2 = -128;
        Integer a3 = -128;
        Integer a4 = 128;
        System.out.println(a1 == a4);//true
        System.out.println(a2 == a3);//false 大于127

    }

}
