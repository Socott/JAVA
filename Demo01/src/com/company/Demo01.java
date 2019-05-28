package com.company;

/**
 * 基本数据类型的大小
 * int 32位 4字节
 * short 16位
 * float 32位
 * double 64位
 * long 64位
 * char 16位
 * byte 8位
 * boolean 1位
 * 自动拆箱和装箱的意思就是，计算数值时，integer会自动转为int进行计算。
 * 而当int传入类型为integer的引用时，int数值又会被包装为integer。
 *
 * //8位
 * byte bx = Byte.MAX_VALUE;
 * byte bn = Byte.MIN_VALUE;
 * //16位
 * short sx = Short.MAX_VALUE;
 * short sn = Short.MIN_VALUE;
 * //32位
 * int ix = Integer.MAX_VALUE;
 * int in = Integer.MIN_VALUE;
 * //64位
 * long lx = Long.MAX_VALUE;
 * long ln = Long.MIN_VALUE;
 * //32位
 * float fx = Float.MAX_VALUE;
 * float fn = Float.MIN_VALUE;
 * //64位
 * double dx = Double.MAX_VALUE;
 * double dn = Double.MIN_VALUE;
 * //16位
 * char cx = Character.MAX_VALUE;
 * char cn = Character.MIN_VALUE;
 * //1位
 * boolean bt = Boolean.TRUE;
 * boolean bf = Boolean.FALSE;
 */
public class Demo01 {
    public static void main(String[] args) {
        /**
         * 基本数据类型的常量池是-128到127之间。
         * 在这个范围中的基本数据类的包装类可以自动拆箱，比较时直接比较数值大小。
         * int的自动拆箱和装箱只在-128到127范围中进行，超过该范围的两个integer的 == 判断是会返回false的
         */
        
    }
}
