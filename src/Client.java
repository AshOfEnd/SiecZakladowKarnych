import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Client {
  //  private static String name;
    private static final String Server_IP="127.0.0.1";
    private static final int Server_port=9090;
    public static void main(String[] args) throws IOException {

        Socket socket=new Socket(Server_IP,Server_port);//utworzenie polaczenie z serverem
        ServerCon serverConn=new ServerCon(socket);

        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        new Thread(serverConn).start();
    while (true) {
        System.out.println(">");
        String command = keyboard.readLine();



        if (command.equals("quit")) break;
        if(command.equals("imie"))
        {

           // System.out.println("podaj swoja nazwe");
           // String imie=keyboard.readLine();
           // out.println(imie);

        }
        out.println(command);


    }

        socket.close();
        System.exit(0);
    }


}
//*********************INSTRUKCJA OBSLUGI*********************
//zeby stworzyc nowa liste trzeba ja ustawic w klasie ServerW
//referencja do listy w ClientH
//ClientH odpowiada za wszystko tak w zasadzie to taki support dla servera
// w cliencie piszecie if tak jak powyzej i podajecie komende do wprowadzenia
//blok komendy w client pozostaje pusty bo chodzi tylko o to zeby wyslac wiadomosc do ClientH
//przykladowo napisalem liste do dodawania imion i do wyswietlania calej listy imion
//tak w zasadzie to nie musicie nawet tego ifa robic dla klienta, on jest dla zasady no i poprawia czytelnosc
// tak jak mialo byc zrobione listy przechowuje server
//z wielowatkowoscia tez nie ma problemow
// pamietajcie zeby najpierw zamknac klientow potem server bo zablokujecie porty
// jesli jednak to zrobiliscie to wystarczy zmienic nr portu dla servera i klienta na ten sam
//kazda nastepna komende robcie w else if zeby nie bylo problemu z krzyzowaniem watkow
//ServerCon to dodatkowa klasa do oblsugi chatu
//watki moga sie ze saba komunikowac a klasa potrzebna byla zeby program nie czekal na readLine
//tak zwany trick
//to chyba wszystko co musicie wiedziec zeby spiac to do klas
//powodzenia!