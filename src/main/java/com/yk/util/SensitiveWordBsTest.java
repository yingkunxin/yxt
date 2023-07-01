package com.yk.util;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ykx
 * @Date: 2023/07/01/13:49
 * @Description:
 */
public class SensitiveWordBsTest {


    public static void main(String[] args) {
        String text = "强大的";
        boolean contains = SensitiveWordBs.newInstance().contains(text);
        System.out.println(contains);
    }
}
