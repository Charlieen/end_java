package com.charlie.ding.tools;

import com.charlie.ding.tools.mysql.DBHelper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdfToMysql {

   private DBHelper dbHelper;

   public PdfToMysql(){
       this.dbHelper= new DBHelper();
   }

    private List<String> getDataFromPDF(String path) {

        byte[]  file= new byte[0];
        String context ="";
        String [] test = {};
        List<String> data = new ArrayList<>();
        try {
            file = FileUtils.readFileToByteArray(new File(path));
            context = ParseText.getTextFormPDF(file);
            test = context.split("\\\n");
            data =Arrays.asList(test);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return data;
    }

    public static void main(String[] args) {
       PdfToMysql pdfToMysql = new PdfToMysql();
       String path="/Users/dzgygmdhx/Desktop/cinuse.pdf";
       List<String> data = pdfToMysql.getDataFromPDF(path);
        try {
            pdfToMysql.dbHelper.preInsert(data);
            pdfToMysql.dbHelper.insertData();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }


    }
}
