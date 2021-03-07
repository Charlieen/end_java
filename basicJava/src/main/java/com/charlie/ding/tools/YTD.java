package com.charlie.ding.tools;



import java.io.File;
import java.net.URL;
import com.github.axet.vget.VGet;

/**
 *
 * @author Manindar
 */
public class YTD {

    public static void main(String[] args) {
        try {

            String url = "http://www.youtube.com/watch?v=fNk_zzaMoSs";

            String path = "/Users/dzgygmdhx/Downloads/";
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}