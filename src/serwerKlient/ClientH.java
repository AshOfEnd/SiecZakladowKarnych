package serwerKlient;

import GUI.StartWindow;
import aktywnoscWiezien.*;
import pracownicy.*;
import wyposazenie.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientH implements Runnable
{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientH> clients;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream is;
  private Placowka krakow=new Placowka();
  private Placowka warszawa=new Placowka();
  private Placowka Poznan=new Placowka();
  private ServerW baza;



    public ClientH(Socket clientSocket, ArrayList<ClientH> clients,ArrayList<Wiezien> listawiezni) throws IOException, ClassNotFoundException
    {
        this.clients=clients;
        this.client=clientSocket;
        in=new BufferedReader(new InputStreamReader(client.getInputStream()));
        out=new PrintWriter(client.getOutputStream(),true);



    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                String request = in.readLine();
                //   String command=keyboard.readLine();
                /*
                if(request.startsWith("say"))
                {
                    int firtsSpace=request.indexOf(" ");
                    if(firtsSpace!=-1)
                    {
                        outToAll(request.substring(firtsSpace+1));
                    }
                }

                 */



                        out.println("wybierz placowke:");
                        out.println("1. Placowka w Krakowie");
                        out.println("1. Placowka w Warszawie");
                        out.println("1. Placowka w Poznaniu");
                        out.println("wpisz quit aby zamknac klienta");
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
                                    out.println("wpisz help aby wyswietlic liste komend");
                                    while (true) {
                                        String command = in.readLine();
                                        if (command.equals("help")) {
                                            out.println("daj pan 3 ");
                                            out.println("zbior dostepnych komend:");
                                            out.println("dodaj wieznia");
                                            out.println("usun wieznia");
                                            out.println("usun pracownika");
                                            out.println("zglos  skarge");
                                            out.println("zglos usterke ");
                                            out.println(" dodaj wieznia do kursu ");
                                            out.println("wyswietl wiezni");
                                            out.println("wyswietl pracownikow");
                                            out.println("dodaj wieznia do pracy");
                                            out.println("przepisz lek");
                                            out.println("zloz zamowienie");
                                            out.println("przydziel do izolatki");

                                            out.println("kliknij 0 aby sie wylogowac");
                                        }

                                        if (command.equals("dodaj-wieznia")) {

                                            out.println("<<>>podaj nazwisko:");
                                            String nazwisko = in.readLine();
                                            out.println("<<>>podaj imie:");
                                            String imie = in.readLine();
                                            out.println("<<>>podaj klase:");
                                            String klasa = in.readLine();
                                            out.println("<<>>podaj wiek:");
                                            String wiek = in.readLine();
                                            out.println("<<>>podaj dateZwolnienia:");
                                            String data = in.readLine();
                                            out.println("<<>>podaj numer celi:");
                                            String cela = in.readLine();

                                            int wiek1=Integer.parseInt(wiek);
                                            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                            int numerC=Integer.parseInt(cela);
                                            krakow.getListaWiezniow().add(new Wiezien(imie,nazwisko,klasa,wiek1,date1,new ArrayList<Skargi>(),new ArrayList<Lek>(),numerC));


                                        } if (command.equals("usun-wieznia")) {

                                            for(int i=0;i<krakow.getListaWiezniow().size();i++)
                                            {
                                                out.println(i+" : "+krakow.getListaWiezniow().get(i).getImie()+" "+krakow.getListaWiezniow().get(i).getNazwisko()+" "+krakow.getListaWiezniow().get(i).getNumerCeli());
                                            }
                                            out.println("<<>>podaj index wieznia ktorego chcesz usunac:");
                                            String usun=in.readLine();
                                            int delete=Integer.parseInt(usun);

                                            krakow.getListaWiezniow().remove(delete);

                                            out.println("rekord usuniety!");



                                        } if (command.equals("usun-pracownika")) {

                                            for(int i=0;i<krakow.getListaWiezniow().size();i++) {
                                                out.println(" ");

                                                out.println( i + " :> " + krakow.getListaPracownikow().get(i).getImie()+" " + krakow.getListaPracownikow().get(i).getNazwisko() + " lat: ");

                                            }
                                            out.println("podaj index pracownika ktorego chesz usunac:");
                                            String s=in.readLine();
                                            int index=Integer.parseInt(s);
                                            krakow.getListaPracownikow().remove(index);
                                            out.println("pracownik zostal usuniety");

                                        } if (command.equals("zglos-skarge")) {

                                            for(int i=0;i<krakow.getListaWiezniow().size();i++)
                                            {
                                                out.println(i+" : "+krakow.getListaWiezniow().get(i).getImie()+" "+krakow.getListaWiezniow().get(i).getNazwisko()+" "+krakow.getListaWiezniow().get(i).getNumerCeli());
                                            }
                                            out.println("<<>>podaj index wieznia do ktorego chcesz dodac skarge");
                                            String index=in.readLine();
                                            int ind=Integer.parseInt(index);
                                            out.println("<<>>podaj tresc skargi, zakoncz wprowadzanie klikajac ENTER:");
                                            String skarga=in.readLine();
                                            out.println("<<>>podaj date: ");
                                            String data=in.readLine();

                                            Date data1=new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                           Skargi skg=new Skargi(skarga,data1);

                                            krakow.getListaWiezniow().get(ind).dodajSkarge(skg);
                                            out.println("Skarga zostala dodana!");


                                        } if (command.equals("dodaj-dokursu")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("wyswietl-wiezni")) {
                                            for(int i=0;i<krakow.getListaWiezniow().size();i++) {
                                                out.println(" ");

                                                out.println( " :> " + krakow.getListaWiezniow().get(i).getImie() + " " + krakow.getListaWiezniow().get(i).getNazwisko() + " lat: " + krakow.getListaWiezniow().get(i).getWiek());
                                                out.println(i + " :>" + krakow.getListaWiezniow().get(i).getNumerCeli() + " " + krakow.getListaWiezniow().get(i).getListaLekow() + " lat: " + krakow.getListaWiezniow().get(i).getKlasa());
                                                out.println( " :> " + krakow.getListaWiezniow().get(i).getDataZwolnienia());

                                            }

                                        } if (command.equals("wyswietl-pracownikow")) {

                                            for(int i=0;i<krakow.getListaWiezniow().size();i++) {
                                                out.println(" ");

                                                out.println( i + " :> " + krakow.getListaPracownikow().get(i).getImie()+" " + krakow.getListaPracownikow().get(i).getNazwisko() + " lat: ");

                                            }

                                        } if (command.equals("dodajw-dopracy")) {



                                        } if (command.equals("przepisz-lek")) {

                                            for(int i=0;i<krakow.getListaWiezniow().size();i++)
                                            {
                                                out.println(i+" : "+krakow.getListaWiezniow().get(i).getImie()+" "+krakow.getListaWiezniow().get(i).getNazwisko()+" "+krakow.getListaWiezniow().get(i).getNumerCeli());
                                            }
                                            out.println("wpisz index wieznia ktoremu chcesz przepisac lek ");
                                            String index=in.readLine();
                                            out.println("podaj nazwe leku ");
                                            String nazwa=in.readLine();
                                            out.println("podaj dawke w mg ");
                                            String dawka=in.readLine();
                                            int index1=Integer.parseInt(index);


                                            krakow.getListaWiezniow().get(index1).przypiszLek(nazwa,dawka);


                                        } if (command.equals("zloz_zamowienie")) {

                                            out.println("");

                                        } if (command.equals("przydziel_do_izolatki")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        }
                                        if (command.equals("0")) {
                                            out.println("wylogowywanie...");
                                            break;
                                        }


                                    }
                                } else {
                                    out.println("zle haslo lub login, sprobuj ponownie");
                                    continue;
                                }
                            }

                        }
                        if (placowka.contains("2")) {
                            while (true) {


                                String log = "aaa";
                                String pass = "0000";
                                out.println("[[ZK W POZNANIU]]");
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
                                    out.println("wpisz help aby wyswietlic liste komend");
                                    while (true) {
                                        String command = in.readLine();
                                        if (command.equals("help")) {
                                            out.println("zbior dostepnych komend:");
                                            out.println("dodaj wieznia");
                                            out.println("usun wieznia");
                                            out.println("usun pracownika");
                                            out.println("zglos  skarge");
                                            out.println("zglos usterke ");
                                            out.println(" dodaj wieznia do kursu ");
                                            out.println("wyswietl wiezni");
                                            out.println("wyswietl pracownikow");
                                            out.println("dodaj wieznia do pracy");
                                            out.println("przepisz lek");
                                            out.println("zloz zamowienie");
                                            out.println("przydziel do izolatki");

                                            out.println("kliknij 0 aby sie wylogowac");
                                        }

                                        if (command.equals("dodaj-wieznia")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("usun-wieznia")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("usun-pracownika")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("zglos-skarge")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("zglos-usterke ")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("dodaj-dokursu")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("wyswietl-wiezni")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("wyswietl-pracownikow")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("dodajw-dopracy")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("przepisz-lek")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("zloz_zamowienie")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        } if (command.equals("przydziel_do_izolatki")) {

                                            out.println("[[kliknij ENTER zeby kontynuowac]]");

                                        }
                                        if (command.equals("0")) {
                                            out.println("wylogowywanie...");
                                            break;
                                        }

                                    }
                                } else {
                                    out.println("zle haslo lub login, sprobuj ponownie");
                                    continue;
                                }
                            }

                        }





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
