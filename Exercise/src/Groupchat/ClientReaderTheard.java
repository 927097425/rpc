package Groupchat;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ClientReaderTheard  extends  Thread{
    Socket socket;
    public ClientReaderTheard(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("读取信息出错");
        }
    }
}
