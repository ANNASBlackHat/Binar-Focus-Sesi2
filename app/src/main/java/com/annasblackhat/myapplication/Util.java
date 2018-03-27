package com.annasblackhat.myapplication;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
    public static void appendLog(String text) {
        File externalStorageDir = Environment.getExternalStorageDirectory();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy_MM_dd");
        String parent = externalStorageDir+"/MyApp/"+sdfDay.format(new Date());
        String date = new SimpleDateFormat("MMdd").format(new Date());
        File logFile = new File(parent,"log_myapp_"+date+"_"+cal.get(Calendar.HOUR_OF_DAY)+".txt");
        if(!new File(parent).exists()){
            new File(parent).mkdirs();
        }
        if (!logFile.exists())
        {
            try {
                logFile.createNewFile();
            }catch (IOException e) {
                System.out.println("create new file error : "+e);
            }
        }

        try{
            SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append("\n"+sdf.format(new Date()) + " : " +text);
            buf.newLine();
            buf.close();
        }catch (IOException e) {
            System.out.println("append log error "+e);
        }
    }
}
