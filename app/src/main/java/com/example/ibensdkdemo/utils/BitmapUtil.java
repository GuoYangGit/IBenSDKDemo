package com.example.ibensdkdemo.utils;
/***
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;

import com.samton.ibensdk_common.utils.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/***
 *
 *   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝
 *  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝
 *  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 *  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 *           ░     ░ ░      ░  ░
 *
 * Created by guoyang on 2020/11/20.
 * github https://github.com/GuoYangGit
 * QQ:352391291
 */
public class BitmapUtil {

    public static Bitmap decodeToBitMap(byte[] date) {
        return decodeToBitMap(date, 640, 480);
    }

    public static Bitmap decodeToBitMap(byte[] data, int width, int height) {
        if (data == null) {
            return null;
        } else {
            try {
                YuvImage image = new YuvImage(data, 17, width, height, (int[]) null);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                image.compressToJpeg(new Rect(0, 0, width, height), 80, stream);
                Bitmap bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());
                stream.close();
                return bmp;
            } catch (Exception var6) {
                var6.printStackTrace();
                return null;
            }
        }
    }

    public static String saveBitmapToSd(Bitmap bitmap) {
        String imgPath = Environment.getExternalStorageDirectory().getPath() + "/IBenService/Images/";
        if (FileUtils.createOrExistsDir(imgPath)) {
            imgPath = imgPath + "image.jpeg";
        }
        try {
            File file = new File(imgPath);
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return imgPath;
        } catch (IOException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
