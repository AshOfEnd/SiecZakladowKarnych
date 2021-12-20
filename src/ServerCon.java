import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerCon implements Runnable{
    private Socket server;
    private BufferedReader in;

public ServerCon(Socket s) throws IOException {
    server =s;
    in=new BufferedReader(new InputStreamReader(server.getInputStream()));

}
    @Override
    public void run() {


            try {
                while(true) {
                    String serverResponse = in.readLine();
                    System.out.println("[S]>> " + serverResponse);
                    if(serverResponse=="koniec") break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    }
}
