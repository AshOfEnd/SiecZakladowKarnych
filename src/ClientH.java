import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientH implements Runnable {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientH> clients;
    private ArrayList<String> imiona;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream is;


    private List<Pracownik>PracownikWarszawa=new ArrayList<>();
    private List<Pracownik>PracownikKrakow=new ArrayList<>();
    private ArrayList<Wiezien> wiezniowieZabrze;
    private ArrayList<Wiezien> wiezniowieWarszawa;
    private ArrayList<Wiezien> wiezniowieKrakow;
    private ArrayList<Pracownik>pracownikWarszawa;
    private ArrayList<Pracownik>pracownikKrakow;
    private ArrayList<Pracownik>pracownikZabrze;

    private List<Placowka> placowka=new ArrayList<>();
////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////
    private ArrayList<Placowka> placowki = new ArrayList<>();
    private String log;

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
    String dwie(){
        String s="dzialaj kurwo";
      return s;
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



                    else if (request.contains("start")) {
                        out.println("1. Zaklad Karny w Zabrzu");
                        out.println("2. Zaklad Karny w Warszawie");
                        out.println("3. Zaklad karny w Krakowie");
                        out.println("4. Stworz nowy Zaklad Karny");
                        String wybierz = in.readLine();
                        if(request.contains("2"))
                        {
                            Placowka Warszawa=new Placowka( wiezniowieWarszawa=new ArrayList<>(),pracownikWarszawa=new ArrayList<>());
                        }
                        else if(request.contains("1")){
                            Placowka Warszawa=new Placowka( wiezniowieZabrze=new ArrayList<>(),pracownikZabrze=new ArrayList<>());
                        }
                        else if(request.contains("3")){
                            Placowka warszawa=new Placowka( wiezniowieKrakow=new ArrayList<>(),pracownikKrakow=new ArrayList<>());
                            out.println("[[wybrales Zaklad Karny w Warszawie!]]");
                            out.println("[[wpisz login aby zalogowac sie do systemu]]");
                            String x = in.readLine();
                            if (x.equals("0000")) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                out.println("[NACZELNIK]");
                                while (true) {
                                    out.println("OPCJE:");
                                    out.println("1. wyswietl wiezni");
                                    out.println("2. wyswietl pracownikow");
                                    out.println("3. wyswietl skargi");
                                    out.println("4. wyswietl raporty");
                                    out.println("5. wyswietl zgloszone usterki");
                                    out.println("q. dodaj wieznia");
                                    out.println("w. dodaj pracownika");
                                    out.println("e. dodaj do listy transferowej");
                                    String z = in.readLine();
                                    if (z.equals("1")) {
                                        for (int i = 0; i < warszawa.getListaWiezniow().size(); i++) {
                                            out.println("index: "+i+" "+warszawa.getListaWiezniow().get(i).getImie()+" "+warszawa.getListaWiezniow().get(i).getNazwisko()+"  ranga:"+warszawa.getListaWiezniow().get(i).getKlasa());
                                            out.println("details:  "+warszawa.getListaWiezniow().get(i).getWiek()+"  data zwolnienia: "+warszawa.getListaWiezniow().get(i).getDataZwolnienia());
                                        }
                                    }
                                    if (z.equals("2")) {
                                        for (int i = 0; i < warszawa.getListaPracownikow().size(); i++) {
                                            out.println("index: "+i+" "+warszawa.getListaPracownikow().get(i).getImie()+" "+warszawa.getListaPracownikow().get(i).getNazwisko()+"  nazwisko:"+warszawa.getListaPracownikow().get(i).getNazwisko());

                                        }
                                    }
                                    if (z.equals("3")) {
                                        for (int i = 0; i < warszawa.getListaPracownikow().size(); i++) {
                                            out.println("index: "+i+" "+warszawa.getListaSkarg().get(i)+" "+warszawa.getListaPracownikow().get(i).getNazwisko()+"  nazwisko:"+warszawa.getListaPracownikow().get(i).getNazwisko());

                                        }
                                    }
                                }

                            }
                        }
                    else if (request.contains("lgoowanie")) {
                            out.println("podaj login");

                            String x = in.readLine();
                            if (x.equals("1234")) {
                                out.println("kotno: chuj");
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
                  //  pracownicy=(List<Pracownik>) is.readObject();
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
                    out.println("dodajkon");
                  //  pracownicy=(List<Pracownik>) is.readObject();
                    System.out.println("dodano nowego pracownika!");
                    out.println("dodaje nowego konserwatora");

                }
                else if(request.contains("dodaj_kucharza"))
                {
                   out.println("podaj imie: ");
                    String imie=in.readLine();
                    out.println("podaj nazwisko: ");
                    String nazwisko=in.readLine();
                    pracownicy.add(new Kucharz(imie,nazwisko));
                }
                else if(request.contains("dodaj_lekarza"))
                {
                    out.println("podaj imie: ");
                    String imie=in.readLine();
                    out.println("podaj nazwisko: ");
                    String nazwisko=in.readLine();
                    pracownicy.add(new Lekarz(imie,nazwisko));

                }
                else if(request.contains("dodaj_naczelnika"))
                {
                    out.println("podaj imie: ");
                    String imie=in.readLine();
                    out.println("podaj nazwisko: ");
                    String nazwisko=in.readLine();
                    pracownicy.add(new Naczelnik(imie,nazwisko));

                    out.println("dodano nowego naczelnika!");

                }
                else if(request.contains("dodaj_wieznia"))
                {
                    out.println("podaj imie: ");
                    String imie=in.readLine();
                    out.println("podaj nazwisko: ");
                    String nazwisko=in.readLine();
                    out.println("klasa :");
                    String klasa=in.readLine();
                    out.println("Wiek:");
                    String wiek=in.readLine();

                    out.println("data zwolnienia: ");
                    String data=in.readLine();
                    out.println("numer celi: ");
                    String numerC=in.readLine();
                    int wiekP=Integer.parseInt(wiek);
                    Date data1=new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    int numerCP=Integer.parseInt(numerC);

                    wiezniowie.add(new Wiezien(imie,nazwisko,klasa,wiekP,data1,(ArrayList<Skargi>) skargi,(ArrayList<Lek>) leki ,numerCP ));

                }
                else if(request.contains("dodaj_wychowawce"))
                {
                    out.println("podaj imie: ");
                    String imie=in.readLine();
                    out.println("podaj nazwisko: ");
                    String nazwisko=in.readLine();
                    pracownicy.add(new Wychowawca(imie,nazwisko, (ArrayList<Kurs>) listaKursow, (ArrayList<Praca>) listaPrac));

                    out.println("dodano nowego naczelnika!");


                }
                else if(request.contains("dodaj_skarge"))
                {
                    out.println("podaj tresc skargi: ");
                    String skarga=in.readLine();
                  for(int i=0;i<wiezniowie.size();i++)
                  {
                      out.println("wiezien: "+i+" "+wiezniowie.get(i).getImie()+wiezniowie.get(i).getNazwisko());
                  }
                  out.println("podaj index wieznia do ktorego chcesz przypisac skarge: ");
                  String numer=in.readLine();
                  Integer numerW=Integer.parseInt(numer);

                    skargi.add(new Skargi(skarga,wiezniowie.get(numerW)));



                }
                else if(request.contains("wyswietl_wiezni"))
                {
                    for(int i=0;i<wiezniowie.size();i++)
                    {
                        out.println("wiezniowie: "+i+wiezniowie.get(i).getImie()+" "+wiezniowie.get(i).getNazwisko());
                    }
                }
                else if(request.contains("wyswietl_pracownikow"))
                {
                    for(int i=0;i<pracownicy.size();i++)
                    {
                        out.println("Pracownicy: "+i+pracownicy.get(i).getImie()+" "+pracownicy.get(i).getNazwisko());
                    }
                }
                else if(request.contains("wyswietl_skargi"))
                {
                    for(int i=0;i<skargi.size();i++)
                    {
                        out.println("Pracownicy: "+i+skargi.get(i).getTresc()+" "+skargi.get(i).getWiezien());
                    }
                }
                else if(request.contains("dodaj_imie"))
                {
                    out.println("dodaj imie");
                    String imie=in.readLine();
                    imiona.add(imie);
                    out.println("dodano nowe imie");
                }
                else if(request.contains("wyswietl_imiona"))
                {
                    for(int i=0;i<imiona.size();i++)
                    {
                        out.println("imiona: "+imiona.get(i));
                    }
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

        } catch (ParseException e) {
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
