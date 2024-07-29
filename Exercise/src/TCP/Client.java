package TCP;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        try(
                Socket socket = new Socket("127.0.0.1",8888);
                OutputStream os = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
        ){
                while(true){
                    Scanner sc = new Scanner(System.in);
                    System.out.print("请输入要发送的数据");
                    String msg = sc.nextLine();
                    dos.writeUTF(msg);
                }

        }catch (Exception e){
                throw e;
        }
    }
}
