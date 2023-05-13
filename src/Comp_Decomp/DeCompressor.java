package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class DeCompressor {
    public  static void method(File file,String fname) throws IOException{
        String fileDirectory=file.getParent();
        String gzipFile=fileDirectory+"/new_"+fname.substring(0,fname.indexOf(".gz"));
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(gzipFile);
        byte []buffer=new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException{

    }
}
