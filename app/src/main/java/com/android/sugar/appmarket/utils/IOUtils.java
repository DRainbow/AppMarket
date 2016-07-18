package com.android.sugar.appmarket.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName: IOUtils
 * @Description:
 * @author: SugarT
 * @date: 16/7/18 下午6:44
 */
public class IOUtils {

    /**
     * 关闭流
     */
    public static boolean close(Closeable io) {
        if (io != null) {
            try {
                io.close();
            } catch (IOException e) {
                LogUtils.e(e);
            }
        }
        return true;
    }
}
