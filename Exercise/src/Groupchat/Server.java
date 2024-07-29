package Groupchat;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket>  sockets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        while(true){
            //获得通信管道
            Socket socket = serverSocket.accept();
            sockets.add(socket);
            new ServerReaderTheard(socket).start();
        }


    }
}
