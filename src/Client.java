import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static final String Server_IP="127.0.0.1";
    private static final int Server_port=6666;
    private static BufferedReader in;



    public static void main(String[] args) throws IOException, ClassNotFoundException, UnknownHostException {

        Socket socket=new Socket(Server_IP,Server_port);//utworzenie polaczenie z serverem
        ServerCon serverConn=new ServerCon(socket);
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);


        new Thread(serverConn).start();

        while (true) {


            System.out.println(">");
            String command = keyboard.readLine();

            if (command.equals("quit")) break;


            out.println(command);


        }

        socket.close();
        System.exit(0);
    }


}
