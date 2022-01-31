package GUI;
import serwerKlient.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame implements ActionListener {

    public StartWindow()
    {
        setSize(300,200);
        setTitle("wybierz zaklad");
        setLayout(null);
        JButton button=new JButton("zatwierdz");
        button.setBounds(100,50,100,20);
        add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("zatwierdzono");

    }


}
