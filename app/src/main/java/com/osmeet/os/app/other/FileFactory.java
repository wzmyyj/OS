package com.osmeet.os.app.other;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yyj on 2018/12/05. email: 2209011667@qq.com
 */

public class FileFactory {
    public static File decodeStream(String filePath,InputStream is) {
        //定义输出流和输入流
        FileOutputStream fos = null;
        //定义一个缓存区
        byte[] buf = new byte[1024];
        //获取到一个file对象
        File file = new File(filePath);
        int len;
        try {
            //获取到输出对象
            fos = new FileOutputStream(file);
            //进行读取
            while ((len = is.read(buf)) != -1) {
                //写入到文件中
                fos.write(buf, 0, len);
            }
            //刷新，将缓冲区数据写入文件
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }
}
