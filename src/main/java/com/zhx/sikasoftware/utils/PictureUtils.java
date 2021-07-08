package com.zhx.sikasoftware.utils;

import java.io.*;

/**
 * @method: Byte[] getPicByte(File file);
 * @description: 对图片的二进制转换
 * @param: 图片文件
 * @return: 该图片的 byte[] 二进制数组
 * @throws: IOException
 * @author: HaoXin
 * @date 2021/7/1 22:56
 */

public class PictureUtils {
    private static Byte[] bytes;
    public static Byte[] getPicByte(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        int available = is.available();
        bytes = new Byte[available];
        for (int i = 0; i < available; i++) {
            bytes[i] = (byte) is.read();
        }
        return bytes;
    }
}
