package com.ru.javaExam.nio;

import java.nio.CharBuffer;

/**
 * Description:    新io流字符缓冲区例子
 * User: NanChengRu
 * Date: 13-11-11
 * Time: 上午10:14
 * JDK: 1.6
 * version: 1.0
 */
public class CharBufferExam {
    public static void main(String[] args){
        CharBuffer cb = CharBuffer.allocate(10);

        System.out.println("字符缓冲区的容量：" + cb.capacity());
        System.out.println("字符缓冲区的限制位置：" + cb.limit());

    }
}
