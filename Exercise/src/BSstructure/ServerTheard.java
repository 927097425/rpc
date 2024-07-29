package BSstructure;



import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTheard implements Runnable{
    Socket socket;
     public ServerTheard(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);

            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println(); // 必须换行
            ps.println("<div style='color:red;font-size:120px;text-align:center'>黑马程序员66<div>");

            ps.close();
            socket.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("处理网页请求出错");
        }
    }
}
