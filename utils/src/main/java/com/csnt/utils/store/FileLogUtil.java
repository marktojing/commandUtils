package com.csnt.utils.store;


import android.os.Build;


import com.csnt.utils.datetime.DateTimeUtil;
import com.csnt.utils.log.LogUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 */
public class FileLogUtil {
    public static void saveLog(String data, File file) {
        //然后读取文件的类容进行拼接
        addLine(file, "************************************" + "日志" +
                "**********************************************");

        addLine(file, data);

        addLine(file, "************************************" + "时间：" + DateTimeUtil.getStringDateSSS() +
                "**********************************************");
    }

    /**
     * 像文件的末尾追加一行
     *
     * @param file 需要追加的文件
     * @param line 追加的内容
     * @Author: JACK-GU
     * @Date: 2017/11/27
     * @E-Mail: 528489389@qq.comss
     */
    private static synchronized void addLine(File file, String line) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            line = line + "\n";
            fileOutputStream.write(line.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getDeviceSerialAll() {
        String s2 = "";
        if (Build.VERSION.SDK_INT >= 9) {
            s2 = Build.SERIAL;
            if (s2 == null)
                s2 = "";
        } else {
            s2 = getDeviceSerial();
        }
        return s2;
    }

    private static final String getDeviceSerial() {
        String s;
        try {
            Method method = Class.forName("android.os.Build").getDeclaredMethod("getString", new
                    Class[]{
                    Class.forName("java.lang.String")
            });
            if (!method.isAccessible())
                method.setAccessible(true);
            s = (String) method.invoke(new Build(), new Object[]{
                    "ro.serialno"
            });
        } catch (ClassNotFoundException classnotfoundexception) {
            classnotfoundexception.printStackTrace();
            return "";
        } catch (NoSuchMethodException nosuchmethodexception) {
            nosuchmethodexception.printStackTrace();
            return "";
        } catch (InvocationTargetException invocationtargetexception) {
            invocationtargetexception.printStackTrace();
            return "";
        } catch (IllegalAccessException illegalaccessexception) {
            illegalaccessexception.printStackTrace();
            return "";
        }
        return s;
    }
    public static void deleteFiles(File file,long saveTime) {
        File[] files = new File[]{};
//        File file = new File(path);
        if (file.exists()) {
            files = file.listFiles();
            if(files.length>0){
                for (File file1 : files) {
                    if(!file1.isDirectory()){
                        long time = DateTimeUtil.getLongDate()-file1.lastModified();
                        if(time/1000>saveTime){
                            boolean delete = file1.delete();
                            if(delete){
                                LogUtil.i(file1.getName()+"日志删除成功");
                            }else{
                                LogUtil.i(file1.getName()+"日志删除失败");
                            }

                        }

                    }else{
                        deleteFiles(file1,saveTime);
                    }
                }
            }

        } else {
            System.out.println("文件不存在!");
        }
    }
    public static void delDir(File file) {
        if (file.isDirectory()) {
            File zFiles[] = file.listFiles();
            for (File file2 : zFiles) {
                delDir(file2);
            }
            file.delete();
        } else {
            file.delete();
        }
    }


}
