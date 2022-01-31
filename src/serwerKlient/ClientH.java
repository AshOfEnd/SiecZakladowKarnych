package serwerKlient;

import GUI.StartWindow;
import aktywnoscWiezien.*;
import pracownicy.*;
import wyposazenie.*;

import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientH  implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientH> clients;
    private ArrayList<String> imiona;
    private ObjectOutputStream objectOutputStream;
    private StartWindow startWindow;
    private List<Lekarz>messages=new ArrayList<>();


////////////////////////////////////////////////////////////
    private List<Wiezien> wiezniowie=new ArrayList<>();
    private List<Skargi> skargi=new ArrayList<>();
    private List<Pracownik> pracownicy=new ArrayList<>();
    private List<Wiezien> praca=new ArrayList<>();
    private List<Wiezien> KursUczestnicy=new ArrayList<>();
    private List<Kurs> listaKursow=new ArrayList<>();
    private List<Zamowienie> listaZamowien=new ArrayList<>();
    private List<Produkt> listaProdoktow=new ArrayList<>();
    private List<Kurs> ListaKursow=new ArrayList<>();
    private List<Praca> listaPrac=new ArrayList<>();
    private List<Raport>listaRaportow=new ArrayList<>();
    private List<ZgloszenieUsterki> listaZgloszonychUsterek=new ArrayList<>();
    private List<Lek> leki=new ArrayList<>();
    //////////////////////////////////////////////////////////
    private String log;
    private StartWindow a;

    public ClientH(Socket clientSocket, ArrayList<ClientH> clients,ArrayList<String> imiona ,StartWindow a) throws IOException, ClassNotFoundException
    {
        this.imiona=imiona;
        this.clients=clients;
        this.client=clientSocket;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream(),true);

        this.startWindow=a;

    }
    String dwie(){
        String s="dzialaj kurwo";
      return s;
    }
    @Override
    public void run() {
            Placowka plac=new Placowka();
        try {

                    //   String command=keyboard.readLine();


                    while(true) {
                        out.println("wybierz placowke:");
                        out.println("1. Placowka w Krakowie");
                        out.println("1. Placowka w Warszawie");
                        out.println("1. Placowka w Poznaniu");
                        String placowka = in.readLine();
                        if (placowka.contains("1")) {
                            while (true) {


                                String log = "aaa";
                                String pass = "0000";
                                out.println("[[ZK W KRAKOWIE]]");
                                out.println("zaloguj sie ");
                                out.println("login");
                                String login = in.readLine();
                                out.println("haslo");
                                String haslo = in.readLine();
                                if(login.equals("0") || haslo.equals("0"))
                                {
                                    break;
                                }
                                if (login.equals(log) && haslo.equals(pass)) {
                                    out.println("udalo ci sie zalogowac!");
                                    while (true) {
                                        String command = in.readLine();
                                        if (command.equals("help")) {
                                            out.println("zbior dostepnych komend:");
                                            out.println("sss");
                                            out.println("zzz");
                                            out.println("yyy");
                                            out.println("kliknij 0 aby sie wylogowac");
                                        }
                                        if (command.equals("ggg")) {
                                            StartWindow a=new StartWindow();
                                            a.setVisible(true);
                                            out.println("huj");
                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        }
                                        if (command.equals("zzz")) {
                                            out.println("huj2");
                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        }
                                        if (command.equals("0")) {
                                            out.println("wylogowywanie...");
                                            break;
                                        }
                                        if(command.startsWith("say"))
                                        {
                                            int firtsSpace=command.indexOf(" ");
                                            if(firtsSpace!=-1)
                                            {
                                                outToAll(command.substring(firtsSpace+1));
                                            }



                                        }

                                    }
                                } else {
                                    out.println("zle haslo lub login, sprobuj ponownie");
                                    continue;
                                }
                            }

                        }
                    }

                /*
              else if (request.contains("lgoowanie")) {
                    out.println("podaj login");

                    String x = in.readLine();
                    if (x.equals("1234")) {

                        while (true) {
                            String z = in.readLine();
                            if (z.equals("d")) {
                                for (int i = 0; i < imiona.size(); i++) {
                                    out.println(imiona.get(i));
                                }
                            }
                            if (z.equals("x")) {
                                out.println("[S] podaj imie:");
                                String imie = in.readLine();
                                imiona.add(imie);
                                out.println("[S] dodano imie: " + imie);
                            }
                        }

                    } else if (x.equals("0001")) {
                        out.println("kotno: dupa");
                        while (true) {
                            String z = in.readLine();
                            if (z.equals("d")) {
                                for (int i = 0; i < imiona.size(); i++) {
                                    out.println(imiona.get(i));
                                }
                            }
                            if (z.equals("x")) {
                                out.println("[S] podaj imie:");
                                String imie = in.readLine();
                                imiona.add(imie);
                                out.println("[S] dodano imie: " + imie);
                            }
                        }

                    } else if (x.equals("0010")) {
                        out.println("kotno: magazynier");
                        while (true) {

                            String z = in.readLine();
                            if (z.equals("d")) {
                                for (int i = 0; i < imiona.size(); i++) {
                                    out.println(imiona.get(i));
                                }
                            }
                            if (z.equals("x")) {
                                out.println("[S] podaj imie:");
                                String imie = in.readLine();
                                imiona.add(imie);
                                out.println("[S] dodano imie: " + imie);
                            }
                        }

                    }


                }

                 */




                    //else if(request.contains(""))

                /*
                {
                    out.println("na jakie konto chcesz sie zalogowac?");
                    out.println("pracownicy.Wychowawca ");
                    out.println("pracownicy.Naczelnik ");
                    out.println("pracownicy.Magazynier ");
                    out.println("pracownicy.Lekarz ");
                    out.println("pracownicy.Kucharz ");
                    out.println("pracownicy.Konserwator ");
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
                         //   objectOutputStream.writeObject(new pracownicy.Wychowawca("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("pracownicy.Naczelnik"))
                    {
                        String haslo="swiat";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new pracownicy.Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("pracownicy.Magazynier"))
                    {
                        String haslo="i";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new pracownicy.Lekarz("Jacek","kowalski"));
                        }
                    }
                    if(login.contains("pracownicy.Lekarz"))
                    {
                        String haslo="szczesliwego";
                        out.println("podaj haslo");
                        String s=in.readLine();
                        if(s.contains(haslo))
                        {
                            out.println("logowanie");
                            objectOutputStream.writeObject(new pracownicy.Lekarz("Jacek","kowalski"));
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
                            objectOutputStream.writeObject(new pracownicy.Lekarz("Jacek","kowalski"));
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
                            objectOutputStream.writeObject(new pracownicy.Lekarz("Jacek","kowalski"));
                        }
                    }

                }
                */


        }catch (IOException e) {
            System.err.println("IOX ");
            System.err.println(e.getStackTrace());

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
