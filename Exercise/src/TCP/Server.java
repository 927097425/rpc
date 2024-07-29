package TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        try(
                ServerSocket serverSocket = new ServerSocket(8888);
                InputStream is = serverSocket.accept().getInputStream();
                DataInputStream dis = new DataInputStream(is);
                ){
            while (true) {

                String rs = dis.readUTF();
                System.out.println(rs);
            }

        }
    }
}
