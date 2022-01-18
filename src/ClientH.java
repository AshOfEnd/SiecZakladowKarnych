import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientH implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientH> clients;
    private ArrayList<String> imiona;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream is;
    private List<Lekarz>messages=new ArrayList<>();
    private List<Pracownik> pracownicy=new ArrayList<>();

    private ArrayList<Placowka> placowki = new ArrayList<>();

    public ClientH(Socket clientSocket, ArrayList<ClientH> clients,ArrayList<String> imiona,ObjectOutputStream outStream,ObjectInputStream inStream) throws IOException, ClassNotFoundException
    {
        this.imiona=imiona;
        this.clients=clients;
        this.client=clientSocket;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream(),true);
        this.objectOutputStream=outStream;
        this.is=inStream;

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

                }else if(request.contains("wyslij"))
                {
                    out.println("rozpoczynam tworzenie tunelu..");
                    out.println("zakonczono");
                    messages.add(new Lekarz("siema","gierczak"));
                    objectOutputStream.writeObject(messages);




                }else if(request.contains("prosba"))
                {
                    out.println("dodaj");
                    pracownicy=(List<Pracownik>) is.readObject();
                    System.out.println("dodano nowego pracownika!");
                    for(int i=0;i< pracownicy.size();i++)
                    {
                      out.println("lista pracownikow"+i+" "+ pracownicy.get(i));
                    }
                }

                else if(request.contains("dodaj_placowke"))
                {
                    out.println("dodaje nowa placowke");
                    placowki.add(new Placowka());
                }

                else if(request.contains("dodaj_izolatke"))
                {
                    out.println("dodaje nowa izolatke");

                }
                else if(request.contains("dodaj_konserwatora"))
                {
                    out.println("dodaje nowego konserwatora");

                }
                else if(request.contains("dodaj_kucharza"))
                {
                    out.println("dodaje nowego kucharza");

                }
                else if(request.contains("dodaj_lekarza"))
                {
                    out.println("dodaje nowego lekarza ");

                }
                else if(request.contains("dodaj_naczelnika"))
                {
                    out.println("dodaje nowego naczelnika ");

                }
                else if(request.contains("dodaj_wieznia"))
                {
                    out.println("dodaje nowego wieznia");

                }
                else if(request.contains("dodaj_wychowawce"))
                {
                    out.println("dodaje nowego wychowace ");

                }




                    //else if(request.contains(""))

                /*
                {
                    out.println("na jakie konto chcesz sie zalogowac?");
                    out.println("Wychowawca ");
                    out.println("Naczelnik ");
                    out.println("Magazynier ");
                    out.println("Lekarz ");
                    out.println("Kucharz ");
                    out.println("Konserwator ");
                    OutputStream outputStream = client.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                        String login=in.readLine();
                    if(login.contains("wychowawca"))
                    {
                        String haslo="wesolych";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                         //   objectOutputStream.writeObject(new Wychowawca("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("Naczelnik"))
                    {
                        String haslo="swiat";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("Magazynier"))
                    {
                        String haslo="i";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("Lekarz"))
                    {
                        String haslo="szczesliwego";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("kucharz"))
                    {
                        String haslo="nowego";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("konserwator"))
                    {
                        String haslo="roku";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new Lekarz("Jacek","kowalski"));
                        }
                    }

                }
                */

            }
        }catch (IOException e) {
            System.err.println("IOX ");
            System.err.println(e.getStackTrace());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
