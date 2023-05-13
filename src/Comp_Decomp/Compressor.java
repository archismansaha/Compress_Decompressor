package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file,String fname) throws IOException {

        String fileDirectory=file.getParent();
        String gzipFile=fileDirectory+"/"+fname+".gz";
        System.out.print(file);
        FileInputStream fis=new FileInputStream(file.getAbsolutePath());
        FileOutputStream fos=new FileOutputStream(gzipFile);
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        byte []buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();

    }

    public static void main(String []args)throws IOException{

    }
}