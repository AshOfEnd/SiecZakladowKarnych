import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientH implements Runnable, ActionListener {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientH> clients;
    private ArrayList<String> imiona;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream is;
    private List<Lekarz>messages=new ArrayList<>();
    private List<Pracownik> pracownicy=new ArrayList<>();

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

                }


                else if(request.contains("lista")){

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
                   out.println("kliknieto");
                   out.println("login");
                   String login=in.readLine();
                   out.println("login: "+login);
                   String password=in.readLine();
                   out.println("password: "+password);
                   if(login.equals("aaa") && password.equals("0000"))
                   {
                       out.println("pozytywny");
                       out.println("visible false");
                   }


                    /*
                    messages.add(new Lekarz("siema","gierczak"));
                    objectOutputStream.writeObject(messages);

                     */




                }
                else if(request.contains("kliknieto"))
                {
                    JFrame frame2=new JFrame();
                    JPanel panel=new JPanel();
                    panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                    frame2.add(panel, BorderLayout.CENTER);
                    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame2.setTitle("dodawanie wieznia ");
                    frame2.pack();
                    JLabel imielabel=new JLabel("imie");
                    imielabel.setBounds(10,20,80,25);
                    panel.add(imielabel);

                    JTextField imieText=new JTextField(20);
                    imieText.setBounds(100,20,165,25);
                    panel.add(imieText);

                    JLabel nazwiskolabel=new JLabel("nazwisko");
                    nazwiskolabel.setBounds(10,30,80,25);
                    panel.add(nazwiskolabel);

                    JTextField nazwiskoText=new JTextField(20);
                    nazwiskoText.setBounds(100,30,165,25);
                    panel.add(nazwiskoText);

                    JButton button=new JButton("zatwierdz");
                    button.setBounds(10,50,80,25);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            out.println("wyslij");
                            String imie=imieText.getText();
                            String nazwisko=nazwiskoText.getText();
                          imiona.add(imie);
                          out.println("dodano imie!");
                          frame2.setVisible(false);


                        }
                    });
                    panel.add(button);
                    frame2.setVisible(true);
                }
                else if(request.contains("prosba"))
                {
                    out.println("dodaj");
                    pracownicy=(List<Pracownik>) is.readObject();
                    System.out.println("dodano nowego pracownika!");
                    for(int i=0;i< pracownicy.size();i++)
                    {
                      out.println("lista pracownikow"+i+" "+ pracownicy.get(i));
                    }
                }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        out.println("chuj chuj");
    }
}
