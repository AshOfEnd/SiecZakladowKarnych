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

                        String command = in.readLine();


                            if(command.equals("wyslij"))
                            {
                                String login=in.readLine();
                                String password=in.readLine();
                                if(login.equals("aaa") && password.equals("0000"))
                                {
                                    out.println("access");
                                }

                            }
                            if(command.equals("proba"))
                            {
                                out.println("dziala");
                            }
                            if(command.equals("dodaj_wieznia"))
                            {
                                out.println("dziala");
                                JFrame frame2=new JFrame();
                                JPanel panel=new JPanel();
                                panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                                frame2.add(panel, BorderLayout.CENTER);
                                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                frame2.setTitle("dodaj-wieznia ");
                                frame2.pack();
                                JTextField imie=new JTextField();
                                imie.setBounds(100,20,165,25);
                                JTextField nazwisko=new JTextField();
                                nazwisko.setBounds(100,30,165,25);
                                JTextField klasa=new JTextField();
                                klasa.setBounds(100,40,165,25);
                                JTextField wiek=new JTextField();
                                wiek.setBounds(100,40,165,25);
                                JTextField dataZwolnienia=new JTextField();
                                dataZwolnienia.setBounds(100,50,165,25);
                                JTextField numerCeli=new JTextField();
                                numerCeli.setBounds(100,60,165,25);
                                JButton button=new JButton("zatwierdz");
                                button.setBounds(10,80,80,25);
                                button.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        out.println("wyslij");
                                        String user = imie.getText();
                                        String nazw = nazwisko.getText();
                                        String kl = klasa.getText();
                                        String age = wiek.getText();
                                        String data = dataZwolnienia.getText();
                                        String cela = numerCeli.getText();
                                        int wiek1 = Integer.parseInt(age);
                                        int nrCeli=Integer.parseInt(cela);
                                        Date date1 = null;
                                        try {
                                            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                        } catch (ParseException ex) {
                                            ex.printStackTrace();
                                        }

                                        plac.getListaWiezniow().add(new Wiezien(user, nazw, kl, wiek1, date1,new ArrayList<Skargi>(),new ArrayList<Lek>(),nrCeli ));


                                    }
                                });
                                panel.add(imie);
                                panel.add(nazwisko);
                                panel.add(klasa);
                                panel.add(wiek);
                                panel.add(dataZwolnienia);
                                panel.add(numerCeli);

                                frame2.setVisible(true);
                            }



                            }

                        } catch (IOException e) {
            e.printStackTrace();
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




}
