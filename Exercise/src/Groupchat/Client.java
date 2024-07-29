package Groupchat;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",8888);
        new ClientReaderTheard(socket).start();
        try{
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            while(true){
                System.out.println("请发送信息：");
                Scanner sc = new Scanner(System.in);
                String msg = sc.nextLine();
                dos.writeUTF(msg);

            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
        }
    }
}
