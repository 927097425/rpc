package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket();

        try {
            while(true) {
                System.out.print("请输入要发送的内容：");
                String msg = sc.nextLine();
                if (msg.equalsIgnoreCase("exit"))break;
                byte[] bytes = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6667);
                socket.send(packet);

            }
        } finally {
            socket.close();
        }

    }
}
