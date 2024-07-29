package Train.Final.Problem5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;



public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6060);
        Properties Users = new Properties();
        String dir = "src\\Train\\Final\\Problem5\\UserList.properties";
        File f = new File(dir);
        if(!f.exists())f.createNewFile();
        Users.load(new FileReader(f));
        Socket socket = serverSocket.accept();
        while(true){
            try{
                System.out.println("接收信息成功");
                InputStream is  = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                String msg = dis.readUTF();
                if(AnalysisMsg(Users,msg))Response(socket,"T");
                else Response(socket,"F");
                System.out.println(msg);
            }catch (Exception e){
                System.out.println(e);
                System.out.println("客户端下线");
                serverSocket.close();
                break;
            }
        }

    }

    private static void Response(Socket socket, String t) {
        try{
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            if(t.equalsIgnoreCase("T"))dos.writeUTF("T");
            else dos.writeUTF("F");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("响应出错");
        }
    }



    private static boolean AnalysisMsg(Properties users, String msg) throws Exception {
        String[] msgs = msg.split("\n");

        String account = msgs[1].split("=")[1];
        String password = msgs[2].split("=")[1];

        if(msgs[0].equals("0"))return regiest(users,account,password);
        else if(msgs[0].equals("1")) return sign(users,account,password);
        else return false;
    }

    private static boolean sign(Properties users, String account, String password) throws Exception {

        if(!users.containsKey(account))return false;
        if(users.get(account).equals(password)) return true;
        return false;
    }

    private static boolean regiest(Properties users, String account, String password) throws Exception {
        if(!users.containsKey(account))users.put(account,password);
        else return false;

        Writer w = new FileWriter("src\\Train\\Final\\Problem5\\UserList.properties");
        users.store(w,"------------用户信息----------");
        return true;
    }

}
