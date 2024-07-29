package BSstructure;


import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket =  new ServerSocket(64748);
        System.out.println("本服务器ip"+ InetAddress.getLocalHost() +":"+serverSocket.getLocalPort());
        ThreadPoolExecutor pool = new ThreadPoolExecutor(24,24,0, TimeUnit.SECONDS,new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("本服务器ip"+ InetAddress.getLocalHost() +":"+socket.getLocalPort());
            pool.execute(new ServerTheard(socket));
        }
    }
}
