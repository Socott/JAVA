package com.company.pb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 正则表达式
 */
public abstract class Demo05 {
    /**
     * [正则表达式]  ------  判断一个字符
     *
     * [abc] --- abc中任意一个字符   	[^abc] --- 除abc外的任意字符
     *
     * [a-z] --- a~z之中的任意小写字母	[a-zA-Z0-9] --- a~z、A~Z、0~9之中的任意一个字符
     *
     * [a-z&&[^bc]] --- a~z 之中除b和c外的任意字符，&&表示与
     */

    /**
     * 转义字符
     *
     * .  --- 任意一个字符  	\d --- 任意一个数字字符[0-9]
     *
     * \w --- 单词字符[a-zA-Z0-9_] \s --- 空白字符[\t\n\x0B\f\r]
     *
     * \D --- 非数字字符	\W --- 非单词字符
     *
     * \S --- 非空白字符
     */

    /**
     * (正则表达式)  ------  判断两个以上字符
     *
     * ( | | ) --- 多个正则表达式可以|联接，表示或
     *
     *  组合表达式
     *
     * X? --- 表示0个或者1个X	X* --- 表示0个或任意多个X
     *
     * X+ --- 表示1个到任意多个X X{n} --- 表示n个X
     *
     * X{n, } --- 表示n到任意多个X         X{n,m} --- 表示n到m个X
     */

    public static void main(String[] args) {
        /**
         *  邮箱的正则表达式
         *
         *  * "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-z]+)+"
         *
         *  * "\w+@[\w[^_]]+(\.[a-zA-Z]+)+" "
         */
        String email = "pengbin_2012@163.com";
        String regexs = "\\w+@[\\w&&[^_]]+(\\.[a-zA-z]+)+";
        boolean matches = email.matches(regexs);
        System.out.println(matches);

        /**
         * String[] split(String regex)
         */
        /** 按照数字部分进行拆分，若在拆分过程中连续匹配上了两次可拆分内容，那么中间可以拆分出一个空字符串，若在末尾匹配上了若干次，后面的空字符串会被舍弃掉*/
        String str = "abc123def456ghj789kl";
        String[] array = str.split("[\\d]+");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        /**
         * String replace(char s,char s2) 将字符串中字符s 更换为字符 s2
         * String replanceAll (String regex,String s2) 将字符串中所有匹配正则表达式regex 的部分更换为 s2
         * String replanceFirst(String regex,s2) 将字符串中第一个匹配正则表达式regex 的部分s 更换为 s2
         */
        String str2 = "abc123def456ghj789kl";/* 将数字部分替换为"#NUMBER#" */
        str2 = str2.replaceAll("[\\d]","#NUMBER");
        System.out.println(str2);

        //1.Date类
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str3 = sdf.format(date);
        System.out.println(str3);

        //2.队列——LinkedList集合
        /**
         * 队列可以存储一组元素，但是存取元素必须遵循先进先出的原则
         * java.util.LinkedList除了实现List接口外，也实现了队列接口
         */
        Queue<String> queue = new LinkedList<String>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        System.out.println(queue);

        /** 出队操作，获取队首元素，获取后该元素即从队列中被移除*/
//        String str4 = queue.poll();
//        System.out.println(str4);
//        System.out.println(queue);

        /** 引用队首元素，但是不做出队操作*/
        String str4 = queue.peek();
        System.out.println(str4);
        System.out.println(queue);

        //双端队列
        Deque<String> deque = new LinkedList<String>();
        deque.offer("two");
        deque.offerFirst("one");
        deque.offerLast("three");
        System.out.println(deque);

        //3.文件流
        /**
         * 流:流根据方向不同分为输入流与输出流，参照点为当前程序,输入流用来读取数据，输出流用来写出数据
         */

    }

}
