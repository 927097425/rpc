package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket=new DatagramSocket(8888);;
        try {
            byte[] buffer = new byte[1024*64];

            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            System.out.println("------服务器启动--------");
            while (true) {
                socket.receive(packet);
                int len = packet.getLength();
                String rs = new String(buffer,0,len);
                System.out.println(rs);
            }
        } finally {
            socket.close();
        }

    }
}
