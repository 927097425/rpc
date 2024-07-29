package Train.Final.Problem3;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws Exception {
        try(
                InputStream is = new FileInputStream("src\\Train\\Final\\Problem3\\系统菜单.txt");
                OutputStream os = new FileOutputStream("src\\Train\\Final\\Problem3\\系统菜单2.txt");
        ) {

            byte[] text = is.readAllBytes();
            String system_list = new String(text);
            System.out.println(system_list);
            String[] system_List = system_list.split("\n");
            Arrays.stream(system_List).sorted((o1, o2) -> o1.compareTo(o2)).forEach(s-> {
                try {
                    os.write(s.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        }catch (Exception e){
            throw e;
        }

    }
}
