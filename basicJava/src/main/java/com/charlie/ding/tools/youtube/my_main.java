package com.charlie.ding.tools.youtube;

import java.io.*;
import java.net.URL;

public class my_main {
    
    public static void test1(){
        String download_path="/Users/dzgygmdhx/Downloads/";
        String url="https://www.youtube.com/watch?v=fNk_zzaMoSs";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl "+url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {

        String FILE_URL="https://archive.org/download/MIT6.0001F16/MIT6_0001F16_Lecture_01_300k.mp4";
        String FILE_NAME="/Users/dzgygmdhx/Downloads/demo.mp4";


        try (
                BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)
        ) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }


    }
}
