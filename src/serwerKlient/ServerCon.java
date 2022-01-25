package serwerKlient;

import pracownicy.Kucharz;
import pracownicy.Lekarz;
import pracownicy.Pracownik;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerCon implements Runnable{
    private Socket server;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private List<Lekarz> listOfMessages=new ArrayList<>();
    private List<Pracownik> listaPracownikow=new ArrayList<>();
    private String x;
    private String y;
Scanner scann=new Scanner(System.in);



    public ServerCon(Socket s) throws IOException {
        server =s;
        out=new PrintWriter(server.getOutputStream(),true);
        in=new BufferedReader(new InputStreamReader(server.getInputStream()));
        objectOutputStream=new ObjectOutputStream(server.getOutputStream());
        objectInputStream=new ObjectInputStream(server.getInputStream());

    }
    @Override
    public void run() {
        while (true) {


            try {
                while (true) {


                    String serverResponse = in.readLine();

                    if (serverResponse.equals("zakonczono")) {

                        listOfMessages = (List<Lekarz>) objectInputStream.readObject();
                        System.out.println("Received [" + listOfMessages.size() + "] messages from: " + server);
                        System.out.println("All messages:");
                        listOfMessages.forEach((msg) -> System.out.println(msg.getImie()));


                    }
                   else if (serverResponse.equals("dodaj")) {
                        listaPracownikow.add(new Pracownik("jacek", "kurski"));
                        objectOutputStream.writeObject(listaPracownikow);
                        System.out.println("rozpoczynasz dodawanie obiektu");


                    }
                   else if (serverResponse.equals("dodajkuch")) {
                      System.out.println("podaj imie: ");

                      System.out.println("podaj nazwisko: ");
                      //y=scann.nextLine();
                        x="chuj";
                        y="chuj2";
                      out.println("kuchobs");
                        System.out.println("x: "+x);
                        System.out.println("y: "+y);

                    }
                   else if(serverResponse.equals("kuchresp"))
                    {

                      Kucharz z=new Kucharz(x,y);

                        objectOutputStream.writeObject(z);
                        System.out.println("serverC: "+z.getImie());
                    }


                    System.out.println("[S]>> " + serverResponse);
                    if (serverResponse == "koniec") break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
///////////////INSTRUKCJA WYSYLANIA OBIEKTOW//////////////
/*
Wieeeeem ze dlugo na to czekaliscie!

okej wiec tak, obiekty mozna wysylac do servera i je z niego odbierac ale procedura jest troche
zagniezdzona
najlepiej bedzie jak wytlumacze na przykladzie ktory macie napisany wyzej.
(dobrze bedzie jak poczytacie sobie troche jak to wgl dziala zeby zrozumiec co mozna wyslac a co nie)
wiec tak
jesli chcemy wyslac cokolwiek
to potrzebujemy objectinputstream i objectoutput stream
ze wzgledu na dzialanie object output stream zawsze musi byc tworzony pierwszy
po obu stronach komunikatora
w przeciwnym wypadku deadlock
wiec tak
wysylanie i odbieranie obslugiwane tylko w klasie serwerKlient.ServerCon
nigdzie indziej nie da sie tego zrobic

tam gdzie macie responde.equals("zakonczono")
to jest odczytywanie obiektu wyslanego przez server
wiadomosc "zakonczono" jest wysylana przez server w serwer.ClientH
wysylac i odbierac obiekty mozecie tylko do tej samej struktury
czyli jesli zapisywane w liscie to wyslane tez musi byc w liscie
a przynajmniej do takich wnioskow doszedlem metoda prob i bledow
wiec jesli wola mozecie poeksperymentowac
wracajac;
zeby odebrac obiekt klient wpisuje wyslij
server odbiera
odsyla wiad "zakonczono"
dodaje obiekt do listy
wysyla liste obiektow
w momencie w ktorym klient dostaje wiadomosc "zakonczono"
uruchamiane jest odczytywanie obiektow
co dziwne to odczytywwanie musi byc aktywne przed proba wyslania
wiec ta kolejnosc ktora zastosowana jest w serwer.ClientH jest uzasadnioa
z wysylaniem jest analogicznie tylko w druga strone
zakomentowany macie tez system logowania ale jak mowie
to tylko szybka prowizorka nie wiem czy bedziemy chcieli takiego modelu uzywac
to co jest tam napisane nie dziala dla tego jak jest teraz zrobione wysylanie i odbieranie
obiektow
ale sprawienie zeby dzialalo nie jest zbyt skomplikowane trzeba tylko w serverConie to obsluzyc
to chyba tyle
("*jesli znajdziecie w kodzie println z jakims brzydkim slowem to przepraszam ale czasami czlowiek ma juz dosc*)
Adios!

 */