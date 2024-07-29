package Train.Final.Problem5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1",6060);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("---------菜单------------");
            System.out.println("--------0.注册------------");
            System.out.println("--------1.登录------------");
            System.out.println("--------exit------------");
            System.out.print("请输入要执行的功能编号:");
            String chose = sc.nextLine();
            if(chose.equalsIgnoreCase("0"))Regiest(socket,sc);
            else if(chose.equalsIgnoreCase("1"))sign(socket,sc);
            else if(chose.equalsIgnoreCase("exit")){
                System.out.println("退出程序");
                socket.close();
                break;
            }
            else System.out.println("您输入的功能有误");
        }
    }

    private static void sign(Socket socket, Scanner sc) throws Exception {
        System.out.println("请输入账号");
        String acount = sc.nextLine();
        System.out.println("请输入密码");
        String Password = sc.nextLine();
        sent_msg(socket,acount,Password,1);
        if(wait_response(socket)){
            System.out.println("恭喜您登录成功");
        }else{
            System.out.println("您输入的账号或密码错误");
        }
    }

    private static void Regiest(Socket socket, Scanner sc) throws Exception {
        System.out.println("请输入账号");
        String acount = sc.nextLine();
        System.out.println("请输入密码");
        String Password = sc.nextLine();
        sent_msg(socket,acount,Password, 0);
        if(wait_response(socket)){
            System.out.println("恭喜您注册成功");
        }else{
            System.out.println("您输入的账号已重复");
        }
    }


    private static boolean wait_response(Socket socket) throws Exception {
        try{
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            String msg = dis.readUTF();
            if(msg.equalsIgnoreCase("T")) return true;

        }catch (Exception e){
            System.out.println(e);
            System.out.println("等待响应出错");
            socket.close();
        }
        return false;
    }

    public  static void sent_msg(Socket socket , String acount, String Password, int menu) throws Exception {
        try{
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(menu+"\n账号="+acount+"\n密码="+Password);
            System.out.println("发送注册信息成功");
            dos.flush();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("发送信息出错");
            socket.close();
        }
    }
}
