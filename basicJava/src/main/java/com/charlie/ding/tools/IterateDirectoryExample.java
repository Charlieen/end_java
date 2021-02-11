package com.charlie.ding.tools;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class IterateDirectoryExample {

    public static  void ChangeFileName(){
        String dirLocation = "/Users/dzgygmdhx/Desktop/srtToTxt/lyb";

        try {
             Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .forEach(file->{
                        String temp = file.getName();
                        String newName=temp.substring(temp.indexOf("Nirvana"), temp.indexOf("Nirvana")+"Nirvana In Fire Ep16".length());;
                        file.renameTo(new File(dirLocation+"/"+newName+".txt"));
                    });
                    ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readPPTXToTxt(){

        String dirLocation = "/Users/dzgygmdhx/Desktop/2021/english/zhiyuxi/geng";

        try {
            List<String> files = Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .map(File::getPath)
                    .collect(Collectors.toList());

            for(int i=0;i<files.size();i++){
                try {
                    String f= files.get(i);
                    String context =  ParseText.getTextFromPPT2007(FileUtils.readFileToByteArray(new File(f.toString())));
                    String fileName = f.toString().replace(".pptx",".txt");
                    Thread.sleep(500);

                    try {
                        writeStringToTxt(fileName,context);
                        }catch(Exception e){
                        System.out.println(e.toString());
                    }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            files.forEach(f->{
//                try {
//                    String context =  ParseText.getTextFromPPT2007(FileUtils.readFileToByteArray(new File(f.toString())));
//                    String fileName = f.toString().replace(".pptx",".txt");
//                    Thread.sleep(1000);
//                    writeStringToTxt(fileName,context);
//                } catch (IOException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });

        } catch (IOException e) {
            // Error while reading the directory
        }
    }

    public static void readXLSXToTxt(){

        String dirLocation = "/Users/dzgygmdhx/Desktop/2021/english/zhiyuxi/geng/homework";

        try {
            List<String> files = Files.list(Paths.get(dirLocation))
                    .map(Path::toFile)
                    .map(File::getPath)
                    .collect(Collectors.toList());

            for(int i=0;i<files.size();i++){
                try {
                    String f= files.get(i);
                    String context =  ParseText.getTextFromExcel2007(FileUtils.readFileToByteArray(new File(f.toString())));
                    context = context.replace("null","____");
                    String fileName = f.toString().replace(".xlsx",".txt");
                    Thread.sleep(500);

                    try {
                        writeStringToTxt(fileName,context);
                    }catch(Exception e){
                        System.out.println(e.toString());
                    }

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            files.forEach(f->{
//                try {
//                    String context =  ParseText.getTextFromPPT2007(FileUtils.readFileToByteArray(new File(f.toString())));
//                    String fileName = f.toString().replace(".pptx",".txt");
//                    Thread.sleep(1000);
//                    writeStringToTxt(fileName,context);
//                } catch (IOException | InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });

        } catch (IOException e) {
            // Error while reading the directory
        }
    }

    public static void writeStringToTxt(String fileName, String context)
            throws IOException {
        String str = context;
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
    }

    public static void main(String[] args) {
       // readPPTXToTxt();
      //  readXLSXToTxt();

//        String ss="(English)【ENG SUB】《琅琊榜》第1集  Nirvana In Fire Ep32 【超清】 欢迎订阅China Zone （胡歌_王凯_吴磊_刘涛_刘敏涛）_video_id_D13EhOAhCrA.srt";
//        System.out.println(ss.indexOf("Nir"));
//        System.out.println("Nirvana In Fire Ep1".length());
//        String newName=ss.substring(ss.indexOf("Nirvana"), ss.indexOf("Nirvana")+"Nirvana In Fire Ep16".length());
//        System.out.println(newName);

        ChangeFileName();
    }
}