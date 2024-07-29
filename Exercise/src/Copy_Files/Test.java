package Copy_Files;

import java.io.*;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

        String name = "Text1";
        String Start = "D:\\java_code";
        search_copy(Start,name);
//        InputStream is = new FileInputStream("src\\Copy_Files\\Text1\\Hello.txt");
//
//        byte[] buffer = is.readAllBytes();
//        System.out.println(new String(buffer));
//        is.close();
//        File f = new File("src\\Copy_Files\\Copy");
//        if (!f.exists()) f.mkdir();
//        System.out.println(f.delete());
        //OutputStream os = new FileOutputStream("src\\Copy_Files\\Copy\\Hello.docx");

//        os.write(buffer);
//
//        os.close();

    }

    public static boolean search_copy(String start,String target) throws Exception {
        File f = new File(start);
        if(!f.exists()||f.isFile()) return false;
        if(!f.getName().contains(target)){
            String[] ListOfFile = f.list();
            for(String FL:ListOfFile){
                if(search_copy(start+"\\"+FL,target)) break;
            }
        }
        else {
            File cur = new File(start);
            File copy = new File(start + "\\..\\Copy");
            if (!copy.exists()) copy.mkdir();
            for (String Lst : cur.list()) {
                InputStream is = new FileInputStream(start + "\\" + Lst);
                OutputStream os = new FileOutputStream(copy + "\\" + Lst);
                byte[] data = is.readAllBytes();
                os.write(data);
                os.close();
                is.close();
            }

            return true;
        }
        return false;


    }

}
