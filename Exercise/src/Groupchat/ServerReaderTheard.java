package Groupchat;

import java.io.*;
import java.net.Socket;

public class ServerReaderTheard extends Thread{
    Socket socket;
    public ServerReaderTheard(Socket socket){
        this.socket  = socket;
    }

    @Override
    public void run() {
        try{
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
                SentMsg2All(msg);

            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("有设备离线了");
            Server.sockets = Server.sockets.stream().filter(s->!s.getRemoteSocketAddress().equals(this.socket.getRemoteSocketAddress())).toList();
        }
    }
    private void SentMsg2All(String msg) throws Exception {
        Server.sockets.stream().filter(soc->!soc.getRemoteSocketAddress().equals(this.socket.getRemoteSocketAddress())).forEach(soc->{

            try{
                OutputStream os = soc.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(msg);
                dos.flush();

            }catch (Exception e){
                System.out.println(e);
                System.out.println("群发消息出错");
            }
        });

    }
}
