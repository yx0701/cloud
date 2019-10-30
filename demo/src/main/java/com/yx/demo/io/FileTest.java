package com.yx.demo.io;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/yangxiao/Desktop/a.txt");

        //字节流
        FileInputStream fi  = new FileInputStream(file);
        FileOutputStream os = new FileOutputStream(file);

        //字符流
        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file);

        //字节缓冲流
        BufferedInputStream bi  = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(file));
        //字符缓冲流
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        br.readLine();

        //转换流  字节转字符流
        InputStreamReader ir  = new InputStreamReader(new FileInputStream(file));
        OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(file));

    }
}
