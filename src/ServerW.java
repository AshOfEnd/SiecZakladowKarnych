import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerW {
    private static ArrayList <ClientH> clients=new ArrayList<>();
    private static ArrayList <String> imiona=new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    private static final int PORT=9090;
    public static void main(String[] args) throws IOException {
       // List<String> lista=new ArrayList<>();
        ServerSocket listenner=new ServerSocket(PORT);
        while(true) {
            System.out.println("[S] oczekiwanie na polaczenie...");
            Socket client = listenner.accept();
            System.out.println("[S] polaczono!");
            ClientH clientThread=new ClientH(client, clients,imiona);
            clients.add(clientThread);
            pool.execute(clientThread);
        }
        //PrintWriter out=new PrintWriter(client.getOutputStream(),true);
      //  BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
      //  BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));

    }
}
