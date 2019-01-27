package com.osmeet.os.app.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yyj on 2019/01/27.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class FileUtil {

    public static final String DEFAULT_FILE_PATH = Environment.getExternalStorageDirectory()
            + File.separator;

    public static boolean saveBitmap(@NonNull Bitmap bitmap, @NonNull String filePath, @NonNull String fileName, Context context) {
        File f = new File(filePath, fileName + ".png");

        try {
            f.deleteOnExit();
            boolean c = f.createNewFile();
            if (!c) return false;
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(f);
        intent.setData(uri);
        context.sendBroadcast(intent);
        return true;
    }
}
