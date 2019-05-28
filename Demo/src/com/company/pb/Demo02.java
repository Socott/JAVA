package com.company.pb;

/**
 * 深入理解String及包装类
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.String的连接
        String s1 = "a";
        String s2 = "a";
        String s3 = "a" + s2;
        String s4 = "a" + "a";
        String s5 = s1 + s2;
        //表达式只有常量时，编译期完成计算
        //表达式有变量时，运行期才计算，所以地址不一样
        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //false
        System.out.println(s4 == "aa"); //true

        //2.String类型的intern
        String s6 = "a";
        String s7 = new String("a");
        //s6是基本类型，比较值。s7是string实例，比较实例地址
        //调用intern时,如果s6中的字符不在常量池，则加入常量池并返回常量的引用
        String s8 = s7.intern();
        System.out.println(s6 == s7);//false
        System.out.println(s6 == s8);//true
        System.out.println(s7 == s8);//false

        //StringBuffer和StringBuilder,底层是继承父类的可变字符数组value
        // char[] value;初始化容量为16
        //Stringbuffer在大部分涉及字符串修改的操作上加了synchronized关键字来保证线程安全，效率较低。
        //String类型在使用 + 运算符例如：String a = "a"
        //a = a + a;时，实际上先把a封装成stringbuilder，调用append方法后再用tostring返回，所以当大量使用字符串加法时，会大量地生成stringbuilder实例，这是十分浪费的，这种时候应该用stringbuilder来代替string。
        new StringBuffer();
        new StringBuilder();
    }
}
