import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientH implements Runnable{
   private Socket client;
   private BufferedReader in;
   private PrintWriter out;
   private ArrayList<ClientH> clients;
   private ArrayList<String> imiona;
   public ClientH(Socket clientSocket, ArrayList<ClientH> clients,ArrayList<String> imiona) throws IOException
   {
      this.imiona=imiona;
       this.clients=clients;
       this.client=clientSocket;
       in=new BufferedReader(new InputStreamReader(client.getInputStream()));
       out=new PrintWriter(client.getOutputStream(),true);
   }
    @Override
    public void run() {

        try {
            while (true) {
                String request = in.readLine();
                //   String command=keyboard.readLine();
                if(request.startsWith("say"))
                {
                    int firtsSpace=request.indexOf(" ");
                    if(firtsSpace!=-1)
                    {
                        outToAll(request.substring(firtsSpace+1));
                    }

                }else if(request.contains("lista")){
                    for(int i=0;i<clients.size();i++) {
                        out.println(clients.get(i));
                    }
                }else if(request.contains("imie"))
                {
                    out.println("[S] podaj imie:");
                    String imie=in.readLine();
                    imiona.add(imie);
                    out.println("[S] dodano imie: "+imie);
                }else if(request.contains("podajim"))
                {
                    for(int i=0;i<imiona.size();i++)
                    {
                        out.println(imiona.get(i));
                    }
                }else if(request.contains("usunim"))
                {
                    out.println(" podaj index ktory chcesz usunac:");
                    for(int i=0;i<imiona.size();i++)
                    {
                        out.println(i+" "+imiona.get(i));
                    }
                    String usun=in.readLine();
                    int usun1=Integer.parseInt(usun);
                    imiona.remove(usun1);
                    out.println("usunieto rekord: "+usun);
                    for(int i=0;i<imiona.size();i++)
                    {
                        out.println(imiona.get(i));
                    }

                }

            }
        }catch (IOException e) {
            System.err.println("IOX ");
            System.err.println(e.getStackTrace());

        }
        finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("IOX close ");

            }
        }
    }
    private void outToAll(String msg){
       for(ClientH aClients:clients){
           aClients.out.println(msg);
       }
    }
}
