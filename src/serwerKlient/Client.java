package serwerKlient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements ActionListener {
    private static final String Server_IP="127.0.0.1";
    private static final int Server_port=6666;
    private static BufferedReader in;
    private BufferedReader keyboard;
    private static PrintWriter out;
    private static Socket socket;



    public static void main(String[] args) throws IOException, ClassNotFoundException, UnknownHostException {

        Socket socket=new Socket(Server_IP,Server_port);//utworzenie polaczenie z serverem

        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);





        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("logowanie ");
        frame.pack();

        panel.setLayout(null);
        JLabel userlabel=new JLabel("User");
        userlabel.setBounds(10,20,80,25);
        panel.add(userlabel);

        JTextField userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel=new JLabel("password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText =new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        JButton button=new JButton("zatwierdz");
        button.setBounds(10,80,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                out.println("wyslij");
                String user=userText.getText();
                String password=passwordText.getText();
                out.println(user);
                out.println(password);



            }
        });
        panel.add(button);
        frame.setVisible(true);

        Thread t = new Thread() {
            @Override
            public void run() {
                while(true)
                {
                    try {
                        String serverResponse = in.readLine();
                        if (serverResponse.equals("access")) {
                                frame.setVisible(false);
                                secscreen(out);
                                /*
                            JFrame frame2=new JFrame();
                            JPanel panel=new JPanel();
                            panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
                            frame2.add(panel, BorderLayout.CENTER);
                            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame2.setTitle("interfejs ");
                            frame2.pack();
                            JButton button=new JButton("dodaj wieznia");
                            button.setBounds(10,80,80,25);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("123");
                                    out.println("dodaj_wieznia");



                                }
                            });
                            JButton button1=new JButton("usun pracownika");
                            button.setBounds(10,90,80,25);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {



                                }
                            });
                            JButton button2=new JButton("dodaj pracownika");
                            button.setBounds(10,100,80,25);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {



                                }
                            });
                            JButton button3=new JButton("dodaj wieznia do izolatki");
                            button.setBounds(10,110,80,25);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {



                                }
                            });
                            JButton button4=new JButton("usun wieznia z izolatki");
                            button.setBounds(10,120,80,25);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {



                                }
                            });
                            panel.add(button);
                            panel.add(button2);
                            panel.add(button1);
                            panel.add(button3);
                            panel.add(button4);

                            frame2.setVisible(true);

                                 */


                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();



        while (true) {


            System.out.println(">");
            String command = keyboard.readLine();

            if (command.equals("quit")) break;

            if(!command.isEmpty()) {


                out.println(command);
            }

        }



        socket.close();
        System.exit(0);
    }

    private static void secscreen(PrintWriter aaa ) throws IOException {


        JFrame frame2=new JFrame();
        JPanel panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        frame2.add(panel, BorderLayout.CENTER);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setTitle("interfejs ");
        frame2.pack();
        JButton button=new JButton("dodaj wieznia");
        button.setBounds(10,80,80,25);
        button.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         System.out.println("123");
                                        aaa.println("dodaj_wieznia");



                                     }
                                 });
        JButton button1=new JButton("usun pracownika");
        button.setBounds(10,90,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        JButton button2=new JButton("dodaj pracownika");
        button.setBounds(10,100,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        JButton button3=new JButton("dodaj wieznia do izolatki");
        button.setBounds(10,110,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        JButton button4=new JButton("usun wieznia z izolatki");
        button.setBounds(10,120,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
        panel.add(button);
        panel.add(button2);
        panel.add(button1);
        panel.add(button3);
        panel.add(button4);

        frame2.setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
