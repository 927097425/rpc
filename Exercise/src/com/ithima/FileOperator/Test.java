package com.ithima.FileOperator;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File f1 = new File("src\\com\\ithima\\FileOperator\\Text1.txt");
        File f2 = new File("src\\com\\ithima\\FileOperator\\Text2.txt");
        try(
                InputStream is = new FileInputStream(f2);
             //   InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream(f2,true);

             //   OutputStream bos= new BufferedOutputStream(os);
                //FileReader
                //FileWriter
//                Reader r = new FileReader(f2);
//                Writer w = new FileWriter(f2);
                //BUfferedReader
                //BufferedWriter
//                Reader br = new BufferedReader(r);
//                Writer bw = new BufferedWriter(w);
                //InputStreamReader
                //OutputStreamWriter
                Reader isr = new InputStreamReader(is);
                Writer osw = new OutputStreamWriter(os);

                //printStream
                //printWriter

                //DataInputStream
                //DataOutputstream
                ){
            os.write(75);
            osw.write("你好中国");
            osw.flush();
            os.write("你好".getBytes());
            os.write("\r\n".getBytes());
//            osw.write("\r\n");
            byte[] buffer = new byte[1024*8];
            int len  = 0;

            while((len = is.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len));
            }

//            os.write(75);
//            osw.write("你好中国");
//            os.write("你好".getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
